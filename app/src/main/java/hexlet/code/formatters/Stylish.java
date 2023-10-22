package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String format(Map<String, List> resultMap) {
        StringBuilder resultString = new StringBuilder("{\n");
        resultMap.entrySet().stream()
                .forEach(str -> {
                    if (str.getValue().get(0).equals("Modified")) {
                        resultString.append("  - ");
                        resultString.append(str.getKey());
                        resultString.append(": ");
                        resultString.append(str.getValue().get(1));
                        resultString.append("\n");
                        resultString.append("  + ");
                        resultString.append(str.getKey());
                        resultString.append(": ");
                        resultString.append(str.getValue().get(2));
                        resultString.append("\n");
                    } else {
                        if (str.getValue().get(0).equals("Unchanged")) {
                            resultString.append("    ");
                        } else if (str.getValue().get(0).equals("Deleted")) {
                            resultString.append("  - ");
                        } else {
                            resultString.append("  + ");
                        }
                        resultString.append(str.getKey());
                        resultString.append(": ");
                        resultString.append(str.getValue().get(1));
                        resultString.append("\n");
                    }
                });
        resultString.append("}");
        return resultString.toString();
    }
}
