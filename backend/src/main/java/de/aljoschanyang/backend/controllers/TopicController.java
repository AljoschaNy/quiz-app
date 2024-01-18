package de.aljoschanyang.backend.controllers;

import de.aljoschanyang.backend.services.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService topicService;
}
