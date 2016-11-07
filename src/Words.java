import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public ArrayList<ArrayList<String>> getList()
	{
		return wordsList;
	}
}
