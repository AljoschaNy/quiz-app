package de.aljoschanyang.backend.services;

import de.aljoschanyang.backend.exceptions.NoQuestionsException;
import de.aljoschanyang.backend.models.Question;
import de.aljoschanyang.backend.models.QuestionDTO;
import de.aljoschanyang.backend.repositories.QuestionRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuestionServiceTest {
    private final QuestionRepo mockQuestionRepo = mock(QuestionRepo.class);
    private final QuestionService questionService = new QuestionService(mockQuestionRepo);

    @Test
    void getQuestionsByTopicId_whenQuestionsExist_thenReturnListOfQuestionDTOs() {
        Question question = Question.builder()
                .id("1")
                .topicId("topicId")
                .difficulty(1)
                .query("query")
                .options(new String[]{"opt1", "opt2"})
                .answer("opt1")
                .build();

        QuestionDTO questionDTO = QuestionDTO.builder()
                .id(question.id())
                .query(question.query())
                .options(question.options())
                .answer(question.answer())
                .build();

        List<Question> questions = List.of(question);
        List<QuestionDTO> expected = List.of(questionDTO);

        when(mockQuestionRepo.findQuestionsByTopicId(question.topicId())).thenReturn(questions);
        List<QuestionDTO> actual = questionService.getQuestionsByTopicId(question.topicId());

        verify(mockQuestionRepo).findQuestionsByTopicId(question.topicId());
        assertEquals(expected, actual);
    }

    @Test
    void getQuestionsByTopicId_whenNoQuestionsFound_thenThrowNoQuestionsException() {
        String topicId = "invalidId";

        when(mockQuestionRepo.findQuestionsByTopicId(topicId)).thenReturn(Collections.emptyList());
        assertThrows(NoQuestionsException.class, () -> questionService.getQuestionsByTopicId(topicId));

        verify(mockQuestionRepo).findQuestionsByTopicId(topicId);
    }
}