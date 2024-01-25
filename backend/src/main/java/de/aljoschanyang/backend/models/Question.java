package de.aljoschanyang.backend.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Objects;

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
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Question question = (Question) o;
                return difficulty == question.difficulty &&
                        Objects.equals(id, question.id) &&
                        Objects.equals(topicId, question.topicId) &&
                        Objects.equals(query, question.query) &&
                        Arrays.equals(options, question.options) &&
                        Objects.equals(answer, question.answer);
        }

        @Override
        public int hashCode() {
                int result = Objects.hash(id, topicId, difficulty, query, answer);
                result = 31 * result + Arrays.hashCode(options);
                return result;
        }

        @Override
        public String toString() {
                return "Question{" +
                        "id='" + id + '\'' +
                        ", topicId='" + topicId + '\'' +
                        ", difficulty=" + difficulty +
                        ", query='" + query + '\'' +
                        ", options=" + Arrays.toString(options) +
                        ", answer='" + answer + '\'' +
                        '}';
        }
}
