package br.edu.iftm.workspace.controller;

import br.edu.iftm.workspace.dto.CollaboratorForm;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.service.CollaboratorWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("workspacecollaborator")
public class CollaboratorWorkspaceController {

    @Autowired
    private CollaboratorWorkspaceService collaboratorWorkspaceService;

    @PostMapping
    public ResponseEntity<Collaborator> save(@RequestBody CollaboratorForm collaboratorForm) {
        return new ResponseEntity<>(collaboratorWorkspaceService.save(collaboratorForm.getSpaceId(), collaboratorForm.getUserId(),
                                                                        collaboratorForm.getAccess()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody CollaboratorForm collaboratorForm) {
        collaboratorWorkspaceService.delete(collaboratorForm.getSpaceId(), collaboratorForm.getUserId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
