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
public class Scrolling extends JPanel
{
        
    Spot CurrentSpot = new Spot();
    Spot myTestSpotN = new Spot();
    Spot myTestSpotS = new Spot();
    Spot myTestSpotE = new Spot();
    Spot myTestSpotW = new Spot();
    Spot myTestSpotNE = new Spot();
    Spot myTestSpotNW = new Spot();
    Spot myTestSpotSE = new Spot();
    Spot myTestSpotSW = new Spot();
    
    private AffichMainYohan myMain;
    private JButton myButton1= new JButton("North");
    private JButton myButton2 = new JButton("East");
    private JButton myButton3 = new JButton("South");
    private JButton myButton4 = new JButton("West");
    private JFrame myFrame;
    private JPanel bigPanel;
    private JLabel Jlabel1,Jlabel2,Jlabel3,Jlabel4,Jlabel5,Jlabel6,Jlabel7,Jlabel8,Jlabel9;
    
    public Scrolling(Spot myNewSpot, AffichMainYohan newMain)
    {
        main(myNewSpot);
        myMain = newMain;
    }
    
    public void main (Spot myNewSpot)
    {
        CurrentSpot = myNewSpot;
        
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,3));
        
        
        Jlabel1 = new JLabel (new ImageIcon("0.png"));
        Jlabel2 = new JLabel (new ImageIcon("0.png"));
        Jlabel3 = new JLabel (new ImageIcon("0.png"));
        Jlabel4 = new JLabel (new ImageIcon("0.png"));
        Jlabel5 = new JLabel (new ImageIcon("0.png"));
        Jlabel6 = new JLabel (new ImageIcon("0.png"));
        Jlabel7 = new JLabel (new ImageIcon("0.png"));
        Jlabel8 = new JLabel (new ImageIcon("0.png"));
        Jlabel9 = new JLabel (new ImageIcon("0.png"));
        
        updateUI(CurrentSpot);
        
        System.out.println("SCrolling inside "+myMain);
        EcouteurScrolling e = new EcouteurScrolling(this,myMain);
        if(CurrentSpot.getExits("N") == null)
        {myButton1.setEnabled(false);}
        else
        {myButton1.addActionListener(e);}
        
        if(CurrentSpot.getExits("D") == null)
        {myButton2.setEnabled(false);}
        else
        {myButton2.addActionListener(e);}
        
        if(CurrentSpot.getExits("S") == null)
        {myButton3.setEnabled(false);}
        else
        {myButton3.addActionListener(e);}
        
        if(CurrentSpot.getExits("Q") == null)
        {myButton4.setEnabled(false);}
        else
        {myButton4.addActionListener(e);}
        
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(2,2));
        myPanel.add(myButton1);
        myPanel.add(myButton2);
        myPanel.add(myButton3);
        myPanel.add(myButton4);
        
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
    
    
    public void updateUI(Spot CurrentSpot)
    {
        if(CurrentSpot.getExits("North") != null)
        {
            Jlabel2.setIcon(new ImageIcon(CurrentSpot.getExits("North").getImageSpot()));
        }
        else
        {
            Jlabel2.setIcon(new ImageIcon( "0.png"));
        }
        
        if(CurrentSpot.getExits("West") != null)
        {
            Jlabel4.setIcon(new ImageIcon(CurrentSpot.getExits("West").getImageSpot()));
        }
        else
        {
            Jlabel4.setIcon(new ImageIcon( "0.png"));
        }
        
        Jlabel5.setIcon(new ImageIcon(CurrentSpot.getImageSpot()));
        
        if(CurrentSpot.getExits("East") != null)
        {
            Jlabel6.setIcon(new ImageIcon(CurrentSpot.getExits("East").getImageSpot()));
        }
        else
        {
            Jlabel6.setIcon(new ImageIcon( "0.png"));
        }
        
        if(CurrentSpot.getExits("South") != null)
        {
            Jlabel8.setIcon(new ImageIcon(CurrentSpot.getExits("South").getImageSpot()));
        }
        else
        {
            Jlabel8.setIcon(new ImageIcon( "0.png"));
        }
    }
    
    public JButton getButton1()
    {return myButton1;}
    
    public JButton getButton2()
    {return myButton2;}
    
    public JButton getButton3()
    {return myButton3;}
    
    public JButton getButton4()
    {return myButton4;}
    // public void actionPerformed (ActionEvent e)
    // {
        // if(e.getSource() == myButton1)
        // {
            // CurrentSpot = CurrentSpot.getExits("North");
            // updateUI(CurrentSpot);
        // }
        // else if(e.getSource() == myButton2)
        // {
            // CurrentSpot = CurrentSpot.getExits("East");
            // updateUI(CurrentSpot);
        // }
        // else if(e.getSource() == myButton3)
        // {
            // CurrentSpot = CurrentSpot.getExits("South");
            // updateUI(CurrentSpot);
        // }
        // else if(e.getSource() == myButton4)
        // {
            // CurrentSpot = CurrentSpot.getExits("West");
            // updateUI(CurrentSpot);
        // }
        // else
        // {
            // System.out.println("Nothing append");
        // }
    // }
}
