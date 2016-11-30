import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	private Words words;
	private ArrayList<ArrayList<String>> wordsDB;
	private ArrayList<String> oneWord;
	
	private AppGUI gui;

	public Test() throws FileNotFoundException, IOException
	{
		words = new Words();
		wordsDB = words.getList();
		oneWord = words.getOne();
		
		gui = new AppGUI();
		gui.prepareGUI(oneWord);
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		Test test = new Test();
		System.out.println(test.wordsDB);
		System.out.println(test.oneWord);
	}

}
