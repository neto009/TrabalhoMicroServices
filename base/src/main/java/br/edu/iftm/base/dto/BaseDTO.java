package br.edu.iftm.base.dto;

import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.entity.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    private String id;
    private String name;
    private List<TableDTO> table;

    public BaseDTO (Base base){
        this.id = base.getId();
        this.name = base.getName();
        this.table = convertToDTO(base.getTable());
    }

    public List<TableDTO> convertToDTO(List<Table> tables){
        return tables.stream().map(TableDTO::new).collect(Collectors.toList());
    }
}
