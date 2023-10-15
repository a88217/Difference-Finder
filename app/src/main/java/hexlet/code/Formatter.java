package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;
import java.util.Map;

public class Formatter {
    public static String format(String format, Map<String, Object> resultMap) throws JsonProcessingException {
        String result = "Unknown format";
        if (format.equals("stylish")) {
            result = Stylish.format(resultMap);
        } else if (format.equals("plain")) {
            result = Plain.format(resultMap);
        } else if (format.equals("json")) {
            result = Json.format(resultMap);
        }
        return result;
    }
}
