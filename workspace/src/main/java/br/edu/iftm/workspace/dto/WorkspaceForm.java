package br.edu.iftm.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class WorkspaceForm {
    @NotBlank(message = "Workspace name cannot be blank!")
    private String name;
    @NotBlank(message = "UserID cannot be blank!")
    private String userId;
}
