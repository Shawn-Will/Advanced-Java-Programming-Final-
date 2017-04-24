package textgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The Class MarkovTextGeneratorLoL.
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	/** The word list. */
	private List<ListNode> wordList;

	/** The starter. */
	private String starter;

	/** The rn generator. */
	private Random rnGenerator;

	/**
	 * Instantiates a new markov text generator lo L.
	 *
	 * @param generator
	 *            the generator
	 */
	public MarkovTextGeneratorLoL(Random generator) {
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textgen.MarkovTextGenerator#train(java.lang.String)
	 */
	@Override
	public void train(String sourceText) {
		if (sourceText.length() == 0) {
			System.out.println("There is no input string!");
		} else {
			String[] sourceWords = sourceText.split("[\\s]+");
			starter = sourceWords[0];
			String prevWord = starter;
			String w;
			ListNode node;
			for (int i = 1; i <= sourceWords.length; i++) {
				if (i == sourceWords.length) {
					w = sourceWords[0];
				} else {
					w = sourceWords[i];
				}

				node = findNode(prevWord);
				if (node == null) {
					node = new ListNode(prevWord);
					node.addNextWord(w);
					wordList.add(node);
				} else {
					node.addNextWord(w);
				}
				prevWord = w;

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textgen.MarkovTextGenerator#generateText(int)
	 */
	@Override
	public String generateText(int numWords) {
		String output = "";
		if (wordList.isEmpty()) {
			System.out.println("Haven't trained yet!!");
			return output;
		}
		if (numWords == 0) {
			return output;
		}
		String currWord = starter;
		output = output + currWord;
		int count = 1;
		while (count < numWords) {
			ListNode node = findNode(currWord);
			String w = node.getRandomNextWord(rnGenerator);
			output = output + " " + w;
			currWord = w;
			count++;
		}
		return output;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String toReturn = "";
		for (ListNode n : wordList) {
			toReturn += n.toString();
		}
		return toReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textgen.MarkovTextGenerator#retrain(java.lang.String)
	 */
	@Override
	public void retrain(String sourceText) {
		wordList = new LinkedList<ListNode>();
		train(sourceText);
	}

	/**
	 * Find node.
	 *
	 * @param word
	 *            the word
	 * @return the list node
	 */
	private ListNode findNode(String word) {
		for (ListNode node : wordList) {
			if (word.equals(node.getWord())) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Return markov.
	 *
	 * @return the string
	 */
	@SuppressWarnings("resource")
	public static String returnMarkov() {
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(10000));
		File file = new File("C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data\\warAndPeace.txt");
		String trainString = "";
		try {
			trainString = new Scanner(file).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		gen.train(trainString);
		System.out.println(
				"Generater Trained from warAndPeace.txt, \n" + "now generating 1000 words from warAndPeace.001.txt");

		File file1 = new File("C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data\\warAndPeace.txt");
		String textString2 = "";
		try {
			textString2 = new Scanner(file1).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		gen.retrain(textString2);
		String content = gen.generateText(1000);
		System.out.println(content);

		return stringSplitter(content);
	}

	/**
	 * String splitter.
	 *
	 * @param content
	 *            the content
	 * @return the string
	 */
	public static String stringSplitter(String content) {
		int length = content.length();
		int partLength = 120;
		int nParts = (length + partLength - 1) / partLength;
		int offset = 0;
		int i = 0;
		String parts[] = new String[nParts];
		while (i < nParts) {
			parts[i] = content.substring(offset, Math.min(offset + partLength, length)) + "\n";
			offset += partLength;
			i++;
		}
		String markov = Arrays.toString(parts);
		markov = markov.replace(",", "").replace("[", "").replace("]", "");
		markov = markov.substring(3);
		return markov;
	}
}