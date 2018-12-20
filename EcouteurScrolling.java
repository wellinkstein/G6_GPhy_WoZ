import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class listens the interface class Scrolling
 *
 * @author Groupe 6
 * @version 20/12/2018
 */
public class EcouteurScrolling implements ActionListener
{
    private AffichMain affichMain;
    private Scrolling myScrolling;
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;
    private DialogScreenInterface youWon,NotTimeToGo;

    /**
     * The constructor for Ecouteur scrolling
     */
    public EcouteurScrolling(Scrolling newScrolling, AffichMain myMain)
    {
       affichMain = myMain;
       myScrolling = newScrolling;
    }
    
    /**
     * This is the action method which handles the 4 directional buttons
     * of scrolling.
     */ 
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == myScrolling.getButton1())
        {
            if(affichMain.getGame().getCurrentSpot().getExits("Z").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("Z"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());
                affichMain.setFightInterface();
                //affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("Z"),affichMain,"Z");
            }
            else
            {
                affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("Z"),affichMain,"Z");
                affichMain.getScrolling().getButton1().setEnabled(false);
                affichMain.getScrolling().getButton2().setEnabled(false);
                affichMain.getScrolling().getButton3().setEnabled(false);
                affichMain.getScrolling().getButton4().setEnabled(false);
            }
        }
        if(e.getSource() == myScrolling.getButton2())
        {
            if(affichMain.getGame().getCurrentSpot().getExits("D").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("D"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());
                affichMain.setFightInterface();
                //affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("D"),affichMain,"D");
            }
            else
            {
                affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("D"),affichMain,"D");
                affichMain.getScrolling().getButton1().setEnabled(false);
                affichMain.getScrolling().getButton2().setEnabled(false);
                affichMain.getScrolling().getButton3().setEnabled(false);
                affichMain.getScrolling().getButton4().setEnabled(false);
            }
        }
        if(e.getSource() == myScrolling.getButton3())
        {
            
            if(affichMain.getGame().getCurrentSpot().getExits("S").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("S"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());
                affichMain.setFightInterface();
                //affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("S"),affichMain,"S");
            }
            else
            {
                affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("S"),affichMain,"S");
                affichMain.getScrolling().getButton1().setEnabled(false);
                affichMain.getScrolling().getButton2().setEnabled(false);
                affichMain.getScrolling().getButton3().setEnabled(false);
                affichMain.getScrolling().getButton4().setEnabled(false);
            }
        }
        if(e.getSource() == myScrolling.getButton4())
        {
            if(affichMain.getGame().getCurrentSpot().getExits("Q").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("Q"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());
                affichMain.setFightInterface();
                //affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("Q"),affichMain,"Q");
            }
            else
            {
                affichMain.getNextSpot().showNextSpot(affichMain.getGame().getCurrentSpot().getExits("Q"),affichMain,"Q");
                affichMain.getScrolling().getButton1().setEnabled(false);
                affichMain.getScrolling().getButton2().setEnabled(false);
                affichMain.getScrolling().getButton3().setEnabled(false);
                affichMain.getScrolling().getButton4().setEnabled(false);
            }
        }
        affichMain.getSpotItem().showListItem(affichMain.getGame().getCurrentSpot(),affichMain);
        if (affichMain.getGame().getCurrentSpot().getExitSpot()){
            if (affichMain.getGame().getPlayer().getTimeToGo()){
                youWon = new DialogScreenInterface(affichMain.getGame().youWon());
                affichMain.setDialog(youWon);
                affichMain.getScrolling().getButton1().setEnabled(false);
                affichMain.getScrolling().getButton2().setEnabled(false);
                affichMain.getScrolling().getButton3().setEnabled(false);
                affichMain.getScrolling().getButton4().setEnabled(false);
                }
            else{
                NotTimeToGo = new DialogScreenInterface(affichMain.getGame().NotTimeToGo());
                affichMain.setDialog(NotTimeToGo);
            }
        }
    }
}
