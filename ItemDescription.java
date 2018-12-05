import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class ItemDescription here.
 *
 * @author (Ludivine Harault)
 * @version (2018-12-05)
 */
public class ItemDescription extends JPanel implements ActionListener
{
    JPanel myPanel;
    JPanel myPanel2, bigPanel;
    JButton myButton;
    JFrame myFrame;
    JLabel myLabel,myLabel1, label;
    // private Common item; 
    // private Spot spot; 

    /**
     * Constructor for objects of class ItemDescription
     */
    public ItemDescription(Item item, Spot spot)
    {
        // Spot spot= new Spot(); 
        // Common item= new Common("Iron Sword","khzie",3,0,0); 
        // spot.addItemSpot(item); 
        myPanel = new JPanel();
        myPanel2 = new JPanel();
        bigPanel = new JPanel();
        //JFrame myFrame;
        myButton = new JButton ("Close");

        bigPanel.setLayout(new GridLayout(0,1));
        myPanel.setLayout(new GridLayout(1,2));
        if (item !=null){
            if (item.getName()=="Iron Sword"){
                Icon icon= new ImageIcon("IronSword.jpg"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Iron Dagger"){
                Icon icon= new ImageIcon("IronDagger.png"); 
                JLabel label= new JLabel(icon);
                 myPanel.add(label);
            }
            else if (item.getName()=="Standard Bow"){
                Icon icon= new ImageIcon("StandardBow.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Iron Armor"){
                Icon icon= new ImageIcon("IronArmor.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Iron Shield"){
                Icon icon= new ImageIcon("IronShield.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Wooden Shield"){
                Icon icon= new ImageIcon("WoodenShield.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Health Potion"){
                Icon icon= new ImageIcon("HealthPotion.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Ariadne's golden thread"){
                Icon icon= new ImageIcon("AriadneGoldenThread.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Ares's sword"){
                Icon icon= new ImageIcon("AresSword.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Artemis's bow"){
                Icon icon= new ImageIcon("ArtemisBow.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Aegis shield"){
                Icon icon= new ImageIcon("AegisShield.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }
            else if (item.getName()=="Hermes's sandals"){
                Icon icon= new ImageIcon("HermesSandals.png"); 
                JLabel label= new JLabel(icon); 
                 myPanel.add(label);
            }

            myLabel= new JLabel(item.getName());
            myLabel1= new JLabel(item.getDescription()); 
        }
        //myFrame = new JFrame("DESCRITPION");
        myPanel2.setLayout(new GridLayout(2,1)); 
        myPanel.add(myLabel); 
        myPanel2.add(myLabel1); 
        myPanel2.add(myButton);
        bigPanel.add(myPanel); 
        bigPanel.add(myPanel2); 
        
        add(bigPanel); 
        // myFrame = new JFrame();
        // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // myFrame.add(bigPanel);
        // myFrame.setSize(150, 150);
        // myFrame.pack();
        // myFrame.setVisible(true);
    }
            


    // myFrame = new JFrame();
    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // myFrame.add(bigPanel);
    // myFrame.setSize(150, 150);
    // myFrame.pack();
    // myFrame.setVisible(true);
 
    /**
     * 
     */
     public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == myButton)
            {
                bigPanel.setVisible(false); 
                // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    }

    
    
}
