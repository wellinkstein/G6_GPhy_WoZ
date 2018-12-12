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
       
    }
}
