import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileAnalysisTest {


    @Test
    public void test_GetFileExtensionOfJava_ShouldReturn_Java() {
        File file = new File("./src/test/fixture/1.java");
        FileAnalysis fileAnalysis = new FileAnalysis(file);
        assertThat(fileAnalysis.getFileExtension(), is("java"));
        assertThat(fileAnalysis.getLineCount(), is(1));
        assertThat(fileAnalysis.getFileName(), is("1.java"));
    }
}