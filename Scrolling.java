import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * This class is an interface of the maze and the buttons which allow Theseus to move
 * This class builds the scrolling interface by calling the imagespot attribute 
 * from the spot class.
 * This allows the scrolling class to show the appropriate block for the location
 * of the player as depending on the number of exits available in each spot
 * the image will change accordingly to represent the exits.
 * 
 * @author Groupe 6
 * @version 20/12/2018
 */
public class Scrolling extends JPanel
{
        
    Spot CurrentSpot = new Spot();
    
    private AffichMain myMain;
    private JButton myButton1= new JButton("Up");
    private JButton myButton2 = new JButton("Right");
    private JButton myButton3 = new JButton("Down");
    private JButton myButton4 = new JButton("Left");
    private JFrame myFrame;
    private JPanel bigPanel;
    private JLabel Jlabel1,Jlabel2,Jlabel3,Jlabel4,Jlabel5,Jlabel6,Jlabel7,Jlabel8,Jlabel9,Jlabel10;
    private JLayeredPane myLayer;
    public Scrolling(Spot myNewSpot, AffichMain newMain)
    {
        myMain = newMain;
        main(myNewSpot);
    }
    
    /**
     * This function creates the interface that will appear for the scrolling
     */
    
    public void main (Spot myNewSpot)
    {
        CurrentSpot = myNewSpot;
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,3));
        bigPanel.setBackground(new Color(208,185,178));
        
        Jlabel1 = new JLabel (new ImageIcon("0.png"));
        Jlabel2 = new JLabel (new ImageIcon("0.png"));
        Jlabel3 = new JLabel (new ImageIcon("0.png"));
        Jlabel4 = new JLabel (new ImageIcon("0.png"));
        Jlabel5 = new JLabel (new ImageIcon("0.png"));
        Jlabel6 = new JLabel (new ImageIcon("0.png"));
        Jlabel7 = new JLabel (new ImageIcon("0.png"));
        Jlabel8 = new JLabel (new ImageIcon("0.png"));
        Jlabel9 = new JLabel (new ImageIcon("0.png"));
        myLayer = new JLayeredPane();
        myLayer.add(Jlabel5, new Integer(2),1);
        updateUI(CurrentSpot);
        
        
        EcouteurScrolling e = new EcouteurScrolling(this,myMain);
        myButton1.addActionListener(e);
        myButton2.addActionListener(e);
        myButton3.addActionListener(e);
        myButton4.addActionListener(e);
        
        if(CurrentSpot.getExits("Z") == null)
        {myButton1.setEnabled(false);}
        if(CurrentSpot.getExits("D") == null)
        {myButton2.setEnabled(false);}
        if(CurrentSpot.getExits("S") == null)
        {myButton3.setEnabled(false);}
        if(CurrentSpot.getExits("Q") == null)
        {myButton4.setEnabled(false);}
        
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(2,1));
        
        JPanel upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(0,1));
        upPanel.add(myButton1);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,3));
        buttonPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        buttonPanel.add(myButton2);
        buttonPanel.add(myButton3);
        buttonPanel.add(myButton4);
        
        myPanel.add(upPanel);
        myPanel.add(buttonPanel);
        for(int i=1; i<=12; i++)
        {
            if(i == 1)
            {
                bigPanel.add(Jlabel1);
            }
            else if(i == 2)
            {
                bigPanel.add(Jlabel2);
            }
            else if(i == 3)
            {
                bigPanel.add(Jlabel3);
            }
            else if(i == 4)
            {
                bigPanel.add(Jlabel4);
            }
            else if(i == 5)
            {
                bigPanel.add(Jlabel5);
            }
            else if(i == 6)
            {
                bigPanel.add(Jlabel6);
            }
            else if(i == 7)
            {
                bigPanel.add(Jlabel7);
            }
            else if(i == 8)
            {
                bigPanel.add(Jlabel8);
            }
            else if(i == 9)
            {
                bigPanel.add(Jlabel9);
            }
            else if(i == 11)
            {
                bigPanel.add(myPanel);
            }
            else
            {
                bigPanel.add(new JLabel( new ImageIcon( "0.png")));
            }
        }
        
        add(bigPanel);
        setVisible(true);
    }
    
    
    /**
     * This method is called to check what exits are available,
     * this checking which buttons should be avaialble to be clicked.
     * It also updated the interface accrodingly.
     */
    public void updateUI(Spot CurrentSpot)
    {
        if(CurrentSpot.getExits("Z") == null)
        {myButton1.setEnabled(false);}
        else{myButton1.setEnabled(true);}
        if(CurrentSpot.getExits("D") == null)
        {myButton2.setEnabled(false);}
        else{myButton2.setEnabled(true);}
        if(CurrentSpot.getExits("S") == null)
        {myButton3.setEnabled(false);}
        else{myButton3.setEnabled(true);}
        if(CurrentSpot.getExits("Q") == null)
        {myButton4.setEnabled(false);}
        else{myButton4.setEnabled(true);}
        if(CurrentSpot.getExits("Z") != null)
        {
            Jlabel2.setIcon(new ImageIcon(CurrentSpot.getExits("Z").getImageSpot()+".png"));
        }
        else
        {
            Jlabel2.setIcon(new ImageIcon( "0.png"));
        }
        
        if(CurrentSpot.getExits("Q") != null)
        {
            Jlabel4.setIcon(new ImageIcon(CurrentSpot.getExits("Q").getImageSpot()+".png"));
        }
        else
        {
            Jlabel4.setIcon(new ImageIcon( "0.png"));
        }
        
        Jlabel5.setIcon(new ImageIcon(CurrentSpot.getImageSpot()+"Link.png"));
        
        if(CurrentSpot.getExits("D") != null)
        {
            Jlabel6.setIcon(new ImageIcon(CurrentSpot.getExits("D").getImageSpot()+".png"));
        }
        else
        {
            Jlabel6.setIcon(new ImageIcon( "0.png"));
        }
        
        if(CurrentSpot.getExits("S") != null)
        {
            Jlabel8.setIcon(new ImageIcon(CurrentSpot.getExits("S").getImageSpot()+".png"));
        }
        else
        {
            Jlabel8.setIcon(new ImageIcon( "0.png"));
        }
    }
    
    /**
     * A method that allows the return 
     */
    public JButton getButton1()
    {return myButton1;}
    
    public JButton getButton2()
    {return myButton2;}
    
    public JButton getButton3()
    {return myButton3;}
    
    public JButton getButton4()
    {return myButton4;}
    
}
