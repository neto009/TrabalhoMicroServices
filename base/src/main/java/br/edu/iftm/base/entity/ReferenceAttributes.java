package br.edu.iftm.base.entity;

import br.edu.iftm.base.entity.attributes.DateDocument;
import br.edu.iftm.base.entity.attributes.NumberDocument;
import br.edu.iftm.base.entity.attributes.StringDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "referenceAttributes")
public class ReferenceAttributes {
    @Id
    private String id;
    @DBRef(lazy = true)
    private List<NumberDocument> numberDocument = new ArrayList<>();
    @DBRef(lazy = true)
    private List<DateDocument> dateDocument = new ArrayList<>();
    @DBRef(lazy = true)
    private List<StringDocument> stringDocument = new ArrayList<>();

    public ReferenceAttributes(List<NumberDocument> numberDocument,
                               List<DateDocument> dateDocument,
                               List<StringDocument> stringDocument) {
        this.numberDocument = numberDocument;
        this.dateDocument = dateDocument;
        this.stringDocument = stringDocument;
    }
}
