package at.technikumwien.swkom.paperlessrest.controller.impl;

import at.technikumwien.swkom.paperlessrest.controller.IDocumentsController;
import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import at.technikumwien.swkom.paperlessrest.data.dto.BulkEditRequest;
import at.technikumwien.swkom.paperlessrest.data.dto.GetDocuments200Response;
import at.technikumwien.swkom.paperlessrest.data.dto.GetDocuments200ResponseResultsInner;
import at.technikumwien.swkom.paperlessrest.data.repos.DocumentsDocumentRepository;
import at.technikumwien.swkom.paperlessrest.services.IFileStorage;
import at.technikumwien.swkom.paperlessrest.services.IMessageBroker;
import at.technikumwien.swkom.paperlessrest.data.messagequeue.ScanDocumentMessage;
import at.technikumwien.swkom.paperlessrest.services.impl.MinIOFileStorage;
import at.technikumwien.swkom.paperlessrest.services.impl.RabbitMQMessageBroker;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentsController implements IDocumentsController {
    private final NativeWebRequest request;
    private final IMessageBroker rabbit;
    private final IFileStorage minio;
    private final DocumentsDocumentRepository documentRepository;

    @Autowired
    public DocumentsController(NativeWebRequest request, RabbitMQMessageBroker rabbit, MinIOFileStorage minio, DocumentsDocumentRepository documentRepository) {
        this.request = request;
        this.rabbit = rabbit;
        this.minio = minio;
        this.documentRepository = documentRepository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/documents/",
            produces = { "application/json" }
    )
    public ResponseEntity<GetDocuments200Response> getDocuments(
            @Parameter(name = "Page", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "Page", required = false) Integer page,
            @Parameter(name = "page_size", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page_size", required = false) Integer pageSize,
            @Parameter(name = "query", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "query", required = false) String query,
            @Parameter(name = "ordering", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "ordering", required = false) String ordering,
            @Parameter(name = "tags__id__all", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tags__id__all", required = false) List<Integer> tagsIdAll,
            @Parameter(name = "document_type__id", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "document_type__id", required = false) Integer documentTypeId,
            @Parameter(name = "storage_path__id__in", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "storage_path__id__in", required = false) Integer storagePathIdIn,
            @Parameter(name = "correspondent__id", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "correspondent__id", required = false) Integer correspondentId,
            @Parameter(name = "truncate_content", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "truncate_content", required = false) Boolean truncateContent
    ) {
        List<DocumentsDocument> docs = documentRepository.findAll();
        List<GetDocuments200ResponseResultsInner> results = new ArrayList<>();
        for(DocumentsDocument result : docs) {
            GetDocuments200ResponseResultsInner document = new GetDocuments200ResponseResultsInner();
            document.id(result.getId());
            document.content(result.getContent());
            document.title(result.getTitle());

            results.add(document);
        }
        GetDocuments200Response res = new GetDocuments200Response();
        res.count(docs.size());
        res.results(results);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/documents/post_document/",
            consumes = { "multipart/form-data" }
    )
    public ResponseEntity<Void> uploadDocument(
            @Parameter(name = "title", description = "") @Valid @RequestParam(value = "title", required = false) String title,
            @Parameter(name = "created", description = "") @Valid @RequestParam(value = "created", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created,
            @Parameter(name = "document_type", description = "") @Valid @RequestParam(value = "document_type", required = false) Integer documentType,
            @Parameter(name = "tags", description = "") @Valid @RequestPart(value = "tags", required = false) List<Integer> tags,
            @Parameter(name = "correspondent", description = "") @Valid @RequestParam(value = "correspondent", required = false) Integer correspondent,
            @Parameter(name = "document", description = "") @RequestPart(value = "document", required = false) List<MultipartFile> document
    ) {
        //save to db
        MultipartFile file = document.get(0);

        DocumentsDocument doc = new DocumentsDocument();
        doc.setFilename(file.getOriginalFilename());
        doc.setTitle(file.getOriginalFilename());
        doc.setCreated(OffsetDateTime.now());
        doc.setModified(OffsetDateTime.now());
        doc.setAdded(OffsetDateTime.now());

        Integer docId = documentRepository.save(doc).getId();
        String bucketPath = docId.toString() + "/" + doc.getFilename();

        //upload file to minio
        minio.upload(bucketPath, file);

        //send message with bucket path to rabbitmq
        ObjectMapper mapper = new ObjectMapper();
        ScanDocumentMessage scanDocumentMessage = new ScanDocumentMessage(docId, bucketPath);
        try {
            String message = mapper.writeValueAsString(scanDocumentMessage);
            rabbit.send(message);
        }
        catch (JacksonException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/documents/bulk_edit/",
            consumes = { "application/json" }
    )
    public ResponseEntity<Void> bulkEdit(
            @Parameter(name = "BulkEditRequest", description = "") @Valid @RequestBody(required = false) BulkEditRequest bulkEditRequest
    ) {
        List<Integer> ids = bulkEditRequest.getDocuments();
        for(Integer id : ids) {
            documentRepository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
