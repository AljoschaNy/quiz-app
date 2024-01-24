package de.aljoschanyang.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    private final Question q1 = new Question("1","topic1",1,"query1",new String[]{"A","B","C"}, "A");
    private final Question q2 = new Question("1","topic1",1,"query1",new String[]{"A","B","C"}, "A");

    private final Question q3 = new Question("2","topic2",1,"query2",new String[]{"D","E","F"}, "D");

    @Test
    void equals_sameObjects_shouldReturnTrue() {
        assertTrue(q1.equals(q1));
    }

    @Test
    void equals_identicalObjects_shouldReturnTrue() {
        assertEquals(q1, q2);
    }

    @Test
    void equals_differentIDs_shouldReturnFalse() {
        Question questionWithDifferentID = new Question("2","topic1",1,"query1",new String[]{"A","B","C"}, "A");
        assertNotEquals(q1, questionWithDifferentID);
    }

    @Test
    void equals_differentTopicIDs_shouldReturnFalse() {
        Question questionWithDifferentTopicID = new Question("1","topic2",1,"query1",new String[]{"A","B","C"}, "A");
        assertNotEquals(q1, questionWithDifferentTopicID);
    }

    @Test
    void equals_differentDifficulties_shouldReturnFalse() {
        Question questionWithDifferentDifficulties = new Question("1","topic1",2,"query1",new String[]{"A","B","C"}, "A");
        assertNotEquals(q1, questionWithDifferentDifficulties);
    }

    @Test
    void equals_differentQueries_shouldReturnFalse() {
        Question questionWithDifferentQueries = new Question("1","topic1",1,"query2",new String[]{"A","B","C"}, "A");
        assertNotEquals(q1, questionWithDifferentQueries);
    }

    @Test
    void equals_differentOptions_shouldReturnFalse() {
        Question questionWithDifferentOptions = new Question("1","topic1",1,"query2",new String[]{"A"}, "A");
        assertNotEquals(q1, questionWithDifferentOptions);
    }

    @Test
    void equals_differentAnswer_shouldReturnFalse() {
        Question questionWithDifferentAnswers = new Question("1","topic1",1,"query2",new String[]{"A","B","C"}, "B");
        assertNotEquals(q1, questionWithDifferentAnswers);
    }

    @Test
    void equals_nullAndDifferentType_shouldReturnFalse() {
        assertNotEquals(null, q1);
        assertNotEquals("String", q1);
    }

    @Test
    void hashCode_identicalObjects_shouldReturnSameHashCode() {
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    void hashCode_differentObjects_shouldReturnDifferentHashCodes() {
        assertNotEquals(q1.hashCode(), q3.hashCode());
    }

    @Test
    void toString_outputValidation() {
        String expected = "Question{id='1', topicId='topic1', difficulty=1, query='query1', options=[A, B, C], answer='A'}";

        assertEquals(expected, q1.toString());
    }
}
