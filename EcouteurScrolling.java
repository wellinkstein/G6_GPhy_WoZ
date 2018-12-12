import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Ecouteur1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EcouteurScrolling implements ActionListener
{
    private AffichMainYohan affichMain;
    private Scrolling myScrolling;
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe EcouteurScrolling
     */
    public EcouteurScrolling(Scrolling newScrolling, AffichMainYohan myMain)
    {
       affichMain = myMain;
       myScrolling = newScrolling;
    }
    
     public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == myScrolling.getButton1())
        {
            System.out.println("North");
            if(affichMain.getGame().getCurrentSpot().getExits("N").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("N"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());}
            else
            {}
        }
        if(e.getSource() == myScrolling.getButton2())
        {
            System.out.println("East");
            System.out.println(affichMain);
            System.out.println(affichMain.getGame().getCurrentSpot().getExits("D"));
            System.out.println("checking monsters");
            if(affichMain.getGame().getCurrentSpot().getExits("D").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("D"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());
                System.out.println(affichMain.getGame().getCurrentSpot());
            }
            else
            {}
        }
        if(e.getSource() == myScrolling.getButton3())
        {
            System.out.println("South");
            if(affichMain.getGame().getCurrentSpot().getExits("S").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("S"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());}
            else
            {}
        }
        if(e.getSource() == myScrolling.getButton4())
        {
            System.out.println("West");
            if(affichMain.getGame().getCurrentSpot().getExits("Q").getListCharacter().size() == 0)
            {
                affichMain.getGame().move(affichMain.getGame().getCurrentSpot().getExits("Q"));
                myScrolling.updateUI(affichMain.getGame().getCurrentSpot());}
            else
            {}
        }
    }
}
