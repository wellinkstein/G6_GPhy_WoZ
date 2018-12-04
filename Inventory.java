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
        implements ActionListener
{
    private JFrame myFrame;
    private Player monJoueur;
    private Common myObj;
    
    private ArrayList<JButton> content = new ArrayList<JButton>();
    
    
    public void main()
    {
        monJoueur = new Player(20,"Thésée",0,5,0);
        myObj = new Common("wooden sword","a small sword made of wood",1,0,0);
        monJoueur.takeItem(myObj);
        monJoueur.takeItem(myObj);
        myObj = new Common("iron shield","a round iron shield",0,0,2);
        monJoueur.takeItem(myObj);
        System.out.println(monJoueur.getNumberItemPossess());
        
        for(int i = 0; i <= (monJoueur.getNumberItemPossess()-1); i++)
        {
            content.add(new JButton(monJoueur.getItems(i).getName()));
            content.add(new JButton("Drop Item"));
        }
        
        
        myFrame = new JFrame("Inventory");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout(0,2));
        
        for(int i = 0; i <= (content.size()-1); i++)
        {
            content.get(i).addActionListener(this);
            myFrame.add(content.get(i));
        }
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        for(int i = 0; i <= (content.size()-1); i++)
        {
            if(e.getSource() == content.get(i))
            {
                System.out.println("Bouton "+i);
                if((i%2)==0)
                {}
                else
                {
                    //monJoueur.dropItem((i-1)%2);
                }
            }
        }
    }
}