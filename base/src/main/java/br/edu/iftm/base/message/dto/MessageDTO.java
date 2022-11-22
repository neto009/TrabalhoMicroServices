package br.edu.iftm.base.message.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String spaceId;
    private String spaceName;
    private String user;
    private String collaboratorAccess;
}