package br.edu.iftm.bridge.dto;

import br.edu.iftm.bridge.enums.Access;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Collaborator {
    private User user;
    private Access access;
}
