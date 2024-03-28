package dev.ioliver.noterbackend.dtos.request.exception;

import dev.ioliver.noterbackend.constants.ExceptionMessages;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Getter
public class DefaultValidationExceptionResponse extends DefaultExceptionResponse {
  private final List<InvalidArgumentErrorDto> fieldsErrors = new ArrayList<>();

  public DefaultValidationExceptionResponse(MethodArgumentNotValidException e) {
    super(HttpStatus.BAD_REQUEST, ExceptionMessages.DEFAULT_VALIDATION_EXCEPTION);

    if (e.getBindingResult() != null && e.getBindingResult().hasFieldErrors())
      for (var fieldError : e.getBindingResult().getFieldErrors()) {
        fieldsErrors.add(InvalidArgumentErrorDto.builder()
            .field(fieldError.getField())
            .message(fieldError.getDefaultMessage())
            .build());
      }
  }

  @Builder
  private record InvalidArgumentErrorDto(String field, String message) {
  }
}
