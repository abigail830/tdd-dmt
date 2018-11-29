import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryScanner {

    List<FileAnalysis> scan(File targetDir) {
        return Stream.of(targetDir.listFiles())
                .flatMap(file1 -> file1.listFiles() == null ?
                        Stream.of(file1) : Stream.of(file1.listFiles()))
                .map(FileAnalysis::new)
                .collect(Collectors.toList());
    }
}