package hexlet.code.formatters;

import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String format (Map<String, Object> resultMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String resultMapAsString = objectMapper.writeValueAsString(resultMap);
        return resultMapAsString;
    }
}
