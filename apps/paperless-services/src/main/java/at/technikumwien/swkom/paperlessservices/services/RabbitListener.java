package at.technikumwien.swkom.paperlessservices.services;

import at.technikumwien.swkom.paperlessservices.config.RabbitMQConfig;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener implements IRabbitListener{
    @Override
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitMQConfig.DOCUMENT_QUEUE)
    public void processMessage(String message) {
        System.out.println("Received Message: " + message);
    }
}
