package br.edu.iftm.workspace.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
@JsonIgnoreProperties(value = { "address" })
@EqualsAndHashCode
public class User {

    @Id
    private String id;
    private String email;
    private String name;
    private Address address;

    public User (String email, String name, Address address){
        this.email = email;
        this.name = name;
        this.address = address;
    }
}
