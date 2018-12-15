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
    private Item itemDes;  //The item displays

    /**
     * Constructor for objects of class ItemDescription
     * @param Item the item for the description of the item
     */
    public ItemDescription(Item item)
    {
        itemDes=item; 
        showItemDes(item); //Display the panel item
    }

    /**
     * The method showItemDes allows us to display the item
     * @param Item the item that we display
     */
    public void showItemDes(Item item)
    {
        removeAll(); //remove all the panel

        //Create panel and button
        myPanel = new JPanel();
        myPanel2 = new JPanel();
        bigPanel = new JPanel();

        myButton = new JButton ("Close");
        myButton.setBackground(Color.gray); 
        myButton.setForeground(Color.white); 
        myButton.addActionListener(this);

        bigPanel.setLayout(new GridLayout(2,1));
        myPanel.setLayout(new GridLayout(1,2));
        //Display the icon of the item
        if (item !=null){
            if (item.getName()=="null")
            {
                Icon icon= new ImageIcon("ItemNull.png"); 
                JLabel label= new JLabel(icon); 

                JLabel label2= new JLabel(icon); 
                myPanel.add(label);
                myPanel2.add(label2);
            }
            else{
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
                //Create the label for the name and the description of the item
                //label.setPreferredSize(new Dimension(100,100));
                //label.setSize(100,100);
                myLabel= new JLabel(item.getName());
                myLabel1= new JLabel(item.getDescription()); 
                myPanel2.setLayout(new GridLayout(3,0));
                myPanel2.add(myLabel,BorderLayout.CENTER); 
                myPanel2.add(myLabel1,BorderLayout.CENTER); 
                myPanel2.add(myButton,BorderLayout.CENTER);

            }

        }

        bigPanel.add(myPanel);
        bigPanel.add(myPanel2);
        add(bigPanel);
        setVisible(true);
        //for update the panel
        revalidate();
        repaint();
    }

    /**
     * The actionPerformed for the class ItemDescription
     * The panel display a gray image when we click on the button close
     * @param ActionEvent the event of the button close
     */
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource() == myButton)
        {
            //this.setVisible(false);
            showItemDes(new Common("null", "", 0, 0, 0)); 
        }
    }

    
}

