import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileAnalysis {
    int lineCount;
    File file;
    String fileName;
    String fileExtension;


    public FileAnalysis(File file) {
        this.file = file;
    }

    public String getFileName() {
        return file.getName();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLineCount() {
        try {
            return (int) Files.lines(this.file.toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileExtension() {
        return getFileName().substring(getFileName().lastIndexOf('.') + 1);
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        return "FileAnalysis{" +
                "lineCount=" + lineCount +
                ", file=" + file +
                '}';
    }
}
