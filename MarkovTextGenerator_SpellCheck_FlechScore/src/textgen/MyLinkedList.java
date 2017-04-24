package textgen;

import java.util.AbstractList;

/**
 * The Class MyLinkedList.
 *
 * @param <E>
 *            the element type
 */
public class MyLinkedList<E> extends AbstractList<E> {

	/** The head. */
	LLNode<E> head;

	/** The tail. */
	LLNode<E> tail;

	/** The size. */
	int size;

	/**
	 * Instantiates a new my linked list.
	 */
	public MyLinkedList() {
		this.size = 0;
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#add(java.lang.Object)
	 */
	public boolean add(E element) {
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = nodeToAdd;
		nodeToAdd.prev = prev;
		nodeToAdd.next = tail;
		tail.prev = nodeToAdd;
		size++;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	public E get(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		LLNode<E> target = head;
		for (int i = 0; i <= index; i++) {
			target = target.next;
		}
		E value = target.data;
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}

		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> nodeAtIndex = head;
		for (int i = 0; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.next;
		}
		LLNode<E> prev = nodeAtIndex.prev;
		prev.next = nodeToAdd;
		nodeToAdd.prev = prev;
		nodeToAdd.next = nodeAtIndex;
		nodeAtIndex.prev = nodeToAdd;
		size++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#remove(int)
	 */
	public E remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		LLNode<E> nodeToRemove = head;
		for (int i = 0; i <= index; i++) {
			nodeToRemove = nodeToRemove.next;
		}
		LLNode<E> prev = nodeToRemove.prev;
		LLNode<E> next = nodeToRemove.next;
		prev.next = next;
		next.prev = prev;
		size--;
		E value = nodeToRemove.data;
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	public E set(int index, E element) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		LLNode<E> nodeToSet = head;
		for (int i = 0; i <= index; i++) {
			nodeToSet = nodeToSet.next;
		}
		nodeToSet.data = element;
		return element;
	}
}