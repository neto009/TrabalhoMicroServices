package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.enums.Access;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorWorkspaceService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserService userService;

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