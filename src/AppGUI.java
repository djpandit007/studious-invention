import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppGUI {
   private JFrame mainFrame;
   private JLabel headerLabel;	// Welcome text
   private JLabel statusLabel;	// Score text
   private JLabel remainingLetters;	// Shows remaining letters of alphabet
   private JLabel guessedLetters;	// Shows letters guessed so far
   private JLabel currentWord;	// Placeholder for blanks of current word
//   private JLabel currentGuess;	// Next character to be guessed
   private JTextArea wordInfo;	// Contains info about the word
//   private JButton submitButton;	// Submits the current guessed character
   private JButton exitButton;	// Exits the game
   private JTextField nextCharacter;	// Contains the next guessed character

   private String alphabet = "abcdefghijklmnopqrstuvwxyz";
   private String usedLetters = "";
   
   private Font statusFont;

//   public AppGUI(){
//      prepareGUI();
//   }

   public void prepareGUI(){
	  
	  GridBagLayout gbLayout = new GridBagLayout();
	  GridBagConstraints gbConstraints = new GridBagConstraints();
	   
      mainFrame = new JFrame("Vocabulary Builder");
      mainFrame.setSize(1280, 1024);
      mainFrame.setLayout(gbLayout);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);
      headerLabel.setText("Welcome to Vocabulary Builder");   
      headerLabel.setFont(new Font(headerLabel.getFont().getName(), headerLabel.getFont().getStyle(), 48));
      gbConstraints.gridy = 0;
      gbConstraints.insets = new Insets(0, 0, 25, 0);
      gbLayout.setConstraints(headerLabel, gbConstraints);
      mainFrame.add(headerLabel);
      
      statusLabel = new JLabel("Your current score is: <score>",JLabel.CENTER);
      statusFont = new Font(statusLabel.getFont().getName(), statusLabel.getFont().getStyle() & ~Font.BOLD, 24);
      statusLabel.setFont(statusFont);
      gbConstraints.gridy = 1;
      gbLayout.setConstraints(statusLabel, gbConstraints);
      mainFrame.add(statusLabel);
      
      wordInfo = new JTextArea("The word meaning, score, origin and usage will be displayed here");
      wordInfo.setEditable(false);
      wordInfo.setFont(new Font(wordInfo.getFont().getName(), wordInfo.getFont().getStyle(), 32));
      wordInfo.setPreferredSize(new Dimension(1000, 300));
      gbConstraints.gridy = 2;
      gbLayout.setConstraints(wordInfo, gbConstraints);
      mainFrame.add(wordInfo);
      
      currentWord = new JLabel("Word so far: _ _ _ _ _ _ _ _ a");
      currentWord.setFont(statusFont);
      gbConstraints.gridy = 3;
      gbLayout.setConstraints(currentWord, gbConstraints);
      mainFrame.add(currentWord);
      
//      currentGuess = new JLabel("Your guess: ");
//      currentGuess.setFont(statusFont);
//      gbConstraints.gridy = 4;
//      gbConstraints.anchor = GridBagConstraints.WEST;
//      gbLayout.setConstraints(currentGuess, gbConstraints);
//      mainFrame.add(currentGuess);
      
      nextCharacter = new JTextField("Guess", 4);
      nextCharacter.setFont(statusFont);
      nextCharacter.setPreferredSize(new Dimension(100, 50));
      gbConstraints.gridy = 4;
      gbLayout.setConstraints(nextCharacter, gbConstraints);
      mainFrame.add(nextCharacter);
      
//      submitButton = new JButton("Submit");
//      submitButton.setFont(statusFont);
////      gbConstraints.gridx = 2;
//      gbConstraints.gridy = 4;
//      gbLayout.setConstraints(submitButton, gbConstraints);
//      mainFrame.add(submitButton);
      
      remainingLetters = new JLabel("", JLabel.CENTER);
      remainingLetters.setText("Letters remaining: " + alphabet);
      remainingLetters.setFont(statusFont);
      gbConstraints.gridx = 0;
      gbConstraints.gridy = 5;
      gbConstraints.anchor = GridBagConstraints.CENTER;
      gbLayout.setConstraints(remainingLetters, gbConstraints);
      mainFrame.add(remainingLetters);
      
      guessedLetters = new JLabel("", JLabel.CENTER);
      guessedLetters.setText("Letters already guessed: " + usedLetters);
      guessedLetters.setFont(statusFont);
      gbConstraints.gridy = 6;
      gbLayout.setConstraints(guessedLetters, gbConstraints);
      mainFrame.add(guessedLetters);
      
      exitButton = new JButton("Exit");
      exitButton.setFont(statusFont);
      exitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mainFrame.setVisible(false);
			mainFrame.dispose();
		}
	});
      gbConstraints.gridy = 7;
      gbLayout.setConstraints(exitButton, gbConstraints);
      mainFrame.add(exitButton);
      
//      nextButton.addActionListener(new ActionListener() {
//          public void actionPerformed(ActionEvent ae){
//              j++;
//              doNext(j, nextButton);
//          }
//         });
      
      mainFrame.setVisible(true);  
   }
}