package hexlet.code.formatters;

import java.util.Iterator;
import java.util.Map;

public class Plain {
    public static String format (Map<String, Object> resultMap) {
        StringBuilder resultString = new StringBuilder("");
        Iterator it = resultMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                value = "'" + value + "'";
            }
            if (!(value instanceof Integer || value instanceof String || value instanceof Boolean || value == null)) {
                value = "[complex value]";
            }
            if (key.startsWith("-mod")) {
                resultString.append("Property '");
                resultString.append(key.split(" ")[1]);
                resultString.append("' was updated. From ");
                resultString.append(value);
                resultString.append(" to ");
            }
            if (key.startsWith("+mod")) {
                resultString.append(value);
                resultString.append("\n");
            }
            if (key.startsWith("- ")) {
                resultString.append("Property '");
                resultString.append(key.split(" ")[1]);
                resultString.append("' was removed");
                resultString.append("\n");
            }
            if (key.startsWith("+ ")) {
                resultString.append("Property '");
                resultString.append(key.split(" ")[1]);
                resultString.append("' was added with value: ");
                resultString.append(value);
                resultString.append("\n");
            }
        }
        return resultString.toString().substring(0, resultString.toString().length() - 1);
    }
}
