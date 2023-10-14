package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String content = Files.readString(path);
        String format = FilenameUtils.getExtension(filePath);
        Map<String, Object> fileMap = new HashMap<>();
        if (format.equals("yml")) {
            ObjectMapper objectMapper = new YAMLMapper();
            fileMap = objectMapper.readValue(content, Map.class);
        } else if (format.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            fileMap = objectMapper.readValue(content, Map.class);
        }
        return fileMap;
    }
}
