package br.edu.iftm.base.service;

import br.edu.iftm.base.dto.BaseDTO;
import br.edu.iftm.base.dto.TableDTO;
import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.repository.BaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private TableService tableService;

    @Autowired
    private ReferenceAttributesService referenceAttributesService;

    @Autowired
    private MongoTemplate mongoTemplate;

    public BaseDTO findById(String id) {
        Base base = baseRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
        return new BaseDTO(base);
    }

    public TableDTO createTable(String baseId) {
        ReferenceAttributes referenceAttributes = referenceAttributesService.save();
        Table table = tableService.save(new Table("Teste", referenceAttributes));
        Update update = new Update();
        update.push("table", table.getId());
        Criteria criteria = Criteria.where("_id").is(baseId);
        mongoTemplate.updateFirst(Query.query(criteria), update, Base.class);
        return new TableDTO(table);
    }

    public Base update(Base base) {
        return baseRepository.save(base);
    }

    public Base save(String id, String name) {
        List<Table> tableList = new ArrayList<>();
        ReferenceAttributes referenceAttributes = referenceAttributesService.save();
        Table table = tableService.save(new Table("Teste", referenceAttributes));
        tableList.add(table);
        Base base = new Base(id, name, tableList);
        return baseRepository.save(base);
    }
}
