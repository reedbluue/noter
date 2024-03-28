package dev.ioliver.noterbackend.controllers;

import dev.ioliver.noterbackend.constants.ExceptionMessages;
import dev.ioliver.noterbackend.dtos.request.document.DocumentUpdateDTO;
import dev.ioliver.noterbackend.dtos.request.exception.DefaultExceptionResponse;
import dev.ioliver.noterbackend.dtos.request.exception.DefaultValidationExceptionResponse;
import dev.ioliver.noterbackend.dtos.response.document.DocumentDTO;
import dev.ioliver.noterbackend.exceptions.document.DocumentNotFoundException;
import dev.ioliver.noterbackend.services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Document Controller")
@RequestMapping("/api/v1/document")
public class DocumentController {
  private final DocumentService documentService;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(
      schema = @Schema(implementation = DefaultValidationExceptionResponse.class)))
  @ApiResponse(responseCode = "404", description = ExceptionMessages.DOCUMENT_NOT_FOUND,
      content = @Content(schema = @Schema(implementation = DefaultExceptionResponse.class)))
  @Operation(description = "This endpoint get document by id", summary = "Get document by id")
  public DocumentDTO get(@PathVariable UUID id) throws DocumentNotFoundException {
    return documentService.get(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(
      schema = @Schema(implementation = DefaultValidationExceptionResponse.class)))
  @Operation(description = "This endpoint create new document", summary = "Create new document")
  public DocumentDTO create() {
    return documentService.create();
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(
      schema = @Schema(implementation = DefaultValidationExceptionResponse.class)))
  @ApiResponse(responseCode = "404", description = ExceptionMessages.DOCUMENT_NOT_FOUND,
      content = @Content(schema = @Schema(implementation = DefaultExceptionResponse.class)))
  @Operation(description = "This endpoint update document", summary = "Update document")
  public DocumentDTO update(@RequestBody @Valid DocumentUpdateDTO documentUpdateDTO)
      throws DocumentNotFoundException {
    return documentService.update(documentUpdateDTO);
  }
}
