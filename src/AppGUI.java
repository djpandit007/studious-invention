import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppGUI {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
//   private JPanel controlPanel;
   private JButton submitButton;
   private JButton exitButton;

   public AppGUI(){
      prepareGUI();
   }

   public static void main(String[] args){
      AppGUI  appGui = new AppGUI();  
      appGui.prepareGUI();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Vocabulary Builder");
      mainFrame.setSize(1280, 1024);
      mainFrame.setLayout(new GridLayout(5, 1));
      mainFrame.setLocationRelativeTo(null);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);
      headerLabel.setText("Welcome to Vocabulary Builder");   
      headerLabel.setFont(new Font(headerLabel.getFont().getName(), headerLabel.getFont().getStyle(), 48));
      
      statusLabel = new JLabel("",JLabel.CENTER);
      
      submitButton = new JButton("Submit");
      exitButton = new JButton("Exit");

      statusLabel.setSize(350,100);

//      controlPanel = new JPanel();
//      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
//      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.add(submitButton);
      mainFrame.add(exitButton);
      mainFrame.setVisible(true);  
   }
}