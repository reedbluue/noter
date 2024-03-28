package dev.ioliver.noterbackend.events.document;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class DocumentUpdateEventListener implements ApplicationListener<DocumentUpdatedEvent> {
  private final SimpMessagingTemplate messagingTemplate;

  @Override
  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  public void onApplicationEvent(DocumentUpdatedEvent event) {
    messagingTemplate.convertAndSend("/topic/doc-update-" + event.getDocumentUpdatedEventDTO().id(),
        event.getDocumentUpdatedEventDTO());
  }
}