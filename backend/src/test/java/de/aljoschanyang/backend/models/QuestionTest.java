package de.aljoschanyang.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    private final Question q1 = new Question("1","topic1",1,"query1",new String[]{"A","B","C"}, "A");
    private final Question q2 = new Question("1","topic1",1,"query1",new String[]{"A","B","C"}, "A");

    private final Question q3 = new Question("2","topic2",1,"query2",new String[]{"D","E","F"}, "D");


    @Test
    void testEquals() {
        assertEquals(q1, q2);
        assertNotEquals(q1, q3);
        assertNotEquals(q1,null);
        assertNotEquals(q1, new Object());
    }

    @Test
    void testHashCode() {
        assertEquals(q1.hashCode(), q2.hashCode());
        assertNotEquals(q1.hashCode(), q3.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Question{id='1', topicId='topic1', difficulty=1, query='query1', options=[A, B, C], answer='A'}";

        assertEquals(expected, q1.toString());
    }
}