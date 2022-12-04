package br.edu.iftm.LOG.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "logWorkspace")
public class LogWorkspace {

    @Id
    private String id;
    private Instant date;
    private String spaceId;
    private String spaceName;
    private String user;
    private String collaboratorAccess;

    public LogWorkspace(String spaceId, String spaceName, String user, String collaboratorAccess) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.user = user;
        this.collaboratorAccess = collaboratorAccess;
        this.date = Instant.now();
    }
}
