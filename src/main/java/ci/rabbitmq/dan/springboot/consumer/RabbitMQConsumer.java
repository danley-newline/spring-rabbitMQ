package ci.rabbitmq.dan.springboot.consumer;

import ci.rabbitmq.dan.springboot.config.RabbitMQConfig;
import ci.rabbitmq.dan.springboot.entity.OrderDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(OrderDTO orderDTO){
        System.out.println("Consumer is able to get the message "+ orderDTO);
    }
}
