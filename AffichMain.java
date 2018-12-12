import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * This class is an example of GridLayout Manager
 * 
 * @author Corentin Journay 
 * @version 04/12/2018
 */
public class AffichMain extends JFrame
{
    private JFrame myFrame;
    private Game myGame; 
    private JPanel panelVarious, panelDescriptionItem, bigPanel, panelHaut, panelBas;
    private SpotItem panelListItem;
    private ItemDescription myDescription;
    private Spot newSpot;
    
    public AffichMain()
    {
        main();
    }
    
    public void main()
    {
        newSpot = new Spot();
        newSpot.setImageSpot("1234.png");
        myGame = new Game();
        
        //creation du frame
        myDescription = new ItemDescription(new Common("Wooden Shield", "item test",0,0,0));
        myDescription.setVisible(false);
        myFrame = new JFrame("Daedalus");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelVarious= new JPanel();
        panelBas= new JPanel();
        panelHaut= new JPanel();
        bigPanel = new JPanel();
        panelListItem = new SpotItem(myGame.getListSpot().get(19),this);
        myGame.move(myGame.getListSpot().get(19));
        //System.out.println(panelListItem);
        panelVarious= panelListItem;
        //Grille du frame et des panels
        myFrame.setLayout(new GridLayout(1,2));
        bigPanel.setLayout(new GridLayout(3,1));
        panelHaut.setLayout(new GridLayout(1,2));
        
        //ajout
        bigPanel.add(myDescription);
        bigPanel.add(panelListItem);
        bigPanel.add(panelBas);
        myFrame.add(new Scrolling(newSpot));
        myFrame.add(bigPanel);

        myFrame.pack();
        myFrame.setVisible(true);
    }
    
   
    
    public void setList()
    {
        bigPanel.removeAll();
        //panelListItem=mySpot; 
        bigPanel.add(myDescription);
       // getSpotItem().showListItem(myGame.getCurrentSpot(), this); 
        bigPanel.add(panelListItem);
        bigPanel.add(panelBas);
        bigPanel.revalidate();
        bigPanel.repaint();
        System.out.println("New List");

    }
        
    public Game getGame()
    {
        return myGame;
    }
    
    public SpotItem getSpotItem()
    {
        return panelListItem;
    }
}
