import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadInFile {
    public static String readCSVIn(String pathName) throws Exception{
        String csv = new String(Files.readAllBytes(Paths.get(pathName)));
        return csv;

    }

}
