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
@Document(collection = "logBase")
public class LogBase {

    @Id
    private String id;
    private Instant date;
    private String spaceId;
    private String user;
    private String collaboratorAccess;

    private String requestType;

    public LogBase(String spaceId, String requestType, String user, String collaboratorAccess) {
        this.spaceId = spaceId;
        this.requestType = requestType;
        this.user = user;
        this.collaboratorAccess = collaboratorAccess;
        this.date = Instant.now();
    }
}
