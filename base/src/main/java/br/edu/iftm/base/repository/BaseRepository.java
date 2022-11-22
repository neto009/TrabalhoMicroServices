package br.edu.iftm.base.repository;

import br.edu.iftm.base.entity.Base;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends MongoRepository<Base, String> {
}
