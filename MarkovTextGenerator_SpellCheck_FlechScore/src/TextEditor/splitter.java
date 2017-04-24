package TextEditor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The Class splitter.
 */
public class splitter {

	/**
	 * Split file.
	 *
	 * @param f
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void splitFile(File f) throws IOException {
		int partCounter = 1;
		int sizeOfFiles = (int) (f.length() / 9);
		byte[] buffer = new byte[sizeOfFiles];
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {
			String name = f.getName();
			int tmp = 0;
			while ((tmp = bis.read(buffer)) > 0) {
				File newFile = new File(
						"C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data\\inputData\\" + name
								+ "." + String.format("%03d", partCounter++));
				try (FileOutputStream out = new FileOutputStream(newFile + ".txt")) {
					out.write(buffer, 0, tmp);
					out.close();
				}
			}
		}
	}
}
