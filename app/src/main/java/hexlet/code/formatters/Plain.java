package hexlet.code.formatters;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(Map<String, List> resultMap) {
        StringBuilder resultString = new StringBuilder("");
        Iterator it = resultMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            List value = (List) entry.getValue();
            String keyStatus = (String) value.get(0);
            switch (keyStatus) {
                case "Modified":
                    resultString.append(String.format("Property '%s' was updated. From %s to %s\n",
                            key, stringify(value.get(1)), stringify(value.get(2))));
                    break;
                case "Deleted":
                    resultString.append(String.format("Property '%s' was removed\n", key));
                    break;
                case "Added":
                    resultString.append(String.format("Property '%s' was added with value: %s\n",
                            key, stringify(value.get(1))));
                    break;
                default:
                    break;
            }
        }
        return resultString.toString().substring(0, resultString.toString().length() - 1);
    }

    private static String stringify(Object value) {

        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }

}
