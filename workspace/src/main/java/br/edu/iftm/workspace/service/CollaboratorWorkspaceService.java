package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.enums.Access;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.exception.NotFoundException;
import br.edu.iftm.workspace.message.Message;
import br.edu.iftm.workspace.message.dto.MessageDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorWorkspaceService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private Message message;

    public Collaborator findById(String userId, String spaceId) {
        Workspace workspace = workspaceService.findById(spaceId);
        Collaborator collaborator = workspace.getCollaboratorList().stream()
                .filter(i-> i.getUser().getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found!"));
        return collaborator;
    }

    public List<Collaborator> findAll(String spaceId) {
        Workspace workspace = workspaceService.findById(spaceId);
        return workspace.getCollaboratorList();
    }


    public Collaborator save(String spaceId, String userId, Access access) {
        User user = userService.findById(userId);
        Collaborator collaborator = new Collaborator(user, access);
        Update update = new Update();
        update.addToSet("collaboratorList", collaborator);
        Criteria criteria = Criteria.where("_id").is(spaceId);
        mongoTemplate.updateFirst(Query.query(criteria), update, "workspace");
        return collaborator;
    }

    public void delete(String spaceId, String userId) {
        Query query = Query.query(Criteria.where("user.$id").is(new ObjectId(userId)));
        Update update = new Update().pull("collaboratorList", query);
        Criteria criteria = Criteria.where("_id").is(spaceId);
        mongoTemplate.updateFirst(Query.query(criteria), update, "workspace");
    }
}