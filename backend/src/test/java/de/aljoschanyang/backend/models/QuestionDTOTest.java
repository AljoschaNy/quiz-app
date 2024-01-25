package de.aljoschanyang.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDTOTest {
    private final QuestionDTO q1 = new QuestionDTO("1","query1",new String[]{"A","B","C"}, "A");
    private final QuestionDTO q2 = new QuestionDTO("1","query1",new String[]{"A","B","C"}, "A");
    private final QuestionDTO q3 = new QuestionDTO("2","query2",new String[]{"D","E","F"}, "D");

    @Test
    void equals_sameObjects_shouldReturnTrue() {
        assertEquals(q1, q1);
    }

    @Test
    void equals_identicalObjects_shouldReturnTrue() {
        assertEquals(q1, q2);
    }

    @Test
    void equals_differentIDs_shouldReturnFalse() {
        QuestionDTO questionWithDifferentID = new QuestionDTO("2","query1",new String[]{"A","B","C"}, "A");
        assertNotEquals(q1, questionWithDifferentID);
    }

    @Test
    void equals_differentQueries_shouldReturnFalse() {
        QuestionDTO questionWithDifferentQueries = new QuestionDTO("1","query2",new String[]{"A","B","C"}, "A");
        assertNotEquals(q1, questionWithDifferentQueries);
    }

    @Test
    void equals_differentOptions_shouldReturnFalse() {
        QuestionDTO questionWithDifferentOptions = new QuestionDTO("1","query1",new String[]{"D","E","F"}, "A");
        assertNotEquals(q1, questionWithDifferentOptions);
    }

    @Test
    void equals_nullOptions_shouldReturnFalse() {
        QuestionDTO questionWithNullOptions = new QuestionDTO("1","query1",null, "A");
        assertNotEquals(q1, questionWithNullOptions);
    }

    @Test
    void equals_differentAnswer_shouldReturnFalse() {
        QuestionDTO questionWithDifferentAnswers = new QuestionDTO("1","query1",new String[]{"A","B","C"}, "C");
        assertNotEquals(q1, questionWithDifferentAnswers);
    }

    @Test
    void equals_nullAnswer_shouldReturnFalse() {
        QuestionDTO questionWithNullAnswers = new QuestionDTO("1","query1",new String[]{"A","B","C"}, null);
        assertNotEquals(q1, questionWithNullAnswers);
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        assertNotEquals(null, q1);
    }

    @Test
    void equals_differentClassObject_shouldReturnFalse() {
        assertNotEquals(new Object(), q1);
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
        String expected = "QuestionDTO{id='1', query='query1', options=[A, B, C], answer='A'}";

        assertEquals(expected, q1.toString());
    }
}
