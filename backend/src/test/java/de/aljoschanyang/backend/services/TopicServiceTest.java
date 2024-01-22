package de.aljoschanyang.backend.services;

import de.aljoschanyang.backend.models.Topic;
import de.aljoschanyang.backend.models.TopicDTO;
import de.aljoschanyang.backend.repositories.TopicRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TopicServiceTest {
    private final TopicRepo mockTopicRepo = mock(TopicRepo.class);
    private final TopicService topicService = new TopicService(mockTopicRepo);

    @Test
    void getAllTopics_whenNoTopicsInDB_thenReturnEmptyList() {
        List<TopicDTO> expected = List.of();

        when(mockTopicRepo.findAll()).thenReturn(Collections.emptyList());
        List<TopicDTO> actual = topicService.getAllTopics();

        verify(mockTopicRepo).findAll();
        assertEquals(expected,actual);
    }

    @Test
    void getAllTopics_whenTopicsExistInDB_thenReturnListOfTopicDTOs() {
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

        List<Topic> entityList = List.of(topic);
        List<TopicDTO> expected = List.of(topicDTO);

        when(mockTopicRepo.findAll()).thenReturn(entityList);

        List<TopicDTO> actual = topicService.getAllTopics();
        verify(mockTopicRepo).findAll();
        assertEquals(expected, actual);
    }
}