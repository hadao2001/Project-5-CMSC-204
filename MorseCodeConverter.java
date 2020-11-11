import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is responsible for translating
 * morse code from text or file into English
 * and printing the morse code tree.
 * 
 * Author: Ha T Dao
 * 
 * Assignment 5, Morse Code due Wednesday, November 11, 2020
 */
public class MorseCodeConverter {


	/**
     * Tree of letters
     */
    private static MorseCodeTree tree = new MorseCodeTree();
    
    
	/**
	 * Converts a file of Morse code into English. Each letter is delimited by a space.
	 * @param selectedFile Morse code to be translated
     * @return text converted into English
     */
	public static String convertToEnglish(File selectedFile) throws FileNotFoundException{
		Scanner input = new Scanner(selectedFile);
		String phrase = "";
		while (input.hasNextLine())  {
			phrase += input.nextLine();
		}
		return convertToEnglish(phrase);
	}

	/**
	 * Converts a string of Morse code into English
	 * @param input
	 * @return String of English
	 */
	public static String convertToEnglish(String input)  {
		String english = "";
		String[] morseCode = input.split("/");
		String[][] codeWords = new String[morseCode.length][];

		// Put the morse code string into arrays for each word
		for (int i = 0; i < codeWords.length; i++)  {
			codeWords[i] = morseCode[i].split(" ");
		}

		// Convert each word from Morse code to English
		for (int i = 0; i < codeWords.length; i++) {
			for (int j = 0; j < codeWords[i].length; j++) {
				codeWords[i][j] = tree.fetch(codeWords[i][j]);
				english += codeWords[i][j];
			}
			if (i == codeWords.length -1) {
				english += "";
			} else english += " ";
		}
	return english;
}

   /**
	 * Get a string which represents the inorder traversal of the morse binary tree
	 * @return the inorder traversal of the morse binary tree
	 */
	
	public static String printTree() {
		
		tree = new MorseCodeTree();
		String s = "";
		
		for(String letter : tree.toArrayList()) {
			s += letter + " ";
		}
		
		return s.substring(0, s.length() - 1);
		
	}
}