import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestRunApplication {
	RunApplication runApp = new RunApplication();
	Boolean guessed;
	String guessWord;
	
	// Test isWordGuessed
	@Test
	public void testIsWordGuessed()
	{
		guessed = runApp.isWordGuessed("adventitious", "abcdefghijklmnopqrstuvwxyz");
		assertEquals(true, guessed);
		
		guessed = runApp.isWordGuessed("adventitious", "adcveni");
		assertEquals(false, guessed);
		
		guessed = runApp.isWordGuessed("adventitious", "adventious");
		assertEquals(true, guessed);
		
		guessed = runApp.isWordGuessed("adventitious", "");
		assertEquals(false, guessed);
		
		guessed = runApp.isWordGuessed("insipid", "abcdefghijklmnopqrstuvwxyz");
		assertEquals(true, guessed);
		
		guessed = runApp.isWordGuessed("insipid", "insp");
		assertEquals(false, guessed);
		
		guessed = runApp.isWordGuessed("insipid", "inspd");
		assertEquals(true, guessed);
		
		guessed = runApp.isWordGuessed("zygote", "abcde");
		assertEquals(false, guessed);
		
		guessed = runApp.isWordGuessed("geopolymerization", "geoplymrizatn");
		assertEquals(true, guessed);
	}
	
	// Test getGuessedWord
	@Test
	public void testGetGuessedWord()
	{
		guessWord = runApp.getGuessedWord("mellifluous", "abcdefghijklmnopqrstuvwxyz");
		assertEquals("mellifluous", guessWord);
		
		guessWord = runApp.getGuessedWord("mellifluous", "adcveni");
		assertEquals("_ e_ _ i_ _ _ _ _ _ ", guessWord);
		
		guessWord = runApp.getGuessedWord("mellifluous", "melifuos");
		assertEquals("mellifluous", guessWord);
		
		guessWord = runApp.getGuessedWord("mellifluous", "");
		assertEquals("_ _ _ _ _ _ _ _ _ _ _ ", guessWord);
		
		guessWord = runApp.getGuessedWord("adventitious", "abcdefghijklmnopqrstuvwxyz");
		assertEquals("adventitious", guessWord);
		
		guessWord = runApp.getGuessedWord("insipid", "abcdefghijklmnopqrstuvwxyz");
		assertEquals("insipid", guessWord);
		
		guessWord = runApp.getGuessedWord("insipid", "insp");
		assertEquals("insipi_ ", guessWord);
		
		guessWord = runApp.getGuessedWord("zygote", "inspd");
		assertEquals("_ _ _ _ _ _ ", guessWord);
		
		guessWord = runApp.getGuessedWord("zygote", "abcde");
		assertEquals("_ _ _ _ _ e", guessWord);
		
		guessWord = runApp.getGuessedWord("geopolymerization", "geoplymrizatn");
		assertEquals("geopolymerization", guessWord);
		
		guessWord = runApp.getGuessedWord("geopolymerization", "");
		assertEquals("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ", guessWord);
	}
}
