package de.aljoschanyang.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.aljoschanyang.backend.models.Topic;
import de.aljoschanyang.backend.models.TopicDTO;
import de.aljoschanyang.backend.repositories.TopicRepo;
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
class TopicControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private ObjectMapper objectMapper;
    private final String BASE_URI = "/api/topics";

    @Test
    @DirtiesContext
    void getAllTopics_whenNoTopicsInDB_thenReturnEmptyList() throws Exception {
        List<TopicDTO> expected = List.of();
        String expectedAsJson = objectMapper.writeValueAsString(expected);

        mockMvc.perform(get(BASE_URI))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedAsJson));
    }

    @Test
    @DirtiesContext
    void getAllTopics_whenTopicsExistInDB_thenReturnListOfTopicDTOs() throws Exception {
        Topic topic = Topic.builder()
                .id("1")
                .title("test")
                .icon("path")
                .category("category")
                .build();

        TopicDTO topicDTO = TopicDTO.builder()
                .id(topic.id())
                .title(topic.title())
                .icon(topic.icon())
                .category(topic.category())
                .build();

        topicRepo.save(topic);
        List<TopicDTO> expected = List.of(topicDTO);
        String expectedAsJson = objectMapper.writeValueAsString(expected);

        mockMvc.perform(get(BASE_URI))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedAsJson));
    }
}