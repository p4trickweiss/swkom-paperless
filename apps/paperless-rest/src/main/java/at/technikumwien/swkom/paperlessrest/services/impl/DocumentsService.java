package at.technikumwien.swkom.paperlessrest.services.impl;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import at.technikumwien.swkom.paperlessrest.data.dto.*;
import at.technikumwien.swkom.paperlessrest.data.messagequeue.ScanDocumentMessage;
import at.technikumwien.swkom.paperlessrest.data.repos.DocumentsDocumentRepository;
import at.technikumwien.swkom.paperlessrest.services.IFileStorage;
import at.technikumwien.swkom.paperlessrest.services.IMessageBroker;
import at.technikumwien.swkom.paperlessrest.services.ISearchService;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DocumentsService {

    private final IMessageBroker rabbit;
    private final IFileStorage minio;
    private final DocumentsDocumentRepository documentRepository;
    private final ISearchService elasticSearchService;

    private static final Logger logger = LoggerFactory.getLogger(DocumentsService.class);


    @Autowired
    public DocumentsService(RabbitMQMessageBroker rabbit, MinIOFileStorage minio, DocumentsDocumentRepository documentRepository, ElasticSearchService elasticSearchService) {
        this.rabbit = rabbit;
        this.minio = minio;
        this.documentRepository = documentRepository;
        this.elasticSearchService = elasticSearchService;
    }

    public GetDocuments200Response getFilteredDocuments(String titleContent) {
        List<Integer> res_ids = elasticSearchService.getDocumentByTitleContent(titleContent);
        List<DocumentsDocument> docs = documentRepository.findByIdIn(res_ids);

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
        return res;
    }
    public GetDocuments200Response getAllDocuments() {
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
        return res;
    }

    public GetDocument200Response getDocument(Integer id) {
        Optional<DocumentsDocument> doc = documentRepository.findById(id);
        GetDocument200Response res = new GetDocument200Response();
        res.setId(doc.get().getId());
        res.setTitle(doc.get().getTitle());
        return res;
    }

    public UpdateDocument200Response updateDocument(Integer id, UpdateDocumentRequest updateDocumentRequest) {
        Optional<DocumentsDocument> doc = documentRepository.findById(id);
        doc.get().setTitle(updateDocumentRequest.getTitle());
        documentRepository.save(doc.get());

        UpdateDocument200Response res = new UpdateDocument200Response();
        res.id(doc.get().getId());
        res.title(doc.get().getTitle());
        res.added(doc.get().getAdded().toString());
        res.created(doc.get().getCreated().toString());
        return res;
    }

    public void uploadDocument(MultipartFile file) {
        //save to db
        DocumentsDocument doc = new DocumentsDocument();
        doc.setFilename(file.getOriginalFilename());
        doc.setTitle(file.getOriginalFilename());
        doc.setCreated(OffsetDateTime.now());
        doc.setModified(OffsetDateTime.now());
        doc.setAdded(OffsetDateTime.now());

        Integer docId = documentRepository.save(doc).getId();
        String bucketPath = docId.toString() + "/" + doc.getFilename();

        minio.upload(bucketPath, file);
        logger.info("Uploaded to Minio!");

        ObjectMapper mapper = new ObjectMapper();
        ScanDocumentMessage scanDocumentMessage = new ScanDocumentMessage(docId, bucketPath);
        try {
            String message = mapper.writeValueAsString(scanDocumentMessage);
            rabbit.send(message);
            logger.info("sent to rabbitmq!");
        }
        catch (JacksonException e) {
            System.out.println(e.getMessage());
        }
    }

    public void bulkEdit(BulkEditRequest bulkEditRequest) {
        if(Objects.equals(bulkEditRequest.getMethod(), "delete")) {
            List<Integer> ids = bulkEditRequest.getDocuments();
            for(Integer id : ids) {
                documentRepository.deleteById(id);
            }
        }
    }
}
