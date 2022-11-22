package br.edu.iftm.base.repository;

import br.edu.iftm.base.entity.ReferenceAttributes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceAttributesRepository extends MongoRepository<ReferenceAttributes, String>{
}
