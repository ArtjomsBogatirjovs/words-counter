package lv.bogatirjov.wordcounter.impl.file;

import lv.bogatirjov.wordcounter.api.file.FileReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class WindowsFileReader implements FileReader {

    @Override
    public String readFile(File file) throws IOException {
        return FileUtils.readFileToString(file, Charset.defaultCharset());
    }
}