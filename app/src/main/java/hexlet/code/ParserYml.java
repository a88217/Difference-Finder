package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class ParserYml implements Parser {
    public final Map<String, Object> parse(String fileContent) throws JsonProcessingException {
        Map<String, Object> fileMap = new HashMap<>();
        ObjectMapper objectMapper = new YAMLMapper();
        fileMap = objectMapper.readValue(fileContent, Map.class);
        return fileMap;
    }
}
