package TextEditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * The Class FileSaver.
 */
public class FileSaver {

	/**
	 * Save file.
	 *
	 * @param file
	 *            the file
	 * @param content
	 *            the content
	 */
	public static void saveFile(File file, String[] content) {
		try {
			FileWriter fileWriter = null;
			fileWriter = new FileWriter(file);
			fileWriter.write(Arrays.toString(content));
			fileWriter.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
