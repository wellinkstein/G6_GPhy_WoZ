import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The class ItemDescription is the interface of all the item in the inventer 
 * or the SpotItem
 *
 * @author (Ludivine Harault)
 * @version (2018-12-12)
 */
public class ItemDescription extends JPanel implements ActionListener
{
    JPanel myPanel2, bigPanel, myPanel; //All the panel for the class ItemDescription
    JButton myButton; //The button close for the item descriprtion
    JLabel myLabel,myLabel1, label; //all the label for the item description
    private Item itemDes; 

    /**
     * Constructor for objects of class ItemDescription
     * @param Item the item for the description of the item
     */
    public ItemDescription(Item item)
    {
        itemDes=item; 
        showItemDes(item); 
    }

    /**
     * ShowItemDes
     */
    public void showItemDes(Item item)
    {
         removeAll();
        myPanel = new JPanel();
        myPanel2 = new JPanel();
        bigPanel = new JPanel();

        myButton = new JButton ("Close");
        myButton.addActionListener(this);

        bigPanel.setLayout(new GridLayout(0,1));
        myPanel.setLayout(new GridLayout(1,2));
        if (item !=null){
            if (item.getName()=="Iron Sword"){
                Icon icon= new ImageIcon("IronSword.png"); 
                JLabel label= new JLabel(icon);
                label.setPreferredSize(new Dimension(50,50));
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
                Icon icon= new ImageIcon("GoldenThread.png"); 
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
            else {
                Icon icon= new ImageIcon("ItemNull.png"); 
                JLabel label= new JLabel(icon); 
                myPanel.add(label); 
            }

            myLabel= new JLabel(item.getName());
            myLabel1= new JLabel(item.getDescription()); 
        }
        else{
            Icon icon= new ImageIcon("ItemNull.png"); 
                JLabel label= new JLabel(icon); 
                myPanel.add(label); 
            }
       
        bigPanel.setLayout(new GridLayout(1,2));
        myPanel2.setLayout(new GridLayout(3,0));
        myPanel2.add(myLabel,BorderLayout.CENTER); 
        myPanel2.add(myLabel1,BorderLayout.CENTER); 
        myPanel2.add(myButton,BorderLayout.CENTER);
 
        bigPanel.add(myPanel);
        bigPanel.add(myPanel2);
        add(bigPanel);
        setVisible(true);
        revalidate();
        repaint();
    }

    /**
     * The actionPerformed for the class ItemDescription
     * @param ActionEvent the event of the button close
     */
     public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == myButton)
            {
                //this.setVisible(false);
                showItemDes(itemDes); 
            }
    }

    
    
}

