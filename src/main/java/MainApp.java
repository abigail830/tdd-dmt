import java.util.Arrays;

public class MainApp {
    public static void main(String[] args){
        Arrays.asList(args).stream().forEach(System.out::println);
    }
}
