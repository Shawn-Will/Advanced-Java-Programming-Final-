package TextEditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Class valueSaver.
 */
public class valueSaver {

	/**
	 * Save val.
	 *
	 * @param wCount the w count
	 * @param sentCount the sent count
	 * @param sylCount the syl count
	 * @param fre the fre
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void saveVal(double wCount, double sentCount, double sylCount, double fre) throws IOException {
		String output = ("Word Count: " + wCount + " Sentence Count: " + sentCount + " Sylable Count: " + sylCount
				+ " FRE Value: " + fre );
		File outputData = new File(
				"C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data\\outputData\\results.txt");
		FileWriter fw = new FileWriter(outputData, true);
		fw.write(output + "\n");
		fw.close();
	}
}