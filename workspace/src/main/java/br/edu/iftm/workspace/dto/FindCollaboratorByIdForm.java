package br.edu.iftm.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCollaboratorByIdForm {
    @NotBlank(message = "UserID cannot be blank!")
    private String userId;
    @NotBlank(message = "SpaceID cannot be blank!")
    private String spaceId;
}
