package dev.ioliver.noterbackend.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends DefaultException {
  public ConflictException() {
    super("Conflict", HttpStatus.CONFLICT);
  }

  public ConflictException(String message) {
    super(message, HttpStatus.CONFLICT);
  }
}
