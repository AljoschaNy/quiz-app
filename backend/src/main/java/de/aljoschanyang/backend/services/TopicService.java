package de.aljoschanyang.backend.services;

import de.aljoschanyang.backend.models.Topic;
import de.aljoschanyang.backend.models.TopicDTO;
import de.aljoschanyang.backend.repositories.TopicRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;

    private TopicDTO convertToDTO(Topic topic) {
        return TopicDTO.builder()
                .id(topic.id())
                .title(topic.title())
                .icon(topic.icon())
                .category(topic.category())
                .build();
    }

    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicRepo.findAll();

        return topics.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
