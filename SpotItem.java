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
    private AffichMainYohan myMain; //The affich Main for the game
    

    /**
     * The constructor of the SpotItem, create the interface of the SpotItem
     * @param spot The currentSpot where the player is
     * @param AffichMainYohan The affichmain of the game
     */
    public SpotItem(Spot spot, AffichMainYohan cont)
    {
        mySpot = spot;
        myMain = cont;
        showListItem(mySpot,myMain);
    }

    /**
     * The fonction of the showListItem, all the create the spotItem.
     * @param Spot the CurrentSpot of the player
     * @param AffichMainYohan  the affichmain of the game
     */
    public void showListItem(Spot spot, AffichMainYohan myMain)
    {
        removeAll();
        
        JPanel myPanel;
        JLabel myLabel; 

        myPanel = new JPanel();
        myPanel1= new JPanel(); 
        myBigPanel=new JPanel();
        
        myBigPanel.removeAll();
        myPanel.removeAll();
        myPanel1.removeAll();
        content.clear();


        for(int i = 0; i <= (spot.getListItem().size()-1); i++)
        {   
            content.add(new JButton(spot.getListItem().get(i).getName()));
            content.add(new JButton("Take"));
        }

     
        myLabel = new JLabel ("These are the items available",JLabel.CENTER);
        myPanel.setLayout(new GridLayout(spot.getListItem().size(),1));
        myPanel1.setLayout(new GridLayout(1,1));
        myPanel1.add(myLabel); 

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

    // public void updateSpotItem(AffichMainYohan myMain)
    // {
        // myBigPanel.removeAll();

        // myBigPanel.setLayout(new GridLayout(2,1));
        // showListItem(myMain.getGame().getCurrentSpot(), myMain);
        // myBigPanel.revalidate();
        // myBigPanel.repaint();

    // }
    /**
     * The getter for the list of the button 
     * @return content the list of the button
     */
    public ArrayList<JButton> getContent(){
        return content;
    }

}
