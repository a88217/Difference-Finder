package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Comparator;


public class Differ {
    public static String generate(String file1, String file2, String formatName) throws Exception {
        Map<String, Object> mapFile1 = Parser.parse(file1);
        Map<String, Object> mapFile2 = Parser.parse(file2);
        SortedMap<String, Object> resultMap = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(" ");
                String[] arr2 = o2.split(" ");
                String s1 = arr1.length == 1 ? arr1[0] : arr1[1];
                String s2 = arr2.length == 1 ? arr2[0] : arr2[1];
                if (s1.equals(s2)) {
                    return arr2[0].compareTo(arr1[0]);
                }
                return s1.compareTo(s2);
            }
        });
        mapFile1.entrySet().stream()
                .forEach(entry -> {
                    if (mapFile2.containsKey(entry.getKey())) {
                        if (mapFile2.get(entry.getKey()) != null && entry.getValue() != null) {
                            if (mapFile2.get(entry.getKey()).equals(entry.getValue())) {
                                resultMap.put(entry.getKey(), entry.getValue());
                            } else {
                                resultMap.put("-mod " + entry.getKey(), entry.getValue());
                                resultMap.put("+mod " + entry.getKey(), mapFile2.get(entry.getKey()));
                            }
                        } else if (mapFile2.get(entry.getKey()) == null && entry.getValue() == null) {
                            resultMap.put(entry.getKey(), entry.getValue());
                        } else {
                            resultMap.put("-mod " + entry.getKey(), entry.getValue());
                            resultMap.put("+mod " + entry.getKey(), mapFile2.get(entry.getKey()));
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
        return Formatter.format(formatName, resultMap);
    }

    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }
}
