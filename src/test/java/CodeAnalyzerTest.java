import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CodeAnalyzerTest {

    CodeAnalyzer codeAnalyzer;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_FilterCounts_ForTwoFile_ShouldReturn2() {
        codeAnalyzer = new CodeAnalyzer("./src/test/fixture/sub1");
        AnalysisResult result = codeAnalyzer.analysis();
        assertThat(result.getFileCounts(), is(2));
        assertFalse(result.isError());
    }

    @Test
    public void test_FilterCounts_ForThreeFileInDiffSubFolder_ShouldReturn3() {
        codeAnalyzer = new CodeAnalyzer("./src/test/fixture");
        AnalysisResult result = codeAnalyzer.analysis();
        assertThat(result.getFileCounts(), is(3));
        assertFalse(result.isError());
    }

//    @Test(expected = NullPointerException.class)
//    public void test_FilterCounts_PathNotFound(){
//        codeAnalyzer = new CodeAnalyzer("./temp1");
//        codeAnalyzer.filterCounts();
//    }

    @Test
    public void test_FilterCounts_PathNotFound() {
        codeAnalyzer = new CodeAnalyzer("./temp1");
        AnalysisResult result = codeAnalyzer.analysis();
        assertThat(result.getFileCounts(), is(-1));
        assertTrue(result.isError());
        assertThat(result.getErrorMsg(), is("Path Not Found"));

    }

    //    @Test(expected = NullPointerException.class)
//    public void test_FilterCounts_InPutIsNotAPath(){
//        codeAnalyzer = new CodeAnalyzer("./temp/test.txt");
//        codeAnalyzer.filterCounts();
//    }
    @Test
    public void test_FilterCounts_InputNotAPath() {
        codeAnalyzer = new CodeAnalyzer("./src/test/fixture/1.java");
        AnalysisResult result = codeAnalyzer.analysis();
        assertThat(result.getFileCounts(), is(-1));
        assertTrue(result.isError());
        assertThat(result.getErrorMsg(), is("Path is not directory"));
    }

    @Test
    public void test_GetTotalLineCount() {
        codeAnalyzer = new CodeAnalyzer("./src/test/fixture");
        assertThat(codeAnalyzer.analysis().getTotalLineCount(), is(6));
    }
}