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

/**
 * This class is an example of GridLayout Manager
 * 
 * @author Corentin Journay 
 * @version 04/12/2018
 */
public class AffichMainYohan extends JFrame implements ActionListener
{

    private Game myGame; 
    private JPanel panelBouton;
    private DialogScreenInterface panelDiag;
    private SpotItem panelSpotItem;
    private Inventory panelInventory;
    private NextSpot panelNextSpot; 
    private ItemDescription panelDesc; 
    private PlayerHead panelPlayer;
    private MonsterHead panelMonster; 
    private Scrolling panelLab;
    private Spot newSpot;
    private JMenuBar menuBar; 
    private JMenu menu; 
    private JMenuItem item; 
    private Container pane;
    private FightInterface panelCombat;
    
    public AffichMainYohan()
    {
        main();
    }
    
    public void main()
    {
        
        newSpot = new Spot();
        newSpot.setImageSpot("1234.png");
        myGame = new Game();
        
        myGame.move(myGame.getListSpot().get(9));
        
        //Grille du frame et des panels
        
        JFrame myFrame = new JFrame("Daedalus");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // myFrame.setSize(1366,768);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setUndecorated(true);
 
        pane= myFrame.getContentPane();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        panelLab = new Scrolling(myGame.getCurrentSpot(),this);
        panelLab.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 0.5;
        c.weighty = 0.6;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight=5;
        c.gridwidth=1;
        c.fill= GridBagConstraints.BOTH;
        pane.add(panelLab, c);
        
        panelPlayer = new PlayerHead(myGame.getPlayer());
        panelPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
        //panelPlayer.setBackground(Color.GREEN);
        //
        c.weightx = 0.25;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=2; //prend deux colonnes
        c.gridheight=1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(panelPlayer, c);
        
        
        panelMonster = new MonsterHead(myGame.getCurrentSpot().getMonster());
        panelMonster.setBorder(BorderFactory.createLineBorder(Color.black));
        //new JPanel();
        //        panelMonster.setBackground(Color.RED);
        c.weightx = 0.25;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(panelMonster, c);
        
        panelInventory= new Inventory(myGame.getPlayer(),this);
        panelInventory.setBorder(BorderFactory.createLineBorder(Color.black));
        // new JPanel();
        // panelInventory.setBackground(Color.ORANGE);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=3;
        c.gridheight=1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(panelInventory, c);
        
        panelSpotItem=new SpotItem(myGame.getCurrentSpot(),this);
        panelSpotItem.setBorder(BorderFactory.createLineBorder(Color.black));
        //new JPanel();
        // panelSpotItem.setBackground(Color.CYAN);
        //
        c.weightx = 0.125;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight=1;
        c.gridwidth=1;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(panelSpotItem, c);
        
        panelDesc= new ItemDescription(new Common("null", "", 0, 0, 0));
        panelDesc.setBorder(BorderFactory.createLineBorder(Color.black));
        //new JPanel();
        //panelDesc.setBackground(Color.PINK);
        c.weightx = 0.125;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(panelDesc, c);
        
        panelCombat= new FightInterface(this);
        panelCombat.setBorder(BorderFactory.createLineBorder(Color.black));
        //new FightInterface();
        //
        //panelCombat.setBackground(Color.BLACK);
        c.weightx = 0.25;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx =3;
        c.gridy = 2;
        pane.add(panelCombat, c);

         
        panelNextSpot = new NextSpot(myGame.getCurrentSpot(),this, "S");
        panelNextSpot.setBorder(BorderFactory.createLineBorder(Color.black));
        //new JPanel();
        // panelNextSpot.setBackground(Color.MAGENTA);
        //
        c.weightx = 0.25;
        c.weighty = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridheight=1;
        c.gridx =1;
        c.gridy = 3;
        pane.add(panelNextSpot, c);
        
        panelDiag = new DialogScreenInterface(myGame.printWelcome());
        panelDiag.setBorder(BorderFactory.createLineBorder(Color.black));
        // System.out.println(myGame.printWelcome());
        //panelDiag.setBackground(Color.YELLOW);
        c.weightx = 0.25;
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
        // myFrame.pack();
        myFrame.setVisible(true);
        
        
    }
    
    public void setDes(ItemDescription myDes)
    {
        panelDesc.removeAll();
        panelDesc.add(myDes);
        pane.revalidate();
        pane.repaint();
    }
    
    public void setDialog(DialogScreenInterface myDialog)
    {
        panelDiag.removeAll();
        panelDiag.add(myDialog);
        panelDiag.revalidate();
        panelDiag.repaint();
        //System.out.println("New Description");
    }
    
    // public void setPlayerHead(PlayerHead playerH)
    // {
        // panelPlayer.removeAll();
        // panelPlayer.add(playerH);
        // panelPlayer.revalidate();
        // panelPlayer.repaint();
        // //System.out.println("New Description");
    // }
    
    public void setScrolling()
    {
        panelLab.updateUI(myGame.getCurrentSpot());
    }
    
    public Game getGame(){
        return myGame;
    }
    
    public SpotItem getSpotItem()
    {
        return panelSpotItem;
    }
    
    public PlayerHead getPlayerHead()
    {
        return panelPlayer;
    }
    public Inventory getInventory()
    {
        return panelInventory;
    }
    
    public NextSpot getNextSpot()
    {
        return panelNextSpot; 
    }
       
    public MonsterHead getMonsterHead()
    {
        return panelMonster; 
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==item){
            System.exit(0);
        }
    }
    // public static void main(String[] args) {
        // //Schedule a job for the event-dispatching thread:
        // //creating and showing this application's GUI.
        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
            // public void run() {
                // createAndShowGUI();
            // }
        // });
    // }
}
