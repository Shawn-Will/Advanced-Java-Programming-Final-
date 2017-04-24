package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * The Class ListNode.
 */
class ListNode {

	/** The word. */
	private String word;

	/** The next words. */
	private List<String> nextWords;

	/**
	 * Instantiates a new list node.
	 *
	 * @param word
	 *            the word
	 */
	ListNode(String word) {
		this.word = word;
		nextWords = new LinkedList<String>();
	}

	/**
	 * Gets the word.
	 *
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Adds the next word.
	 *
	 * @param nextWord
	 *            the next word
	 */
	public void addNextWord(String nextWord) {
		nextWords.add(nextWord);
	}

	/**
	 * Gets the random next word.
	 *
	 * @param generator
	 *            the generator
	 * @return the random next word
	 */
	public String getRandomNextWord(Random generator) {
		int size = nextWords.size();
		int index = generator.nextInt(size);
		return nextWords.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
}