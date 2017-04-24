package SpellChecker;

/**
 * The Class Bucket.
 */
public class Bucket {

	/** The first. */
	Node first;

	/**
	 * Gets the.
	 *
	 * @param in
	 *            the in
	 * @return true, if successful
	 */
	public boolean get(String in) {
		Node next = first;
		while (next != null) {
			if (next.word.equals(in)) {
				return true;
			}
			next = next.next;
		}
		return false;
	}

	/**
	 * Put.
	 *
	 * @param key
	 *            the key
	 */
	public void put(String key) {
		for (Node curr = first; curr != null; curr = curr.next) {
			if (key.equals(curr.word)) {
				return;
			}
		}
		first = new Node(key, first);
	}

}
