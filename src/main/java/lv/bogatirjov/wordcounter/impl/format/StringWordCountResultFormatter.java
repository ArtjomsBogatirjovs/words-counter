package lv.bogatirjov.wordcounter.impl.format;

import lv.bogatirjov.wordcounter.api.counter.WordCountResult;
import lv.bogatirjov.wordcounter.api.format.WordCountResultFormatter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StringWordCountResultFormatter implements WordCountResultFormatter<String> {

    @Override
    public String format(WordCountResult wordCountResult) {
        final Map<String, Integer> wordCount = wordCountResult.getWordCount();

        List<Map.Entry<String, Integer>> listWithMapEntries = mapEntriesToList(wordCount);

        sortListByEntryValue(listWithMapEntries);

        StringBuilder stringBuilder = new StringBuilder();

        formatString(listWithMapEntries, stringBuilder);

        return stringBuilder.toString();
    }

    private void formatString(List<Map.Entry<String, Integer>> listWithMapEntries, StringBuilder stringBuilder) {
        for (Map.Entry<String, Integer> entry : listWithMapEntries) {
            stringBuilder.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
    }

    private void sortListByEntryValue(List<Map.Entry<String, Integer>> sortedMapEntries) {
        sortedMapEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }

    private List<Map.Entry<String, Integer>> mapEntriesToList(Map<String, Integer> wordCount) {
        return new ArrayList<>(wordCount.entrySet());
    }

}