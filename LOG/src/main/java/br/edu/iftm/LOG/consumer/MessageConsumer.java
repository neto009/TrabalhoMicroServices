package br.edu.iftm.LOG.consumer;

import br.edu.iftm.LOG.dto.MessageDTO;
import br.edu.iftm.LOG.entity.Log;
import br.edu.iftm.LOG.service.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private LogService logService;

    @RabbitListener(queues = "workspace.queue")
    public void receive (MessageDTO messageDTO) {
        Log log = logService.save(messageDTO);
    }
}
