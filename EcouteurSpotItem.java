import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The class EcouteurSpotItem, is the listener of 
 * the class SpotItem and ItemDescription
 *
 * @author (Ludivine Harault et Corentin Journay)
 * @version (12/12/2018)
 */
public class EcouteurSpotItem implements ActionListener
{
    private AffichMainYohan affichMain;// the interface main of the game
    private SpotItem mySpotItem; //The Interface SpotItem

    /**
     * The constructeur of the listener of the SpotItem
     * @SpotItem The panel of the interface SpotItem
     * @AffichMain The interface affichMain of the game
     */
    public EcouteurSpotItem(SpotItem newSpotItem, AffichMainYohan myMain){
        affichMain = myMain;
        mySpotItem = newSpotItem;
    }

    /**
     * The actionPerformed of the listener of the interface SpotItem
     * When we click on the button with a item, the description of the item displays
     * When we click on the button take next to the item, the item is added to the inventory of the player
     * The item is removed of the spot
     * The panel SpotItem and the panel Inventory is update
     * @param ActionEvent the event for the button
     */
    public void actionPerformed (ActionEvent e)
    {
        for(int i = 0; i <= ( mySpotItem.getContent().size()-1); i++)
        {

            if(e.getSource() == mySpotItem.getContent().get(i))
            {

                if((i%2)==0)
                {   
                    ItemDescription myDes = new ItemDescription(mySpotItem.getSpot().getOneItem((i/2)));
                    affichMain.setDes(myDes); //Update of the panel ItemDescription

                    //getItemDescription().showItemDes(mySpotItem.getSpot().getOneItem((i/2)));
                }
                else
                {
                    //System.out.println(affichMain.getGame().getCurrentSpot().getNumberOfItemInSpot());
                    affichMain.getGame().getPlayer().takeItem(mySpotItem.getSpot().getOneItem(((i-1)/2))); //Take the item 
                    //affichMain.getGame().getPlayer().takeItem(affichMain.getGame().getCurrentSpot().getOneItem(((i-1)/2)));
                    
                    if (affichMain.getGame().getPlayer().getNumberItemPossess() < affichMain.getGame().getPlayer().getLimitItem())
                    {
                    affichMain.getGame().getCurrentSpot().removeItemSpot(mySpotItem.getSpot().getOneItem(((i-1)/2))); //remove the item in the spot
                     }
                     else if (affichMain.getGame().getPlayer().getNumberItemPossess() == affichMain.getGame().getPlayer().getLimitItem() && affichMain.getGame().getLimitReach()== false)
                     {
                         
                         affichMain.getGame().getCurrentSpot().removeItemSpot(mySpotItem.getSpot().getOneItem(((i-1)/2))); //remove the item in the spot
                         affichMain.getGame().setLimitReach(true); 
                     }
                    
                    affichMain.getInventory().showPlayerItem(affichMain.getGame().getPlayer(),affichMain); //update Inventory

                    affichMain.getSpotItem().showListItem(affichMain.getGame().getCurrentSpot(),affichMain);//Update the ItemSpot

                    affichMain.getPlayerHead().showPlayerHead(affichMain.getGame().getPlayer()); //Update the characteristic of the player

                }
            } 
        }
    }
}
