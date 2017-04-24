Text Editor Project
Shawn Williams
SCCC Data Structures CST 246
Due 12-21-2016




Please use the Split command at the first startup of the program. This will split the text file 'WarAndPiece.txt', found within the 'data' folder. 


The split command will split the text file into 10 equal files and save them to the 'inputData' subfolder. You can then open the split files called 
'warAndPeace.txt.001.txt - warAndPeace.txt.010.txt' in the text editor using the open comand. After the file has loaded into the program you can 
then use the Edit menu to choose the rest of the comands.



EDIT Comands: 
	Word Count: This will calulate the number of WORDS in the file
	Sentence Count: This will calulate the number of SENTENCES in the file
	Syllable Count: This will calulate the number of SYLLABLES in the file
	Flech Score: This will calculate the FLECH SCORE of the file
			FLECH SCORE is calulated with 'Flech Score = 206.835 - (1.015 * ASL) - (84.6 * ASW)' 
				ASL = Average Sentence Length
				ASW = Average Number of Syllables per Word
	Claculate All: This will calulate all of the above comands
	Save Vlaues: This will save all the values calculated with the above comands to the subfolder 'outputData' in one text file named 'results.txt'

	
	
Utilities Commands: 
	Markov Generator: This will use a 	Markov Text Generator to generate a random list of 1000 words
 					For more information please select Markov Generator Definition under the 'HELP' menu.
 	Graph: Graphs something... Not sure what yet, but something.


Flech Score	
	The Flech Score is a test that is designed to indicate how difficult a reading passage in English is to understand. 
	We use the Flech Reading Score here. It is calculated using the formula: (206.835 - (1.015 * asl) - (84.6 * asw)), 
	where ASL is the 'Average Sentence Length' and ASW is the 'Average Syllables PerWord'. The scores are seperated 
	based on the equivalent grade level of reading.



	Flech Score: 
		Score 90-100:			5th Grade, Very Easy
		Score 80-89.9:			6th Grade, Easy
		Score 70-79.9:			7th Grade, Fairly Easy
		Score 60-69.9:			8th & 9th Grade, Average English
		Score 50-59.9:			10th - 12th Grade, Fairly Difficult
		Score 30-49.9:			College Level, Difficult
		Score 0-29.9:			College Graduate, Very difficult

	
Markov Text Generator
	The Markov Text Generator is function that will take in 100,000 words from the file
	'WarAndPeace.txt' and train the generator using these words. It will then take another 
	file and using the already trained generator, create a String of 1000 words from the trained generator.
	This version of the Generator is using Linked Lists.


Binary Search Tree
	To search for value clear textarea using clear comand, then type in a date that you want to search for, format is yyyy-mm-dd, 
	then select Binary Search Tree in Utilities Menue. It will come back with the value for the date you searched for
	and the amount of time in seconds it took to search for it.


Spell Check
	To use the Spell Check feature please clear the text area using the 'CLEAR' command. 
	Then enter the word your looking to check on into this text area. When you choose 
	the spell check it will return if your word was spelled correctly or not.
	If the word was not spelled correctly it will return a list of possible corrections for the inputed word.
