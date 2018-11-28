public class AnalysisResult {

    private int fileCounts = -1;
    private int totalLineCount = -1;
    private boolean error = Boolean.FALSE;
    private String errorMsg = "";

    public AnalysisResult() {
    }

    public AnalysisResult(int fileCounts) {
        this.fileCounts = fileCounts;
    }

    public AnalysisResult(boolean error, String errorMsg) {
        this.error = error;
        this.errorMsg = errorMsg;
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
