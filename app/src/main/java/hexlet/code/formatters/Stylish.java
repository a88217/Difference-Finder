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
                            resultString.append(String.format(unchangedKey(), str.getKey(), str.getValue().get(1)));
                            break;
                        case "Added":
                            resultString.append(String.format(addedKey(), str.getKey(), str.getValue().get(1)));
                            break;
                        case "Deleted":
                            resultString.append(String.format(deletedKey(), str.getKey(), str.getValue().get(1)));
                            break;
                        default:
                            resultString.append(String.format(modifiedKey(),
                                    str.getKey(), str.getValue().get(1), str.getKey(), str.getValue().get(2)));
                    }
                });
        resultString.append("}");
        return resultString.toString();
    }

    public static String addedKey() {
        return "  + %s: %s\n";
    }
    public static String deletedKey() {
        return "  - %s: %s\n";
    }
    public static String unchangedKey() {
        return "    %s: %s\n";
    }
    public static String modifiedKey() {
        return "  - %s: %s\n  + %s: %s\n";
    }

}
