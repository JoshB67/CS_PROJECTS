package textFileReaderFont;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {
	/* Declaring the checked exception */
	public static String getFileContents(String filename) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader(filename));
		String line = bufferedReader.readLine();
		boolean firstTime = true;
		while (line != null) {
			if (!firstTime)
				stringBuffer.append("\n");
			stringBuffer.append(line);
			firstTime = false;

			line = bufferedReader.readLine();
		}
		return stringBuffer.toString();
	}
}