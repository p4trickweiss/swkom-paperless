package at.fhtw.swkom.paperless.controller;

import at.fhtw.swkom.paperless.controller.interfaces.IDocumentsController;
import at.fhtw.swkom.paperless.data.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.data.repos.DocumentsDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentsController implements IDocumentsController {
    private final NativeWebRequest request;
    private final DocumentsDocumentRepository documentRepository;

    @Autowired
    public DocumentsController(NativeWebRequest request, DocumentsDocumentRepository documentRepository) {
        this.request = request;
        this.documentRepository = documentRepository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Map<String, Object>> uploadDocument (
            @RequestPart("document") MultipartFile file
    ){
        DocumentsDocument doc = new DocumentsDocument();
        doc.setTitle(file.getOriginalFilename());
        doc.setContent(file.getContentType());
        doc.setCreated(OffsetDateTime.now());
        doc.setModified(OffsetDateTime.now());
        doc.setAdded(OffsetDateTime.now());
        doc.setStorageType(file.getContentType());

        this.documentRepository.save(doc);

        // Integer documentId = this.documentRepository.save(doc).getId();

        /*try{
            this.documentStorage.persistObject(documentId, file);
        }catch (Exception exception){
            exception.printStackTrace();
        }*/

        // this.rabbitMQProducer.sendMessage(documentId.toString());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "File uploaded successfully");

        return ResponseEntity.ok(response);
    }
}
