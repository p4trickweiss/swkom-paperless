package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.config.RabbitMQConfig;
import at.technikumwien.swkom.paperlessservices.services.IDocumentOCRService;
import at.technikumwien.swkom.paperlessservices.services.IMessageBroker;
import at.technikumwien.swkom.paperlessservices.data.messagequeue.ScanDocumentMessage;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageBroker implements IMessageBroker {
    private final IDocumentOCRService documentOCRService;
    @Autowired
    RabbitMQMessageBroker(DocumentOCRService documentOCRService) {
        this.documentOCRService = documentOCRService;
    }

    @Override
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitMQConfig.DOCUMENT_QUEUE)
    public void processDocumentsMessage(String message) {
        System.out.println("Received Message: " + message);

        ObjectMapper mapper = new ObjectMapper();
        try {
            ScanDocumentMessage scanDocumentMessage = mapper.readValue(message, ScanDocumentMessage.class);
            documentOCRService.processDocument(scanDocumentMessage.getPath());
        }
        catch (JacksonException e) {
            System.out.println(e.getMessage());
        }
    }

    public void send(String message) {
        //TODO implement send
    }

}
