package de.aljoschanyang.backend.exceptions;

public class NoQuestionsException extends RuntimeException{
    public NoQuestionsException(String topicId) {
        super("No questions found for this topic id: " + topicId);
    }
}
