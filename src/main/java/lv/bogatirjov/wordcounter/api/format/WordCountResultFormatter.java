package lv.bogatirjov.wordcounter.api.format;

import lv.bogatirjov.wordcounter.api.counter.WordCountResult;


public interface WordCountResultFormatter<T> {

    <T> T format(WordCountResult wordCountResult);

}