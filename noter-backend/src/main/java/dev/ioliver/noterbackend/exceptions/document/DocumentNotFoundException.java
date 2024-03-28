package dev.ioliver.noterbackend.exceptions.document;

import dev.ioliver.noterbackend.constants.ExceptionMessages;
import dev.ioliver.noterbackend.exceptions.NotFoundException;
import java.util.UUID;

public class DocumentNotFoundException extends NotFoundException {
  public DocumentNotFoundException() {
    super(ExceptionMessages.DOCUMENT_NOT_FOUND);
  }

  public DocumentNotFoundException(UUID id) {
    super(ExceptionMessages.DOCUMENT_NOT_FOUND + " | Id: " + id);
  }
}