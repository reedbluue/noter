package dev.ioliver.noterbackend.dtos.request.document;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import org.hibernate.validator.constraints.Length;

public record DocumentUpdateDTO(

    @NotNull UUID id,

    @NotNull @Length(min = 3, max = 100) String title,

    @NotNull String content

) {
}
