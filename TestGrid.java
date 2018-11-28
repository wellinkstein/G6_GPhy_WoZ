import java.awt.*;
import javax.swing.*;

/**
 * This class is an example of GridLayout Manager
 * 
 * @author PG 
 * @version 2013-02-04
 */
public class TestGrid
{
    public static void main ()
    {
        JFrame myFrame = new JFrame("GridLayout");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.setLayout(new GridLayout(8,9));
        
        for(int i=1; i<=72; i++)
        {
            if((i % 2) == 1)
            {
                myFrame.add(new JLabel( new ImageIcon( "13.png")));
            }
            else
            {
                myFrame.add(new JLabel( new ImageIcon( "24.png")));
            }
            
        }

        myFrame.pack();
        myFrame.setVisible(true);
    }
}
