package at.technikumwien.swkom.paperlessrest.controller.impl;

import at.technikumwien.swkom.paperlessrest.controller.IDocumentsController;
import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import at.technikumwien.swkom.paperlessrest.data.repos.DocumentsDocumentRepository;
import at.technikumwien.swkom.paperlessrest.services.IFileStorage;
import at.technikumwien.swkom.paperlessrest.services.IMessageBroker;
import at.technikumwien.swkom.paperlessrest.services.impl.MinIOFileStorage;
import at.technikumwien.swkom.paperlessrest.services.impl.RabbitMQMessageBroker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
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

    /**
     * POST /api/documents/post_document
     *
     * @param title  (optional)
     * @param created  (optional)
     * @param documentType  (optional)
     * @param tags  (optional)
     * @param correspondent  (optional)
     * @param document  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "uploadDocument",
            tags = { "Documents" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success")
            }
    )
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
        doc.setContent(file.getContentType());
        doc.setCreated(OffsetDateTime.now());
        doc.setModified(OffsetDateTime.now());
        doc.setAdded(OffsetDateTime.now());

        Integer docId = documentRepository.save(doc).getId();
        String bucketPath = docId.toString() + "/" + doc.getFilename();

        //upload file to minio
        minio.upload(bucketPath, file);
        //send message with bucket path to rabbitmq
        rabbit.send(bucketPath);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
