package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {

    public static String format(Map<String, List> resultMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String resultMapAsString = objectMapper.writeValueAsString(resultMap);
        return resultMapAsString.replace("-mod ", "- ").replace("+mod ", "+ ");
    }
}
