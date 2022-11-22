package br.edu.iftm.base.message;

import br.edu.iftm.base.message.dto.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {

    @Value("${base.rabbitmq.exchange}")
    String exchange;

    @Value("${base.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(MessageDTO messageDTO) {
        rabbitTemplate.convertAndSend(exchange, routingKey, messageDTO);
    }
}

