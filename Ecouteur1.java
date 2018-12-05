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
    private SpotItem spotItem;
    private AffichMain affichMain;
    private Item itemClicked;
    private JPanel panelDescription;
    
    public Ecouteur1(SpotItem sI){
       spotItem=sI; 
       //affichMain =aM;
    }
    
     public void actionPerformed (ActionEvent e)
    {
        for(int i = 0; i <= (spotItem.getContent().size()-1); i++)
        {
            
            if(e.getSource() == spotItem.getContent().get(i))
            {
                System.out.println("Bouton "+i);
                if((i%2)==0)
                {   
                    panelDescription = new ItemDescription(e.getSource());
                    System.out.println("Description of the item"+(i%2));
                }
                else
                {
                    System.out.println("Taking");  
                    System.out.println(affichMain.getGame().getCurrentSpot().getPlayer().getNumberItemPossess());
                    affichMain.getGame().getCurrentSpot().getPlayer().takeItem(affichMain.getGame().getCurrentSpot().getListItem().get((i-1)));     
                    System.out.println(affichMain.getGame().getCurrentSpot().getPlayer().getNumberItemPossess());
                }
            }
        }
    }
}
