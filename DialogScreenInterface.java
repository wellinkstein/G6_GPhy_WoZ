
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A dialog screen with some text
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class DialogScreenInterface extends JPanel
{
    private JPanel myPanel; //panel
    private JLabel dialog;

    /**
     * Constructeur of DialogScreenInterface
     * @param String dialogText
     */
    public DialogScreenInterface(String dialogText)
    {
        dialog = new JLabel(dialogText);        
        myPanel = new JPanel();
        myPanel.setBackground(new Color(208,185,178));
        myPanel.add(dialog);
        add(myPanel);
    }
    

}
