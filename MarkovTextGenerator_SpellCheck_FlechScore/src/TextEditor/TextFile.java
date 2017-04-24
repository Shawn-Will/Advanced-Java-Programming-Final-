package TextEditor;

import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class TextFile.
 */
public class TextFile {

	/** The file. */
	private final Path file;

	/** The content. */
	private final List<String> content;

	/**
	 * Instantiates a new text file.
	 *
	 * @param file
	 *            the file
	 * @param content
	 *            the content
	 */
	public TextFile(Path file, List<String> content) {
		this.file = file;
		this.content = content;
	}

	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public Path getFile() {
		return file;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public List<String> getContent() {
		return content;
	}
}
