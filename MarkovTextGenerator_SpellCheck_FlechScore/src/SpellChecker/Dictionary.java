package SpellChecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Class Dictionary.
 */
public class Dictionary {

	/** The m. */
	private int M = 1319;

	/** The array. */
	final private Bucket[] array;

	/**
	 * Instantiates a new dictionary.
	 */
	public Dictionary() {
		this.M = M;

		array = new Bucket[M];
		for (int i = 0; i < M; i++) {
			array[i] = new Bucket();
		}
	}

	/**
	 * Hash.
	 *
	 * @param key
	 *            the key
	 * @return the int
	 */
	private int hash(String key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	/**
	 * Adds the.
	 *
	 * @param key
	 *            the key
	 */
	public void add(String key) {
		array[hash(key)].put(key);
	}

	/**
	 * Contains.
	 *
	 * @param input
	 *            the input
	 * @return true, if successful
	 */
	public boolean contains(String input) {
		input = input.toLowerCase();
		return array[hash(input)].get(input);
	}

	/**
	 * Builds the.
	 *
	 * @param filePath
	 *            the file path
	 */
	public void build(String filePath) {
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				add(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	/**
	 * Gets the random entries.
	 *
	 * @param num
	 *            the num
	 * @return the random entries
	 */
	public String[] getRandomEntries(int num) {
		String[] toRet = new String[num];
		for (int i = 0; i < num; i++) {
			Node n = array[(int) Math.random() * M].first;
			int rand = (int) Math.random() * (int) Math.sqrt(num);

			for (int j = 0; j < rand && n.next != null; j++)
				n = n.next;
			toRet[i] = n.word;

		}
		return toRet;
	}

}