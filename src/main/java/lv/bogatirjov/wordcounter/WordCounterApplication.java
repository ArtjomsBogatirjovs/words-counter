package lv.bogatirjov.wordcounter;

import lv.bogatirjov.wordcounter.api.counter.WordCountResult;
import lv.bogatirjov.wordcounter.api.file.FileFinder;
import lv.bogatirjov.wordcounter.api.file.FileFinderResult;
import lv.bogatirjov.wordcounter.api.file.FileReader;
import lv.bogatirjov.wordcounter.api.counter.WordCounter;
import lv.bogatirjov.wordcounter.api.format.WordCountResultFormatter;
import lv.bogatirjov.wordcounter.impl.counter.TextWordCounter;
import lv.bogatirjov.wordcounter.impl.file.WindowsFilesFinder;
import lv.bogatirjov.wordcounter.impl.file.WindowsFileReader;
import lv.bogatirjov.wordcounter.impl.format.StringWordCountResultFormatter;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;


public class WordCounterApplication {

    public static void main(String[] args) throws IOException {
        String fileName = getFileNameFromUserInput();
        final File diskRoot = getDiskRootFromUser();
        final FileFinder fileFinder = new WindowsFilesFinder();
        final FileReader fileReader = new WindowsFileReader();
        final FileFinderResult fileFinderResult = fileFinder.findFiles(diskRoot, fileName);

        System.out.println(fileFinderResult.getFiles());
        fileName = getFileNameFromUserInput();

        final Optional<File> fileToRead = fileFinderResult.getFileByName(fileName);
        if (fileToRead.isPresent()) {
            final String text = fileReader.readFile(fileToRead.get());
            final WordCounter wordCounter = new TextWordCounter();
            final WordCountResult wordCountResult = wordCounter.countWords(text);

            final WordCountResultFormatter<String> resultFormatter = new StringWordCountResultFormatter();
            final String formattedResult = resultFormatter.format(wordCountResult);
            System.out.println(formattedResult);
        } else {
            System.out.println("File not found!");
        }
    }

    private static String getFileNameFromUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        return sc.nextLine();
    }

    private static File getDiskRootFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path where search: ");
        return new File(sc.nextLine());
    }

}