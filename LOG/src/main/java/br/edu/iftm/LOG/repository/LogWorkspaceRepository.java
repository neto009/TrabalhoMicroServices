package br.edu.iftm.LOG.repository;

import br.edu.iftm.LOG.entity.LogWorkspace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface LogWorkspaceRepository extends MongoRepository<LogWorkspace, String> {

    @Query("{'user': ?0}")
    List<LogWorkspace> findByUser (String id);

    List<LogWorkspace> findBySpaceId(String spaceId);

    List<LogWorkspace> findByDate(Instant date);
}
