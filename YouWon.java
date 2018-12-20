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
 * Write a description of class YouWon here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == exitButton)
        {
            System.exit(0);
        }
    }
}
