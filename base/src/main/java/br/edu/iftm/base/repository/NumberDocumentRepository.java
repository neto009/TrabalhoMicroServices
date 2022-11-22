package br.edu.iftm.base.repository;

import br.edu.iftm.base.entity.attributes.NumberDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberDocumentRepository extends MongoRepository<NumberDocument, String> {
}
