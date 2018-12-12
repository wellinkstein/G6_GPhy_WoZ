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
 * NextSpot displays the monster present in the spot defined by the chosen direction
 *
 * @author (Yohan Lefol)
 * @version (2018-12-04)
 */
public class NextSpot extends JPanel 
{
    private Game myGame;
    private Spot mySpot;
    private JButton myFightButton,myFleeButton;
    private JPanel myPanel,myFightPanel,myFleePanel,bigPanel,bigButtonPanel;
    private JFrame myFrame,myFrame2;
    private JLabel myLabel,myLabel2,myLabel3;
    private String direction; 
    private AffichMainYohan myMain; //The affich Main for the game
    /**
     * Constructor for objects of class NextSpot.
     */
    public NextSpot(Spot gameSpot, AffichMainYohan myMain1, String newDirection)
    // public NextSpot()
    {
        mySpot= gameSpot; 
        myMain= myMain1; 
        direction=newDirection; 
        showNextSpot(mySpot, myMain); 
    }

    /**
     * 
     */
    public JButton getMyFleeButton(){
        return myFleeButton; 
    }

    /**
     * 
     */
    public void showNextSpot(Spot gameSpot, AffichMainYohan myMain){
        removeAll();

        myPanel = new JPanel();
        myFightPanel = new JPanel();
        myFleePanel = new JPanel();
        bigPanel = new JPanel();
        bigButtonPanel = new JPanel();

        bigPanel.removeAll();
        myPanel.removeAll();
        myFightPanel.removeAll();
        myFleePanel.removeAll();
        bigButtonPanel.removeAll(); 

        myFightButton = new JButton ("Fight");
        myFightButton.setFont(new Font("Arial", Font.PLAIN, 40));
        myFleeButton = new JButton ("Flee");
        myFleeButton.setFont(new Font("Arial", Font.PLAIN, 40));

        myFightPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        myFightPanel.add (myFightButton, c);

        myFleePanel.setLayout(new GridBagLayout());

        c.gridx = 1;
        c.gridy = 0;

        myFleePanel.add (myFleeButton, c);

        bigPanel.setLayout(new GridLayout(0,1));
        bigButtonPanel.setLayout (new GridLayout(1,2));
        bigButtonPanel.add(myFightPanel);
        bigButtonPanel.add(myFleePanel);

        
        myPanel.setLayout(new GridLayout(1,2));

        EcouteurNextSpotFight e = new EcouteurNextSpotFight(this, myMain);
        myFightButton.addActionListener(e);
        myFleeButton.addActionListener(e);

        if (gameSpot.getMonster() != null) //Medusa
        {
            if(gameSpot.getMonster().getName() == "Medusa")
            {
                Icon icon = new ImageIcon("MedusaHead.png");
                JLabel label = new JLabel(icon);
                myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                myPanel.add(label);
                myPanel.add(myLabel);
                bigPanel.add(myLabel2);
                bigPanel.add(myPanel);
                bigPanel.add(myLabel2);
                bigPanel.add(bigButtonPanel);


            }

            else if(gameSpot.getMonster().getName() == "Chimera") // Chimera
            {
                Icon icon = new ImageIcon("ChimeraHead.png");
                JLabel label = new JLabel(icon);
                myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                myPanel.add(label);
                myPanel.add(myLabel);
                bigPanel.add(myLabel2);
                bigPanel.add(myPanel);
                bigPanel.add(myLabel2);
                bigPanel.add(bigButtonPanel);

            }   
            else if(gameSpot.getMonster().getName() == "Cerberus") // Cerberus
            {
                Icon icon = new ImageIcon("CerberusHead.png");
                JLabel label = new JLabel(icon);
                myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                myPanel.add(label);
                myPanel.add(myLabel);
                bigPanel.add(myLabel2);
                bigPanel.add(myPanel);
                bigPanel.add(myLabel2);
                bigPanel.add(bigButtonPanel);

            }   
            else if(gameSpot.getMonster().getName() == "Arachne") // Arachne
            {
                Icon icon = new ImageIcon("ArachneHead.png");
                JLabel label = new JLabel(icon);
                myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                myPanel.add(label);
                myPanel.add(myLabel);
                bigPanel.add(myLabel2);
                bigPanel.add(myPanel);
                bigPanel.add(myLabel2);
                bigPanel.add(bigButtonPanel);

            }   
            else if(gameSpot.getMonster().getName() == "Cyclops") // Cyclops
            {
                Icon icon = new ImageIcon("CyclopsHead.png");
                JLabel label = new JLabel(icon);
                myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                myPanel.add(label);
                myPanel.add(myLabel);
                bigPanel.add(myLabel2);
                bigPanel.add(myPanel);
                bigPanel.add(myLabel2);
                bigPanel.add(bigButtonPanel);

            }   
            else if(gameSpot.getMonster().getName() == "Minotaur") // Minotaur
            {
                Icon icon = new ImageIcon("MinotaurHead.png");
                JLabel label = new JLabel(icon);
                myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                myPanel.add(label);
                myPanel.add(myLabel);
                bigPanel.add(myPanel);
                bigPanel.add(myLabel2);
                bigPanel.add(bigButtonPanel);


            }

        }
        else {

            JLabel label = new JLabel("No monster");
           
            myPanel.add(label);
            bigPanel.add(myPanel);


        }
        bigPanel.setVisible(true);
        add(bigPanel);
        revalidate();
        repaint();
    }

    public Spot getSpotNextSpot(){
        return mySpot; 
    }

    public JButton getMyFightButton(){
        return myFightButton; 
    }
    
    public String getDirection()
    {
        return direction; 
    }
}
