package br.edu.iftm.bridge.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Base {

    private String id;
    private String name;
    private List<Collaborator> collaboratorList;
}
