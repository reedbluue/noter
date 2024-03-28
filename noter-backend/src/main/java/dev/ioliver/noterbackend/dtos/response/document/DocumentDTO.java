package dev.ioliver.noterbackend.dtos.response.document;

import java.util.UUID;

public record DocumentDTO(

    UUID id,

    String title,

    String content

) {
}
