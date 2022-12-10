package br.edu.iftm.bridge.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class WorkspaceDTO {

    private String id;
    private String name;
    private List<Collaborator> collaboratorList;
    private List<Base> bases;
}
