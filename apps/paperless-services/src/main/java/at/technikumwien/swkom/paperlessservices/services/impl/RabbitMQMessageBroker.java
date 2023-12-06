package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.config.RabbitMQConfig;
import at.technikumwien.swkom.paperlessservices.data.messagequeue.DocumentResultMessage;
import at.technikumwien.swkom.paperlessservices.services.IDocumentOCRService;
import at.technikumwien.swkom.paperlessservices.services.IMessageBroker;
import at.technikumwien.swkom.paperlessservices.data.messagequeue.ScanDocumentMessage;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageBroker implements IMessageBroker {
    private final IDocumentOCRService documentOCRService;
    private final RabbitTemplate template;
    private Queue result_queue;
    @Autowired
    RabbitMQMessageBroker(DocumentOCRService documentOCRService, RabbitMQConfig config) {
        this.template = config.rabbitTemplate();
        this.result_queue = config.documentResultQueue();
        this.documentOCRService = documentOCRService;
    }

    @Override
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitMQConfig.DOCUMENT_QUEUE)
    public void processDocumentsMessage(String message) {
        System.out.println("Received Message: " + message);

        ObjectMapper mapper = new ObjectMapper();
        try {
            ScanDocumentMessage scanDocumentMessage = mapper.readValue(message, ScanDocumentMessage.class);
            String content = documentOCRService.processDocument(scanDocumentMessage.getPath(), scanDocumentMessage.getId());

            DocumentResultMessage documentResultMessage = new DocumentResultMessage(scanDocumentMessage.getId(), content);
            String result_string = mapper.writeValueAsString(documentResultMessage);

            template.convertAndSend(result_queue.getName(), result_string);
        }
        catch (JacksonException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void send(String message) {
        this.template.convertAndSend(result_queue.getName(), message);
    }

}
