import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Ecouteur1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ecouteur1 implements ActionListener
{
    private AffichMain affichMain;
    private SpotItem mySpotItem;
    private Item itemClicked;
    private ItemDescription iDescription;
    
    public Ecouteur1(SpotItem newSpotItem){
       //affichMain = new AffichMain();
       mySpotItem = newSpotItem;
    }
    
     public void actionPerformed (ActionEvent e)
    {
        System.out.println(e.getSource());
        
        //System.out.println(affichMain.getSpotItem());
        for(int i = 0; i <= ( mySpotItem.getContent().size()-1); i++)
        {
            //System.out.println(affichMain.getSpotItem().getContent().get(i));
            if(e.getSource() == mySpotItem.getContent().get(i))
            {
                //System.out.println("Bouton "+i);
                if((i%2)==0)
                {   
                    System.out.println(mySpotItem.getSpot().getOneItem((i/2)));
                    //mySpotItem.showDescriptionItem(mySpotItem.getSpot().getOneItem((i/2)));
                    System.out.println("Description of the item"+(i%2));
                    ItemDescription myDes = new ItemDescription(mySpotItem.getSpot().getOneItem((i/2)));
                }
                else
                {
                    //System.out.println("Taking");  
                    //System.out.println(affichMain.getGame().getCurrentSpot().getPlayer().getNumberItemPossess());
                    //affichMain.getGame().getCurrentSpot().getPlayer().takeItem(affichMain.getGame().getCurrentSpot().getListItem().get((i-1)));     
                    //System.out.println(affichMain.getGame().getCurrentSpot().getPlayer().getNumberItemPossess());
                }
            }
        }
    }
}
