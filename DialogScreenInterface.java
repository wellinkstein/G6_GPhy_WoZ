
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A dialog screen with some text
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class DialogScreenInterface extends JFrame implements ActionListener
{
    
    private JButton buttonClose;
    private JPanel myPanel;
    private JLabel dialog;
    private JFrame myFrame;

    /**
     * Constructeur of DialogScreenInterface
     */
    public DialogScreenInterface()
    {
        JFrame myFrame;
        myFrame = new JFrame("Dialog Screen");
        
        buttonClose = new JButton("Close");
        buttonClose.addActionListener(this);
        
        dialog = new JLabel("Test");
        
        myPanel = new JPanel();
        
        myPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.anchor = GridBagConstraints.CENTER;
        myPanel.add(dialog, c);
        
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.PAGE_END;
        myPanel.add(buttonClose, c);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        myFrame.dispose();
    }
    
    public void displayDescription(String description)
    {
        dialog.setText(description);
    }
}
