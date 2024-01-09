package at.technikumwien.swkom.paperlessrest.controller.impl;

import at.technikumwien.swkom.paperlessrest.controller.IDocumentsController;
import at.technikumwien.swkom.paperlessrest.data.dto.*;
import at.technikumwien.swkom.paperlessrest.services.impl.DocumentsService;
import at.technikumwien.swkom.paperlessrest.services.impl.RabbitMQMessageBroker;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentsController implements IDocumentsController {
    private final NativeWebRequest request;
    private final DocumentsService documentsService;

    private static final Logger logger = LoggerFactory.getLogger(DocumentsController.class);


    @Autowired
    public DocumentsController(NativeWebRequest request, DocumentsService documentsService) {
        this.request = request;
        this.documentsService = documentsService;
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
            @Parameter(name = "truncate_content", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "truncate_content", required = false) Boolean truncateContent,
            @Parameter(name = "title_content", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "title_content", required = false) String titleContent
    ) {
        GetDocuments200Response res;

        if(titleContent != null){
            res = documentsService.getFilteredDocuments(titleContent);
        } else
        {
            res = documentsService.getAllDocuments();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/documents/{id}/",
            produces = { "application/json" }
    )
    public ResponseEntity<GetDocument200Response> getDocument(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "page", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(name = "full_perms", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "full_perms", required = false) Boolean fullPerms
    ) {
        GetDocument200Response res = documentsService.getDocument(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/documents/{id}/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<UpdateDocument200Response> updateDocument(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateDocumentRequest", description = "") @RequestBody(required = false) UpdateDocumentRequest updateDocumentRequest
    ) {
        UpdateDocument200Response res = documentsService.updateDocument(id, updateDocumentRequest);
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
        documentsService.uploadDocument(document.get(0));
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
        documentsService.bulkEdit(bulkEditRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
