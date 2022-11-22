package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.enums.Access;
import br.edu.iftm.workspace.dto.WorkspaceForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.exception.NotFoundException;
import br.edu.iftm.workspace.message.Message;
import br.edu.iftm.workspace.message.dto.MessageDTO;
import br.edu.iftm.workspace.repository.BaseRepository;
import br.edu.iftm.workspace.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private Message message;

    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    public Workspace findById(String id) {
        return workspaceRepository.findById(id).orElseThrow(() -> new NotFoundException("Workspace doesn't Exist!"));
    }

    public Workspace save(WorkspaceForm workspaceForm) {
        User user = userService.findById(workspaceForm.getUserId());
        Collaborator collaborator = new Collaborator(user, Access.OWNER);
        Workspace workspace = workspaceRepository.save(new Workspace(workspaceForm.getName(), Arrays.asList(collaborator), Arrays.asList()));
        message.sendMessage(new MessageDTO(workspace.getId(), workspace.getName(), user.getId(), Access.OWNER.toString()));
        return workspace;
    }

    public Workspace update(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    public void delete(String id) {
        Workspace workspace = this.findById(id);
        workspace.getBases().parallelStream().forEach(base -> baseRepository.deleteById(base.getId()));
        workspaceRepository.deleteById(id);
    }
}
