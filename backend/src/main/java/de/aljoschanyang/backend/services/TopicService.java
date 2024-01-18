package de.aljoschanyang.backend.services;

import de.aljoschanyang.backend.repositories.TopicRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;

}
