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
 * Write a description of class GameOver here.
 *
 * @author (Yohan Lefol)
 * @version (11/12/2018)
 */
public class GameOver extends JPanel
{
    
    private JPanel myPanel;
    private JLabel dialog;
    private JFrame myFrame;

    /**
     * Constructor for objects of class GameOver
     */
    public GameOver()
    {
        myFrame = new JFrame();
        dialog = new JLabel("GAME OVER");
        dialog.setFont(new Font("Arial", Font.PLAIN, 300));

        myPanel = new JPanel();
        myPanel.add(dialog);
        

        myPanel.setSize(1000,1000);
        myPanel.setVisible(true);
        // myFrame.add(myPanel);
        // myFrame.setSize(1000,1000);
        // myFrame.setVisible(true);
        // myFrame.pack();
        add(myPanel);
    }
}
