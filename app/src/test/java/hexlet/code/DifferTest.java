package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    @Test
    public void testGenerateJSON() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYAML() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1YAML.yml").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2YAML.yml").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonPlain() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonJson() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "{\"chars1\":[\"a\",\"b\",\"c\"],\"- chars2\":[\"d\",\"e\",\"f\"],\"+ chars2\":false,\""
                + "- checked\":false,\"+ checked\":true,\"- default\":null,\""
                + "+ default\":[\"value1\",\"value2\"],\"- id\":45,\"+ id\":null,\"- key1\":\"value1\",\""
                + "+ key2\":\"value2\",\"numbers1\":[1,2,3,4],\"- numbers2\":[2,3,4,5],\""
                + "+ numbers2\":[22,33,44,55],\"- numbers3\":[3,4,5],\"+ numbers4\":[4,5,6],\""
                + "+ obj1\":{\"nestedKey\":\"value\",\"isNested\":true},\"- setting1\":\"Some value\",\""
                + "+ setting1\":\"Another value\",\"- setting2\":200,\"+ setting2\":300,\""
                + "- setting3\":true,\"+ setting3\":\"none\"}";
        String actual = Differ.generate(file1, file2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlJson() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "{\"chars1\":[\"a\",\"b\",\"c\"],\"- chars2\":[\"d\",\"e\",\"f\"],\"+ chars2\":false,\""
                + "- checked\":false,\"+ checked\":true,\"- default\":null,\""
                + "+ default\":[\"value1\",\"value2\"],\"- id\":45,\"+ id\":null,\"- key1\":\"value1\",\""
                + "+ key2\":\"value2\",\"numbers1\":[1,2,3,4],\"- numbers2\":[2,3,4,5],\""
                + "+ numbers2\":[22,33,44,55],\"- numbers3\":[3,4,5],\"+ numbers4\":[4,5,6],\""
                + "+ obj1\":{\"nestedKey\":\"value\",\"isNested\":true},\"- setting1\":\"Some value\",\""
                + "+ setting1\":\"Another value\",\"- setting2\":200,\"+ setting2\":300,\""
                + "- setting3\":true,\"+ setting3\":\"none\"}";
        String actual = Differ.generate(file1, file2, "json");
        assertEquals(expected, actual);
    }
}
