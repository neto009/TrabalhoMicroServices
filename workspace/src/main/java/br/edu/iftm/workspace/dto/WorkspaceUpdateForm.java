package br.edu.iftm.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class WorkspaceUpdateForm {
    @NotBlank(message = "Workspace ID cannot be blank!")
    private String id;
    @NotBlank(message = "Workspace name cannot be blank!")
    private String name;
    @NotBlank(message = "UserID cannot be blank!")
    private String userId;
}