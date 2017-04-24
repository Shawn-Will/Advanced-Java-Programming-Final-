package textgen;

/**
 * The Class LLNode.
 *
 * @param <E>
 *            the element type
 */
class LLNode<E> {

	/** The prev. */
	LLNode<E> prev;

	/** The next. */
	LLNode<E> next;

	/** The data. */
	E data;

	/**
	 * Instantiates a new LL node.
	 */
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	/**
	 * Instantiates a new LL node.
	 *
	 * @param e
	 *            the e
	 */
	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}