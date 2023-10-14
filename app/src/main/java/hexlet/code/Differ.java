package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Comparator;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {
        Map<String, Object> mapFile1 = Parser.parse(file1);
        Map<String, Object> mapFile2 = Parser.parse(file2);

        SortedMap<String, Object> resultMap = new TreeMap<>();
        StringBuilder resultString = new StringBuilder("{\n");
        mapFile1.entrySet().stream()
                        .forEach(entry -> {
                            if (mapFile2.containsKey(entry.getKey())) {
                                if (mapFile2.get(entry.getKey()).equals(entry.getValue())) {
                                    resultMap.put(entry.getKey(), entry.getValue());
                                } else {
                                    resultMap.put("- " + entry.getKey(), entry.getValue());
                                    resultMap.put("+ " + entry.getKey(), mapFile2.get(entry.getKey()));
                                }
                            } else {
                                resultMap.put("- " + entry.getKey(), entry.getValue());
                            }
                        });
        mapFile2.entrySet().stream()
                .forEach(entry -> {
                    if (!mapFile1.containsKey(entry.getKey())) {
                        resultMap.put("+ " + entry.getKey(), entry.getValue());
                    }
                });
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
                    resultString.append(str.getValue());
                    resultString.append("\n");
                });

        resultString.append("}");
        return resultString.toString();
    }
}
