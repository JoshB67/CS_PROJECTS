package ExceptionExamples;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("text.txt");
		
			for (String line : Files.readAllLines(path)) {
				System.out.println(line);
			}
		
		

	}

}
