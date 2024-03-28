package dev.ioliver.noterbackend.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends DefaultException {
  public NotFoundException() {
    super("Bad request", HttpStatus.NOT_FOUND);
  }

  public NotFoundException(String message) {
    super(message, HttpStatus.NOT_FOUND);
  }
}
