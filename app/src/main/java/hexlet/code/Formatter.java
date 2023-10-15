package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String format(String format, Map<String, Object> resultMap) {
        String result = "Unknown format";
        if (format.equals("stylish")) {
            result = Stylish.format(resultMap);
        } else if (format.equals("plain")) {
            result = Plain.format(resultMap);
        }
        return result;
    }
}
