package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @NotBlank(message = "Number cannot be blank!")
    private String number;
    @NotBlank(message = "Street cannot be blank!")
    private String street;
    @NotBlank(message = "District cannot be blank!")
    private String district;
}
