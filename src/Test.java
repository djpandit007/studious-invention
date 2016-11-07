import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	private Words words;
	private ArrayList<ArrayList<String>> wordsDB;

	public Test() throws FileNotFoundException, IOException
	{
		words = new Words();
		wordsDB = words.getList();
		System.out.println(wordsDB);
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		Test test = new Test();
		System.out.println(test.wordsDB);
	}

}
