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
 * @author PG 
 * @version 2013-02-04
 */
public class TestGrid extends JFrame
        implements ActionListener
{
    
    ArrayList<Character> listTestC = new ArrayList<Character>();
    ArrayList<Item> listTestI = new ArrayList<Item>();
        
    Spot CurrentSpot = new Spot(listTestC,listTestI);
    Spot myTestSpotN = new Spot(listTestC,listTestI);
    Spot myTestSpotS = new Spot(listTestC,listTestI);
    Spot myTestSpotE = new Spot(listTestC,listTestI);
    Spot myTestSpotW = new Spot(listTestC,listTestI);
    Spot myTestSpotNE = new Spot(listTestC,listTestI);
    Spot myTestSpotNW = new Spot(listTestC,listTestI);
    Spot myTestSpotSE = new Spot(listTestC,listTestI);
    Spot myTestSpotSW = new Spot(listTestC,listTestI);
    
    private JButton myButton1, myButton2, myButton3, myButton4;
    public void main ()
    {
        JFrame myFrame = new JFrame("GridLayout");
        
        CurrentSpot.setExits("North",myTestSpotN);
        CurrentSpot.setExits("South",myTestSpotS);
        CurrentSpot.setExits("East",myTestSpotE);
        CurrentSpot.setExits("West",myTestSpotW);
        
        myTestSpotN.setExits("East",myTestSpotNE);
        myTestSpotE.setExits("North",myTestSpotNE);
        
        myTestSpotS.setExits("East",myTestSpotSE);
        myTestSpotE.setExits("South",myTestSpotSE);
        
        myTestSpotN.setExits("West",myTestSpotNW);
        myTestSpotW.setExits("North",myTestSpotNW);
        
        myTestSpotS.setExits("West",myTestSpotSW);
        myTestSpotW.setExits("South",myTestSpotSW);
        
        CurrentSpot.setImageSpot("1234.png");
        myTestSpotN.setImageSpot("234.png");
        myTestSpotS.setImageSpot("124.png");
        myTestSpotE.setImageSpot("134.png");
        myTestSpotW.setImageSpot("123.png");
        myTestSpotNE.setImageSpot("34.png");
        myTestSpotNW.setImageSpot("23.png");
        myTestSpotSE.setImageSpot("14.png");
        myTestSpotSW.setImageSpot("12.png");
        
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(2,2));
        
        JButton myButton1 = new JButton("North");
        JButton myButton2 = new JButton("East");
        JButton myButton3 = new JButton("South");
        JButton myButton4 = new JButton("West");
        
        myPanel.add(myButton1);
        myPanel.add(myButton2);
        myPanel.add(myButton3);
        myPanel.add(myButton4);
        
        myButton1.addActionListener(this);
        myButton2.addActionListener(this);
        myButton3.addActionListener(this);
        myButton4.addActionListener(this);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        myFrame.setLayout(new GridLayout(4,3));
        
        for(int i=1; i<=12; i++)
        {
            if(i == 1)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("North").getExits("West").getImageSpot())));
            }
            else if(i == 2)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("North").getImageSpot())));
            }
            else if(i == 3)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("North").getExits("East").getImageSpot())));
            }
            else if(i == 4)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("West").getImageSpot())));
            }
            else if(i == 5)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getImageSpot())));
            }
            else if(i == 6)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("East").getImageSpot())));
            }
            else if(i == 7)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("South").getExits("West").getImageSpot())));
            }
            else if(i == 8)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("South").getImageSpot())));
            }
            else if(i == 9)
            {
                myFrame.add(new JLabel( new ImageIcon(CurrentSpot.getExits("South").getExits("East").getImageSpot())));
            }
            else if(i == 11)
            {
                myFrame.add(myPanel);
            }
            else
            {
                myFrame.add(new JLabel( new ImageIcon( "0.png")));
            }
            
        }

        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==myButton1)
        {
            CurrentSpot = CurrentSpot.getExits("North");
            System.out.println("going North");
        }
        else if(e.getSource()==myButton2)
        {
            CurrentSpot = CurrentSpot.getExits("East");
            System.out.println("going East");
        }
        else if(e.getSource()==myButton3)
        {
            CurrentSpot = CurrentSpot.getExits("South");
            System.out.println("going South");
        }
        else if(e.getSource()==myButton4)
        {
            CurrentSpot = CurrentSpot.getExits("West");
            System.out.println("going West");
        }
    }
}
