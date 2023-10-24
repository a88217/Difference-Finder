package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String format(Map<String, List> resultMap) {
        StringBuilder resultString = new StringBuilder("{\n");
        resultMap.entrySet().stream()
                .forEach(str -> {
                    String entryState = (String) str.getValue().get(0);
                    switch (entryState) {
                        case "Unchanged":
                            resultString.append("    ");
                            break;
                        case "Added":
                            resultString.append("  + ");
                            break;
                        case "Deleted":
                            resultString.append("  - ");
                            break;
                        default:
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
                    }
                    if (!entryState.equals("Modified")) {
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
