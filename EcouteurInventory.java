import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class EcouteurInventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EcouteurInventory implements ActionListener
{
    private AffichMainYohan affichMain;
    private Inventory myInventory;
    private ItemDescription iDescription;

    /**
     * Constructor for objects of class EcouteurInventory
     */
    public EcouteurInventory(Inventory newInventory, AffichMainYohan myMain){
       affichMain = myMain;
       myInventory = newInventory;
    }
    
     public void actionPerformed (ActionEvent e)
    {
        Container mycont = myInventory.getParent();
        for(int i = 0; i <= ( myInventory.getContent().size()-1); i++)
        {
            if(e.getSource() == myInventory.getContent().get(i))
            {
                if((i%2)==0)
                {   
                    System.out.println(myInventory.getPlayer().getItems((i/2)));
                    System.out.println("Description of the item"+(i%2));
                    ItemDescription myDes = new ItemDescription(myInventory.getPlayer().getItems((i/2)));
                    affichMain.setDes(myDes);
                }
                else
                {
                    System.out.println("Je lache un truc"); 
                    System.out.println(affichMain.getGame().getPlayer().getNumberItemPossess());
                    System.out.println(myInventory.getPlayer().getItems((i/2)).getName());
                    affichMain.getGame().getListSpot().get(19).addItemSpot(myInventory.getPlayer().getItems((i/2)));
                    affichMain.getGame().getPlayer().dropItem(myInventory.getPlayer().getItems((i/2)));
                    affichMain.getInventory().showPlayerItem(affichMain.getGame().getPlayer(),affichMain); 
                    affichMain.getSpotItem().showListItem(affichMain.getGame().getListSpot().get(19),affichMain);
                    PlayerHead playerH = new PlayerHead(myInventory.getPlayer());
                    affichMain.setPlayerHead(playerH);
                    
                    System.out.println(affichMain.getGame().getPlayer().getNumberItemPossess());
                }
            }
        }
    }
}
