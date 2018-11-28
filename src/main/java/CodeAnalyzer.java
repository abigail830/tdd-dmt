import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CodeAnalyzer {

    private String path;

    public CodeAnalyzer(String path) {
        this.path = path;
    }

    public AnalysisResult analysis() {
        File file = new File(path);

        if (!file.exists())
            return new AnalysisResult(Boolean.TRUE, "Path Not Found");

        if (!file.isDirectory())
            return new AnalysisResult(Boolean.TRUE, "Path is not directory");

        AnalysisResult result = new AnalysisResult();
        List<File> scanResult = scan();
        result = filterCounts(result, scanResult);
        result = getTotalLineCount(result, scanResult);
        return result;
    }

    private AnalysisResult filterCounts(AnalysisResult result, List<File> scanResult) {
        result.setFileCounts(scanResult.size());
        return result;

    }

    private AnalysisResult getTotalLineCount(AnalysisResult result, List<File> scanResult) {

        Optional<Integer> reduce = scanResult.stream().map(file -> {
            try {
                return (int) Files.lines(file.toPath()).count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }).reduce((x, y) -> x + y);

        if (reduce.isPresent())
            result.setTotalLineCount(reduce.get());

        return result;
    }

    private List<File> scan() {
        return Stream.of(new File(path).listFiles())
                .flatMap(file1 -> file1.listFiles() == null ?
                        Stream.of(file1) : Stream.of(file1.listFiles()))
                .collect(toList());
    }



}
