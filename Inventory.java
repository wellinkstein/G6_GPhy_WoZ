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
public class Inventory extends JFrame
{
    JFrame myFrame;
    Player monJoueur;
    Common myObj;
    public void main()
    {
        monJoueur = new Player(20,"Thésée",0,5,0);
        myObj = new Common("épée bois","une petite épée jouet",1,0,0);
        monJoueur.takeItem(myObj);
        monJoueur.takeItem(myObj);
        monJoueur.takeItem(myObj);
        System.out.println(monJoueur.get)
        
        myFrame = new JFrame("Inventory");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout(0,2));
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
}