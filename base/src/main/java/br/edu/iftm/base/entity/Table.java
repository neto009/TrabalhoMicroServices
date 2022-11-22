package br.edu.iftm.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "table")
public class Table {
    @Id
    private String id;
    private String name;
    private List<String> referenceDocumentsId = new ArrayList<>();
    private List<Lines> linesReference = new ArrayList<>();
    @DBRef
    private ReferenceAttributes attributes;
    @Transient
    private List<ReferenceAttributes> referenceDataAttributes;

    public Table (String name, ReferenceAttributes attributes){
        this.name = name;
        this.attributes = attributes;
    }
}
