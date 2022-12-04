package br.edu.iftm.LOG.consumer;

import br.edu.iftm.LOG.dto.MessageBaseDTO;
import br.edu.iftm.LOG.dto.MessageDTO;
import br.edu.iftm.LOG.entity.LogBase;
import br.edu.iftm.LOG.entity.LogWorkspace;
import br.edu.iftm.LOG.service.LogBaseService;
import br.edu.iftm.LOG.service.LogWorkspaceService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private LogWorkspaceService logWorkspaceService;

    @Autowired
    private LogBaseService logBaseService;

    @RabbitListener(queues = "workspace.queue")
    public void receive (MessageDTO messageDTO) {
        LogWorkspace logWorkspace = logWorkspaceService.save(messageDTO);
    }

    @RabbitListener(queues = "base.queue")
    public void receiveBase (MessageBaseDTO messageBaseDTO) {
        LogBase logBase = logBaseService.save(messageBaseDTO);
    }
}
