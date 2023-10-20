package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }

    @Test
    public void testGenerateJsonDefault() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultStylish;
        String actual = Differ.generate(file1, file2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlDefault() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1YAML.yml").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2YAML.yml").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultStylish;
        String actual = Differ.generate(file1, file2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonStylish() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultStylish;
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlStylish() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1YAML.yml").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2YAML.yml").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultStylish;
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonPlain() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultPlain;
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultPlain;
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonJson() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultJson;
        String actual = Differ.generate(file1, file2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlJson() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = resultJson;
        String actual = Differ.generate(file1, file2, "json");
        assertEquals(expected, actual);
    }
}
