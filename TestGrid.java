import java.awt.*;
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
public class TestGrid
{
    public static void main ()
    {
        JFrame myFrame = new JFrame("GridLayout");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        
        myFrame.setLayout(new GridLayout(3,3));
        
        for(int i=1; i<=9; i++)
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
            else
            {
                myFrame.add(new JLabel( new ImageIcon( "noir.png")));
            }
            
        }

        myFrame.pack();
        myFrame.setVisible(true);
    }
}
