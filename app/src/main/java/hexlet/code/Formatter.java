package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(String format, Map<String, List> resultMap) throws Exception {
        switch (format) {
            case "stylish":
                return Stylish.format(resultMap);
            case "plain":
                return Plain.format(resultMap);
            case "json":
                return Json.format(resultMap);
            default:
                throw new RuntimeException("Unknown format: '" + format + "'");
        }
    }
}

