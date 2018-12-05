import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class NextSpot here.
 *
 * @author (Yohan Lefol)
 * @version (2018-12-04)
 */
public class NextSpot extends JPanel
{
    private Game myGame;
    private Spot mySpot;
    /**
     * Constructor for objects of class NextSpot
     */
    public NextSpot()
    {
        JPanel myPanel;
        JPanel myPanel2, bigPanel;
        JButton myButton,myButton2;
        JFrame myFrame;
        JLabel myLabel,myLabel2;

        
        
        
        myPanel = new JPanel();
        myPanel2 = new JPanel();
        bigPanel = new JPanel();
        
        myButton = new JButton ("Fight");
        myButton2 = new JButton ("Flee");
        
        bigPanel.setLayout(new GridLayout(0,1));
        
        myPanel.setLayout(new GridLayout(1,2));
        
        myFrame = new JFrame("MONSTER");
        
        myGame = new Game();
        mySpot = new Spot();
        // myGame.setCurrentSpot(myGame.getListSpot().get(20));
        // System.out.println(myGame.getCurrentSpot());
        // myGame.getCurrentSpot().getMonster();
        System.out.println(myGame.getCurrentSpot());
        System.out.println(myGame.getListSpot().get(0).getMonster());
        System.out.println("Before NEWWWWW if");
            if (myGame.getCurrentSpot().getMonster() != null) //Medusa
            {
                if(myGame.getCurrentSpot().getMonster().getName() == "Medusa")
                {
                    Icon icon = new ImageIcon("Medusa.jpg");
                    JLabel label = new JLabel(icon);
                    myLabel = new JLabel ("Medusa");
                    myLabel2 = new JLabel("Snake Lady");
                    myPanel.add(label);
                    myPanel.add(myLabel);
                    bigPanel.add(myLabel2);
                    myPanel2.setLayout(new GridLayout(1,2));
                    myPanel2.add (myButton);
                    myPanel2.add (myButton2);
                    bigPanel.add(myPanel);
                    bigPanel.add(myPanel2);
                    myFrame = new JFrame();
                    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    myFrame.add(bigPanel);
                    myFrame.setSize(150, 150);
                    myFrame.pack();
                    myFrame.setVisible(true);
                    
                }
                System.out.println("During If");
            }
        System.out.println("After if");
            // if (myGame.getCurrentSpot() == myGame.getListSpot().get(10)) // Chimera
            // {
                // Icon icon = new ImageIcon("Chimera.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Chimera");
                // myLabel2 = new JLabel("Lion thing");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
            // }   
            // if (myGame.getCurrentSpot() == myGame.getListSpot().get(5)) // Cerberus
            // {
                // Icon icon = new ImageIcon("Cerberus.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Cerberus");
                // myLabel2 = new JLabel("Three headed dog");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
            // }   
            // if (myGame.getCurrentSpot() == myGame.getListSpot().get(40)) // Arachne
            // {
                // Icon icon = new ImageIcon("Arachne.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Arachne");
                // myLabel2 = new JLabel("Spider Lady");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
            // }   
            // if (myGame.getCurrentSpot() == myGame.getListSpot().get(60)) // Cyclops
            // {
                // Icon icon = new ImageIcon("Cyclops.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Cyclops");
                // myLabel2 = new JLabel("Giant one eyed dude");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
            // }   
            // if (myGame.getCurrentSpot() == myGame.getListSpot().get(2)) // Minotaur
            // {
                // Icon icon = new ImageIcon("Minotaur.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Minotaur");
                // myLabel2 = new JLabel("Hornet monster");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
                
            // } 
                // Icon icon = new ImageIcon("Medusa.jpg");
                // JLabel label = new JLabel(icon);
                // myLabel = new JLabel ("Medusa");
                // myLabel2 = new JLabel("Snake Lady");
                // myPanel.add(label);
                // myPanel.add(myLabel);
                // bigPanel.add(myLabel2);
                // myPanel2.setLayout(new GridLayout(1,2));
                // myPanel2.add (myButton);
                // myPanel2.add (myButton2);
                // bigPanel.add(myPanel);
                // bigPanel.add(myPanel2);
                // myFrame = new JFrame();
                // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // // myFrame.add(bigPanel);
                // myFrame.setSize(150, 150);
                // myFrame.pack();
                // myFrame.setVisible(true);
        
        
        // myFrame.setTitle("Monster Description");
        
        // Icon icon = new ImageIcon("Medusa.jpg");
        // JLabel label = new JLabel(icon);
        // myLabel = new JLabel ("Medusa");
        // myLabel2 = new JLabel("Snake Lady");
        // myPanel.add(label);
        // myPanel.add(myLabel);
        // bigPanel.add(myPanel);
        // bigPanel.add(myLabel2);
        // myPanel2.setLayout(new GridLayout(1,2));
        // myPanel2.add (myButton);
        // myPanel2.add (myButton2);
        // bigPanel.add(myPanel2);
        // myFrame = new JFrame();
        // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // myFrame.add(bigPanel);
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
    public void sampleMethod(int y)
    {
        // put your code here
        
    }
}
