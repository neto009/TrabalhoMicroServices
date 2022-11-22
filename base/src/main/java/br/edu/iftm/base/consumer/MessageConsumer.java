package br.edu.iftm.base.consumer;

import br.edu.iftm.base.consumer.dto.ConsumerDTO;
import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.service.BaseService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private BaseService baseService;

    @RabbitListener(queues = "workspacesend.queue")
    public void receive (ConsumerDTO consumerDTO) {
        Base base = baseService.save(consumerDTO.getId(), consumerDTO.getName());
    }
}
