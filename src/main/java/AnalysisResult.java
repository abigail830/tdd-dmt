import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AnalysisResult {

    private int fileCounts = -1;
    private int totalLineCount = -1;
    private List<File> fileList = new ArrayList<>();
    private boolean error = Boolean.FALSE;
    private String errorMsg = "";

    public AnalysisResult() {
    }

    public AnalysisResult(boolean error, String errorMsg) {
        this.error = error;
        this.errorMsg = errorMsg;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public int getTotalLineCount() {
        return totalLineCount;
    }

    public void setTotalLineCount(int totalLineCount) {
        this.totalLineCount = totalLineCount;
    }

    public int getFileCounts() {
        return fileCounts;
    }

    public void setFileCounts(int fileCounts) {
        this.fileCounts = fileCounts;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "fileCounts=" + fileCounts +
                ", totalLineCount=" + totalLineCount +
                ", error=" + error +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
