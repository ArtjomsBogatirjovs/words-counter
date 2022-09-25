package lv.bogatirjov.wordcounter.api.file;

import java.io.File;
import java.io.IOException;

public interface FileReader {

    String readFile(File fileName) throws IOException;

}