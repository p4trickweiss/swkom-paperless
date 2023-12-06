package at.technikumwien.swkom.paperlessrest.services.impl;

import at.technikumwien.swkom.paperlessrest.config.RabbitMQConfig;
import at.technikumwien.swkom.paperlessrest.data.messagequeue.DocumentResultMessage;
import at.technikumwien.swkom.paperlessrest.services.IContentUpdateService;
import at.technikumwien.swkom.paperlessrest.services.IMessageBroker;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageBroker implements IMessageBroker {
    private final IContentUpdateService contentUpdateService;
    private final RabbitTemplate template;
    private final Queue queue;

    @Autowired
    RabbitMQMessageBroker(RabbitMQConfig config, ContentUpdateService contentUpdateService) {
        this.template = config.rabbitTemplate();
        this.queue = config.documentQueue();
        this.contentUpdateService = contentUpdateService;
    }

    @Override
    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
    }

    @Override
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitMQConfig.DOCUMENT_RESULT_QUEUE)
    public void processOCRResultsMessage(String message) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            DocumentResultMessage documentResultMessage = mapper.readValue(message, DocumentResultMessage.class);
            contentUpdateService.update(documentResultMessage.getId(), documentResultMessage.getContent());
        }
        catch (JacksonException e) {
            System.out.println(e.getMessage());
        }

    }
}
