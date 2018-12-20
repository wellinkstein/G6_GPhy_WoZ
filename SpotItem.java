import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.*;
import java.util.Set;
/**
 * The class SpotItem allows us to have the interface of the Item in the spot.
 * This class displays all the Item in the spot where the player is
 *
 * @author (Ludivine Harault)
 * @version (2018-12-04)
 */
public class SpotItem extends JPanel
{
    private JLabel myLabel; //The label for the explication of the panel
    private JPanel myPanel, myPanel1, myBigPanel; //all the panel of the panl SpotItem 
    private ArrayList<JButton> content = new ArrayList<JButton>(); //A list for the buttons
    private Spot mySpot; //The current Spot 
    private AffichMain myMain; //The affich Main for the game

    /**
     * The constructor of the SpotItem, create the interface of the SpotItem
     * @param spot The currentSpot where the player is
     * @param AffichMainYohan The affichmain of the game
     */
    public SpotItem(Spot spot, AffichMain cont)
    {
        mySpot = spot;
        myMain = cont;
        showListItem(mySpot,myMain);
    }

    /**
     * The fonction of the showListItem allows us to create the spotItem.
     * @param Spot the CurrentSpot of the player
     * @param AffichMainYohan  the affichmain of the game
     */
    public void showListItem(Spot spot, AffichMain myMain)
    {
      
        removeAll(); //remove the SpotItem
        mySpot = spot;
        
        //Create all the panel
        JPanel myPanel;
        JLabel myLabel; 

        myPanel = new JPanel();
        myPanel1= new JPanel(); 
        myBigPanel=new JPanel();

        //remove all the panel in the SpotItem
        content.clear();

        //Add all the button in the content list
        for(int i = 0; i <= (spot.getListItem().size()-1); i++)
        {   
            content.add(new JButton(spot.getListItem().get(i).getName()));
            content.add(new JButton("Take"));

        }

        //Create the label of the SpotItem
        if (spot.getListItem().size()!=0){
            myLabel = new JLabel ("The available items in the spot",JLabel.CENTER);
        }
        else {
            myLabel = new JLabel ("These are no items in the spot",JLabel.CENTER);
        }
        myPanel.setLayout(new GridLayout(spot.getListItem().size(),1));
        myPanel1.setLayout(new GridLayout(1,1));
        myPanel1.add(myLabel); 

        //Adding a actionListener of all the button of the SpotItem
        for(int i = 0; i <= (content.size()-1); i++)
        {
            EcouteurSpotItem e = new EcouteurSpotItem(this, myMain);
            content.get(i).addActionListener(e);
            myPanel.add(content.get(i));
        }

        myBigPanel.setLayout(new GridLayout(2,1)); 
        myBigPanel.add(myPanel1); 
        myBigPanel.add(myPanel); 

        myBigPanel.setVisible(true); 
        add(myBigPanel);
        //upDate the panel
        revalidate();
        repaint();
        setVisible(true);

    }

    /**
     * The getter of the spot of the player in the affichMain
     * @return spot 
     */
    public Spot getSpot()
    {
        return mySpot;
    }

    /**
     * The getter for the list of the button 
     * @return content the list of the button
     */
    public ArrayList<JButton> getContent(){
        return content;
    }

}
