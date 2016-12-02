import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AppGUI {
   private JFrame mainFrame;
   private JLabel headerLabel;	// Welcome text
   private JLabel statusLabel;	// Score text
   private JLabel remainingLetters;	// Shows remaining letters of alphabet
   private JLabel guessedLetters;	// Shows letters guessed so far
   private JLabel currentWord;	// Placeholder for blanks of current word
   private JLabel currentGuess;	// Next character to be guessed
   private JLabel result;	// Shows whether you guessed the word correctly or not
   private JLabel guessesLabel;	// Shows the number of guesses left
   private JTextArea wordInfo;	// Contains info about the word
   private JButton submitButton;	// Submits the current guessed character
   private JButton newWord;		// Presents the user with a new word
   private JButton exitButton;	// Exits the game
   private JTextField nextCharacter;	// Contains the next guessed character

   private String alphabet = "abcdefghijklmnopqrstuvwxyz";
   private String usedLetters = "";
   private String wordToGuess, meaning, usage, origin;
   private int guessesLeft = 8;
   private String nextChar;
   private int points, currentScore;
   
   private Font statusFont;
   private RunApplication app = new RunApplication();

   public void prepareGUI(ArrayList<String> word){
	   
	   wordToGuess = word.get(0);
	   meaning = word.get(1);
	   usage = word.get(2);
	   points = Integer.parseInt(word.get(3));
	   origin = word.get(5);
	   currentScore = GameScore.score;
	   
	   app.isWordGuessed(wordToGuess, usedLetters);
	  
	  GridBagLayout gbLayout = new GridBagLayout();
	  GridBagConstraints gbConstraints = new GridBagConstraints();
	   
      mainFrame = new JFrame("Vocabulary Builder");
      mainFrame.setSize(1280, 1024);
      mainFrame.setLayout(gbLayout);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
        	 app.writeResultsToFile(GameScore.wordAttempt);
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);
      headerLabel.setText("Welcome to the game, Hangman");   
      headerLabel.setFont(new Font(headerLabel.getFont().getName(), headerLabel.getFont().getStyle(), 48));
      gbConstraints.gridy = 0;
      gbConstraints.insets = new Insets(0, 0, 25, 0);
      gbLayout.setConstraints(headerLabel, gbConstraints);
      mainFrame.add(headerLabel);
      
      statusLabel = new JLabel("Your current score is: " + currentScore,JLabel.CENTER);
      statusFont = new Font(statusLabel.getFont().getName(), statusLabel.getFont().getStyle() & ~Font.BOLD, 24);
      statusLabel.setFont(statusFont);
      gbConstraints.gridy = 1;
      gbLayout.setConstraints(statusLabel, gbConstraints);
      mainFrame.add(statusLabel);
      
      guessesLabel = new JLabel("Guesses left: " + guessesLeft);
      guessesLabel.setFont(statusFont);
      gbConstraints.gridy = 1;
      gbLayout.setConstraints(guessesLabel, gbConstraints);
      mainFrame.add(guessesLabel);
      
      wordInfo = new JTextArea();
      wordInfo.setText("I am thinking of a word that is " + wordToGuess.length() + " letters long" + 
    		  "\nMeaning: " + meaning + 
    		  "\nPoints: " + points + 
    		  "\nUsage: " + usage + 
    		  "\nOrigin: " + origin);
      wordInfo.setEditable(false);
      wordInfo.setLineWrap(true);
      wordInfo.setFont(new Font(wordInfo.getFont().getName(), wordInfo.getFont().getStyle(), 32));
      wordInfo.setPreferredSize(new Dimension(800, 300));
      gbConstraints.gridy = 2;
      gbLayout.setConstraints(wordInfo, gbConstraints);
      mainFrame.add(wordInfo);
      
      currentWord = new JLabel("Word revealed so far: ");
      currentWord.setFont(statusFont);
      gbConstraints.gridy = 3;
      gbLayout.setConstraints(currentWord, gbConstraints);
      mainFrame.add(currentWord);
      
      currentGuess = new JLabel("Your guess: ");
      currentGuess.setFont(statusFont);
      gbConstraints.gridy = 4;
      gbConstraints.anchor = GridBagConstraints.WEST;
      gbLayout.setConstraints(currentGuess, gbConstraints);
      mainFrame.add(currentGuess);
      
      nextCharacter = new JTextField("", 2);
      nextCharacter.setFont(statusFont);
      nextCharacter.setPreferredSize(new Dimension(100, 50));
      nextCharacter.requestFocus();
      gbConstraints.gridy = 4;
      gbConstraints.anchor = GridBagConstraints.CENTER;
      gbLayout.setConstraints(nextCharacter, gbConstraints);
      mainFrame.add(nextCharacter);
      nextCharacter.getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			submitButton.requestFocus();
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			submitButton.requestFocus();
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			submitButton.requestFocus();
		}
	});
      
      submitButton = new JButton("Submit");
      submitButton.setFont(statusFont);
      gbConstraints.gridy = 4;
      gbConstraints.anchor = GridBagConstraints.EAST;
      gbLayout.setConstraints(submitButton, gbConstraints);
      mainFrame.add(submitButton);
      submitButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			nextChar = nextCharacter.getText().toLowerCase();
			if (nextChar != "" && nextChar.length() == 1 && nextChar.matches("[a-zA-Z]{1}"))
			{
				if (!usedLetters.contains(nextChar))
				{
					usedLetters += nextChar;
					alphabet = alphabet.replace(nextChar, "");
					if (wordToGuess.contains(nextChar))
					{
						result.setText("Good guess");
					}
					else
					{
						result.setText("Oops! That letter is not in my word");
						guessesLeft -= 1;
						guessesLabel.setText("Guesses left: " + guessesLeft);
					}
					guessedLetters.setText("Letters already guessed: " + usedLetters);
					remainingLetters.setText("Letters remaining: " + alphabet);
				}
				else
				{
					result.setText("You've already guessed that letter");
				}
			}
			
			nextCharacter.setText("");
			currentWord.setText("Word revealed so far: " + app.getGuessedWord(wordToGuess, usedLetters));
			if (app.isWordGuessed(wordToGuess, usedLetters))
			{
				result.setText("Congratulations, you won! Click on New Word to continue.");
				GameScore.wordAttempt.add(new ArrayList<String>(Arrays.asList(wordToGuess, "Correct")));
				GameScore.score += points;
				statusLabel.setText("Your current score is: " + currentScore);
			}
			else if (guessesLeft <= 0)
			{
				result.setText("Sorry, you ran out of guesses. The word was " + wordToGuess + ". Click New Word to continue.");
				GameScore.wordAttempt.add(new ArrayList<String>(Arrays.asList(wordToGuess, "Wrong")));
			}
			nextCharacter.requestFocus();
		}
	});
      
      result = new JLabel("", JLabel.CENTER);
      result.setFont(statusFont);
      gbConstraints.gridx = 0;
      gbConstraints.gridy = 5;
      gbConstraints.anchor = GridBagConstraints.CENTER;
      gbLayout.setConstraints(result, gbConstraints);
      mainFrame.add(result);
      
      remainingLetters = new JLabel("", JLabel.CENTER);
      remainingLetters.setText("Letters remaining: " + alphabet);
      remainingLetters.setFont(statusFont);
      gbConstraints.gridx = 0;
      gbConstraints.gridy = 6;
      gbConstraints.anchor = GridBagConstraints.CENTER;
      gbLayout.setConstraints(remainingLetters, gbConstraints);
      mainFrame.add(remainingLetters);
      
      guessedLetters = new JLabel("", JLabel.CENTER);
      guessedLetters.setText("Letters already guessed: " + usedLetters);
      guessedLetters.setFont(statusFont);
      gbConstraints.gridx = 0;
      gbConstraints.gridy = 7;
      gbLayout.setConstraints(guessedLetters, gbConstraints);
      mainFrame.add(guessedLetters);
      
      newWord = new JButton("New Word");
      newWord.setFont(statusFont);
      gbConstraints.gridx = 0;
      gbConstraints.gridy = 8;
      gbLayout.setConstraints(newWord, gbConstraints);
      mainFrame.add(newWord);
      newWord.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainFrame.dispose();
			app.StartNewGame();
		}
	});
      
      exitButton = new JButton("Exit");
      exitButton.setFont(statusFont);
      gbConstraints.gridx = 1;
      gbConstraints.gridy = 8;
      gbLayout.setConstraints(exitButton, gbConstraints);
      mainFrame.add(exitButton);
      exitButton.addActionListener(new ActionListener() {
    	  
    	@Override
  		public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
  			mainFrame.setVisible(false);
  			mainFrame.dispose();
  			app.writeResultsToFile(GameScore.wordAttempt);
  			System.exit(0);
  		}
  	});
      
      mainFrame.setVisible(true);
      mainFrame.getRootPane().setDefaultButton(submitButton);
   }
}