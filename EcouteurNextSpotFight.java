import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This is the external listener for the fight button of the next spot class.
 * It handles a button that will involve "fleeing" the monster and another button whih allows the player to fight the monster.
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
     *This action handles both buttons, the flee button cancels the move() called by the player, allowing the player to select another position and avoid the spot which contains the monster
     *The other button is fight, it causes the player to move forward into the spot containing a monster, this initiates a fight.
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==myNextSpot.getMyFleeButton()) //cancels the choice of direction and doesn't engage a fight
        {   
            affichMain1.getNextSpot().showNextSpot(affichMain1.getGame().getCurrentSpot(), affichMain1,affichMain1.getNextSpot().getDirection());
            affichMain1.setScrolling();
        }
        else if (e.getSource()==myNextSpot.getMyFightButton())
        {
            //System.out.println(affichMain1.getGame().getCurrentSpot().getExits(affichMain1.getNextSpot().getDirection()));
            //System.out.println(affichMain1.getNextSpot().getDirection());
            affichMain1.getGame().move(affichMain1.getGame().getCurrentSpot().getExits(affichMain1.getNextSpot().getDirection()));
            affichMain1.getMonsterHead().showMonsterHead(affichMain1.getGame().getCurrentSpot().getMonster()); 
            affichMain1.getNextSpot().showNextSpot(null, affichMain1,null);
            affichMain1.setScrolling();
            affichMain1.setFightInterface();
            affichMain1.getScrolling().getButton1().setEnabled(false);
            affichMain1.getScrolling().getButton2().setEnabled(false);
            affichMain1.getScrolling().getButton3().setEnabled(false);
            affichMain1.getScrolling().getButton4().setEnabled(false);
            
            //affichMain1.getNextSpot().showNextSpot(affichMain1.getGame().getCurrentSpot(), affichMain1,affichMain1.getNextSpot().getDirection());
        }
    }
}
