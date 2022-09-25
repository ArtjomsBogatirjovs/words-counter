package lv.bogatirjov.wordcounter.impl.file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WindowsFilesFinderTest {
    public static final String FILE_DIRECTORY = "file_finder";
    private WindowsFilesFinder finder;
    private String path;

    @BeforeEach
    void setUp() {
        ClassLoader classLoader = getClass().getClassLoader();
        this.path = classLoader.getResource(FILE_DIRECTORY).getPath();
        this.finder = new WindowsFilesFinder();
    }

    @Test
    void testFindFilesByName() {
        File testSearchDirectory = new File(path);
        List<File> actualResult = finder.findFiles(testSearchDirectory, "test").getFiles();
        List<File> expectedResult = listAllFiles();
        expectedResult.remove(new File(path + "\\file-test"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindAllFiles() {
        File testSearchDirectory = new File(path);
        List<File> actual = finder.findFiles(testSearchDirectory, "").getFiles();
        List<File> expected = listAllFiles();
        assertEquals(expected, actual);
    }

    @Test
    void testNotFindFiles() {
        File testSearchDirectory = new File(path);
        List<File> actualResult = finder.findFiles(testSearchDirectory, "empty").getFiles();
        List<File> expectedResult = new ArrayList<>();
        assertEquals(expectedResult, actualResult);
    }

    private List<File> listAllFiles() {
        return new ArrayList<>() {{
            add(new File(path + "\\file-test"));
            add(new File(path + "\\folder\\folder_2\\test-folder2"));
            add(new File(path + "\\folder\\folder_2\\test_folder21"));
            add(new File(path + "\\folder\\test_folder"));
            add(new File(path + "\\test"));
            add(new File(path + "\\test_folder\\test-test_folder"));
        }};
    }
}
