package hexlet.code;

import java.util.*;

public class Format {
    public static String stylish (Map<String, Object> resultMap) {
        StringBuilder resultString = new StringBuilder("{\n");
        resultMap.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Object>>() {
                    @Override
                    public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                        String[] arr1 = o1.getKey().split(" ");
                        String[] arr2 = o2.getKey().split(" ");
                        String s1 = arr1.length == 1 ? arr1[0] : arr1[1];
                        String s2 = arr2.length == 1 ? arr2[0] : arr2[1];
                        if (s1.equals(s2)) {
                            return arr2[0].compareTo(arr1[0]);
                        }
                        return s1.compareTo(s2);
                    }
                })
                .forEach(str -> {
                    if (!(str.getKey().startsWith("+") || str.getKey().startsWith("-"))) {
                        resultString.append("  ");
                    }

                    resultString.append("  ");
                    resultString.append(str.getKey());
                    resultString.append(": ");
                    resultString.append((str.getValue()));
                    resultString.append("\n");
                });

        resultString.append("}");
        return resultString.toString();
    }
}
