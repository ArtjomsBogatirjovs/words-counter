package lv.bogatirjov.wordcounter.impl.file;

import lv.bogatirjov.wordcounter.api.file.FileFinder;
import lv.bogatirjov.wordcounter.api.file.FileFinderResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WindowsFilesFinder implements FileFinder {

    @Override
    public FileFinderResult findFiles(File diskRoot, String fileName) {
        return new FileFinderResult(findInDirectory(diskRoot, fileName));
    }

    private List<File> findInDirectory(File diskRoot, String fileName) {
        List<File> fileList = new ArrayList<>();
        File[] directoryFiles = diskRoot.listFiles();
        if (directoryFiles != null) {
            for (File directoryFile : directoryFiles) {
                if (directoryFile.isDirectory()) {
                    fileList.addAll(findInDirectory(directoryFile, fileName));
                } else if (isNameCorrect(directoryFile, fileName)) {
                    fileList.add(directoryFile);
                }
            }
        }
        return fileList;
    }

    private boolean isNameCorrect(File file, String fileName) {
        return file.getName().startsWith(fileName);
    }
}
