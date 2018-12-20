import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Fight interface
 * This class handles the fight interface that will appear in the main interface
 * 
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
    private AffichMainYohan affichMain;
    private Spot mySpot;
    private DialogScreenInterface youWon, gameOver, getOut, youWonFight;
    private JScrollPane scroller;
 
    /**
     * Constructor of objects class fightInterface
     */
    public FightInterface(AffichMainYohan affichMainYohan)
    {
        affichMain=affichMainYohan;
        updatePanel(affichMain);
    }

    /**
     * A method the print a text in the dialog box when the monster is dead
     * @Param boolean ded: Takes in a boolean to check if the monster is dead
     * 
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
        //panelBig.revalidate();
        //panelBig.repaint();  
    }

    /**
     * Action listener for beginFight
     * @param ActionEvent e
     */

    public void actionPerformed(ActionEvent e)
    {
        if(affichMain.getGame().getCurrentSpot().getMonster()!=null)
        {
            fight();
            affichMain.getPlayerHead().showPlayerHead(affichMain.getGame().getPlayer()); 
            affichMain.getMonsterHead().showMonsterHead(affichMain.getGame().getCurrentSpot().getMonster()); 
            buttonStartFight.setEnabled(false);
        }
    }

    /**
     * The fight starts. it ends when one of the characters dies
     * 
     */
    public void fight() 
    { 
        int damFighter;
        affichMain.getGame().whoBegins();
        // System.out.println("starter:"+affichMain.getGame().whoBegins().getName());
        if(affichMain.getGame().getFighter()==affichMain.getGame().getPlayer()){
            updateCombatLogbook("Theseus begins the fight!");
        }
        else
        {
            updateCombatLogbook("The monster begins the fight!");
        }
        
        //System.out.println("fighter: "+affichMain.getGame().getFighter().getDamage());
        //System.out.println("player: "+affichMain.getGame().getPlayer().getDamage());

        while (affichMain.getGame().getFighter().HP!=0){
            //System.out.println("fighter befor inflict: "+affichMain.getGame().getFighter().getHP());
            //damFighter=affichMain.getGame().inflictDamage();
            damFighter=affichMain.getGame().inflictDamage();
            //System.out.println("fighter after inflict: "+affichMain.getGame().getFighter().getHP());
            //System.out.println("fighter1: "+ affichMain.getGame().getFighter());
            //System.out.println(damFighter);
            if (affichMain.getGame().getFighter()==affichMain.getGame().getPlayer()){
                damFighter=damFighter+affichMain.getGame().criticalHit(); // add critical hit damage A MODIFIER pour ne pas prendre en compte armure quand crit
            }
            if (affichMain.getGame().getFighter()==affichMain.getGame().getPlayer())
            {
                updateCombatLogbook("Theseus inflicts" + damFighter + "damages to the monster."); 
            }
            else
            {
                updateCombatLogbook("The monster inflicts" + damFighter + "damages to Theseus.");
            }

            affichMain.getGame().setFighter(affichMain.getGame().getFighter()); // the fighter changes
            //System.out.println("fighter2: "+ affichMain.getGame().getFighter());
            //try
            //{
            //    Thread.sleep(1000);
            //}
            //catch(InterruptedException ex)
            //{
            //    Thread.currentThread().interrupt();
            //}
            //break;
        }

        if (affichMain.getGame().getFighter()==affichMain.getGame().getPlayer()) { 

            gameOver = new DialogScreenInterface(affichMain.getGame().gameOver());
            affichMain.setDialog(gameOver); // ici bloquer le scrolling
        }
        else if(affichMain.getGame().getFighter()==affichMain.getGame().getCurrentSpot().getBoss()&& affichMain.getGame().getPlayer().getThread()==true)
        {
            //Checks if minotaur dead and player has the golden thread 
            youWon = new DialogScreenInterface(affichMain.getGame().youWon());
            affichMain.setDialog(youWon);
            affichMain.getGame().getPlayer().gainXp(1);
            affichMain.getGame().getPlayer().adjustCritRate();
        }
        else if (affichMain.getGame().getFighter()==affichMain.getGame().getCurrentSpot().getBoss())
        {
            getOut = new DialogScreenInterface(affichMain.getGame().getOut());
            affichMain.setDialog(getOut);
            affichMain.getGame().bossDead();
            affichMain.getGame().getPlayer().gainXp(1);
            affichMain.getGame().getPlayer().adjustCritRate();
        }
        else
        {
            youWonFight = new DialogScreenInterface(affichMain.getGame().youWonFight());
            affichMain.setDialog(youWonFight);
            affichMain.getGame().monsterDead();
            affichMain.getGame().getPlayer().gainXp(1);
            affichMain.getGame().getPlayer().adjustCritRate();
            affichMain.getScrolling().getButton1().setEnabled(true);
            affichMain.getScrolling().getButton2().setEnabled(true);
            affichMain.getScrolling().getButton3().setEnabled(true);
            affichMain.getScrolling().getButton4().setEnabled(true);
            if(affichMain.getGame().getCurrentSpot().getExits("Z") == null)
            {affichMain.getScrolling().getButton1().setEnabled(false);}
            if(affichMain.getGame().getCurrentSpot().getExits("D") == null)
            {affichMain.getScrolling().getButton2().setEnabled(false);}
            if(affichMain.getGame().getCurrentSpot().getExits("S") == null)
            {affichMain.getScrolling().getButton3().setEnabled(false);}
            if(affichMain.getGame().getCurrentSpot().getExits("Q") == null)
            {affichMain.getScrolling().getButton4().setEnabled(false);}
          
        }
    }

    

    /**
     * A method to update the panel. If there is a monster in the currentSpot, the 
     * picture of the monster and his description will be added to the panel.
     */
    public void updatePanel(AffichMainYohan affichMainYohan)
    {
        removeAll();
        affichMain=affichMainYohan;
        
        buttonStartFight = new JButton("Start Fight");
        buttonStartFight.addActionListener(this);
        
        
        
        dialog = new JLabel("<html><b>Combat logbook</b><br>--------------------------<br><br><br>");
        //scroller.add(dialog);
        scroller = new JScrollPane(dialog);
        scroller.setPreferredSize(new Dimension (400,200));
        panelBot = new JPanel();
        panelBot.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.95;
        c.gridx = 0;
        c.gridy=0;
        panelBot.add(scroller, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0; 
        c.weightx = 0.05;
        panelBot.add(buttonStartFight, c);

        panelBot.add(scroller);
        
        
        panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());

        iconPlayer = new ImageIcon("TheseusFinal.png"); 
        playerImg = new JLabel();
        playerImg.setIcon(iconPlayer);
        // playerImg.setPreferredSize(new Dimension(150,150));
        // playerImg.setSize(150,150);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy=0;
        panelMain.add(playerImg,c);

        if (affichMain.getGame().getCurrentSpot().getMonster() != null)
        {
            if(affichMain.getGame().getCurrentSpot().getMonster().getName() == "Medusa") // Medusa
            {
                iconMonster = new ImageIcon("MedusaFinal.png");
                monsterImg = new JLabel();
                monsterImg.setIcon(iconMonster);
               // monsterImg.setPreferredSize(new Dimension(150,150));
                //monsterImg.setSize(150,150);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = 1;
                c.gridy=0;
                panelMain.add(monsterImg,c);
                updateNameMonster("Medusa! Her sight might be more dangerous than the snakes on her head.<br><br>");
                buttonStartFight.setEnabled(true);
            }
            else if(affichMain.getGame().getCurrentSpot().getMonster().getName() == "Chimera") // Chimera
        {
            iconMonster = new ImageIcon("ChimeraFinal.png");
            monsterImg = new JLabel();
            monsterImg.setIcon(iconMonster);
            //monsterImg.setPreferredSize(new Dimension(150,150));
            //monsterImg.setSize(150,150);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy=0;
            panelMain.add(monsterImg,c);
            updateNameMonster("Chimera! Lion head, goat body and snake tail... Definitely a failed genetic experiment.<br><br>");
            buttonStartFight.setEnabled(true);
        }
        else if(affichMain.getGame().getCurrentSpot().getMonster().getName() == "Cerberus") // Cerberus
        {
            iconMonster = new ImageIcon("CerberusFinal.png");
            monsterImg = new JLabel();
            monsterImg.setIcon(iconMonster);
            //monsterImg.setPreferredSize(new Dimension(150,150));
            //monsterImg.setSize(150,150);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy=0;
            panelMain.add(monsterImg,c);
            updateNameMonster("Cerberus! Don't worry, he won't bite. Or will he...<br><br>");
            buttonStartFight.setEnabled(true);
        }
        else if(affichMain.getGame().getCurrentSpot().getMonster().getName() == "Arachne") // Arachne
        {
            iconMonster = new ImageIcon("ArachneFinal.png");
            monsterImg = new JLabel();
            monsterImg.setIcon(iconMonster);
            //monsterImg.setPreferredSize(new Dimension(150,150));
            //monsterImg.setSize(150,150);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy=0;
            panelMain.add(monsterImg,c);
            updateNameMonster("Arachne! Be careful of her pointy fangs.<br><br>");
            buttonStartFight.setEnabled(true);
        }
        else if(affichMain.getGame().getCurrentSpot().getMonster().getName() == "Cyclops") // Cyclops
        {
            iconMonster = new ImageIcon("CyclopsFinal.png");
            monsterImg = new JLabel();
            monsterImg.setIcon(iconMonster);
            //monsterImg.setPreferredSize(new Dimension(150,150));
            //monsterImg.setSize(150,150);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy=0;
            panelMain.add(monsterImg,c);
            updateNameMonster("Cyclops! He's got an eye on you.<br><br>");
            buttonStartFight.setEnabled(true);
        }
        else if(affichMain.getGame().getCurrentSpot().getMonster().getName() == "Minotaur") // Minotaur
        {
            iconMonster = new ImageIcon("MinotaurFinal.png");
            monsterImg = new JLabel();
            monsterImg.setIcon(iconMonster);
            //monsterImg.setPreferredSize(new Dimension(150,150));
            //monsterImg.setSize(150,150);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy=0;
            panelMain.add(monsterImg,c);
            updateNameMonster("The Minotaur! May the Gods be with you.<br><br>");
            buttonStartFight.setEnabled(true);
        }
        }

        else
        {
            buttonStartFight.setEnabled(false);
        }
        
        panelBig = new JPanel(new GridLayout(2,0));
        // panelBot.setPreferredSize(new Dimension(400,400));
        // panelBot.setSize(400,400);
        panelBig.add(panelMain);
        panelBig.add(panelBot);
        //panelBig.add(Scroller);
        panelBig.setVisible(true);
        add(panelBig);
        revalidate();
        repaint();
    }
}
