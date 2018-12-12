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
    private PlayerHead playerH;
    
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
                    affichMain.setDes(myDes);
                }
                else
                {
                    System.out.println(affichMain.getGame().getPlayer().getNumberItemPossess());
                    
                    affichMain.getGame().getPlayer().takeItem(mySpotItem.getSpot().getOneItem((i/2)));
                    System.out.println(affichMain.getGame().getPlayer().getNumberItemPossess());
                    
                    affichMain.getGame().getCurrentSpot().removeItemSpot(mySpotItem.getSpot().getOneItem((i/2)));
                    affichMain.getInventory().showPlayerItem(affichMain.getGame().getPlayer(),affichMain); //met à jour l'inventaire
                    
                    System.out.println(affichMain.getInventory().getPlayer().getNumberItemPossess());
                    
                    affichMain.getSpotItem().showListItem(affichMain.getGame().getCurrentSpot(),affichMain);
                    PlayerHead playerH = new PlayerHead(affichMain.getGame().getPlayer());
                    affichMain.setPlayerHead(playerH);
                    
                }
            }
        }
    }
}
