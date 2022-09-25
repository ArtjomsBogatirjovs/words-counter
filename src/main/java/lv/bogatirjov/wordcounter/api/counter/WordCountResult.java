package lv.bogatirjov.wordcounter.api.counter;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

@Getter
public class WordCountResult {

    private final Map<String, Integer> wordCount;

    public WordCountResult(Map<String, Integer> wordCount) {
        this.wordCount = Collections.unmodifiableMap(wordCount);
    }

    public void printMap() {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}