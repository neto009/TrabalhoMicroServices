package br.edu.iftm.base.dto;

import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.entity.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDTO {
    private String id;
    private String name;
    private ReferenceAttributes attributes;
    private List<ReferenceAttributes> referenceDataAttributes;

    public TableDTO(Table table) {
        this.id = table.getId();
        this.name = table.getName();
        this.attributes = table.getAttributes();
        this.referenceDataAttributes = table.getReferenceDataAttributes();
    }
}
