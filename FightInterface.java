import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Fight interface
 *
 * @author Jérémie Guilbaud
 * @version 1.0
 */
public class FightInterface extends JPanel implements ActionListener
{

    private JPanel panelMain, panelBot, panelBig;
    private JLabel dialog, playerImg, monsterImg;
    private ImageIcon iconPlayer, iconMonster;
    private JButton buttonStartFight;
    private Game myGame;
    private Spot mySpot;

    /**
     * Constructor of objects class fightInterface
     */
    public FightInterface()
    {

        buttonStartFight = new JButton("Start Fight");
        buttonStartFight.addActionListener(this);

        dialog = new JLabel("<html><b>Combat logbook</b><br>--------------------------<br><br><br>");
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

        panelBot.add(dialog);

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
                buttonStartFight.setEnabled(true);
            }
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
            updateNameMonster("Cerberus! Don't worry, he won't bite. Or will he...<br><br>");
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
            updateNameMonster("Arachne! Be careful of her pointy fangs.<br><br>");
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
            updateNameMonster("Cyclops! He's got an eye on you.<br><br>");
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
            updateNameMonster("The Minotaur! May the Gods be with you.<br><br>");
            buttonStartFight.setEnabled(true);
        }
        else
        {
            buttonStartFight.setEnabled(false);
        }

        panelBig = new JPanel(new GridLayout(2,0));
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        panelBig.setVisible(true);
        add(panelBig);
    }

    /**
     * A method the print a text in the dialog box when the monster is dead
     */
    public void printDeadMonster(boolean ded)
    {
        if(ded==true)
        {
            dialog.setText(dialog.getText() + "The monster is dead!<br><br>");
        }
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
     * A method to enter text in the dialog box.
     * The text will be the description of the combat
     * @param String texte: text to be added to the combat logbook
     */
    public void updateCombatLogbook(String texte)
    {
        dialog.setText(dialog.getText() + texte + "<br>");
    }

    /**
     * Action listener for beginFight
     * @param ActionEvent e
     */

    public void actionPerformed(ActionEvent e)
    {
        if(myGame.getCurrentSpot().getMonster()!=null)
        {
            fight();
        }
    }

    /**
     * The fight starts. it ends when one of the characters dies
     * @return List<Integer> listDamage: the list of all the damage
     * that were inflicted during the fight.
     * If the list begins by "-1", it means that Theseus began the fight.
     * 
     */
    public void fight() 
    { 
        int damFighter;
        myGame.whoBegins();
        if(myGame.getFighter()==myGame.getPlayer()){
            updateCombatLogbook("Theseus begins the fight!");
        }
        else
        {
            updateCombatLogbook("The monster begins the fight!");
        }

        while (myGame.getFighter().HP!=0){
            damFighter=inflictDamage();
            if (myGame.getFighter()==myGame.getPlayer()){
                damFighter=damFighter+criticalHit();
            }
            myGame.setFighter(myGame.getFighter());
        }

        if (myGame.getFighter()==myGame.getPlayer()) { 
            myGame.setWinTrue();
        }
        else myGame.setWinFalse(); 
    }

    /**
     * The fighter inflicts damage to the other character in the spot
     * 
     */
    public int inflictDamage() 
    { 
        int dam=0;
        for (int i = 0; i < myGame.getCurrentSpot().getListCharacter().size(); i++)
        {
            if (myGame.getCurrentSpot().getListCharacter().get(i) != myGame.getFighter()){
                myGame.getCurrentSpot().getListCharacter().get(i).loseHp(myGame.getFighter().getDamage());
                dam = myGame.getCurrentSpot().getListCharacter().get(i).valLoseHp(myGame.getFighter().getDamage());
            }
        }
        return dam;
    }

    /**
     * 
     * @return int dam: return the damage with or without critical strike
     */
    public int criticalHit() 
    { 
        Random rand = new Random();
        int crit = rand.nextInt(100); 
        if (myGame.getPlayer().getCritRate()<=crit){
            int dam = (myGame.getFighter().getDamage())/2;
            for (int i = 0; i < myGame.getCurrentSpot().getListCharacter().size(); i++)
            {
                if (myGame.getCurrentSpot().getListCharacter().get(i) != myGame.getFighter()){
                    myGame.getCurrentSpot().getListCharacter().get(i).loseHp(dam);  
                }
            }
            return dam;
        }
        else return 0;
    }

    /**
     * A method to write in the dialog box the fight
     * use thread.wait to add delay
     *
     * public void fight()
     *{
     *
     *    try
     *    {
     *        Thread.sleep(1000);
     *    }
     *    catch(InterruptedException ex)
     *    {
     *        Thread.currentThread().interrupt();
     *    }
     *
     *}
     */
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
                updateNameMonster("Chimera! Lion head, goat body and snake tail... Definitely a failed genetic experiment.<br><br>");
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
                updateNameMonster("Cerberus! Don't worry, he won't bite. Or will he...<br><br>");
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
                updateNameMonster("Arachne! Be careful of her pointy fangs.<br><br>");
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
                updateNameMonster("Cyclops! He's got an eye on you.<br><br>");
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
                updateNameMonster("The Minotaur! May the Gods be with you.<br><br>"); 
                buttonStartFight.setEnabled(true);
            }
            else
            {
                buttonStartFight.setEnabled(false);
            }
        }
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        panelBig.setVisible(false);
        panelBig.setVisible(true);
        add(panelBig);

    }
}
