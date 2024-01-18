package de.aljoschanyang.backend.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collation = "topics")
public record Topic(
        @Id
        String _id,
        String title,
        String icon,
        String category
) {
}
