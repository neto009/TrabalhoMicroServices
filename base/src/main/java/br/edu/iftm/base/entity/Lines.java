package br.edu.iftm.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lines {
    private String tableA;
    private String tableB;
    private Long line;
}
