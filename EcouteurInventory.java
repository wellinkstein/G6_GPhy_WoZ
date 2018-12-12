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
    private Item itemClicked;
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
            //System.out.println(affichMain.getSpotItem().getContent().get(i));
            if(e.getSource() == myInventory.getContent().get(i))
            {
                //System.out.println("Bouton "+i);
                if((i%2)==0)
                {   
                    System.out.println(myInventory.getPlayer().getItems((i/2)));
                    //myInventory.showDescriptionItem(myInventory.getSpot().getOneItem((i/2)));
                    System.out.println("Description of the item"+(i%2));
                    ItemDescription myDes = new ItemDescription(myInventory.getPlayer().getItems((i/2)));
                    affichMain.setDes(myDes);
                }
                else
                {
                    System.out.println("Je prend un truc");
                    //System.out.println(myInventory.getSpot().getOneItem((i/2)));  
                    System.out.println(affichMain.getGame().getListSpot().get(19).getListItem().size());
                    affichMain.getGame().getCurrentSpot().getPlayer().takeItem(myInventory.getPlayer().getItems((i/2))); 
                    affichMain.getGame().getListSpot().get(19).removeItemSpot(myInventory.getPlayer().getItems((i/2)));
                    affichMain.getInventory().showPlayerItem(affichMain.getGame().getPlayer(),affichMain); 
                    //affichMain.getSpotItem().updateSpotItem(affichMain.getGame().getCurrentSpot()); 
                    //affichMain.setList(); 
                    //affichMain.getSpotItem().updateSpotItem(affichMain);
                    //affichMain.setList(myInventory); 
                    System.out.println(affichMain.getGame().getListSpot().get(19).getListItem().size());
                    //System.out.println(affichMain.getGame().getCurrentSpot().getPlayer().getNumberItemPossess());
                }
            }
        }
    }
}
