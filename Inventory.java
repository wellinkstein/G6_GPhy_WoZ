import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.*;
import java.util.Set;

/**
 * This class is an example of GridLayout Manager
 * 
 * @author Groupe 7  
 * @version 04/12/2018
 */
public class Inventory extends JPanel
{

    private ArrayList<JButton> content = new ArrayList<JButton>();
    private Player monJoueur;
    private JLabel myLabel; 
    private JPanel myPanel, myPanel1, myBigPanel; 
    private Spot spot;
    private JComboBox combo; 
    private AffichMainYohan myMain;
    private JButton myButton; 

    public Inventory(Player theseus, AffichMainYohan cont)
    {
        monJoueur= theseus;
        myMain = cont;
        showPlayerItem(monJoueur,myMain);
    }
       
    public void showPlayerItem(Player theseus, AffichMainYohan myMain)
    {
        removeAll();
        
        JPanel myPanel;
        JLabel myLabel; 

        myPanel = new JPanel();
        myPanel1= new JPanel(); 
        myBigPanel=new JPanel();
        myBigPanel.removeAll();
        myPanel.removeAll();
        myPanel1.removeAll();
        content.clear();
        
        myButton = new JButton("Drop"); 
        combo = new JComboBox(); 
        EcouteurInventory e = new EcouteurInventory(this, myMain);
        
        for(int i = 0; i <= (monJoueur.getNumberItemPossess()-1); i++)
        {
           // content.add(new JButton(monJoueur.getItems(i).getName()));
           // content.add(new JButton("Drop Item"));
           combo.addItem(monJoueur.getItems(i).getName());
           combo.addActionListener(e); 
           
        }

        myButton.addActionListener(e); 
        myLabel = new JLabel ("Your inventory",JLabel.CENTER);
        //myPanel.setLayout(new GridLayout(2,monJoueur.getNumberItemPossess()));
        myPanel.setLayout(new GridLayout(1,monJoueur.getNumberItemPossess()));
        myPanel1.setLayout(new GridLayout(1,0));
        myPanel1.add(myLabel); 
        myPanel.add(combo); 
        myPanel.add(myButton); 

        // for(int i = 0; i <= (content.size()-1); i+=2)
        // {
            // EcouteurInventory e = new EcouteurInventory(this, myMain);
            // content.get(i).addActionListener(e);
            // myPanel.add(content.get(i));
        // }
        
        // for(int i = 1; i <= (content.size()-1); i+=2)
        // {
            // EcouteurInventory e = new EcouteurInventory(this, myMain);
            // content.get(i).addActionListener(e);
            // myPanel.add(content.get(i));
        // }

        myBigPanel.setLayout(new GridLayout(2,1)); 
        myBigPanel.add(myPanel1); 
        myBigPanel.add(myPanel); 
        myBigPanel.setVisible(true); 
        add(myBigPanel); 
        
        revalidate();
        repaint();
        setVisible(true);
        //myBigPanel.setVisible(false); 

    }
    
    public Player getPlayer()
    {
        return monJoueur;
    }
    
    public ArrayList<JButton> getContent(){
        return content;
    }
    
    public JButton getMyButton()
    {
        return myButton; 
    }
    
    public JComboBox getCombo(){
        return combo; 
    }
}