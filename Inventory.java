import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.*;
import java.util.Set;

/**
 * The class Inventory, is the interface for display the item of the player
 * We can added item in the inventory and drop item
 * 
 * @author Groupe 6  
 * @version 04/12/2018
 */
public class Inventory extends JPanel
{
    private Player monJoueur; //The player of the game
    private JLabel myLabel; //the label of the inventory
    private JPanel myPanel, myPanel1, myBigPanel;  //all the panel of the inventory
    private JComboBox combo; //The list of the Inventory
    private AffichMainYohan myMain; //the interface in the game
    private JButton myButton, myButton1; //The button for the drop

    /**
     * This is the constructor of the inventory interface
     * @param Player theseus allows to use the player of the game
     * @param AffichMainYohan The interface of the game
     */
    public Inventory(Player theseus, AffichMainYohan cont)
    {
        monJoueur= theseus;
        myMain = cont;
        showPlayerItem(monJoueur,myMain); //update of the panel Inventory
    }

    /**
     * The method showPlayerItem allows us to display the items of the player via a list. 
     * If the player does not have item, we cannot click on the button drop
     * @param Player theseus allows to use the player of the game
     * @param AffichMainYohan The interface of the game
     */
    public void showPlayerItem(Player theseus, AffichMainYohan myMain)
    {
        removeAll(); //Remove the panel Inventory

        JPanel myPanel;
        JLabel myLabel; 

        myPanel = new JPanel();
        myPanel1= new JPanel(); 
        myBigPanel=new JPanel();

        //remove all the panel
        myBigPanel.removeAll();
        myPanel.removeAll();
        myPanel1.removeAll();

        //create the button drop
        myButton = new JButton("Drop"); 
        myButton.setBackground(Color.gray); 
        myButton.setForeground(Color.white);
        // //create the button take for the health potion
        // myButton1= new JButton("Drink");
        // myButton1.setBackground(Color.gray); 
        // myButton1.setForeground(Color.white);
        //create the list 
        combo = new JComboBox(); 
        EcouteurInventory e = new EcouteurInventory(this, myMain);

        //If the player does not have item, we cannot click on the button drop
        // if (monJoueur.getNumberItemPossess()==0)
        // {
            // myButton.setEnabled(false);
        // }

        // //If the player can drink the health potion, when he has the health potion in the inventory
        // myButton1.setEnabled(false); 

        
        //Create the list with all the items
        for(int i = 0; i <= (monJoueur.getNumberItemPossess()-1); i++)
        {
            combo.addItem(monJoueur.getItems(i).getName());
            combo.addActionListener(e); 

        }

        myButton.addActionListener(e); 
        //myButton1.addActionListener(e); 
        myLabel = new JLabel ("Your inventory",JLabel.CENTER);
        myPanel.setLayout(new GridLayout(1,3));
        myPanel1.setLayout(new GridLayout(1,0));
        myPanel1.add(myLabel);
       // myPanel.add(myButton1); 
        myPanel.add(combo); 
        myPanel.add(myButton); 

        myBigPanel.setLayout(new GridLayout(2,1)); 
        myBigPanel.add(myPanel1); 
        myBigPanel.add(myPanel); 
        myBigPanel.setVisible(true); 
        add(myBigPanel); 

        //update the panel Inventory
        revalidate();
        repaint();
        setVisible(true);

    }

    /**
     * The getter to have the player of the game
     * @return monJoueur the player of the game
     */
    public Player getPlayer()
    {
        return monJoueur;
    }

    /**
     * The getter to use the button "Drop"
     * @return JButton myButton the button drop
     */
    public JButton getMyButton()
    {
        return myButton; 
    }

    /**
     * The getter to use the button "Drink"
     * @return JButton myButton the button drink for the health potion
     */
    public JButton getMyButton1()
    {
        return myButton1; 
    }

    /**
     * The getter to use the list of the items
     * @return JComboBox combo the list of the items
     */

    public JComboBox getCombo(){
        return combo; 
    }
}