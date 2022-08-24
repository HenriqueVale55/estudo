package br.com.estudo.estudo.exceptions;

import br.com.estudo.estudo.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class CommandExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundEntity.class)
    public ResponseEntity<Object> handNotFoundEntityException(NotFoundEntity ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        Error error = new Error();
        error.setErrorMessage(ex.getMessage());
        error.setErrorTime(OffsetDateTime.now());
        return ResponseEntity.status(status).body(error);
    }
}
