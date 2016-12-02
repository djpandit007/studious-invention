import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RunApplication {
	
	public Boolean isWordGuessed(String secretWord, String lettersGuessed)
	{
		Set<Character> secret = new HashSet<Character>();
		Set<Character> letters = new HashSet<Character>();
		List<Character> c = new ArrayList<Character>();
		
		for (int i = 0; i < secretWord.length(); i++)
		{
			secret.add(secretWord.charAt(i));
		}
		
		for (int i = 0; i < lettersGuessed.length(); i++)
		{
			if (secretWord.contains(String.valueOf(lettersGuessed.charAt(i))))
			{
				letters.add(lettersGuessed.charAt(i));
			}
		}
		
		c.addAll(secret);
		c.removeAll(letters);
		
		if (c.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String getGuessedWord(String secretWord, String lettersGuessed)
	{
		List<Character> secret = new ArrayList<Character>();
		List<String> temp = new ArrayList<String>();
		String ans = "";
		char chChar;
		
		for (int i = 0; i < secretWord.length(); i++)
		{
			temp.add("_ ");
		}
		
		for (int i = 0; i < secretWord.length(); i++)
		{
			secret.add(secretWord.charAt(i));
		}
		
		for (int i = 0; i < lettersGuessed.length(); i++)
		{
			chChar = lettersGuessed.charAt(i);
			while (secret.contains(chChar))
			{
				for (int j = 0; j < secret.size(); j++)
				{
					if (chChar == secret.get(j))
					{
						temp.set(j, String.valueOf(chChar));
						secret.set(j, '*');
					}
				}
			}
		}
				
		for (int i = 0; i < temp.size(); i++)
		{
			ans += temp.get(i);
		}
		
		return ans;
	}
	
	public void writeResultsToFile(ArrayList<ArrayList<String>> wordCorrectMap)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		System.out.println(timeStamp);
		
		try
		{
			PrintWriter writer = new PrintWriter(timeStamp + ".txt", "UTF-8");
			System.out.println("Size: " + wordCorrectMap.size());
			for (int i = 0; i < wordCorrectMap.size(); i++)
			{
				writer.println(wordCorrectMap.get(i).get(0) + " " + wordCorrectMap.get(i).get(1));
			}
			writer.close();
		}
		catch (IOException e)
		{
			System.out.println("There was an IO Exception");
		}
	}
	
	public void StartNewGame()
	{
		Words words;
		ArrayList<String> oneWord = new ArrayList<String>();
		AppGUI gui;
		
		try {
			words = new Words();
			oneWord = words.getOne();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gui = new AppGUI();
		gui.prepareGUI(oneWord);
		
		System.out.println(oneWord);
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		new RunApplication().StartNewGame();
	}

}
