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
 * @author Corentin Journay 
 * @version 04/12/2018
 */
public class Inventory extends JPanel
implements ActionListener
{

    private ArrayList<JButton> content = new ArrayList<JButton>();
    private Player monJoueur;
    private JLabel myLabel; 
    private JPanel myPanel, myPanel1, myBigPanel; 
    private Spot spot;
    private AffichMainYohan myMain;

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
        // myFrame = new JFrame("Inventory");
        // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // myFrame.setLayout(new GridLayout(0,1));
        myPanel = new JPanel();
        myPanel1= new JPanel(); 
        myBigPanel=new JPanel();
        
        myBigPanel.removeAll();
        myPanel.removeAll();
        myPanel1.removeAll();
        content.clear();
        
        for(int i = 0; i <= (monJoueur.getNumberItemPossess()-1); i++)
        {
            content.add(new JButton(monJoueur.getItems(i).getName()));
            content.add(new JButton("Drop Item"));
        }

        
        myLabel = new JLabel ("Your inventory",JLabel.CENTER);
        myPanel.setLayout(new GridLayout(1,monJoueur.getNumberItemPossess()));
        myPanel1.setLayout(new GridLayout(1,1));
        myPanel1.add(myLabel); 

        for(int i = 0; i <= (content.size()-1); i++)
        {
            EcouteurInventory e = new EcouteurInventory(this, myMain);
            content.get(i).addActionListener(e);
            myPanel.add(content.get(i));
        }

        myBigPanel.setLayout(new GridLayout(2,1)); 
        myBigPanel.add(myPanel1); 
        myBigPanel.add(myPanel); 

        add(myBigPanel); 
        //myBigPanel.setVisible(false); 

    }

    public void actionPerformed (ActionEvent e)
    {
        for(int i = 0; i <= (content.size()-1); i++)
        {
            if(e.getSource() == content.get(i))
            {
                System.out.println("Bouton "+i);
                if((i%2)==0)
                {
                    System.out.println("Description of the item"+(i%2));
                }
                else
                {
                    System.out.println("Dropping");
                    monJoueur.dropItemNb((i-1));
                    myBigPanel.revalidate();
                }
            }
        }
    }
    public Player getPlayer()
    {
        return monJoueur;
    }
    
    public ArrayList<JButton> getContent(){
        return content;
    }
   
}