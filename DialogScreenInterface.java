
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
    private JPanel myPanel;
    private JLabel dialog;

    /**
     * Constructeur of DialogScreenInterface
     */
    public DialogScreenInterface(String dialogText)
    {
        dialog = new JLabel(dialogText);        
        myPanel = new JPanel();
        myPanel.add(dialog);
        add(myPanel);
    }
    

}
