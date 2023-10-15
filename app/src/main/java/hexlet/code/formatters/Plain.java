package hexlet.code.formatters;

import net.sf.saxon.expr.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

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
        return resultString.toString();
    }
}

/*
forEach(str -> {
                    if (str.getKey().startsWith("-mod")) {

                    }
                    if (str.getKey().startsWith("+mod") || str.getKey().startsWith("- ") || str.getKey().startsWith("+ ")) {
                        resultString.append("Property '");
                        resultString.append(str.getKey().split(" ")[1]);
                        resultString.append("' was ");
                        if (str.getKey().startsWith("- ")) {
                            resultString.append("removed");
                        } else if (str.getKey().startsWith("+ ")) {
                            resultString.append("added with value: ");
                            resultString.append(str.getValue());
                        } else {
                            resultString.append("updated. From ");
                            resultString.append(oldValue);
                            resultString.append(" to ");
                            resultString.append(str.getValue());

                        }
                        resultString.append("\n");
                    }
                })
*/