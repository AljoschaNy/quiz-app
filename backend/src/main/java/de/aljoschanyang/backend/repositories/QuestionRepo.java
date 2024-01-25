package de.aljoschanyang.backend.repositories;

import de.aljoschanyang.backend.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepo extends MongoRepository<Question, String> {
    List<Question> findQuestionsByTopicId(String topicId);
}
