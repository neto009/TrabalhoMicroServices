package br.edu.iftm.base.entity.attributes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "numberTable")
public class NumberDocument {
    @Id
    private String id;
    private Long value;

    public NumberDocument(Long value) {
        this.value = value;
    }
}
