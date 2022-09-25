package lv.bogatirjov.wordcounter.api.file;

import lombok.Getter;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Getter
public class FileFinderResult {
    private final List<File> files;

    public FileFinderResult(List<File> files) {
        this.files = Collections.unmodifiableList(files);
    }

    public Optional<File> getFileByName(String fileName) {
        for (File file : files) {
            if (file.getName().startsWith(fileName)) {
                return Optional.of(file);
            }
        }
        return Optional.empty();
    }
}
