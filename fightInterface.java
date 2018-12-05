import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Fight interface
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class fightInterface extends JFrame
{
    
    private JButton buttonStartFight;
    private JPanel panelMain, panelBot, panelBig;
    private JLabel dialog, fight;

    /**
     * Constructor of objects class fightInterface
     */
    public fightInterface()
    {
        JFrame myFrame;
        myFrame = new JFrame("Fight Interface");
        
        buttonStartFight = new JButton("Start Fight");
        
        dialog = new JLabel("Test");
        fight = new JLabel("Fight");
        
        panelBot = new JPanel();
        panelBot.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.95;
        c.gridx = 0;
        c.gridy=0;
        panelBot.add(dialog, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipady = 0; 
        //c.weighty = 1.0;
        //c.anchor = GridBagConstraints.PAGE_END;
        //c.insets = new Insets(10,0,0,0);
        c.gridx = 1; 
        //c.gridwidth = 2;
        c.gridy = 0; 
        c.weightx = 0.05;
        panelBot.add(buttonStartFight, c);
        
        
        panelMain = new JPanel();

        panelMain.add(fight);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelBig = new JPanel(new GridLayout(2,0));
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        
        myFrame.add(panelBig);
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
}