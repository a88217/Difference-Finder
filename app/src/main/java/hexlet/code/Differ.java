package hexlet.code;

import hexlet.code.parsers.ParserFactory;
import org.apache.commons.io.FilenameUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String path1, String path2, String formatName) throws Exception {
        Map<String, Object> data1 = getData(path1);
        Map<String, Object> data2 = getData(path2);
        Map<String, List> resultMap = DiffCalculate.calculate(data1, data2);
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
