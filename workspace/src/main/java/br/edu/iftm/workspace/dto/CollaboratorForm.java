package br.edu.iftm.workspace.dto;

import br.edu.iftm.workspace.enums.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorForm {
    @NotBlank(message = "SpaceID cannot be blank!")
    private String spaceId;
    @NotBlank(message = "UserID cannot be blank!")
    private String userId;
    @NotBlank(message = "Access cannot be blank!")
    private Access access;

    public CollaboratorForm(String spaceId, String userId){
        this.spaceId = spaceId;
        this.userId = userId;
    }
}
