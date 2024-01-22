package de.aljoschanyang.backend.models;

import lombok.Builder;

@Builder
public record QuestionDTO(
        String id,
        String query,
        String[] options,
        String answer
) {
}
