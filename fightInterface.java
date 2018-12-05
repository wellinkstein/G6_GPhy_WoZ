import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Fight interface
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class fightInterface extends JFrame implements ActionListener
{
    
    private JButton buttonStartFight;
    private JPanel panelMain, panelBot, panelBig;
    private JLabel dialog, playerImg, monsterImg;
    private JFrame myFrame;
    private ImageIcon iconPlayer, iconMonster;

    /**
     * Constructor of objects class fightInterface
     */
    public fightInterface()
    {
        myFrame = new JFrame("Fight Interface");
        
        buttonStartFight = new JButton("Start Fight");
        buttonStartFight.addActionListener(this);
        
        dialog = new JLabel("Wow much damage very suspense");
        
        panelBot = new JPanel();
        panelBot.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.95;
        c.gridx = 0;
        c.gridy=0;
        panelBot.add(dialog, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0; 
        c.weightx = 0.05;
        panelBot.add(buttonStartFight, c);
        
        iconPlayer = new ImageIcon("player.jpg"); 
        playerImg = new JLabel();
        playerImg.setIcon(iconPlayer);
        
        iconMonster = new ImageIcon("darth_vader.jpg");
        monsterImg = new JLabel();
        monsterImg.setIcon(iconMonster);
        
        panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy=0;
        panelMain.add(playerImg,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy=0;
        panelMain.add(monsterImg,c);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelBig = new JPanel(new GridLayout(2,0));
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        
        myFrame.add(panelBig);
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
       // Game.fight();
    }
    
    public void displayFight()
    {
        //dialog.setText("");
    }
    
    //public void fighters
}
