import java.util.Arrays;

public class MainApp {
    public static void main(String[] args){
        Arrays.asList(args).stream().forEach(System.out::println);

        CodeAnalyzer codeAnalyzer = new CodeAnalyzer(args[0]);
        System.out.println(codeAnalyzer.analysis().toString());

    }
}
