package hexlet.code;

import hexlet.code.parsers.ParserFactory;
import org.apache.commons.io.FilenameUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String fileName1, String fileName2, String formatName) throws Exception {
        Map<String, Object> mapFile1 = getData(fileName1);
        Map<String, Object> mapFile2 = getData(fileName2);
        Map<String, List> resultMap = DiffCalculate.calculate(mapFile1, mapFile2);
        return Formatter.format(formatName, resultMap);
    }

    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }

    public static Map<String, Object> getData(String fileName) throws Exception {
        Path path = Paths.get(fileName).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String fileContent = Files.readString(path);
        String fileFormat = FilenameUtils.getExtension(fileName);
        Map<String, Object> fileMap = ParserFactory.getParser(fileFormat).parse(fileContent);
        return fileMap;
    }
}
