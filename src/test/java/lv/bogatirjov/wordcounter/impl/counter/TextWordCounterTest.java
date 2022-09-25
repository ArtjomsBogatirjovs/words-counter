package lv.bogatirjov.wordcounter.impl.counter;

import lv.bogatirjov.wordcounter.api.counter.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextWordCounterTest {
    private WordCounter textWordCounter;

    @BeforeEach
    void setUp() {
        this.textWordCounter = new TextWordCounter();
    }

    @Test
    void testDelimiters() {
        String testText = "test,test1.test2?test3\"test4\ntest5 test6";
        Map<String, Integer> actual = textWordCounter.countWords(testText).getWordCount();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("test", 1);
        expected.put("test1", 1);
        expected.put("test2", 1);
        expected.put("test3", 1);
        expected.put("test4", 1);
        expected.put("test5", 1);
        expected.put("test6", 1);
        assertEquals(expected, actual);
    }

    @Test
    void testCaseInsensitive() {
        String testText = "Test tEst Test test WORD worD wORd WorD";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("test", 4);
        expected.put("word", 4);
        Map<String, Integer> actual = textWordCounter.countWords(testText).getWordCount();
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyText() {
        String testText = " ";
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = textWordCounter.countWords(testText).getWordCount();
        assertEquals(expected, actual);
    }

    @Test
    void testWordCount() {
        String testText = "test is test";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("is", 1);
        expected.put("test", 2);
        Map<String, Integer> actual = textWordCounter.countWords(testText).getWordCount();
        assertEquals(expected, actual);
    }
}