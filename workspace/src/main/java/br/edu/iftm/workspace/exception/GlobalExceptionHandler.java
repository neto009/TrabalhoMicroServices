package br.edu.iftm.workspace.exception;

import br.edu.iftm.workspace.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ErrorDTO
                .builder()
                .withErrorCode("V001")
                .withMessage(ex.getFieldError().getDefaultMessage())
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleWorkspaceNotFoundException(final NotFoundException ex) {
        return new ResponseEntity<>(ErrorDTO
                .builder()
                .withErrorCode("001")
                .withMessage(ex.getMessage())
                .withStatus(HttpStatus.NOT_FOUND.value())
                .build(),
                HttpStatus.NOT_FOUND);
    }
}
