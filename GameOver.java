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
 * This is a simple class coding for a pop up of a gameover message if the player has died. It ends the game.
 *
 * @author (Yohan Lefol)
 * @version (11/12/2018)
 */
public class GameOver extends JFrame implements ActionListener
{
    private JFrame myFrame;
    private JPanel myPanel;
    private JLabel dialog;
    private JButton exitButton;

    /**
     * Constructor for objects of class GameOver
     */
    public GameOver()
    {
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setUndecorated(true);
        dialog = new JLabel("GAME OVER", SwingConstants.CENTER);
        dialog.setOpaque(true);
        dialog.setBackground(Color.red);
        dialog.setFont(new Font("Arial", Font.PLAIN, 200));
        exitButton = new JButton("CLOSE, LOSER!");
        exitButton.setBackground(Color.gray); 
        exitButton.setForeground(Color.red);
        
        exitButton.setFont(new Font("Arial", Font.PLAIN, 200));
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
     * The event listener for the close button of this class.
     * @param ActionEvent e
     */
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == exitButton)
        {
            System.exit(0);
        }
    }
}
