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
        implements ActionListener
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
    
    private JButton myButton1= new JButton("North");
    private JButton myButton2 = new JButton("East");
    private JButton myButton3 = new JButton("South");
    private JButton myButton4 = new JButton("West");
    private JFrame myFrame;
    private JPanel bigPanel,wholePanel;
    private JLabel Jlabel1,Jlabel2,Jlabel3,Jlabel4,Jlabel5,Jlabel6,Jlabel7,Jlabel8,Jlabel9;
    
    public Scrolling()
    {
        main();
    }
    
    public void main ()
    {
        CurrentSpot.setExits("North",myTestSpotN);
        CurrentSpot.setExits("South",myTestSpotS);
        CurrentSpot.setExits("East",myTestSpotE);
        CurrentSpot.setExits("West",myTestSpotW);
        
        myTestSpotN.setExits("East",myTestSpotNE);
        myTestSpotN.setExits("West",myTestSpotNW);
        myTestSpotN.setExits("South",CurrentSpot);
        
        myTestSpotE.setExits("North",myTestSpotNE);
        myTestSpotE.setExits("West",CurrentSpot);
        myTestSpotE.setExits("South",myTestSpotSE);
        
        
        myTestSpotW.setExits("North",myTestSpotNW);
        myTestSpotW.setExits("South",myTestSpotSW);
        myTestSpotW.setExits("East",CurrentSpot);
        
        myTestSpotS.setExits("West",myTestSpotSW);
        myTestSpotS.setExits("North",CurrentSpot);
        myTestSpotS.setExits("East",myTestSpotSE);
        
        myTestSpotSE.setExits("North",myTestSpotE);
        myTestSpotSE.setExits("West",myTestSpotN);
        
        myTestSpotSW.setExits("North",myTestSpotW);
        myTestSpotSW.setExits("East",myTestSpotS);
        
        myTestSpotNE.setExits("South",myTestSpotE);
        myTestSpotNE.setExits("West",myTestSpotN);
        
        myTestSpotNW.setExits("South",myTestSpotW);
        myTestSpotNW.setExits("East",myTestSpotN);
        
        
        CurrentSpot.setImageSpot("1234.png");
        myTestSpotN.setImageSpot("234.png");
        myTestSpotS.setImageSpot("124.png");
        myTestSpotE.setImageSpot("134.png");
        myTestSpotW.setImageSpot("123.png");
        myTestSpotNE.setImageSpot("34.png");
        myTestSpotNW.setImageSpot("23.png");
        myTestSpotSE.setImageSpot("14.png");
        myTestSpotSW.setImageSpot("12.png");
        
        //myFrame = new JFrame("Mon Scrolling");
        //myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,3));
        
        myButton1.addActionListener(this);
        myButton2.addActionListener(this);
        myButton3.addActionListener(this);
        myButton4.addActionListener(this);
        
        Jlabel1 = new JLabel (new ImageIcon("0.png"));
        Jlabel2 = new JLabel (new ImageIcon(CurrentSpot.getExits("North").getImageSpot()));
        Jlabel3 = new JLabel (new ImageIcon("0.png"));
        Jlabel4 = new JLabel (new ImageIcon(CurrentSpot.getExits("West").getImageSpot()));
        Jlabel5 = new JLabel (new ImageIcon(CurrentSpot.getImageSpot()));
        Jlabel6 = new JLabel (new ImageIcon(CurrentSpot.getExits("East").getImageSpot()));
        Jlabel7 = new JLabel (new ImageIcon("0.png"));
        Jlabel8 = new JLabel (new ImageIcon(CurrentSpot.getExits("South").getImageSpot()));
        Jlabel9 = new JLabel (new ImageIcon("0.png"));
        
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
    
    public JPanel getPanel()
    {
        return wholePanel;
    }
    
    public void updateUI()
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
    
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == myButton1)
        {
            CurrentSpot = CurrentSpot.getExits("North");
            updateUI();
        }
        else if(e.getSource() == myButton2)
        {
            CurrentSpot = CurrentSpot.getExits("East");
            updateUI();
        }
        else if(e.getSource() == myButton3)
        {
            CurrentSpot = CurrentSpot.getExits("South");
            updateUI();
        }
        else if(e.getSource() == myButton4)
        {
            CurrentSpot = CurrentSpot.getExits("West");
            updateUI();
        }
        else
        {
            System.out.println("Nothing append");
        }
    }
}
