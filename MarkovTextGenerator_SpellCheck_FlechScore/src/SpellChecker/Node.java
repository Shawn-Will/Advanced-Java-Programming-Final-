package SpellChecker;

/**
 * The Class Node.
 */
public class Node {

	/** The word. */
	String word;

	/** The next. */
	Node next;

	/**
	 * Instantiates a new node.
	 *
	 * @param key
	 *            the key
	 * @param next
	 *            the next
	 */
	public Node(String key, Node next) {
		this.word = key;
		this.next = next;
	}
}
