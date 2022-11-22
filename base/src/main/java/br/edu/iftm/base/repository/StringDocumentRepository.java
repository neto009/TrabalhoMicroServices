package br.edu.iftm.base.repository;

import br.edu.iftm.base.entity.attributes.StringDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringDocumentRepository extends MongoRepository<StringDocument, String> {
}
