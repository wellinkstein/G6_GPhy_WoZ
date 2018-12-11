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
public class AffichMain2 extends JFrame
{
    private JFrame myFrame;
    private Game myGame; 
    private JPanel panelGauche, panelDroiteH, panelDroiteB, panelDroiteC, bigPanel, panelDroite, panelSpotItem, panelDesc, panelInventory, panelNextSpot, panelCombat, panelDiag, panelBouton, panelLab, panelPlayer, panelMonster;
    private SpotItem panelListItem;
    private Spot newSpot;
    public void main()
    {
        newSpot = new Spot();
        newSpot.setImageSpot("1234.png");
        myGame = new Game();
        //creation du frame
        myFrame = new JFrame("Daedalus");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelGauche= new JPanel();
        panelDroite= new JPanel();
        bigPanel = new JPanel();
        
        //Grille du frame et des panels
        myFrame.setLayout(new GridLayout(1,2));
        panelDroiteH=new JPanel();
        panelDroiteC=new JPanel();
        panelDroiteB=new JPanel();
        
        panelSpotItem =new JPanel();
        panelSpotItem =new SpotItem(myGame.getListSpot().get(19));
        panelCombat=new JPanel();
        panelDesc= new JPanel();
        panelInventory= new JPanel();
        panelNextSpot=new JPanel();
        panelDiag = new JPanel();
        panelBouton= new JPanel();
        panelLab=new JPanel();
        panelPlayer = new JPanel();
        panelMonster= new JPanel();
        
        panelGauche.setLayout(new GridLayout(2,1));
        panelDroite.setLayout(new GridLayout(4,1));
        
        panelDroiteH.setLayout(new GridLayout(2,1));
        panelDroiteC.setLayout(new GridLayout(3,1));
        panelDroiteB.setLayout(new GridLayout(2,1));
        
        //ajout
        panelDroiteH.add(panelPlayer);
        panelDroiteH.add(panelMonster);
        
        panelDroiteC.add(panelSpotItem);
        panelDroiteC.add(panelDesc);
        panelDroiteC.add(panelCombat);
        
        panelDroiteB.add(panelNextSpot);
        panelDroiteB.add(panelDiag);
        
        panelGauche.add(panelLab);
        panelGauche.add(panelBouton);
        
        panelDroite.add(panelDroiteH);
        panelDroite.add(panelInventory);
        panelDroite.add(panelDroiteC);
        panelDroite.add(panelDroiteB);

      
        myFrame.add(panelGauche);
        myFrame.add(panelDroite);
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public Game getGame(){
        return myGame;
    }
    
    public SpotItem getSpotItem()
    {
        return panelListItem;
    }
}
