import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class EcouteurDialog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EcouteurDialog
{
    private AffichMainYohan affichMain;
    private DialogScreenInterface dialog;
    
    /**
     * Constructor for objects of class EcouteurInventory
     */
    public EcouteurDialog(DialogScreenInterface myDialog, AffichMainYohan myMain){
       affichMain = myMain;
       dialog = myDialog;
    }
    
     public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == dialog.getButtonStart())
        {
             affichMain.getContentPane().setEnabled(true);
        }
    }
}