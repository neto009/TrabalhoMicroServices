package br.edu.iftm.LOG.repository;

import br.edu.iftm.LOG.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    Optional<Log> findByUser (String id);
}
