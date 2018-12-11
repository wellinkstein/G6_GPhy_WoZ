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
 * Write a description of class MonsterHead here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MonsterHead extends JPanel
{
    private Game myGame;
    private JPanel myMainPanel, myStatsPanel;
    private JLabel myHealth, myXP, myAttack, myProtection;
    private JFrame myFrame;

    /**
     * Constructor for objects of class MonsterHead
     */
    public MonsterHead(Spot mySpot)
    {
        JPanel myMainPanel, myStatsPanel;
        JFrame myFrame;
        myGame = new Game();
        
        if (mySpot.getMonster().getName()=="Medusa")
        {
            myHealth = new JLabel("HP: "+String.valueOf(mySpot.getMonster().getHP()),JLabel.CENTER);
            myXP = new JLabel("XP: "+String.valueOf(mySpot.getMonster().getXp()),JLabel.CENTER);
            myAttack = new JLabel("Attack: "+String.valueOf(mySpot.getMonster().getDamage()),JLabel.CENTER);
            myProtection = new JLabel("Protection: "+String.valueOf(mySpot.getMonster().getProtection()),JLabel.CENTER);
            Icon icon = new ImageIcon("MedusaHead.png");
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
            
            myMainPanel.setSize(50,150);
            myMainPanel.setVisible(true);
            add(myMainPanel);
        }
        else if (mySpot.getMonster().getName()=="Chimera")
        {
            myHealth = new JLabel("HP: "+String.valueOf(mySpot.getMonster().getHP()),JLabel.CENTER);
            myXP = new JLabel("XP: "+String.valueOf(mySpot.getMonster().getXp()),JLabel.CENTER);
            myAttack = new JLabel("Attack: "+String.valueOf(mySpot.getMonster().getDamage()),JLabel.CENTER);
            myProtection = new JLabel("Protection: "+String.valueOf(mySpot.getMonster().getProtection()),JLabel.CENTER);
            Icon icon = new ImageIcon("ChimeraHead.png");
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
            
            myMainPanel.setSize(50,150);
            myMainPanel.setVisible(true);
            add(myMainPanel);
        }
        else if (mySpot.getMonster().getName()=="Cerberus")
        {
            myHealth = new JLabel("HP: "+String.valueOf(mySpot.getMonster().getHP()),JLabel.CENTER);
            myXP = new JLabel("XP: "+String.valueOf(mySpot.getMonster().getXp()),JLabel.CENTER);
            myAttack = new JLabel("Attack: "+String.valueOf(mySpot.getMonster().getDamage()),JLabel.CENTER);
            myProtection = new JLabel("Protection: "+String.valueOf(mySpot.getMonster().getProtection()),JLabel.CENTER);
            Icon icon = new ImageIcon("CerberusHead.png");
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
            
            myMainPanel.setSize(50,150);
            myMainPanel.setVisible(true);
            add(myMainPanel);
        }
        else if (mySpot.getMonster().getName()=="Arachne")
        {
            myHealth = new JLabel("HP: "+String.valueOf(mySpot.getMonster().getHP()),JLabel.CENTER);
            myXP = new JLabel("XP: "+String.valueOf(mySpot.getMonster().getXp()),JLabel.CENTER);
            myAttack = new JLabel("Attack: "+String.valueOf(mySpot.getMonster().getDamage()),JLabel.CENTER);
            myProtection = new JLabel("Protection: "+String.valueOf(mySpot.getMonster().getProtection()),JLabel.CENTER);
            Icon icon = new ImageIcon("ArachneHead.png");
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
            
            myMainPanel.setSize(50,150);
            myMainPanel.setVisible(true);
            add(myMainPanel);
        }
        else if (mySpot.getMonster().getName()=="Cyclops")
        {
            myHealth = new JLabel("HP: "+String.valueOf(mySpot.getMonster().getHP()),JLabel.CENTER);
            myXP = new JLabel("XP: "+String.valueOf(mySpot.getMonster().getXp()),JLabel.CENTER);
            myAttack = new JLabel("Attack: "+String.valueOf(mySpot.getMonster().getDamage()),JLabel.CENTER);
            myProtection = new JLabel("Protection: "+String.valueOf(mySpot.getMonster().getProtection()),JLabel.CENTER);
            Icon icon = new ImageIcon("CyclopsHead.png");
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
            
            myMainPanel.setSize(50,150);
            myMainPanel.setVisible(true);
            add(myMainPanel);
        }
        else if (mySpot.getMonster().getName()=="Minotaur")
        {
            myHealth = new JLabel("HP: "+String.valueOf(mySpot.getMonster().getHP()),JLabel.CENTER);
            myXP = new JLabel("XP: "+String.valueOf(mySpot.getMonster().getXp()),JLabel.CENTER);
            myAttack = new JLabel("Attack: "+String.valueOf(mySpot.getMonster().getDamage()),JLabel.CENTER);
            myProtection = new JLabel("Protection: "+String.valueOf(mySpot.getMonster().getProtection()),JLabel.CENTER);
            Icon icon = new ImageIcon("MinotaurHead.png");
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
            
            myMainPanel.setSize(50,150);
            myMainPanel.setVisible(true);
            add(myMainPanel);
        }
        
    }

}
