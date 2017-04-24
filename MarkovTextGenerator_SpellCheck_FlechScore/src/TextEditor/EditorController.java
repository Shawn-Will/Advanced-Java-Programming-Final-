package TextEditor;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BinarySearchTree.BinaryTree;
import BinarySearchTree.Node;
import SpellChecker.SpellCheck;
import textgen.MarkovTextGeneratorLoL;

/**
 * The Class EditorController.
 */
public class EditorController {

	/** Initialize text areas. */
	@FXML
	public TextArea areaText;

	/** The word count area. */
	@FXML
	private TextArea wordCountArea;

	/** The sentence count area. */
	@FXML
	private TextArea sentenceCountArea;

	/** The syllable count area. */
	@FXML
	private TextArea syllableCountArea;

	/** The flesch score area. */
	@FXML
	private TextArea fleschScoreArea;

	/** The current text file. */
	private TextFile currentTextFile;

	/** The model. */
	private EditorModel model;

	/** The sent count. */
	private double sentCount = 0.0;

	/** The w count. */
	private double wCount = 0.0;

	/** The syl count. */
	private double sylCount = 0.0;

	/** The fre. */
	private double fre = 0.0;

	/** The asl. */
	private double asl;

	/** The asw. */
	private double asw;

	/**
	 * Instantiates the editor controller.
	 *
	 * @param model
	 *            the model
	 */
	public EditorController(EditorModel model) {
		this.model = model;
	}

	/**
	 * On save.
	 */
	@FXML
	private void onSave() {
		FileChooser fileChooser = new FileChooser();
		fileChooser
				.setInitialDirectory(new File("C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data"));
		TextFile textFile = null;
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			if (file != null) {
				FileSaver.saveFile(file, areaText.getText().split("\n"));
			}
		} else {
			textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
			model.save(textFile);
		}
		System.out.println("File Saved.");
	}

	/**
	 * On load.
	 */
	@FXML
	private void onLoad() {
		FileChooser fileChooser = new FileChooser();
		fileChooser
				.setInitialDirectory(new File("C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data"));
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			IOResult<TextFile> io = model.load(file.toPath());

			if (io.isOk() && io.hasData()) {
				currentTextFile = io.getData();
				areaText.clear();
				currentTextFile.getContent().forEach(line -> areaText.appendText(line + "\n"));
			} else {
				System.out.println("Failed");
			}
		}
	}

	/**
	 * On split.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@FXML
	private void onSplit() throws IOException {
		File f = new File("C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data\\warAndPeace.txt");
		splitter.splitFile(f);
		System.out.println("File Was Split.");
	}

	/**
	 * On clear.
	 */
	@FXML
	private void onClear() {
		areaText.clear();
	}

	/**
	 * On close.
	 */
	@FXML
	private void onClose() {
		model.close();
	}

	/**
	 * On word count.
	 *
	 * @return the double wCount
	 */
	@FXML
	private double onWordCount() {
		Pattern p = Pattern.compile("\\S+");
		Matcher m = p.matcher(areaText.getText().toString());
		while (m.find()) {
			wCount++;
		}
		wordCountArea.setText("Word Count: " + String.valueOf(wCount));
		return wCount;
	}

	/**
	 * On sentence count.
	 *
	 * @return the double sentCount
	 */
	@FXML
	private double onSentenceCount() {
		Pattern p = Pattern.compile("[^?!.][?!.]");
		Matcher m = p.matcher(areaText.getText().toString());
		while (m.find()) {
			sentCount++;
		}
		sentenceCountArea.setText("Sentence Count: " + String.valueOf(sentCount));
		return sentCount;
	}

	/**
	 * On syllable count.
	 *
	 * @return the double sylCount
	 */
	@FXML
	private double onSyllableCount() {
		String regex = "[aeioUyAEIOUY]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(areaText.getText().toString());
		while (m.find()) {
			sylCount++;
		}
		syllableCountArea.setText("Syllable Count: " + String.valueOf(sylCount));
		return sylCount;
	}

	/**
	 * On flech score.
	 */
	@FXML
	private void onFlechScore() {
		asl = (wCount / sentCount);
		asw = (sylCount / wCount);
		fre = (206.835 - (1.015 * asl) - (84.6 * asw));
		fleschScoreArea.setText("Flewch Reading Ease: " + fre);
	}

	/**
	 * On all.
	 */
	@FXML
	private void onAll() {
		onWordCount();
		onSentenceCount();
		onSyllableCount();
		onFlechScore();
	}

	/**
	 * On save val.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@FXML
	private void onSaveVal() throws IOException {
		valueSaver.saveVal(wCount, sentCount, sylCount, fre);
	}

	/**
	 * On markov gen.
	 */
	@FXML
	private void onMarkovGen() {
		areaText.clear();
		areaText.appendText(MarkovTextGeneratorLoL.returnMarkov().toString());
	}

	/**
	 * On BST.
	 */
	@FXML
	private void onBST() {
		BufferedReader br;
		BinaryTree btree = new BinaryTree();
		try {
			br = new BufferedReader(
					new FileReader("C:\\Users\\sbw73_000\\CST_246\\WilliamsFinalProject_CST246\\src\\data\\DJIA.txt"));
			String line = "";
			while ((line = br.readLine()) != null) {
				Node date = new Node(line);
				btree.addNode(date.key, date.value);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}

		long start = System.nanoTime();
		String searchDate = areaText.getText();
		double djiaVal = btree.getValueForKey(searchDate);
		long stop = System.nanoTime();

		long time = stop - start;
		double timeSect = time / 1000000000.0;

		if (djiaVal == -1)
			areaText.appendText(
					"\nSorry this Date is not found in the Tree or is in the wrong format, please try again."
							+ "\nRemember the format is 'yyyy-mm-dd'"
							+ "\n\nAnother reason for this error could be that the market was closed on the searched day");
		else
			areaText.appendText("\nDJAI for the Date searched is : " + djiaVal + "\nIt took " + timeSect
					+ " Seconds to find the value for : " + searchDate);
	}

	/**
	 * On spell check.
	 */
	@FXML
	private void onSpellCheck() {
		SpellCheck sc = new SpellCheck();
		String word = new String(areaText.getText().toString());

		if (sc.run(word) == true) {
			areaText.appendText("\nThe word " + word + " is spelled correctly");
		} else {
			areaText.appendText("\nThe word " + word + " is NOT spelled correctly");
			areaText.appendText(sc.printSuggestions(word));
		}
	}

	/**
	 * On about.
	 */
	@FXML
	private void onAbout() {
		String about = "Please use the Split command at the first startup of the program"
				+ ". This will split the text file 'WarAndPiece.txt', found within the " + "'data' folder. \n\n\n";

		String info = "The split command will split the text file into 10 equal files and "
				+ "save them to the 'inputData' subfolder. You can then open the split files called"
				+ " \n'warAndPeace.txt.001.txt - warAndPeace.txt.010.txt' in the text editor using the "
				+ "open comand. After the file has loaded into the program you can \nthen use the Edit "
				+ "menu to choose the rest of the comands.\n\n\n";

		String editInfo = "EDIT Comands: \n" + "\tWord Count: This will calulate the number of WORDS in the file\n"
				+ "\tSentence Count: This will calulate the number of SENTENCES in the file\n"
				+ "\tSyllable Count: This will calulate the number of SYLLABLES in the file\n"
				+ "\tFlech Score: This will calculate the FLECH SCORE of the file\n"
				+ "\t\t\tFLECH SCORE is calulated with 'Flech Score = 206.835 " + "- (1.015 * ASL) - (84.6 * ASW)' \n"
				+ "\t\t\t\tASL = Average Sentence Length\n" + "\t\t\t\tASW = Average Number of Syllables per Word\n"
				+ "\tClaculate All: This will calulate all of the above comands\n"
				+ "\tSave Vlaues: This will save all the values calculated with the above comands "
				+ "to the subfolder 'outputData' in one text file named 'results.txt'\n\n";

		String utilInfo = "Utilities Commands: \n" + "\tMarkov Generator: This will use a"
				+ " \tMarkov Text Generator to generate a random list of 1000 words\n"
				+ " \t\t\t\t\tFor more information please select Markov Generator Definition under the 'HELP' menu.\n"
				+ " \tGraph: Graphs something... Not sure what yet, but something." + "\n\n\n\n";

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("About");
		alert.setContentText(about);
		alert.show();

		areaText.setText(about + info + editInfo + utilInfo);
	}

	/**
	 * On flech score about.
	 */
	@FXML
	private void onFlechScoreAbout() {
		String flech = "The Flech Score is a test that is designed to indicate how difficult a"
				+ " reading passage in English is to understand. \nWe use the Flech Reading Score here."
				+ " It is calculated using the formula: (206.835 - (1.015 * asl) - (84.6 * asw)),"
				+ " \nwhere ASL is the 'Average Sentence Length' and ASW is the 'Average Syllables PerWord'."
				+ " The scores are seperated \nbased on the equivalent grade level of reading.";

		String flechScore = "Flech Score: \n" + "\tScore 90-100:\t\t\t5th Grade, Very Easy\n"
				+ "\tScore 80-89.9:\t\t\t6th Grade, Easy\n" + "\tScore 70-79.9:\t\t\t7th Grade, Fairly Easy\n"
				+ "\tScore 60-69.9:\t\t\t8th & 9th Grade, Average English\n"
				+ "\tScore 50-59.9:\t\t\t10th - 12th Grade, Fairly Difficult\n"
				+ "\tScore 30-49.9:\t\t\tCollege Level, Difficult\n"
				+ "\tScore 0-29.9:\t\t\tCollege Graduate, Very difficult\n";

		areaText.setText(flech + "\n\n\n" + flechScore);

	}

	/**
	 * On markov gen about.
	 */
	@FXML
	private void onMarkovGenAbout() {
		String mark = "The Markov Text Generator is function that will take in 100,000 words from the file\n"
				+ " 'WarAndPeace.txt' and train the generator using these words. It will then take another \nfile"
				+ " and using the already trained generator, create a String of 1000 words from the trained generator."
				+ "\n\nThis version of the Generator is using Linked Lists.";

		areaText.setText(mark);
	}

	/**
	 * On B tree about.
	 */
	@FXML
	private void onBTreeAbout() {
		String btreeAbout = "To search for value clear textarea using clear comand,"
				+ " then type in a date that you want to search for, format is yyyy-mm-dd, "
				+ "\nthen select Binary Search Tree in Utilities Menue. It will come back with"
				+ " the value for the date you searched for\n and the amount of time in seconds"
				+ " it took to search for it.";

		areaText.setText(btreeAbout);
	}

	/**
	 * On spell check about.
	 */
	@FXML
	private void onSpellCheckAbout() {
		String spellAbout = "To use the Spell Check feature please clear the text area"
				+ " using the 'CLEAR' command. \nThen enter the word your looking to check on"
				+ " into this text area. When you choose \nthe spell check it will return if your"
				+ " word was spelled correctly or not."
				+ "\nIf the word was not spelled correctly it will return a list of possible corrections"
				+ " for the inputed word.";

		areaText.setText(spellAbout);
	}
}