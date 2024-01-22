package de.aljoschanyang.backend.services;

import de.aljoschanyang.backend.models.Question;
import de.aljoschanyang.backend.models.QuestionDTO;
import de.aljoschanyang.backend.repositories.QuestionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepo questionRepo;

    private QuestionDTO convertToDTO (Question question) {
        return QuestionDTO.builder()
                .id(question.id())
                .query(question.query())
                .options(question.options())
                .answer(question.answer())
                .build();
    }

    public List<QuestionDTO> getQuestionsByTopicId(String topicId) {
        List<Question> questions = questionRepo.findQuestionsByTopicId(topicId);

        return questions.stream()
                .map(this::convertToDTO)
                .toList();
    }
}
