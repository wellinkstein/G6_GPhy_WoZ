import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *  The EcouteurInventory is the listener for the class Inventory.
 *  The listener uses the panel ItemDescription to display the description of the item
 *
 * @author (Groupe 6)
 * @version (14/12/2018)
 */
public class EcouteurInventory implements ActionListener
{
    private AffichMainYohan affichMain; //The interface of the game
    private Inventory myInventory; //The panel Inventory
    private ItemDescription iDescription; //The panel ItemDescription

    /**
     * The constructor of the listener of the Inventory
     * @param Inventory //The panel Inventory
     * @param AffichMainYohan //The interface of the game
     */
    public EcouteurInventory(Inventory newInventory, AffichMainYohan myMain){
        affichMain = myMain;
        myInventory = newInventory;
    }

    /**
     * The actionPerformed of the listener of the interface Inventory
     * When we click on the list with a item, the description of the item displays
     * When we click on the button drop when we have click on the item in the list, the item is removed to the inventory of the player
     * The item is added of the spot
     * The panel SpotItem and the panel Inventory is update
     * @param ActionEvent the event for the list and the button drop
     */
    public void actionPerformed (ActionEvent e)
    {

        for(int i = 0; i <= (affichMain.getGame().getPlayer().getNumberItemPossess()); i++)
        {
            if(e.getSource() == myInventory.getCombo())
            {  
                ItemDescription myDes = new ItemDescription(myInventory.getPlayer().getItems(myInventory.getCombo().getSelectedIndex()), affichMain); //Display the Item of the list
                affichMain.setDes(myDes); //Update The ItemDescription
                
                if (myInventory.getPlayer().getItems(myInventory.getCombo().getSelectedIndex()).getName()== "Health Potion")
                {
                    myInventory.getMyButton1().setEnabled(true);
                }
            }
            else if (e.getSource()== myInventory.getMyButton())
            {

                affichMain.getGame().getCurrentSpot().addItemSpot(myInventory.getPlayer().getItems(myInventory.getCombo().getSelectedIndex())); //Add the item of the spot

                affichMain.getGame().getPlayer().dropItem(myInventory.getPlayer().getItems(myInventory.getCombo().getSelectedIndex())); //Remove the item of the player
                
                affichMain.getGame().setLimitReach(false); 
                
                affichMain.getInventory().showPlayerItem(affichMain.getGame().getPlayer(),affichMain); //Update the item of the player

                affichMain.getSpotItem().showListItem(affichMain.getGame().getCurrentSpot(),affichMain); //Update the Item of the Spot

                affichMain.getPlayerHead().showPlayerHead(affichMain.getGame().getPlayer());   //Update the characteristic of the player          
            }
            // else if (e.getSource()== myInventory.getMyButton1())
             // {
                // affichMain.getGame().getPlayer().drinkPotion();
                 
                // affichMain.getInventory().showPlayerItem(affichMain.getGame().getPlayer(),affichMain); //Update the item of the player

                // affichMain.getSpotItem().showListItem(affichMain.getGame().getCurrentSpot(),affichMain); //Update the Item of the Spot

                // affichMain.getPlayerHead().showPlayerHead(affichMain.getGame().getPlayer());   //Update the characteristic of the player  
                 
             // }
            
                
        }
    }
}

