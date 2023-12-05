package at.technikumwien.swkom.paperlessrest.services.impl;

import at.technikumwien.swkom.paperlessrest.config.RabbitMQConfig;
import at.technikumwien.swkom.paperlessrest.services.IMessageBroker;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageBroker implements IMessageBroker {
    private final RabbitTemplate template;
    private final Queue queue;

    @Autowired
    RabbitMQMessageBroker(RabbitMQConfig config) {
        this.template = config.rabbitTemplate();
        this.queue = config.documentQueue();
    }

    @Override
    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
    }

    @Override
    public void processOCRResultsMessage() {
        //TODO receive message from ocr-results queue and save to DB
    }
}
