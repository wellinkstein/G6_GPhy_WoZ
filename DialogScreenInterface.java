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
    private JPanel myPanel;
    private JLabel dialog;

    /**
     * Constructeur of DialogScreenInterface
     */
    public DialogScreenInterface()
    {
        JFrame myFrame;
        myFrame = new JFrame("Dialog Screen");
        
        buttonClose = new JButton("Close");
        buttonClose.setSize(80,20);
        
        dialog = new JLabel("Test");
        
        myPanel = new JPanel();
        
        myPanel.setLayout(new BorderLayout(0,1));
        
        myPanel.add(dialog, BorderLayout.NORTH);
        myPanel.add(buttonClose, BorderLayout.SOUTH);
        
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
