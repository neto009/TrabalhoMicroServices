package br.edu.iftm.base.repository.impl;

import br.edu.iftm.base.entity.ReferenceAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ReferenceAttibutesImplements {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean saveDateDocument(String attributesId, String documentId) {
        try {
            Update update = new Update();
            update.push("dateDocument", documentId);
            Criteria criteria = Criteria.where("_id").is(attributesId);
            mongoTemplate.updateFirst(Query.query(criteria), update, ReferenceAttributes.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean saveStringDocument(String attributesId, String documentId) {
        try {
            Update update = new Update();
            update.push("stringDocument", documentId);
            Criteria criteria = Criteria.where("_id").is(attributesId);
            mongoTemplate.updateFirst(Query.query(criteria), update, ReferenceAttributes.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean saveNumberDocument(String attributesId, String documentId) {
        try {
            Update update = new Update();
            update.push("numberDocument", documentId);
            Criteria criteria = Criteria.where("_id").is(attributesId);
            mongoTemplate.updateFirst(Query.query(criteria), update, ReferenceAttributes.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
