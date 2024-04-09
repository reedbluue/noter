package dev.ioliver.noterbackend.dtos.request.document;

import jakarta.validation.constraints.NotNull;

public record DocumentUpdateDTO(

    @NotNull String id,

    @NotNull String content

) {
}
