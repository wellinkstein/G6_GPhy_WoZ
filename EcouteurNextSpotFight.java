import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This is the external listener for the fight button of the next spot class.
 *
 * @author (Yohan Lefol)
 * @version (12/12/2018)
 */
public class EcouteurNextSpotFight implements ActionListener
{
    private AffichMainYohan affichMain1;
    private NextSpot myNextSpot;
    

    /**
     * Constructor for objects of class EcouteurNextSpotFight
     */
    public EcouteurNextSpotFight(NextSpot newNextSpot, AffichMainYohan myMain)
    {
        affichMain1 = myMain;
        myNextSpot = newNextSpot;
    }

    /**
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void actionPerformed (ActionEvent e)
    {
       if(e.getSource()==NextSpot.myFleeButton) //cancels the choice of direction and doesn't engage a fight
        {
            
            bigPanel.removeAll();
            myLabel3 = new JLabel("No monster");
            bigPanel.add(myLabel3);
            
            // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                    
            bigPanel.revalidate();
            bigPanel.repaint();       
        }
    }
}
