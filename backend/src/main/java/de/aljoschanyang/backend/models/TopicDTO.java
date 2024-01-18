package de.aljoschanyang.backend.models;

import lombok.Builder;

@Builder
public record TopicDTO(
        String _id,
        String title,
        String icon,
        String category
) {
}
