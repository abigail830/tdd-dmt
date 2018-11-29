import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalysisResult {

    private int totalLineCount = -1;
    public Double avgLineCount;
    public int maxLineCount;

    private List<FileAnalysis> fileList = new ArrayList<>();
    private Map<String, Long> fileTypeMap;

    private boolean error = Boolean.FALSE;
    private String errorMsg = "";

    public AnalysisResult() {
    }

    public AnalysisResult(boolean error, String errorMsg) {
        this.error = error;
        this.errorMsg = errorMsg;
    }

    public List<FileAnalysis> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileAnalysis> fileList) {
        this.fileList = fileList;
    }

    public int getTotalLineCount() {
        return fileList.stream().mapToInt(fileList -> fileList.getLineCount()).sum();
    }

    public void setTotalLineCount(int totalLineCount) {
        this.totalLineCount = totalLineCount;
    }

    public int getFileCounts() {
        return fileList.size();
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Map<String, Long> getFileTypeMap() {
        return fileList.stream().map(fileAnalysis -> fileAnalysis.getFileExtension())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    public Double getAvgLineCount() {
        return fileList.stream().mapToInt(fileList -> fileList.getLineCount()).average().getAsDouble();
    }


    public int getMaxLineCount() {
        return fileList.stream().mapToInt(fileList -> fileList.getLineCount()).max().getAsInt();
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "totalLineCount=" + totalLineCount +
                ", avgLineCount=" + avgLineCount +
                ", maxLineCount=" + maxLineCount +
                ", fileList=" + fileList +
                ", fileTypeMap=" + fileTypeMap +
                ", error=" + error +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
