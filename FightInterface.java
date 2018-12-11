import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Fight interface
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class FightInterface extends JFrame implements ActionListener
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
    public FightInterface()
    {
        myFrame = new JFrame("Fight Interface");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BEGIN POUR TEST
        myGame = new Game();
        mySpot = new Spot();
        Legendary artemisBow= new Legendary("Artemis's bow","",4,0,0);
        LesserBoss medusa= new LesserBoss(20,"Arachne",5,4,1,"",artemisBow);

        //mySpot.addCharacterSpot(medusa);
        myGame.setCurrentSpot(mySpot);
        // END POUR TEST

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
            if(myGame.getCurrentSpot().getMonster().getName() == "Medusa") // Medusa
            {
                iconMonster = new ImageIcon("MedusaFinal.png");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);

                buttonStartFight.setEnabled(true);
            }

            else if(myGame.getCurrentSpot().getMonster().getName() == "Chimera") // Chimera
            {
                iconMonster = new ImageIcon("chimera.jpg");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);

                buttonStartFight.setEnabled(true);
            }
            else if(myGame.getCurrentSpot().getMonster().getName() == "Cerberus") // Cerberus
            {
                iconMonster = new ImageIcon("CerberusFinal.png");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);

                buttonStartFight.setEnabled(true);
            }
            else if(myGame.getCurrentSpot().getMonster().getName() == "Arachne") // Arachne
            {
                iconMonster = new ImageIcon("ArachneFinal.png");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);

                buttonStartFight.setEnabled(true);
            }
            else if(myGame.getCurrentSpot().getMonster().getName() == "Cyclops") // Cyclops
            {
                iconMonster = new ImageIcon("CyclopsFinal.png");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);

                buttonStartFight.setEnabled(true);
            }
            else if(myGame.getCurrentSpot().getMonster().getName() == "Minotaur") // Minotaur
            {
                iconMonster = new ImageIcon("MinotaurFinal.png");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);

                buttonStartFight.setEnabled(true);
            }
        }
        else
        {
            buttonStartFight.setEnabled(false);
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
        if(myGame.getCurrentSpot().getMonster()!=null)
        {
            myGame.fight();
        }
    }

    public void displayFight()
    {
        dialog.setText("");
    }

    //public void fighters
}
