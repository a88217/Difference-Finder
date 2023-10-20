package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Read {
    public static String[] readFile(String fileName) throws Exception {
        Path path = Paths.get(fileName).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String[] result = new String[2];
        result[0] = Files.readString(path);
        result[1] = FilenameUtils.getExtension(fileName);
        return result;
    }
}
