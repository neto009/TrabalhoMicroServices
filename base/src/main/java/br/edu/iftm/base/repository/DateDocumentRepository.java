package br.edu.iftm.base.repository;

import br.edu.iftm.base.entity.attributes.DateDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateDocumentRepository extends MongoRepository<DateDocument,String> {
}
