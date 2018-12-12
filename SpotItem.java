import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.*;
import java.util.Set;
/**
 * The class SpotItem allows us to have the interface of the Item in the spot.
 *
 * @author (Ludivine Harault)
 * @version (2018-12-04)
 */
public class SpotItem extends JPanel
{
    private JLabel myLabel; 
    private JPanel myPanel, myPanel1, myBigPanel; 
    private ArrayList<JButton> content = new ArrayList<JButton>();
    private Item click; 
    private ItemDescription iD;
    private Spot mySpot;
    private AffichMain myMain;
    //private AffichMain aM;

    /**
     * 
     */
    public SpotItem(Spot spot, AffichMain cont)
    {
        mySpot = spot;
        myMain = cont;
        showListItem(mySpot,myMain);
    }

    public void showListItem(Spot spot, AffichMain myMain)
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

        //panelListItem=mySpot; 

        for(int i = 0; i <= (spot.getListItem().size()-1); i++)
        {   
            content.add(new JButton(spot.getListItem().get(i).getName()));
            content.add(new JButton("Take"));
        }

     
        myLabel = new JLabel ("These are the items available",JLabel.CENTER);
        myPanel.setLayout(new GridLayout(spot.getListItem().size(),1));
        myPanel1.setLayout(new GridLayout(1,1));
        myPanel1.add(myLabel); 

        for(int i = 0; i <= (content.size()-1); i++)
        {
            Ecouteur1 e = new Ecouteur1(this, myMain);
            content.get(i).addActionListener(e);
            myPanel.add(content.get(i));
        }

        myBigPanel.setLayout(new GridLayout(2,1)); 
        myBigPanel.add(myPanel1); 
        myBigPanel.add(myPanel); 

       
        myBigPanel.setVisible(true); 
        add(myBigPanel);
        revalidate();
        repaint();
        setVisible(true);

    }
    public Spot getSpot()
    {
        return mySpot;
    }

    public void updateSpotItem(AffichMain myMain)
    {
        myBigPanel.removeAll();
        //content.clear(); 
        myBigPanel.setLayout(new GridLayout(2,1));
        showListItem(myMain.getGame().getCurrentSpot(), myMain);
        myBigPanel.revalidate();
        myBigPanel.repaint();

    }
    // public void showDescriptionItem(Item myItem)
    // {
    // System.out.println("Entrez dans la method DescriptionItem");
    // ItemDescription myItemD = new ItemDescription(myItem);
    // this.removeAll();
    // this.add(myItemD);
    // this.revalidate();
    // this.repaint();
    // }

    public Item getItemClicked()
    {
        return click;
    }

    public ArrayList<JButton> getContent(){
        return content;
    }

}
