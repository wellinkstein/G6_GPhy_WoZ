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
 * 
 * This is the class that controls the visual aspect of the players icon and his stats
 * The icon will always be present and the statistics will be updated whenever they change
 * This includes combat, item pick-up and item drops.
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
     * @param Player player
     */
    public PlayerHead(Player player)
    {
        showPlayerHead(player); 
    }
    
    /**
     * The fonction showPlayerHead, create the panel of PlayerHead
     * @param Player player
     */
    public void showPlayerHead(Player player)
    {
        removeAll();
        JPanel myMainPanel, myStatsPanel;
        //Below is a set up of the different stats panel
        myHealth = new JLabel("HP: "+String.valueOf(player.getHP()),JLabel.CENTER);
        myXP = new JLabel("XP: "+String.valueOf(player.getXp()),JLabel.CENTER);
        myAttack = new JLabel("Attack: "+String.valueOf(player.getDamage()),JLabel.CENTER);
        myProtection = new JLabel("Protection: "+String.valueOf(player.getProtection()),JLabel.CENTER);
        Icon icon = new ImageIcon("TheseusHead.png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(150,50));
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
        //the various panels created, stat panel and icon are loaded into mainPanel
        
        myMainPanel.setVisible(true);
        add(myMainPanel);//adds main panel to the main interface (AffichMainYohan)
        revalidate();
        repaint();
    }
    
}
