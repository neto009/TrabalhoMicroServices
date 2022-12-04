package br.edu.iftm.LOG.service;

import br.edu.iftm.LOG.dto.MessageBaseDTO;
import br.edu.iftm.LOG.entity.LogBase;
import br.edu.iftm.LOG.repository.LogBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LogBaseService {
    @Autowired
    private LogBaseRepository logBaseRepository;

    public List<LogBase> findAll() {
        return logBaseRepository.findAll();
    }

    public Optional<LogBase> findById(String id) {
        return logBaseRepository.findById(id);
    }

    public List<LogBase> findByUser(String id) {
        return logBaseRepository.findByUser(id);
    }

    public List<LogBase> findByDate(String date) {
        Instant currentDate = Instant.parse(date);
        return logBaseRepository.findByDate(currentDate);
    }

    public List<LogBase> findByRequest(String requestType) {
        return logBaseRepository.findByRequestType(requestType);
    }

    public List<LogBase> findBySpaceId(String spaceId) {
        return logBaseRepository.findBySpaceId(spaceId);
    }

    public LogBase save(MessageBaseDTO messageBaseDTO) {
        LogBase logBase = logBaseRepository.save(new LogBase(messageBaseDTO.getSpaceId(),
                messageBaseDTO.getRequestType(),
                messageBaseDTO.getUser(),
                messageBaseDTO.getCollaboratorAccess()));
        return logBase;
    }
}
