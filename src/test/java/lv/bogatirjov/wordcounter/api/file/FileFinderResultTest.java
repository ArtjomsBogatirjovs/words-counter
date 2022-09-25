package lv.bogatirjov.wordcounter.api.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FileFinderResultTest {

    @Test
    void testGetFirstMatch() {
        List<File> testFiles = getTestList();
        FileFinderResult fileFinderResult = new FileFinderResult(testFiles);
        Optional<File> expected = Optional.of(new File("tested"));
        Optional<File> actual = fileFinderResult.getFileByName("test");
        assertEquals(expected, actual);
    }

    @Test
    void testGetByName() {
        List<File> testFiles = getTestList();
        FileFinderResult fileFinderResult = new FileFinderResult(testFiles);
        Optional<File> expected = Optional.of(new File("tested"));
        Optional<File> actual = fileFinderResult.getFileByName("tested");
        assertEquals(expected, actual);
    }

    @Test
    void testNotFound() {
        List<File> testFiles = getTestList();
        FileFinderResult fileFinderResult = new FileFinderResult(testFiles);
        Optional<File> expected = Optional.empty();
        Optional<File> actual = fileFinderResult.getFileByName("wrongFile");
        assertEquals(expected, actual);
    }

    @Test
    void testSearchInEmptyList() {
        List<File> testFiles = new ArrayList<>();
        FileFinderResult fileFinderResult = new FileFinderResult(testFiles);
        Optional<File> expected = Optional.empty();
        Optional<File> actual = fileFinderResult.getFileByName("random");
        assertEquals(expected, actual);
    }

    private List<File> getTestList() {
        return new ArrayList<>() {{
            add(new File("1test"));
            add(new File("Test"));
            add(new File("tested"));
            add(new File("test"));
        }};
    }
}