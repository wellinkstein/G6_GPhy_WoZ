import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import sun.audio.*;

/**
 * This class manages the main display of the game, it will recruit various interface classes and combine them in a grid bag layout.
 * 
 * 
 * @author Groupe 6 
 * @version 20/12/2018
 */
public class AffichMain extends JFrame implements ActionListener
{

    private Game myGame; 
    private JPanel panelBouton;//The buttons within the main panel
    private DialogScreenInterface panelDiag;//The dialog section of the interface
    private SpotItem panelSpotItem;//The spotItem section of the interface
    private Inventory panelInventory;//The inventory section of the interface
    private NextSpot panelNextSpot; //The NextSpot section of the interface
    private ItemDescription panelDesc; //The item description section of the interface
    private PlayerHead panelPlayer;//The Player Head section of the interface
    private MonsterHead panelMonster; //The Monster Head section of the interface
    private Scrolling panelLab;//The Scrolling aspect of the interface
    private Spot newSpot;
    private JMenuBar menuBar; //The menu bar allowing a user to exit at any time
    private JMenu menu; 
    private JMenuItem item; 
    private Container pane;
    private FightInterface panelCombat;//The fighting aspect of the interface
    
    /**
     * The constructor of the class calls the main function, this causes the game to be launched when an AffichMain is instantiated
     */
    public AffichMain()
    {
        main();
    }
    
    /**
     * The main function of AffichMain, this takes in all the components of the interface and puts them accrodingly in the gridbaglayout;
     */
    public void main()
    {
        try {
 
            Clip clip = AudioSystem.getClip();
            File soundFile = new File("rpg.wav");
            AudioInputStream inputStream = AudioSystem
                    .getAudioInputStream(soundFile);
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        newSpot = new Spot();
        newSpot.setImageSpot("1234.png");
        myGame = new Game();
        
        
        JFrame myFrame = new JFrame("Daedalus");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setUndecorated(true);
       
        
        pane= myFrame.getContentPane();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        pane.setLayout(new GridBagLayout());
       
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,3);
        
        panelLab = new Scrolling(myGame.getCurrentSpot(),this);
        panelLab.setBorder(BorderFactory.createLineBorder(Color.black));
        panelLab.setBackground(new Color(208,185,178));
        c.weightx = 0.4;
        c.weighty = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight=5;
        c.gridwidth=1;
        c.fill= GridBagConstraints.BOTH;
        pane.add(panelLab, c);
        
        panelPlayer = new PlayerHead(myGame.getPlayer());
        panelPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.3;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=2; //prend deux colonnes
        c.gridheight=1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(panelPlayer, c);
        
        
        panelMonster = new MonsterHead(myGame.getCurrentSpot().getMonster());
        panelMonster.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.3;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(panelMonster, c);
        
        panelInventory= new Inventory(myGame.getPlayer(),this);
        panelInventory.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.6;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=3;
        c.gridheight=1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(panelInventory, c);
        
        panelSpotItem=new SpotItem(myGame.getCurrentSpot(),this);
        panelSpotItem.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.15;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight=1;
        c.gridwidth=1;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(panelSpotItem, c);
        
        panelDesc= new ItemDescription(new Common("null", "", 0, 0, 0));
        panelDesc.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.15;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(panelDesc, c);
        
        panelCombat= new FightInterface(this);
        panelCombat.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.3;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx =3;
        c.gridy = 2;
        pane.add(panelCombat, c);

         
        panelNextSpot = new NextSpot(myGame.getCurrentSpot(),this, "S");
        panelNextSpot.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.3;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridheight=1;
        c.gridx =1;
        c.gridy = 3;
        pane.add(panelNextSpot, c);
        
        panelDiag = new DialogScreenInterface(myGame.printWelcome());
        panelDiag.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.3;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx =3;
        c.gridy = 3;
        pane.add(panelDiag, c);
        
        //Création de la barre de menu
        this.menuBar = new JMenuBar();
        //Installation dans la fenêtre
        myFrame.setJMenuBar(menuBar);
        //Construction du premier menu
        menu = new JMenu("Menu");

        this.menuBar.add(menu);
        this.item = new JMenuItem("Quit");
        menu.add(item);
        item.addActionListener(this);
        //myFrame.pack();
        myFrame.setVisible(true);
        
        
    }
    
    /**
     * A method that sets new descriptions, and removing the old ones
     */
    public void setDes(ItemDescription myDes)
    {
        panelDesc.removeAll();
        panelDesc.add(myDes);
        pane.revalidate();
        pane.repaint();
    }
    
    /**
     * A method that removes old dialog and sets the new dialog
     */
    public void setDialog(String myDialog)
    {
        panelDiag.removeAll();
        panelDiag.add(new DialogScreenInterface(myDialog));
        panelDiag.revalidate();
        panelDiag.repaint();
        //System.out.println("New Description");
    }
    
    /**
     * A method that created the GameOver interface
     */
    public void gameOverFrame(){
        GameOver over = new GameOver();
    }
    
    /**
     * A method that sets the youWon frame
     */
    public void youWonFrame(){
        YouWon over = new YouWon(myGame.youWon());
    }
    
    /**
     * A method that sets the Scrolling
     */
    public void setScrolling()
    {
        panelLab.updateUI(myGame.getCurrentSpot());
    }
    
    /**
     * A method that sets the Fight interface
     */
    public void setFightInterface()
    {
      panelCombat.updatePanel(this);
    }
    
    /**
     * get for Game
     */
    public Game getGame(){
        return myGame;
    }
    
    /**
     * get for SpotItem
     */
    public SpotItem getSpotItem()
    {
        return panelSpotItem;
    }
    
    /**
     * A getter for PlayerHead
     */
    public PlayerHead getPlayerHead()
    {
        return panelPlayer;
    }
    
    /**
     * A getter for the inventory interface
     */
    public Inventory getInventory()
    {
        return panelInventory;
    }
    
    /**
     * A getter for Next Spot
     */
    public NextSpot getNextSpot()
    {
        return panelNextSpot; 
    }
       
    /**
     * A getter for Monster Head
     */
    public MonsterHead getMonsterHead()
    {
        return panelMonster; 
    }
    
    /**
     * A getter for scrolling
     */
    public Scrolling getScrolling()
    {
        return panelLab;
    }
    
    /**
     * The action event for the close function of the menu
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==item){
            System.exit(0);
        }
    }

}
