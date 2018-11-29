import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeAnalyzer {


    private DirectoryScanner directoryScanner = new DirectoryScanner();
    private String path;

    public CodeAnalyzer(String path) {
        this.path = path;
    }

    public AnalysisResult analysis() {
        File targetDir = new File(path);

        if (!targetDir.exists())
            return new AnalysisResult(Boolean.TRUE, "Path Not Found");

        if (!targetDir.isDirectory())
            return new AnalysisResult(Boolean.TRUE, "Path is not directory");

        AnalysisResult result = new AnalysisResult();
        List<FileAnalysis> scanResult = directoryScanner.scan(targetDir);

        result.setFileList(directoryScanner.scan(targetDir));

        return result;
    }

    private int filterCounts(List<FileAnalysis> scanResult) {
        return scanResult.size();

    }

    private int getTotalLineCount(List<FileAnalysis> scanResult) {

        Optional<Integer> reduce = scanResult.stream().map(fileAnalysis -> {
            try {
                return (int) Files.lines(fileAnalysis.getFile().toPath()).count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }).reduce((x, y) -> x + y);

        if (reduce.isPresent())
            return reduce.get();

        return -1;
    }

    private List<FileAnalysis> scan(File targetDir) {
        return directoryScanner.scan(targetDir);
    }

    private Map<String, Long> getFileType(List<FileAnalysis> scanResult) {
        return scanResult.stream().map(fileAnalysis -> fileAnalysis.getFileExtension())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
    }


    public Double getAvgLineCount(List<FileAnalysis> scanResult) {
        return scanResult.stream()
                .mapToInt(fileAnalysis -> fileAnalysis.getLineCount())
                .average().getAsDouble();

    }


}
