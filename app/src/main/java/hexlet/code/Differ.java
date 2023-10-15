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
    public static Map<String, Object> generate(String file1, String file2) throws Exception {
        Map<String, Object> mapFile1 = Parser.parse(file1);
        Map<String, Object> mapFile2 = Parser.parse(file2);

        SortedMap<String, Object> resultMap = new TreeMap<>();
        mapFile1.entrySet().stream()
                        .forEach(entry -> {
                            if (mapFile2.containsKey(entry.getKey())) {
                                if (mapFile2.get(entry.getKey()) != null && entry.getValue() != null) {
                                    if (mapFile2.get(entry.getKey()).equals(entry.getValue())) {
                                        resultMap.put(entry.getKey(), entry.getValue());
                                    } else {
                                        resultMap.put("- " + entry.getKey(), entry.getValue());
                                        resultMap.put("+ " + entry.getKey(), mapFile2.get(entry.getKey()));
                                    }
                                } else if (mapFile2.get(entry.getKey()) == null && entry.getValue() == null) {
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
        return resultMap;
    }
}
