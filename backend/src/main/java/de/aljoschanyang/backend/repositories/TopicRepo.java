package de.aljoschanyang.backend.repositories;

import de.aljoschanyang.backend.models.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepo extends MongoRepository<Topic, String> {
}
