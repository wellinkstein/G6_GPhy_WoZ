import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.geom.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
/**
 * NextSpot displays the monster present in the spot defined by the chosen direction
 *
 * @author (Yohan Lefol)
 * @version (2018-12-04)
 */
public class NextSpot extends JPanel implements ActionListener
{
    private Game myGame;
    private Spot mySpot;
    private JButton myFightButton,myFleeButton;
    private JPanel myPanel,myFightPanel,myFleePanel,bigPanel,bigButtonPanel;
    private JFrame myFrame,myFrame2;
    private JLabel myLabel,myLabel2,myLabel3;
    /**
     * Constructor for objects of class NextSpot.
     */
    public NextSpot(Spot gameSpot)
    // public NextSpot()
    {
        myPanel = new JPanel();
        myFightPanel = new JPanel();
        myFleePanel = new JPanel();

        bigPanel = new JPanel();
        bigButtonPanel = new JPanel();
        
        myFightButton = new JButton ("Fight");
        myFightButton.setFont(new Font("Arial", Font.PLAIN, 40));
        myFleeButton = new JButton ("Flee");
        myFleeButton.setFont(new Font("Arial", Font.PLAIN, 40));
        
        myFightPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        myFightPanel.add (myFightButton, c);
        
        myFleePanel.setLayout(new GridBagLayout());
        
        c.gridx = 1;
        c.gridy = 0;

        myFleePanel.add (myFleeButton, c);
        
        bigPanel.setLayout(new GridLayout(0,1));
        bigButtonPanel.setLayout (new GridLayout(1,2));
        bigButtonPanel.add(myFightPanel);
        bigButtonPanel.add(myFleePanel);
        

        
        myPanel.setLayout(new GridLayout(1,2));
       
        // myFrame = new JFrame("MONSTER");
        
        myFightButton.addActionListener(this);
        myFleeButton.addActionListener(this);
        // myGame = new Game();
        
            if (gameSpot.getMonster() != null) //Medusa
            {
                if(gameSpot.getMonster().getName() == "Medusa")
                {
                    Icon icon = new ImageIcon("MedusaHead.png");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                    myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(bigButtonPanel);
                    
                    
                    
                    //myFrame = new JFrame();
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                    
                }
            
                else if(gameSpot.getMonster().getName() == "Chimera") // Chimera
                {
                    Icon icon = new ImageIcon("ChimeraHead.jpg");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                    myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(bigButtonPanel);
                    
                    
                    
                    // myFrame = new JFrame();
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                }   
                else if(gameSpot.getMonster().getName() == "Cerberus") // Cerberus
                {
                    Icon icon = new ImageIcon("CerberusHead.jpg");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                    myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(bigButtonPanel);
                    
                    
                    
                    // myFrame = new JFrame();
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                }   
                else if(gameSpot.getMonster().getName() == "Arachne") // Arachne
                {
                    Icon icon = new ImageIcon("ArachneHead.jpg");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                    myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(bigButtonPanel);
                    
                    
                    
                    // myFrame = new JFrame();
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                }   
                else if(gameSpot.getMonster().getName() == "Cyclops") // Cyclops
                {
                    Icon icon = new ImageIcon("CyclopsHead.jpg");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                    myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(bigButtonPanel);
                    
                    
                    
                    // myFrame = new JFrame();
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                }   
                else if(gameSpot.getMonster().getName() == "Minotaur") // Minotaur
                {
                    Icon icon = new ImageIcon("MinotaurHead.jpg");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel (gameSpot.getMonster().getName(),JLabel.CENTER);
                    myLabel2 = new JLabel(gameSpot.getMonster().getDescription(),JLabel.CENTER);
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(bigButtonPanel);
                    
                    
                    
                    // myFrame = new JFrame();
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                }
               
            }
             else {
                    
                    JLabel label = new JLabel("No monster");
                    myLabel = new JLabel ("No monster");
                    myLabel2 = new JLabel("No monster");
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myLabel2);
                     
                }
            bigPanel.setVisible(true);
                    // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                
            // } 
                // Icon icon = new ImageIcon("Medusa.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Medusa");
                // myLabel2 = new JLabel("Snake Lady");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
                // myFightPanel.setLayout(new GridLayout(1,2));
                // myFightPanel.add (myFightButton);
                // myFightPanel.add (myFleeButton);
                // bigPanel.add(myPanel);
                // bigPanel.add(myFightPanel);
                // myFrame = new JFrame();
                // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // // myFrame.add(bigPanel);
                // myFrame.setSize(150, 150);
                // myFrame.pack();
                // myFrame.setVisible(true);
        
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==myFleeButton) //cancels the choice of direction and doesn't engage a fight
        {
            
            bigPanel.removeAll();
            myLabel3 = new JLabel("No monster");
            bigPanel.add(myLabel3);
            
            // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // myFrame.add(bigPanel);
                    // myFrame.setSize(150, 150);
                    // myFrame.pack();
                    // myFrame.setVisible(true);
                    
            bigPanel.revalidate();
            bigPanel.repaint();       
        }
        
    }
}
