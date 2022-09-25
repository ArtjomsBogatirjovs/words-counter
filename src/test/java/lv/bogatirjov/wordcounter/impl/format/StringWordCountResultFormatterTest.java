package lv.bogatirjov.wordcounter.impl.format;

import lv.bogatirjov.wordcounter.api.counter.WordCountResult;
import lv.bogatirjov.wordcounter.api.format.WordCountResultFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringWordCountResultFormatterTest {
    private WordCountResultFormatter<String> formatter;

    @BeforeEach
    void setUp() {
        this.formatter = new StringWordCountResultFormatter();
    }

    @Test
    void testFormat() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("test", 53);
        String expectedResult = "test : 53\n";
        String actualResult = formatter.format(new WordCountResult(testMap));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEmpty() {
        String actual = formatter.format(new WordCountResult(new HashMap<>()));
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void testSortedString() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("test", 53);
        testMap.put("test1", 79);
        testMap.put("test2", 1);
        testMap.put("test3", 80);
        testMap.put("test4", 78);
        String expectedResult = "test3 : 80\n";
        String actualResult = formatter.format(new WordCountResult(testMap));
        assertTrue(actualResult.startsWith(expectedResult));
    }
}