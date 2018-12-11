import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Fight interface
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class FightInterface extends JPanel //implements ActionListener
{

    private JPanel panelMain, panelBot, panelBig;
    private JLabel dialog, playerImg, monsterImg;
    private ImageIcon iconPlayer, iconMonster;
    private Game myGame;
    private Spot mySpot;

    /**
     * Constructor of objects class fightInterface
     */
    public FightInterface()
    {

        dialog = new JLabel("<html><b>Combat logbook</b><br>--------------------------<br><br><br>");

        panelBot = new JPanel();
        panelBot.setLayout(new GridBagLayout());

        panelBot.add(dialog);

        GridBagConstraints c = new GridBagConstraints();

        panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());

        iconPlayer = new ImageIcon("TheseusFinal.png"); 
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
                updateNameMonster("Medusa! Her sight might be more dangerous than the snakes on her head.<br><br>");
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
                updateNameMonster("Chimera! Lion head, goat body and snake tail... Definitely a failed genetic experiment.<br><br>");
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
                updateNameMonster("Cerberus! Don't worry, he won't bite. Or will he...<br><br>");
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
                updateNameMonster("Arachne! Be careful of her pointy fangs.<br><br>");
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
                updateNameMonster("Cyclops! He's got an eye on you.<br><br>");

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
                updateNameMonster("The Minotaur! May the Gods be with you.<br><br>");

            }
        }

        panelBig = new JPanel(new GridLayout(2,0));
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        panelBig.setVisible(true);
        add(panelBig);
    }
    
    /**
     * A method to enter the name of the monster that Theseus is fighting
     * with a description.
     * @param String texte: text to be added to the combat logbook
     */
    public void updateNameMonster(String texte)
    {
        dialog.setText(dialog.getText() + "You are fighting " + texte);
    }
    
    /**
     * A method to update the panel. If there is a monster in the currentSpot, the 
     * picture of the monster and his description will be added to the panel.
     */
    public void updatePanel()
    {

        GridBagConstraints c = new GridBagConstraints();

        iconPlayer = new ImageIcon("TheseusFinal.png"); 
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
                updateNameMonster("Medusa! Her sight might be more dangerous than the snakes on her head.<br><br>");
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
                updateNameMonster("Chimera! Lion head, goat body and snake tail... Definitely a failed genetic experiment.<br><br>");
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
                updateNameMonster("Cerberus! Don't worry, he won't bite. Or will he...<br><br>");
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
                updateNameMonster("Arachne! Be careful of her pointy fangs.<br><br>");
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
                updateNameMonster("Cyclops! He's got an eye on you.<br><br>");

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
                updateNameMonster("The Minotaur! May the Gods be with you.<br><br>");

            }
        }
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        panelBig.setVisible(false);
        panelBig.setVisible(true);
        add(panelBig);
        
    }
}
