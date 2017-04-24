package BinarySearchTree;

/**
 * The Class BinaryTree.
 */
public class BinaryTree {

	/** The root. */
	public Node root;

	/** The max. */
	double MAX = 0;

	/** The min. */
	double MIN = 0;

	/**
	 * Adds the node.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void addNode(String key, double value) {
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key.compareToIgnoreCase(focusNode.key) < 0) {
					focusNode = focusNode.left;
					if (focusNode == null) {
						parent.left = newNode;
						return;
					}

				} else {
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * Order tree by date.
	 *
	 * @param node
	 *            the node
	 * @return the node
	 */
	public Node orderTreeByDate(Node node) {
		if (node != null) {
			orderTreeByDate(node.left);
			System.out.println(node);
			orderTreeByDate(node.right);
		}
		return node;
	}

	/**
	 * Find node.
	 *
	 * @param key
	 *            the key
	 * @return the node
	 */
	public Node findNode(String key) {
		Node focusNode = root;
		while (focusNode.key.compareToIgnoreCase(key) != 0) {
			if (key.compareToIgnoreCase(focusNode.key) < 0) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}

	/**
	 * Gets the value for key.
	 *
	 * @param key
	 *            the key
	 * @return the value for key
	 */
	public double getValueForKey(String key) {
		Node focusNode = root;
		while (focusNode.key.compareToIgnoreCase(key) != 0) {
			if (key.compareToIgnoreCase(focusNode.key) < 0) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
			if (focusNode == null)
				return -1;
		}
		return focusNode.value;
	}

	/**
	 * Gets the nodes count.
	 *
	 * @param node
	 *            the node
	 * @return the nodes count
	 */
	public int getNodesCount(Node node) {
		if (node == null) {
			return 0;
		} else {
			int count = 1;
			count += getNodesCount(node.left);
			count += getNodesCount(node.right);
			return count;
		}
	}

	/**
	 * Gets the min value.
	 *
	 * @param node
	 *            the node
	 * @return the min value
	 */
	public double getMinValue(Node node) {
		if (node != null) {
			getMinValue(node.left);
			if (MIN == 0) {
				MIN = node.value;
			}

			if (MIN > node.value) {
				MIN = node.value;
			}
			getMinValue(node.right);
		}
		return MIN;
	}

	/**
	 * Gets the max value.
	 *
	 * @param node
	 *            the node
	 * @return the max value
	 */
	public double getMaxValue(Node node) {
		if (node != null) {
			getMaxValue(node.left);
			if (MAX == 0) {
				MAX = node.value;
			}

			if (MAX < node.value) {
				MAX = node.value;
			}
			getMaxValue(node.right);
		}
		return MAX;
	}
}