package de.aljoschanyang.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDTOTest {
    private final QuestionDTO q1 = new QuestionDTO("1","query1",new String[]{"A","B","C"}, "A");
    private final QuestionDTO q2 = new QuestionDTO("1","query1",new String[]{"A","B","C"}, "A");
    private final QuestionDTO q3 = new QuestionDTO("2","query2",new String[]{"D","E","F"}, "D");

    @Test
    void testEquals() {
        assertEquals(q1, q2);
        assertNotEquals(q1, q3);
        assertNotEquals(q1, null);
        assertNotEquals(q1, new Object());
    }

    @Test
    void testHashCode() {
        assertEquals(q1.hashCode(), q2.hashCode());
        assertNotEquals(q1.hashCode(), q3.hashCode());
    }

    @Test
    void testToString() {
        String expected = "QuestionDTO{id='1', query='query1', options=[A, B, C], answer='A'}";

        assertEquals(expected, q1.toString());
    }
}