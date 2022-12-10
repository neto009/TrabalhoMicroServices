package br.edu.iftm.bridge.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class User {
    private String id;
    private String email;
    private String name;
    private Address address;
}
