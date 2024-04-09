package dev.ioliver.noterbackend.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends DefaultException {
  public InternalServerException() {
    super("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public InternalServerException(String message) {
    super(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
