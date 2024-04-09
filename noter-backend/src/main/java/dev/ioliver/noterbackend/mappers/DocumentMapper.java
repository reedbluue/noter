package dev.ioliver.noterbackend.mappers;

import dev.ioliver.noterbackend.domain.entities.Document;
import dev.ioliver.noterbackend.dtos.request.document.DocumentUpdateDTO;
import dev.ioliver.noterbackend.dtos.response.document.DocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper {
  public abstract DocumentDTO toDto(Document document);

  public abstract Document toEntity(DocumentDTO documentDTO);

  public abstract void update(DocumentUpdateDTO documentUpdateDTO,
      @MappingTarget Document document);
}
