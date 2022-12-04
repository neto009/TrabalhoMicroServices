package br.edu.iftm.LOG.service;

import br.edu.iftm.LOG.dto.MessageDTO;
import br.edu.iftm.LOG.entity.LogWorkspace;
import br.edu.iftm.LOG.repository.LogWorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LogWorkspaceService {
    @Autowired
    private LogWorkspaceRepository logWorkspaceRepository;

    public List<LogWorkspace> findAll() {
        return logWorkspaceRepository.findAll();
    }

    public Optional<LogWorkspace> findById(String id) {
        return logWorkspaceRepository.findById(id);
    }

    public List<LogWorkspace> findByUser(String id) {
        return logWorkspaceRepository.findByUser(id);
    }

    public List<LogWorkspace> findByDate(String date) {
        Instant currentDate = Instant.parse(date);
        return logWorkspaceRepository.findByDate(currentDate);
    }

    public List<LogWorkspace> findBySpaceId(String spaceId) {
        return logWorkspaceRepository.findBySpaceId(spaceId);
    }

    public LogWorkspace save(MessageDTO messageDTO) {
        LogWorkspace logWorkspace = logWorkspaceRepository.save(new LogWorkspace(messageDTO.getSpaceId(),
                                                messageDTO.getSpaceName(),
                                                messageDTO.getUser(),
                                                messageDTO.getCollaboratorAccess()));
        return logWorkspace;
    }
}
