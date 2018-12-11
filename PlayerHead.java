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
 * Write a description of class PlayerHead here.
 *
 * @author (Yohan Lefol)
 * @version (11/12/2018)
 */
public class PlayerHead extends JPanel
{
    private Game myGame;
    private JPanel myMainPanel, myStatsPanel;
    private JLabel myHealth, myXP, myAttack, myProtection;
    private JFrame myFrame;
    
    /**
     * Constructor for objects of class PlayerHead
     */
    public PlayerHead(Player player)
    {
        JPanel myMainPanel, myStatsPanel;
        
        
        myHealth = new JLabel("HP: "+String.valueOf(player.getHP()),JLabel.CENTER);
        myXP = new JLabel("XP: "+String.valueOf(player.getXp()),JLabel.CENTER);
        myAttack = new JLabel("Attack: "+String.valueOf(player.getDamage()),JLabel.CENTER);
        myProtection = new JLabel("Protection: "+String.valueOf(player.getProtection()),JLabel.CENTER);
        Icon icon = new ImageIcon("Theseus head.png");
        JLabel label = new JLabel(icon);
        
        myMainPanel=new JPanel();
        myMainPanel.setLayout(new GridLayout(1,1));
        
        myStatsPanel= new JPanel();
        myStatsPanel.setLayout(new GridLayout(4,1));
        
        myMainPanel.add(label);
        
        myStatsPanel.add(myHealth);
        myStatsPanel.add(myXP);
        myStatsPanel.add(myAttack);
        myStatsPanel.add(myProtection);
        
        myMainPanel.add(myStatsPanel);
        
        myMainPanel.setSize(50,150);
        myMainPanel.setVisible(true);
        add(myMainPanel);
        
        // myFrame = new JFrame();
        // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // myFrame.add(myMainPanel);
        // myFrame.setSize(50,150);
        // myFrame.pack();
        // myFrame.setVisible(true);
    }
}
