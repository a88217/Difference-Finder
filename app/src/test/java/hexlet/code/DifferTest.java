package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    @Test
    public void testGenerate() throws Exception {
        Path path1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        String file1 = path1.toString();
        String file2 = path2.toString();
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate(file1, file2);
        assertEquals(expected, actual);
    }
}
