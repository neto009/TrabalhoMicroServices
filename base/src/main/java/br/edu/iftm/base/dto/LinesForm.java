package br.edu.iftm.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinesForm {
    private String id;
    private String stringValue;
    private Long longValue;
}
