package br.edu.iftm.workspace.message;

import br.edu.iftm.workspace.message.dto.MessageBaseDTO;
import br.edu.iftm.workspace.message.dto.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {

    @Value("${workspace.rabbitmq.exchange}")
    String exchange;

    @Value("${workspace.rabbitmq.routingkey}")
    String routingKey;

    @Value("${sendBase.rabbitmq.routingkey}")
    String routingKeyBase;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(MessageDTO messageDTO) {
        rabbitTemplate.convertAndSend(exchange, routingKey, messageDTO);
    }

    public void sendMessageBase(MessageBaseDTO messageBaseDTO) {
        rabbitTemplate.convertAndSend(exchange, routingKeyBase, messageBaseDTO);
    }
}
