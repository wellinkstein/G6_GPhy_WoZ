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
 * This class handles the apparition of a monsters icon (only its head) when a fight is initiated
 * along with the picture of the head, the monsters stats will appear and be updated during
 * the fight.
 *
 * @author (Group6)
 * @version (14/12/2018)
 */
public class MonsterHead extends JPanel
{
    private JPanel myMainPanel, myStatsPanel;
    private JLabel myHealth, myXP, myAttack, myProtection;
    private JFrame myFrame;

    /**
     * Constructor for objects of class MonsterHead
     * @param Monster monster
     */
    public MonsterHead(Monster monster)
    {
        showMonsterHead(monster); 
    }

    /**
     * The method showMonsterHead, to create the panel monster in the game
     * @param Monster monster
     */
    public void showMonsterHead(Monster monster)
    {
        removeAll();//removes everything from the panels
        JPanel myMainPanel, myStatsPanel; //creation of the two main panels
        
        myMainPanel=new JPanel();
        myMainPanel.setLayout(new GridLayout(1,1));
        myMainPanel.setBackground(new Color(208,185,178));
        myStatsPanel= new JPanel();
        myStatsPanel.setLayout(new GridLayout(4,1));
        myStatsPanel.setBackground(new Color(208,185,178));
        if (monster==null){ //checks if there is a monster in the "spot"
            myHealth = new JLabel("HP: null",JLabel.CENTER);
            myXP = new JLabel("XP: null",JLabel.CENTER);
            myAttack = new JLabel("Attack: null",JLabel.CENTER);
            myProtection = new JLabel("Protection: null",JLabel.CENTER);
            Icon icon = new ImageIcon("imagenulle.png");
            JLabel label = new JLabel(icon);
            label.setPreferredSize(new Dimension(150,50));
            myMainPanel.add(label);
        
            myStatsPanel.add(myHealth);
            myStatsPanel.add(myXP);
            myStatsPanel.add(myAttack);
            myStatsPanel.add(myProtection);
            
            myMainPanel.add(myStatsPanel);
        }
        else{
            if (monster.getName()=="Medusa")//checks if medusa is in the spot
            {
                myHealth = new JLabel("HP: "+String.valueOf(monster.getHP()),JLabel.CENTER);
                myXP = new JLabel("XP: "+String.valueOf(monster.getXp()),JLabel.CENTER);
                myAttack = new JLabel("Attack: "+String.valueOf(monster.getDamage()),JLabel.CENTER);
                myProtection = new JLabel("Protection: "+String.valueOf(monster.getProtection()),JLabel.CENTER);
                Icon icon = new ImageIcon("MedusaHead.png");
                JLabel label = new JLabel(icon);
                label.setPreferredSize(new Dimension(150,50));
                myMainPanel.add(label);
        
                myStatsPanel.add(myHealth);
                myStatsPanel.add(myXP);
                myStatsPanel.add(myAttack);
                myStatsPanel.add(myProtection);
            
                myMainPanel.add(myStatsPanel);
            
            }
            else if (monster.getName()=="Chimera")//checks if chimera is in the spot
            {
                myHealth = new JLabel("HP: "+String.valueOf(monster.getHP()),JLabel.CENTER);
                myXP = new JLabel("XP: "+String.valueOf(monster.getXp()),JLabel.CENTER);
                myAttack = new JLabel("Attack: "+String.valueOf(monster.getDamage()),JLabel.CENTER);
                myProtection = new JLabel("Protection: "+String.valueOf(monster.getProtection()),JLabel.CENTER);
                Icon icon = new ImageIcon("ChimeraHead.png");
                JLabel label = new JLabel(icon);
                label.setPreferredSize(new Dimension(150,50));
                myMainPanel.add(label);
                
                myStatsPanel.add(myHealth);
                myStatsPanel.add(myXP);
                myStatsPanel.add(myAttack);
                myStatsPanel.add(myProtection);
                
                myMainPanel.add(myStatsPanel);
            }
            else if (monster.getName()=="Cerberus")//checks if cerberus in the spot
            {
                myHealth = new JLabel("HP: "+String.valueOf(monster.getHP()),JLabel.CENTER);
                myXP = new JLabel("XP: "+String.valueOf(monster.getXp()),JLabel.CENTER);
                myAttack = new JLabel("Attack: "+String.valueOf(monster.getDamage()),JLabel.CENTER);
                myProtection = new JLabel("Protection: "+String.valueOf(monster.getProtection()),JLabel.CENTER);
                Icon icon = new ImageIcon("CerberusHead.png");
                JLabel label = new JLabel(icon);
                label.setPreferredSize(new Dimension(150,50));
                myMainPanel.add(label);
                
                myStatsPanel.add(myHealth);
                myStatsPanel.add(myXP);
                myStatsPanel.add(myAttack);
                myStatsPanel.add(myProtection);
                
                myMainPanel.add(myStatsPanel);
            }   
            else if (monster.getName()=="Arachne")//checks if arachne is in the spot
            {
                myHealth = new JLabel("HP: "+String.valueOf(monster.getHP()),JLabel.CENTER);
                myXP = new JLabel("XP: "+String.valueOf(monster.getXp()),JLabel.CENTER);
                myAttack = new JLabel("Attack: "+String.valueOf(monster.getDamage()),JLabel.CENTER);
                myProtection = new JLabel("Protection: "+String.valueOf(monster.getProtection()),JLabel.CENTER);
                Icon icon = new ImageIcon("ArachneHead.png");
                JLabel label = new JLabel(icon);
                label.setPreferredSize(new Dimension(150,50));
                myMainPanel.add(label);
        
                myStatsPanel.add(myHealth);
                myStatsPanel.add(myXP);
                myStatsPanel.add(myAttack);
                myStatsPanel.add(myProtection);
                
                myMainPanel.add(myStatsPanel);
            }   
            else if (monster.getName()=="Cyclops")//checks if cyclops is in the spot
            {
                myHealth = new JLabel("HP: "+String.valueOf(monster.getHP()),JLabel.CENTER);
                myXP = new JLabel("XP: "+String.valueOf(monster.getXp()),JLabel.CENTER);
                myAttack = new JLabel("Attack: "+String.valueOf(monster.getDamage()),JLabel.CENTER);
                myProtection = new JLabel("Protection: "+String.valueOf(monster.getProtection()),JLabel.CENTER);
                Icon icon = new ImageIcon("CyclopsHead.png");
                JLabel label = new JLabel(icon);
                label.setPreferredSize(new Dimension(150,50));
        
                myMainPanel.add(label);
        
                myStatsPanel.add(myHealth);
                myStatsPanel.add(myXP);
                myStatsPanel.add(myAttack);
                myStatsPanel.add(myProtection);
            
                myMainPanel.add(myStatsPanel);
            }
            else if (monster.getName()=="Minotaur")//checks if minotaur is in the spot
            {
                myHealth = new JLabel("HP: "+String.valueOf(monster.getHP()),JLabel.CENTER);
                myXP = new JLabel("XP: "+String.valueOf(monster.getXp()),JLabel.CENTER);
                myAttack = new JLabel("Attack: "+String.valueOf(monster.getDamage()),JLabel.CENTER);
                myProtection = new JLabel("Protection: "+String.valueOf(monster.getProtection()),JLabel.CENTER);
                Icon icon = new ImageIcon("MinotaurHead.png");
                JLabel label = new JLabel(icon);
                label.setPreferredSize(new Dimension(150,50));
                
                myMainPanel.add(label);
        
                myStatsPanel.add(myHealth);
                myStatsPanel.add(myXP);
                myStatsPanel.add(myAttack);
                myStatsPanel.add(myProtection);
            
                myMainPanel.add(myStatsPanel);
            }
        
        }
        
        
        myMainPanel.setVisible(true);
        add(myMainPanel);//adds this class/panel to the main interface (AffichMainYohan)
        revalidate();
        repaint();
    }
}
