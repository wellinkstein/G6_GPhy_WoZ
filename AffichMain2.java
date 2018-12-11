import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

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

    private Game myGame; 
    private JPanel panelGauche, panelDroiteH, panelDroiteB, panelDroiteC, bigPanel, panelDroite, panelSpotItem, panelDesc, panelInventory, panelNextSpot, panelCombat, panelDiag, panelBouton, panelLab, panelPlayer, panelMonster;
    private SpotItem panelListItem;
    private Spot newSpot;
    public void main()
    {
        
        newSpot = new Spot();
        newSpot.setImageSpot("1234.png");
        myGame = new Game();
        
        
        //Grille du frame et des panels
        
        JFrame myFrame = new JFrame("Daedalus");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1000,700);
 
        Container pane = myFrame.getContentPane();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        panelGauche= new JPanel();
        panelDroite= new JPanel();
        
        panelLab = new JPanel();
        panelLab.setBackground(Color.BLUE);
        // c.weightx = 0.5;
        // c.weighty = 0.6;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight=3;
        // c.fill= GridBagConstraints.BOTH;
        pane.add(panelLab, c);
        
        panelPlayer = new JPanel();
        panelPlayer.setBackground(Color.GREEN);
        //new PlayerHead(myGame.getPlayer());
        // c.weightx = 0.25;
        // c.weighty = 0.1;
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.gridwidth=2; //prend deux colonnes
        c.gridx = 1;
        c.gridy = 0;
        pane.add(panelPlayer, c);
        
        
        panelMonster = new JPanel();
        panelMonster.setBackground(Color.RED);
        //new MonsterHead(myGame.getListSpot().get(6).getMonster());
        // c.weightx = 0.25;
        // c.weighty = 0.1;
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.gridwidth=1;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(panelMonster, c);
        
        panelInventory=new JPanel();
        panelInventory.setBackground(Color.BLUE);
        // c.weightx = 0.5;
        // c.weighty = 0.1;
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.gridwidth=3;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(panelInventory, c);
        
        panelSpotItem=new JPanel();
        panelSpotItem.setBackground(Color.RED);
        //new SpotItem(myGame.getListSpot().get(19));
        // c.weightx = 0.125;
        // c.weighty = 0.4;
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.gridheight=3;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(panelSpotItem, c);
        
        panelDesc=new JPanel();
        panelDesc.setBackground(Color.PINK);
        // c.weightx = 0.125;
        // c.weighty = 0.4;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(panelDesc, c);
        
        panelCombat=new JPanel();
        panelCombat.setBackground(Color.BLACK);
        // c.weightx = 0.25;
        // c.weighty = 0.4;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx =3;
        c.gridy = 2;
        pane.add(panelCombat, c);
        
        panelBouton = new JPanel();
        panelBouton.setBackground(Color.GRAY);
        // c.weightx = 0.5;
        // c.weighty = 0.4;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx =0;
        c.gridy =3;
        pane.add(panelBouton, c);
        
        panelNextSpot = new JPanel();
        panelNextSpot.setBackground(Color.BLACK);
        //new NextSpot(myGame.getListSpot().get(6));
        // c.weightx = 0.25;
        // c.weighty = 0.4;
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.gridwidth = 2;
        c.gridx =1;
        c.gridy = 3;
        pane.add(panelNextSpot, c);
        
        panelDiag = new JPanel();
        panelDiag.setBackground(Color.YELLOW);
        // c.weightx = 0.25;
        // c.weighty = 0.4;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx =3;
        c.gridy = 3;
        pane.add(panelDiag, c);

        // // myFrame.setLayout(new GridLayout(1,2));
        // // panelDroiteH=new JPanel();
        // // panelDroiteC=new JPanel();
        // // panelDroiteB=new JPanel();
        
        
        // panelSpotItem =new JPanel();
        // panelSpotItem =new SpotItem(myGame.getListSpot().get(19));
        // panelCombat=new JPanel();
        // panelCombat.setBackground(Color.ORANGE);
        // panelDesc= new JPanel();
        // panelInventory= new JPanel();
        // panelInventory.setSize(5,5);
        // panelInventory.setBackground(Color.GREEN);
        // panelNextSpot=new JPanel();
        // //panelNextSpot= new NextSpot();
        // panelDiag = new JPanel();
        // panelBouton= new JPanel();
        // panelLab=new JPanel();
        
        // panelPlayer = new JPanel();
        // panelPlayer = new PlayerHead(myGame.getPlayer());
        // panelPlayer.setBackground(Color.BLUE);
        
        // panelMonster= new JPanel();
        // panelMonster = new MonsterHead(myGame.getListSpot().get(6).getMonster());
        
        // panelGauche.setLayout(new GridLayout(2,1));
        // panelDroite.setLayout(new GridLayout(4,1));
        
        // panelDroiteH.setLayout(new GridLayout(1,2));
        // panelDroiteC.setLayout(new GridLayout(1,3));
        // panelDroiteB.setLayout(new GridLayout(1,2));
        
        // //ajout
        // panelDroiteH.add(panelPlayer);
        // panelDroiteH.add(panelMonster);
        
        // panelDroiteC.add(panelSpotItem);
        // panelDroiteC.add(panelDesc);
        // panelDroiteC.add(panelCombat);
        
        // panelDroiteB.add(panelNextSpot);
        // panelDroiteB.add(panelDiag);
        
        // panelGauche.add(panelLab);
        // panelGauche.add(panelBouton);
        
        // panelDroite.add(panelDroiteH);
        // panelDroite.add(panelInventory);
        // panelDroite.add(panelDroiteC);
        // panelDroite.add(panelDroiteB);

      
        // myFrame.add(panelGauche);
        // myFrame.add(panelDroite);
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
 
    // public static void main(String[] args) {
        // //Schedule a job for the event-dispatching thread:
        // //creating and showing this application's GUI.
        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
            // public void run() {
                // createAndShowGUI();
            // }
        // });
    // }
}
