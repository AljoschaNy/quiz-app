package de.aljoschanyang.backend.models;

import lombok.Builder;

import java.util.Arrays;
import java.util.Objects;

@Builder
public record QuestionDTO(
        String id,
        String query,
        String[] options,
        String answer
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(query, that.query) &&
                Arrays.equals(options, that.options) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, query, answer);
        result = 31 * result + Arrays.hashCode(options);
        return result;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id='" + id + '\'' +
                ", query='" + query + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer='" + answer + '\'' +
                '}';
    }
}
