package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

public class Parser {
    public static Map<String, Object> parse(String[] file) throws Exception {
        String content = file[0];
        String format = file[1];
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
