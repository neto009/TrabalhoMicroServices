package br.edu.iftm.workspace.controller;

import br.edu.iftm.workspace.dto.CollaboratorForm;
import br.edu.iftm.workspace.dto.FindCollaboratorByIdForm;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.service.CollaboratorWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("workspacecollaborator")
public class CollaboratorWorkspaceController {

    @Autowired
    private CollaboratorWorkspaceService collaboratorWorkspaceService;

    @GetMapping("/colaborator")
    public ResponseEntity<Collaborator> findById(@Valid @RequestBody FindCollaboratorByIdForm findCollaboratorByIdForm) {
        return new ResponseEntity<>(collaboratorWorkspaceService.findById(findCollaboratorByIdForm.getUserId(),
                findCollaboratorByIdForm.getSpaceId()), HttpStatus.OK);
    }

    @GetMapping("/{spaceId}")
    public ResponseEntity<List<Collaborator>> findAll(@PathVariable String spaceId) {
        return new ResponseEntity<>(collaboratorWorkspaceService.findAll(spaceId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Collaborator> save(@Valid @RequestBody CollaboratorForm collaboratorForm) {
        return new ResponseEntity<>(collaboratorWorkspaceService.save(collaboratorForm.getSpaceId(), collaboratorForm.getUserId(),
                                                                        collaboratorForm.getAccess()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Collaborator> update(@Valid @RequestBody CollaboratorForm collaboratorForm) {
        return new ResponseEntity<>(collaboratorWorkspaceService.save(collaboratorForm.getSpaceId(), collaboratorForm.getUserId(),
                collaboratorForm.getAccess()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@Valid @RequestBody CollaboratorForm collaboratorForm) {
        collaboratorWorkspaceService.delete(collaboratorForm.getSpaceId(), collaboratorForm.getUserId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
