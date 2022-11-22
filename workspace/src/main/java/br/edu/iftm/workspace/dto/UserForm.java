package br.edu.iftm.workspace.dto;

import br.edu.iftm.workspace.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    @NotBlank(message = "User email cannot be blank!")
    private String email;
    @NotBlank(message = "User name cannot be blank!")
    private String name;
    private Address address;
}
