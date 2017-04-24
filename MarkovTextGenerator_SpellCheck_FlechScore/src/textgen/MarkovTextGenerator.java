package textgen;

/**
 * The Interface MarkovTextGenerator.
 */
public interface MarkovTextGenerator {

	/**
	 * Train.
	 * 
	 * @param sourceText
	 *            the source text
	 */
	public void train(String sourceText);

	/**
	 * Generate text.
	 * 
	 * @param numWords
	 *            the num words
	 * @return the string
	 */
	public String generateText(int numWords);

	/**
	 * Retrain.
	 * 
	 * @param sourceText
	 *            the source text
	 */
	public void retrain(String sourceText);
}