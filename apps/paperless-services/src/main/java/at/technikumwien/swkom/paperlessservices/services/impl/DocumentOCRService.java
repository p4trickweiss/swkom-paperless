package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.config.RabbitMQConfig;
import at.technikumwien.swkom.paperlessservices.services.IDocumentOCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class DocumentOCRService implements IDocumentOCRService {
    private final TesseractOCRWorker tesseractOCRWorker;
    private final MinIOService minIOService;

    @Autowired
    DocumentOCRService(TesseractOCRWorker tesseractOCRWorker, MinIOService minIOService) {
        this.tesseractOCRWorker = tesseractOCRWorker;
        this.minIOService = minIOService;
    }

    @Override
    public void processDocument(String docName) {
        try(InputStream fileStream = minIOService.download(docName)) {
            String content = tesseractOCRWorker.processFile(docName, fileStream);
            System.out.println(content);
            //TODO send content to REST via message queue
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
