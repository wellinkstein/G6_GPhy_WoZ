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
    private JPanel panelMain, panelBot;
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
        panelBot.setLayout(new BorderLayout(2,0));
        panelBot.add(dialog, BorderLayout.WEST);
        panelBot.add(buttonStartFight, BorderLayout.EAST);
        
        panelMain = new JPanel();
       // panelMain.setLayout(new FlowLayout());
        panelMain.add(fight);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        myFrame.add(panelMain);
        myFrame.add(panelBot);
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
