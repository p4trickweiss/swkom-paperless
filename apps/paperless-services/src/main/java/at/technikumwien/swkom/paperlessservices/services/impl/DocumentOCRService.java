package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.models.ElasticSearchDocument;
import at.technikumwien.swkom.paperlessservices.services.*;
import co.elastic.clients.elasticsearch._types.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class DocumentOCRService implements IDocumentOCRService {

    private final IOCRWorker tesseractOCRWorker;
    private final IFileStorage minIOService;
    private final ISearchIndexService elasticSearchService;

    @Autowired
    DocumentOCRService(TesseractOCRWorker tesseractOCRWorker, MinIOService minIOService, ElasticSearchService elasticSearchService) {
        this.tesseractOCRWorker = tesseractOCRWorker;
        this.minIOService = minIOService;
        this.elasticSearchService = elasticSearchService;
    }

    @Override
    public String processDocument(String docName, int id) {
        try(InputStream fileStream = minIOService.download(docName)) {
            String content = tesseractOCRWorker.processFile(docName, fileStream);

            ElasticSearchDocument document = new ElasticSearchDocument(id, docName, content);

            Result res = elasticSearchService.indexDocument(document);

            System.out.printf(res.toString());

            return content;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
