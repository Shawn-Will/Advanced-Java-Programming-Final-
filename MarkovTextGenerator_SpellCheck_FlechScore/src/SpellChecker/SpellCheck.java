package SpellChecker;

import java.util.ArrayList;
import java.util.Scanner;

import TextEditor.EditorController;
import javafx.scene.control.TextArea;

/**
 * The Class SpellCheck.
 */
public class SpellCheck {

	/** The dict. */
	private Dictionary dict;

	/** The Constant filePath. */
	final static String filePath = "C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246"
			+ "\\bin\\SpellChecker\\words.txt";

	/** The Constant alphabet. */
	final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	/**
	 * Instantiates a new spell check.
	 */
	public SpellCheck() {
		dict = new Dictionary();
		dict.build(filePath);
	}

	/**
	 * Run.
	 *
	 * @param word
	 *            the word
	 * @return true, if successful
	 */
	public boolean run(String word) {
		boolean done = false;
		String input = word;
		if (input.equals("")) {
			return false;
		}

		if (dict.contains(input)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prints the suggestions.
	 *
	 * @param input
	 *            the input
	 * @return the string
	 */
	public String printSuggestions(String input) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> print = makeSuggestions(input);
		if (print.size() == 0) {
			return " and I have no idea what word you could mean.\n";
		}
		sb.append(" perhaps you meant:\n");
		for (String s : print) {
			sb.append("\n  -" + s);
		}
		return sb.toString();
	}

	/**
	 * Make suggestions.
	 *
	 * @param input
	 *            the input
	 * @return the array list
	 */
	private ArrayList<String> makeSuggestions(String input) {
		ArrayList<String> toReturn = new ArrayList<>();
		toReturn.addAll(charAppended(input));
		toReturn.addAll(charMissing(input));
		toReturn.addAll(charsSwapped(input));
		return toReturn;
	}

	/**
	 * Char appended.
	 *
	 * @param input
	 *            the input
	 * @return the array list
	 */
	private ArrayList<String> charAppended(String input) {
		ArrayList<String> toReturn = new ArrayList<>();
		for (char c : alphabet) {
			String atFront = c + input;
			String atBack = input + c;
			if (dict.contains(atFront)) {
				toReturn.add(atFront);
			}
			if (dict.contains(atBack)) {
				toReturn.add(atBack);
			}
		}
		return toReturn;
	}

	/**
	 * Char missing.
	 *
	 * @param input
	 *            the input
	 * @return the array list
	 */
	private ArrayList<String> charMissing(String input) {
		ArrayList<String> toReturn = new ArrayList<>();

		int len = input.length() - 1;
		if (dict.contains(input.substring(1))) {
			toReturn.add(input.substring(1));
		}
		for (int i = 1; i < len; i++) {
			String working = input.substring(0, i);
			working = working.concat(input.substring((i + 1), input.length()));
			if (dict.contains(working)) {
				toReturn.add(working);
			}
		}
		if (dict.contains(input.substring(0, len))) {
			toReturn.add(input.substring(0, len));
		}
		return toReturn;
	}

	/**
	 * Chars swapped.
	 *
	 * @param input
	 *            the input
	 * @return the array list
	 */
	private ArrayList<String> charsSwapped(String input) {
		ArrayList<String> toReturn = new ArrayList<>();

		for (int i = 0; i < input.length() - 1; i++) {
			String working = input.substring(0, i);
			working = working + input.charAt(i + 1);
			working = working + input.charAt(i);
			working = working.concat(input.substring((i + 2)));
			if (dict.contains(working)) {
				toReturn.add(working);
			}
		}
		return toReturn;
	}
}