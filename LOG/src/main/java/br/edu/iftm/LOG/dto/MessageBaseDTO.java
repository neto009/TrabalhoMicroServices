package br.edu.iftm.LOG.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBaseDTO {
    private String spaceId;
    private String requestType;
    private String user;
    private String collaboratorAccess;
}
