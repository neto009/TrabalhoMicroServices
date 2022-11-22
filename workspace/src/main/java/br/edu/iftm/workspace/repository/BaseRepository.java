package br.edu.iftm.workspace.repository;

import br.edu.iftm.workspace.entity.Base;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends MongoRepository<Base, String> {
}
