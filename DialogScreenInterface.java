
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A dialog screen with some text
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class DialogScreenInterface extends JFrame
{
    
    private JButton buttonClose;
    private JPanel myPanel1, myPanel2, myPanel;
    private JLabel dialog;

    /**
     * Constructeur of DialogScreenInterface
     */
    public DialogScreenInterface()
    {
        JFrame myFrame;
        myFrame = new JFrame("Dialog Screen");
        
        buttonClose = new JButton("Close");
        
        dialog = new JLabel("Test");
        
        myPanel = new JPanel();
        
        myPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        //c.weighty = 0.95;
        myPanel.add(dialog, c);
        
        c.fill = GridBagConstraints.VERTICAL;
        //c.weighty = 0.05;
        c.anchor = GridBagConstraints.CENTER;
        myPanel.add(buttonClose, c);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
