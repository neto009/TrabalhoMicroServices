package br.edu.iftm.LOG.repository;

import br.edu.iftm.LOG.entity.LogBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface LogBaseRepository extends MongoRepository<LogBase, String> {


    @Query("{'user': ?0}")
    List<LogBase> findByUser (String id);

    List<LogBase> findBySpaceId(String spaceId);

    List<LogBase> findByDate(Instant date);

    List<LogBase> findByRequestType(String requestType);
}
