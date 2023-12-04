package at.technikumwien.swkom.paperlessservices.services;

import at.technikumwien.swkom.paperlessservices.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface IRabbitListener {
    @RabbitListener(queues = RabbitMQConfig.DOCUMENT_QUEUE)
    void processMessage(String message);
}
