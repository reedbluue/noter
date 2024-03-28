package dev.ioliver.noterbackend.handle;

import dev.ioliver.noterbackend.constants.ExceptionMessages;
import dev.ioliver.noterbackend.dtos.request.DefaultExceptionResponse;
import dev.ioliver.noterbackend.dtos.request.DefaultValidationExceptionResponse;
import dev.ioliver.noterbackend.exceptions.DefaultException;
import org.hibernate.query.sqm.UnknownPathException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<DefaultValidationExceptionResponse> methodArgumentNotValid(
      MethodArgumentNotValidException e) {
    return ResponseEntity.status(e.getStatusCode())
        .contentType(MediaType.APPLICATION_JSON)
        .body(new DefaultValidationExceptionResponse(e));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<DefaultExceptionResponse> authenticationException(
      HttpMessageNotReadableException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new DefaultExceptionResponse(HttpStatus.BAD_REQUEST,
            e.getMessage().contains(ExceptionMessages.REQUEST_BODY_MISSING)
                ? ExceptionMessages.REQUEST_BODY_MISSING : e.getMessage()));
  }

  @ExceptionHandler(UnknownPathException.class)
  public ResponseEntity<DefaultExceptionResponse> unknownPathException(UnknownPathException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new DefaultExceptionResponse(HttpStatus.BAD_REQUEST,
            ExceptionMessages.UNKNOWN_PATH_EXCEPTION));
  }

  @ExceptionHandler(DefaultException.class)
  public ResponseEntity<DefaultExceptionResponse> defaultException(DefaultException e) {
    return ResponseEntity.status(e.getStatus())
        .contentType(MediaType.APPLICATION_JSON)
        .body(new DefaultExceptionResponse(e.getStatus(), e.getMessage()));
  }
}
