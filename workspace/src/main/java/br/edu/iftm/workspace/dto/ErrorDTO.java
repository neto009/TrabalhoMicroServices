package br.edu.iftm.workspace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ErrorDTO {
    private String errorCode;
    private int status;
    private String message;
    private String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a z Z"));

    private ErrorDTO (String errorCode, String message, int status){
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
    }

    public static ErrorDTOBuilder builder(){
        return new ErrorDTOBuilder();
    }
    public static class ErrorDTOBuilder {
        private String errorCode;
        private int status;
        private String message;

        public ErrorDTOBuilder() {
        }

        public ErrorDTOBuilder withErrorCode(final String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorDTOBuilder withStatus (final int status) {
            this.status = status;
            return this;
        }

        public ErrorDTOBuilder withMessage (final String message) {
            this.message = message;
            return this;
        }

        public ErrorDTO build(){
            return new ErrorDTO(errorCode, message, status);
        }
    }
}
