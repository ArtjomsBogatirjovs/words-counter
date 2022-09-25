package lv.bogatirjov.wordcounter.impl.counter;

import lv.bogatirjov.wordcounter.api.counter.WordCountResult;
import lv.bogatirjov.wordcounter.api.counter.WordCounter;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TextWordCounter implements WordCounter {
    @Override
    public WordCountResult countWords(String text) {
        Map<String, Integer> wordCounts;
        String formattedText = replaceSpacingWithPointAndToLowerCase(text);
        String[] arrayOfAllWords = getArrayOfWordsFromText(formattedText);
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(arrayOfAllWords));
        wordCounts = getWordsAndItAmount(uniqueWords, arrayOfAllWords);
        return new WordCountResult(wordCounts);
    }

    private String replaceSpacingWithPointAndToLowerCase(String text) {
        return text.replaceAll("\\s+", ".").toLowerCase();
    }

    private String[] getArrayOfWordsFromText(String text) {
        String delimiters = ".,?\"";
        return StringUtils.split(text, delimiters);
    }

    private Map<String, Integer> getWordsAndItAmount(Set<String> wordsToCount, String[] allWordsArray) {
        Map<String, Integer> wordCounts = new HashMap<>();
        int wordAmount;
        for (String word : wordsToCount) {
            wordAmount = countWordAmount(word, allWordsArray);
            wordCounts.put(word, wordAmount);
        }
        return wordCounts;
    }

    private int countWordAmount(String word, String[] words) {
        int counter = 0;
        for (String s : words) {
            if (s.equalsIgnoreCase(word)) {
                counter++;
            }
        }
        return counter;
    }
}