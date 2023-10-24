package hexlet.code;

public class ParserFactory {
    public static Parser getParser(String fileFormat) {
        switch (fileFormat) {
            case "yml":
                return new ParserYml();
            case "json":
                return new ParserJson();
            default:
                throw new RuntimeException("Unknown fileExtention: '" + fileFormat + "'");
        }
    }
}
