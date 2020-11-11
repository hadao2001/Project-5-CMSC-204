import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a student JUnit test for morse code conversion system. 
 * There are two text files needed: 
 * 
 * 
 * @author Ha T Dao
 * 
 */
public class MorseCodeConverter_STUDENT_Test {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = MorseCodeConverter.printTree();
		s = s.trim(); // take off preceding or succeeding spaces
		assertEquals(correctResult, s);
	}

	@Test
	public void testConvertToEnglishString() {	
		String converttest1 = MorseCodeConverter.convertToEnglish(".- / .-- .... --- .-.. . / -. . .-- / .-- --- .-. .-.. -..");
		assertEquals("a whole new world",converttest1);
		
		String test2="happy new year";		
		String converttest2 = MorseCodeConverter.convertToEnglish(".... .- .--. .--. -.-- / -. . .-- / -.-- . .- .-.");
		assertEquals(test2, converttest2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="you can rely on me";		
		getFile("Text1.txt");
		String converttest1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converttest1);
		
		String test2="you are beautiful in white";		
		getFile("Text2.txt");
		String converttest2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converttest2);

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}


