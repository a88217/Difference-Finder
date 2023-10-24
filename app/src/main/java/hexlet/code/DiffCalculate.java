package hexlet.code;

import java.util.Objects;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.HashSet;

public class DiffCalculate {

    public static Map<String, List> calculate(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

        SortedMap<String, List> resultMap = new TreeMap<String, List>();
        Set<String> keySet = new HashSet<>();
        keySet.addAll(mapFile1.keySet());
        keySet.addAll(mapFile2.keySet());
        keySet.stream()
                .forEach(key -> {
                    if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                        if (Objects.equals(mapFile1.get(key), mapFile2.get(key))) {
                            resultMap.put(key, Arrays.asList("Unchanged", mapFile1.get(key)));
                        } else {
                            resultMap.put(key, Arrays.asList("Modified", mapFile1.get(key), mapFile2.get(key)));
                        }
                    } else if (mapFile1.containsKey(key) && !mapFile2.containsKey(key)) {
                        resultMap.put(key, Arrays.asList("Deleted", mapFile1.get(key)));
                    } else {
                        resultMap.put(key, Arrays.asList("Added", mapFile2.get(key)));
                    }
                });
        return resultMap;
    }

}
