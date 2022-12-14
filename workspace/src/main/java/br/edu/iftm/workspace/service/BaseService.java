package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.BaseUpdateForm;
import br.edu.iftm.workspace.enums.Access;
import br.edu.iftm.workspace.dto.BaseForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.exception.NotFoundException;
import br.edu.iftm.workspace.message.Message;
import br.edu.iftm.workspace.message.dto.MessageBaseDTO;
import br.edu.iftm.workspace.message.dto.MessageDTO;
import br.edu.iftm.workspace.repository.BaseRepository;
import br.edu.iftm.workspace.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;

    @Autowired
    private Message message;

    public Base findById(String id) {
        return baseRepository.findById(id).orElseThrow(() -> new NotFoundException("Base no Exist!"));
    }

    public Base save(BaseForm baseForm) {
        Workspace workspace = workspaceService.findById(baseForm.getWorkspaceId());
        List<Collaborator> collaboratorList = new ArrayList<>();
        User user = userService.findById(baseForm.getUserId());
        Optional<Collaborator> owner = workspace.getCollaboratorList().stream()
                .filter(colab-> colab.getUser().getId().equals(baseForm.getUserId())).findFirst();
        if(!owner.isPresent()){
            collaboratorList.add(new Collaborator(user, Access.OWNER));
        }
        Base base = new Base(baseForm.getName(), collaboratorList);
        Base currentBase = baseRepository.save(base);
        List<Base> baseList = workspace.getBases();
        baseList.add(currentBase);
        workspace.setBases(baseList);
        workspaceRepository.save(workspace);
        message.sendMessageBase(new MessageBaseDTO(currentBase.getId(), currentBase.getName()));
        message.sendMessage(new MessageDTO(currentBase.getId(), currentBase.getName(), user.getId(), Access.OWNER.toString()));
        return currentBase;
    }

    public Base update(BaseUpdateForm baseUpdateForm) {
        Base base = baseRepository.findById(baseUpdateForm.getId())
                .orElseThrow(()-> new NotFoundException("Base no Exist!"));
        base.setName(baseUpdateForm.getName());
        Optional<Access> userAccess = base.getCollaboratorList()
                .stream()
                .filter(i-> i.getUser().getId().equals(baseUpdateForm.getUserId()))
                .map(j-> j.getAccess())
                .findAny();
        if(!userAccess.isEmpty()) {
            message.sendMessage(new MessageDTO(base.getId(), base.getName(), baseUpdateForm.getUserId(), userAccess.toString()));
        } else {
            //Workspace workspace = workspaceRepository.findByBasesById(baseUpdateForm.getId());
        }
        return baseRepository.save(base);
    }
    public void delete(String id) {
        baseRepository.deleteById(id);
    }
}
