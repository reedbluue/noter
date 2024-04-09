package dev.ioliver.noterbackend.events.document;

import dev.ioliver.noterbackend.dtos.response.document.DocumentUpdatedEventDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DocumentUpdatedEvent extends ApplicationEvent {
  private final DocumentUpdatedEventDTO documentUpdatedEventDTO;

  public DocumentUpdatedEvent(Object source, DocumentUpdatedEventDTO documentUpdatedEventDTO) {
    super(source);
    this.documentUpdatedEventDTO = documentUpdatedEventDTO;
  }
}
