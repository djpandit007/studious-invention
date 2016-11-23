import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// This class reads the data from file and makes it available to our program as an ArrayList
public class Words {
	
	ArrayList<ArrayList<String>> wordsList = new ArrayList<ArrayList<String>>();
	
	public Words() throws FileNotFoundException, IOException
	{
		String file = "words.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				ArrayList<String> wordLine = new ArrayList<String>(Arrays.asList(line.split("\t")));
				wordsList.add(wordLine);
			}
		}
	}
	
	// Returns the whole words DB
	public ArrayList<ArrayList<String>> getList()
	{
		return wordsList;
	}
	
	public ArrayList<String> getOne()
	{
		Random rand = new Random();
		int length = wordsList.size();
		int arrayIndex = rand.nextInt(length);
		return wordsList.get(arrayIndex);
	}
}
