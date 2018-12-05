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
    private JPanel panelVarious, panelDescriptionItem, panelListItem;
    private Spot newSpot;
    public void main()
    {
        newSpot = new Spot();
        newSpot.setImageSpot("1234.png");
        
        myFrame = new JFrame("Daedalus");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(new Scrolling(newSpot));
        panelVarious= new JPanel();
        panelListItem = new SpotItem();
        myGame = new Game();  
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public Game getGame(){
        return myGame;
    }
}
