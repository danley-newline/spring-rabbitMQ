package ci.rabbitmq.dan.springboot.producer;

import ci.rabbitmq.dan.springboot.config.RabbitMQConfig;
import ci.rabbitmq.dan.springboot.entity.Order;
import ci.rabbitmq.dan.springboot.entity.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RMQProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @PostMapping("/order")
    public OrderDTO placeOrder(@RequestBody Order order){
        OrderDTO orderDTO = new OrderDTO(order, "Order placed", "Hi producer yours Order is placed ");

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderDTO);
        return orderDTO;
    }
}
