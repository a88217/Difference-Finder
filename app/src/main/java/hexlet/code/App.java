package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private File filepath1;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private File filepath2;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format")
    private String format = "";
    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println("Hello World!");
        return 0;
    }
}
