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
    private Spot mySpot; //The next spot
    private JButton myFightButton,myFleeButton; //The button for the panel
    private JPanel myPanel,myFightPanel,myFleePanel,bigPanel,bigButtonPanel; //all the panel
    private JLabel myLabel,myLabel2; //all the label
    private String direction; //The direction of the next spot
    private AffichMainYohan myMain; //The affich Main for the game
    /**
     * Constructor for objects of class NextSpot.
     * The NextSpot is the future spot where the player will go if he decides to click on fight
     * When the player click on the button flee, the player does not fight the monster. He stays in the same spot
     * This interface only appears to warn a player of an upcomong monster, otherwise it will be empty.
     * @param Spot the next spot of the player 
     * @param AffichMainYohan The interface of the game
     * @param String the direction of the player wants to go
     */
    public NextSpot(Spot gameSpot, AffichMainYohan myMain1, String newDirection)
    {
        mySpot= gameSpot; 
        myMain= myMain1; 
        direction=newDirection; 
        showNextSpot(mySpot, myMain,direction); //update the panel NextSpot
    }

    /**
     * The getter for the button myFlee
     * @return myFleeButton
     */
    public JButton getMyFleeButton(){
        return myFleeButton; 
    }

    /**
     * The method showNextSpot allows us to create the panel NextSpot and to update this panel
     * @param Spot the next spot of the player 
     * @param AffichMainYohan The interface of the game
     * @param String the direction of the player wants to go
     */
    public void showNextSpot(Spot gameSpot, AffichMainYohan myMain, String newDirection){
        
        removeAll(); //remove the panel
        direction=newDirection;
        //create the panel and the button
        myPanel = new JPanel();
        myFightPanel = new JPanel();
        myFleePanel = new JPanel();
        bigPanel = new JPanel();
        bigButtonPanel = new JPanel();

        //remove all the little panel
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
        //Display the icon of the monster in the next spot
        //System.out.println(gameSpot.getMonster());
        //System.out.println(gameSpot);
        if (gameSpot.getMonster() != null && direction!=null) 
        {
            if(gameSpot.getMonster().getName() == "Medusa")
            {
                Icon icon = new ImageIcon("MedusaHead.png");
                JLabel label = new JLabel(icon);
                myPanel.add(label);
            }

            else if(gameSpot.getMonster().getName() == "Chimera") // Chimera
            {
                Icon icon = new ImageIcon("ChimeraHead.png");
                JLabel label = new JLabel(icon);
                myPanel.add(label);
            }   
            else if(gameSpot.getMonster().getName() == "Cerberus") // Cerberus
            {
                Icon icon = new ImageIcon("CerberusHead.png");
                JLabel label = new JLabel(icon);
                myPanel.add(label);

            }   
            else if(gameSpot.getMonster().getName() == "Arachne") // Arachne
            {
                Icon icon = new ImageIcon("ArachneHead.png");
                JLabel label = new JLabel(icon);
                myPanel.add(label);
            }   
            else if(gameSpot.getMonster().getName() == "Cyclops") // Cyclops
            {
                Icon icon = new ImageIcon("CyclopsHead.png");
                JLabel label = new JLabel(icon);
                myPanel.add(label);

            }   
            else if(gameSpot.getMonster().getName() == "Minotaur") // Minotaur
            {
                Icon icon = new ImageIcon("MinotaurHead.png");
                JLabel label = new JLabel(icon);
                myPanel.add(label);
            }
            myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
            myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
            myPanel.add(myLabel);
            bigPanel.add(myPanel);
            bigPanel.add(myLabel2);
            bigPanel.add(bigButtonPanel);

        }
        else {
            // If there are no monster in the next spot
            JLabel label = new JLabel("No monster");
            myPanel.add(label);
            bigPanel.add(myPanel);
        }
        bigPanel.setVisible(true);
        add(bigPanel);
        revalidate(); //update the NextSot
        repaint();
    }

    /**
     * The getter for the next spot 
     * @return mySpot the next spot
     */
    public Spot getSpotNextSpot(){
        return mySpot; 
    }

    /**
     * The getter for the button myFightbutton
     * @return myFightButton
     */
    public JButton getMyFightButton(){
        return myFightButton; 
    }

    /**
     * The getter for the direction that the player will take
     * @return String direction the next direction that the player will take
     */
    public String getDirection()
    {
        return direction; 
    }
}
