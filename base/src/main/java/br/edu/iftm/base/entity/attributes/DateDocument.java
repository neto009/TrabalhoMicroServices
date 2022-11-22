package br.edu.iftm.base.entity.attributes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dateTable")
public class DateDocument {
    @Id
    private String id;
    private String value;

    public DateDocument (String value) {
        this.value = value;
    }
}
