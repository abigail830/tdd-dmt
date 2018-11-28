import java.io.File;

public class CodeAnalyzer {

    private String path;

    public CodeAnalyzer(String path) {
        this.path = path;
    }

    public AnalysisResult filterCounts() {
        File file = new File(path);
        AnalysisResult result = new AnalysisResult();

        if (!file.exists()) {
            result.setError(Boolean.TRUE);
            result.setErrorMsg("Path Not Found");
            return result;
        }

        if (!file.isDirectory()) {
            result.setError(Boolean.TRUE);
            result.setErrorMsg("Path is not directory");
            return result;
        }

        result.setFileCounts(file.listFiles().length);
        return result;

    }

}
