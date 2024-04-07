package dev.ioliver.noterbackend.dtos.request.document;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record DocumentUpdateDTO(

    @NotNull String id,

    @NotNull @Length(max = 100) String title,

    @NotNull String content

) {
}
