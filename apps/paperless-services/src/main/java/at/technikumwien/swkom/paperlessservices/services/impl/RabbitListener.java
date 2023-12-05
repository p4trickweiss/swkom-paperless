package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.config.RabbitMQConfig;
import at.technikumwien.swkom.paperlessservices.services.IDocumentOCRService;
import at.technikumwien.swkom.paperlessservices.services.IMessageQueueListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener implements IMessageQueueListener {
    private final IDocumentOCRService documentOCRService;
    @Autowired
    RabbitListener(DocumentOCRService documentOCRService) {
        this.documentOCRService = documentOCRService;
    }

    @Override
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitMQConfig.DOCUMENT_QUEUE)
    public void processDocumentsMessage(String message) {
        System.out.println("Received Message: " + message);

        documentOCRService.processDocument(message);
    }
}
