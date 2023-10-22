package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Arrays;

public class DifCalculate {

    public static Map<String, List> calculate(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

        SortedMap<String, List> resultMap = new TreeMap<String, List>();
        mapFile1.entrySet().stream()
                .forEach(entry -> {
                    if (mapFile2.containsKey(entry.getKey())) {
                        if (mapFile2.get(entry.getKey()) != null && entry.getValue() != null) {
                            if (mapFile2.get(entry.getKey()).equals(entry.getValue())) {
                                resultMap.put(entry.getKey(), Arrays.asList("Unchanged", entry.getValue()));
                            } else {
                                resultMap.put(entry.getKey(),
                                        Arrays.asList("Modified", entry.getValue(), mapFile2.get(entry.getKey())));
                            }
                        } else if (mapFile2.get(entry.getKey()) == null && entry.getValue() == null) {
                            resultMap.put(entry.getKey(), Arrays.asList("Unchanged", null));
                        } else {
                            resultMap.put(entry.getKey(),
                                    Arrays.asList("Modified", entry.getValue(), mapFile2.get(entry.getKey())));
                        }
                    } else {
                        resultMap.put(entry.getKey(), Arrays.asList("Deleted", entry.getValue()));
                    }
                });
        mapFile2.entrySet().stream()
                .forEach(entry -> {
                    if (!mapFile1.containsKey(entry.getKey())) {
                        resultMap.put(entry.getKey(), Arrays.asList("Added", entry.getValue()));
                    }
                });
        return resultMap;
    }

}
