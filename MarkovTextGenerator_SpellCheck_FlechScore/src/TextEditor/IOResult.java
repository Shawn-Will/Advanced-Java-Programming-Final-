package TextEditor;

/**
 * The Class IOResult.
 *
 * @param <T>
 *            the generic type
 */
public class IOResult<T> {

	/** The data. */
	private T data;

	/** The ok. */
	private boolean ok;

	/**
	 * Instantiates a new IO result.
	 *
	 * @param ok
	 *            the ok
	 * @param data
	 *            the data
	 */
	public IOResult(boolean ok, T data) {
		this.ok = ok;
		this.data = data;
	}

	/**
	 * Checks if is ok.
	 *
	 * @return true, if is ok
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * Checks for data.
	 *
	 * @return true, if successful
	 */
	public boolean hasData() {
		return data != null;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}
}