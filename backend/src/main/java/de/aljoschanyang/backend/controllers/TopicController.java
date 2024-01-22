package de.aljoschanyang.backend.controllers;

import de.aljoschanyang.backend.models.TopicDTO;
import de.aljoschanyang.backend.services.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService topicService;

    @GetMapping
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }
}
