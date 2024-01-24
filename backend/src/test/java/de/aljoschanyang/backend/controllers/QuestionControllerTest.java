package de.aljoschanyang.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.aljoschanyang.backend.models.Question;
import de.aljoschanyang.backend.models.QuestionDTO;
import de.aljoschanyang.backend.repositories.QuestionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private ObjectMapper objectMapper;
    private final String BASE_URI = "/api/questions";

    @Test
    @DirtiesContext
    void getQuestionsByTopicId_whenQuestionsExist_thenReturnListOfQuestionDTOs() throws Exception {
        Question question = Question.builder()
                .id("1")
                .topicId("topic1")
                .difficulty(1)
                .query("query")
                .options(new String[]{"option1", "option2"})
                .answer("option1")
                .build();

        QuestionDTO questionDTO = QuestionDTO.builder()
                .id(question.id())
                .query(question.query())
                .options(question.options())
                .answer(question.answer())
                .build();

        List<QuestionDTO> expected = List.of(questionDTO);

        questionRepo.save(question);
        String expectedAsJson = objectMapper.writeValueAsString(expected);

        mockMvc.perform(get(BASE_URI + "/" + question.topicId()))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedAsJson));
    }

    @Test
    @DirtiesContext
    void getQuestionsByTopicId_whenNoQuestionsFound_thenThrowNoQuestionsException() throws Exception {
        String invalidId = "1";

        mockMvc.perform(get(BASE_URI + "/" + invalidId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No questions found for this topic id: " + invalidId));
    }


}