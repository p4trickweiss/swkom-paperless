package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.config.RabbitMQConfig;
import at.fhtw.swkom.paperless.services.IMessageBroker;
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
    public void send(int id) {
        this.template.convertAndSend(queue.getName(), String.valueOf(id));
    }
}
