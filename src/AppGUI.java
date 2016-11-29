import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppGUI {
   private JFrame mainFrame;
   private JLabel headerLabel;
//   private JLabel statusLabel;
//   private JLabel remainingLetters;
//   private JLabel guessedLetters;
   private JTextArea wordInfo;
//   private JButton submitButton;
//   private JButton exitButton;
//   
//   private String alphabet = "abcdefghijklmnopqrstuvwxyz";
//   private String usedLetters = "";

   public AppGUI(){
      prepareGUI();
   }

   public static void main(String[] args){
      AppGUI  appGui = new AppGUI();  
      appGui.prepareGUI();
   }

   private void prepareGUI(){
	  
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
//      gbConstraints.gridx = 0;
      gbConstraints.gridy = 0;
      gbLayout.setConstraints(headerLabel, gbConstraints);
      mainFrame.add(headerLabel);
      
      
      
      wordInfo = new JTextArea("The word meaning, score, origin and usage will be displayed here");
      wordInfo.setEditable(false);
      wordInfo.setFont(new Font(wordInfo.getFont().getName(), wordInfo.getFont().getStyle(), 32));
      wordInfo.setPreferredSize(new Dimension(1000, 300));
//      gbConstraints.gridx = 0;
      gbConstraints.gridy = 1;
      gbLayout.setConstraints(wordInfo, gbConstraints);
      mainFrame.add(wordInfo);
      
//      statusLabel = new JLabel("Your current score is: <score>",JLabel.CENTER);
//      
//      remainingLetters = new JLabel("", JLabel.CENTER);
//      remainingLetters.setText("Letters remaining: " + alphabet);
//      
//      guessedLetters = new JLabel("", JLabel.CENTER);
//      guessedLetters.setText("Letters already guessed: " + usedLetters);
//      
//      submitButton = new JButton("Submit");
//      submitButton.setMaximumSize(new Dimension(5, 5));
//      submitButton.setPreferredSize(new Dimension(10, 10));
//      
//      exitButton = new JButton("Exit");
//      exitButton.setPreferredSize(new Dimension(30, 30));
//
//      statusLabel.setSize(350,100);
//
//      mainFrame.add(statusLabel);
//
//      mainFrame.add(submitButton);
//      mainFrame.add(remainingLetters);
//      mainFrame.add(guessedLetters);
//      mainFrame.add(exitButton);
      mainFrame.setVisible(true);  
   }
}