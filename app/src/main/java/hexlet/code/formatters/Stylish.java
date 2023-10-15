package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String format (Map<String, Object> resultMap) {
        StringBuilder resultString = new StringBuilder("{\n");
        resultMap.entrySet().stream()
                .forEach(str -> {
                    if (!(str.getKey().startsWith("+") || str.getKey().startsWith("-"))) {
                        resultString.append("  ");
                    }
                    resultString.append("  ");
                    if (str.getKey().startsWith("-mod")) {
                        resultString.append("- ");
                        resultString.append(str.getKey().split(" ")[1]);
                    } else if (str.getKey().startsWith("+mod")) {
                        resultString.append("+ ");
                        resultString.append(str.getKey().split(" ")[1]);
                    } else {
                        resultString.append(str.getKey());
                    }
                    resultString.append(": ");
                    resultString.append((str.getValue()));
                    resultString.append("\n");
                });
        resultString.append("}");
        return resultString.toString();
    }
}
