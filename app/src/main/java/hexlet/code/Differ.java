package hexlet.code;

import java.util.Map;
import java.util.List;


public class Differ {

    public static String generate(String fileName1, String fileName2, String formatName) throws Exception {
        String[] readedFile1 = Read.readFile(fileName1);
        String[] readedFile2 = Read.readFile(fileName2);
        Map<String, Object> mapFile1 = Parser.parse(readedFile1);
        Map<String, Object> mapFile2 = Parser.parse(readedFile2);
        Map<String, List> resultMap = DifCalculate.calculate(mapFile1, mapFile2);
        return Formatter.format(formatName, resultMap);
    }

    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }
}
