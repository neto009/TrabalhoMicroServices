package br.edu.iftm.base.repository;

import br.edu.iftm.base.entity.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends MongoRepository<Table, String> {
}
