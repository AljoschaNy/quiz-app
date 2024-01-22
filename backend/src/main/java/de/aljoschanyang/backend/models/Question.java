package de.aljoschanyang.backend.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Document(collection = "questions")
public record Question(
        @Id
        String id,
        @Field("topic_id")
        String topicId,
        int difficulty,
        String query,
        String[] options,
        String answer
) {
}
