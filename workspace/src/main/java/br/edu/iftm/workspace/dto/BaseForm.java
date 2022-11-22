package br.edu.iftm.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class BaseForm {
    @NotBlank(message = "Base name cannot be blank!")
    private String name;
    @NotBlank(message = "WorkspaceID cannot be blank!")
    private String workspaceId;
    @NotBlank(message = "UserID name cannot be blank!")
    private String userId;
}
