package dev.ioliver.noterbackend.services;

import dev.ioliver.noterbackend.domain.entities.Document;
import dev.ioliver.noterbackend.dtos.request.document.DocumentUpdateDTO;
import dev.ioliver.noterbackend.dtos.response.document.DocumentDTO;
import dev.ioliver.noterbackend.dtos.response.document.DocumentUpdatedEventDTO;
import dev.ioliver.noterbackend.events.document.DocumentUpdatedEvent;
import dev.ioliver.noterbackend.exceptions.document.DocumentNotFoundException;
import dev.ioliver.noterbackend.mappers.DocumentMapper;
import dev.ioliver.noterbackend.repositories.DocumentRepository;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DocumentService {
  private final DocumentRepository documentRepository;
  private final DocumentMapper documentMapper;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Transactional(readOnly = true)
  public DocumentDTO get(@NotNull String id) throws DocumentNotFoundException {
    Optional<Document> document = documentRepository.optionalById(id);
    DocumentDTO documentDTO;
    if (document.isEmpty()) {
      documentDTO = create(id);
    } else {
      documentDTO = documentMapper.toDto(document.get());
    }
    return documentDTO;
  }

  @Transactional
  public DocumentDTO create(@NotNull String id) {
    Document document = Document.builder().id(id).build();
    Document saved = documentRepository.save(document);
    return documentMapper.toDto(saved);
  }

  @Transactional
  public DocumentDTO update(@NotNull DocumentUpdateDTO documentUpdateDTO)
      throws DocumentNotFoundException {
    Document document = documentMapper.toEntity(get(documentUpdateDTO.id()));
    documentMapper.update(documentUpdateDTO, document);
    Document saved = documentRepository.save(document);
    applicationEventPublisher.publishEvent(
        new DocumentUpdatedEvent(this, new DocumentUpdatedEventDTO(saved.getId())));
    return documentMapper.toDto(saved);
  }
}
