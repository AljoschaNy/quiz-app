package de.aljoschanyang.backend.controllers;

import de.aljoschanyang.backend.models.QuestionDTO;
import de.aljoschanyang.backend.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/{topicId}")
    public List<QuestionDTO> getQuestionsByTopicId(@PathVariable String topicId) {
        return questionService.getQuestionsByTopicId(topicId);
    }
}
