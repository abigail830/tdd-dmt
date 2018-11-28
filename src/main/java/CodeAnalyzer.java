import java.io.File;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CodeAnalyzer {

    private String path;

    public CodeAnalyzer(String path) {
        this.path = path;
    }

    public AnalysisResult filterCounts() {
        File file = new File(path);

        if (!file.exists())
            return new AnalysisResult(-1, Boolean.TRUE, "Path Not Found");

        if (!file.isDirectory())
            return new AnalysisResult(-1, Boolean.TRUE, "Path is not directory");

        List<File> fileList = Stream.of(new File(path).listFiles())
                .flatMap(file1 -> file1.listFiles() == null ?
                        Stream.of(file1) : Stream.of(file1.listFiles()))
                .collect(toList());


        return new AnalysisResult(fileList.size(), Boolean.FALSE, "");

    }

}
