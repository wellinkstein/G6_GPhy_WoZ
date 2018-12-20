import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.geom.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
/**
 * This is a class for the message that appears when a player wins the game
 *
 * @author (Hatim)
 * @version (20/12/2018)
 */
public class YouWon extends JFrame implements ActionListener
{
    private JFrame myFrame;
    private JPanel myPanel;
    private JLabel dialog;
    private JButton exitButton;

    /**
     * Constructor for objects of class YouWon
     */
    public YouWon(String message)
    {
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setUndecorated(true);
        dialog = new JLabel(message, SwingConstants.CENTER);
        dialog.setOpaque(true);
        dialog.setBackground(new Color(196,218,255));
        dialog.setFont(new Font("Arial", Font.PLAIN, 100));
        exitButton = new JButton("Close to be free!");
        exitButton.setBackground(Color.white); 
        exitButton.setForeground(new Color(196,218,255));
        
        exitButton.setFont(new Font("Arial", Font.PLAIN, 100));
        exitButton.addActionListener(this);
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(2,1));
        myPanel.add(dialog);
        myPanel.add(exitButton);
       
        myPanel.setVisible(true);
        myFrame.add(myPanel);
        
        myFrame.setVisible(true);
        
        
    }
    
    /**
     * This is the method coding for the button of this class, it is a button that closes.
     */
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == exitButton)
        {
            System.exit(0);
        }
    }
}
