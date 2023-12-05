package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.services.IDocumentOCRService;
import at.technikumwien.swkom.paperlessservices.services.IFileStorage;
import at.technikumwien.swkom.paperlessservices.services.IOCRWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class DocumentOCRService implements IDocumentOCRService {
    private final IOCRWorker tesseractOCRWorker;
    private final IFileStorage minIOService;

    @Autowired
    DocumentOCRService(TesseractOCRWorker tesseractOCRWorker, MinIOService minIOService) {
        this.tesseractOCRWorker = tesseractOCRWorker;
        this.minIOService = minIOService;
    }

    @Override
    public void processDocument(String docName) {
        try(InputStream fileStream = minIOService.download(docName)) {
            String content = tesseractOCRWorker.processFile(docName, fileStream);
            //TODO send content to REST via ocr-result queue
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
