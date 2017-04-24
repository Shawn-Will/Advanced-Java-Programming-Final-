package BinarySearchTree;

import java.util.StringTokenizer;

/**
 * The Class Node.
 */
public class Node {

	/** The key. */
	public String key;
	
	/** The value. */
	public double value;

	/** The left. */
	Node left;
	
	/** The right. */
	Node right;

	/**
	 * Instantiates a new node.
	 *
	 * @param line the line
	 */
	public Node(String line) {
		StringTokenizer st = new StringTokenizer(line, " ");
		this.key = st.nextElement().toString();
		this.value = Double.parseDouble(st.nextElement().toString());
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param key the key
	 * @param value the value
	 */
	Node(String key, double value) {
		this.key = key;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return key + " " + value;
	}

}