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
    private Game myGame;
    private Spot mySpot;

    /**
     * Constructor of objects class fightInterface
     */
    public fightInterface()
    {
        myFrame = new JFrame("Fight Interface");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myGame = new Game();
        mySpot = new Spot();

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

        panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());

        iconPlayer = new ImageIcon("theseus.png"); 
        playerImg = new JLabel();
        playerImg.setIcon(iconPlayer);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy=0;
        panelMain.add(playerImg,c);

        if (myGame.getCurrentSpot().getMonster() != null)
        {
            iconMonster = new ImageIcon("darth_vader.jpg");
            monsterImg = new JLabel();
            monsterImg.setIcon(iconMonster);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy=0;
            panelMain.add(monsterImg,c);
        }

        panelBig = new JPanel(new GridLayout(2,0));
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        myFrame.add(panelBig);
        myFrame.pack();
        myFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        myGame.fight();
    }

    public void displayFight()
    {
        //dialog.setText("");
    }

    //public void fighters
}
