public class AnalysisResult {

    private int fileCounts = -1;
    private boolean error = Boolean.FALSE;
    private String errorMsg = "";

    public AnalysisResult() {

    }

    public AnalysisResult(int fileCounts, boolean error, String errorMsg) {
        this.fileCounts = fileCounts;
        this.error = error;
        this.errorMsg = errorMsg;
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
}
