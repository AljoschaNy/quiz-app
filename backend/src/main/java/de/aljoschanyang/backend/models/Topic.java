package de.aljoschanyang.backend.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "topics")
public record Topic(
        @Id
        String id,
        String title,
        String icon,
        String category
) {
}
