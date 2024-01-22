package de.aljoschanyang.backend.models;

import lombok.Builder;

@Builder
public record TopicDTO(
        String id,
        String title,
        String icon,
        String category
) {
}
