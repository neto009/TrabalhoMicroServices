package br.edu.iftm.base.entity.attributes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "stringTable")
public class StringDocument {
    @Id
    private String id;
    private String value;

    public StringDocument (String value) {
        this.value = value;
    }
}
