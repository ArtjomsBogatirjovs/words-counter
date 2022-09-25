package lv.bogatirjov.wordcounter.api.file;

import java.io.File;

public interface FileFinder {
    FileFinderResult findFiles(File file, String fileName);
}
