package lv.bogatirjov.wordcounter.impl.file;

import lv.bogatirjov.wordcounter.api.file.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WindowsFileReaderTest {
    public static final String FILE_DIRECTORY = "file_reader";
    private FileReader reader;
    private String path;

    @BeforeEach
    void setUp() {
        this.reader = new WindowsFileReader();
        ClassLoader classLoader = getClass().getClassLoader();
        this.path = classLoader.getResource(FILE_DIRECTORY).getPath();
    }

    @Test
    void testReadFileWithText() throws IOException {
        File testFile = new File(path + "\\file-withText");
        String expectedResult = "test Result";
        String actualResult = reader.readFile(testFile);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testReadFileWithoutText() throws IOException {
        File testFile = new File(path + "\\file-emptyText");
        String expectedResult = "";
        String actualResult = reader.readFile(testFile);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFileNotFound() {
        File testFile = new File(path + "\\file-notExist");
        assertThrows(IOException.class, () -> reader.readFile(testFile));
    }
}