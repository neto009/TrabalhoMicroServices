package br.edu.iftm.workspace.entity;

import br.edu.iftm.workspace.enums.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Collaborator {

    @DBRef
    private User user;
    private Access access;
}
