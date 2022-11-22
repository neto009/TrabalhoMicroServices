package br.edu.iftm.workspace.repository;

import br.edu.iftm.workspace.entity.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace, String> {
}
