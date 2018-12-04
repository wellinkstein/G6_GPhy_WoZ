/**
 * The Legendary class is a specific item obtained by killing the monsters.

 * @author (Yousra & Delphine)
 * @version (2018-11-14)
 */
public class Legendary extends Item
{

    /**
     * Constructor of legendary items
     * @param String itemName: name of the legendary item
     * @param String des: description of the legendary item
     * @param int dam: damage of the legendary item
     * @param int HG: health gain of the legendary item
     * @param int prot: protection value of the legendary item
     */
    public Legendary(String itemName, String des, int dam, int HG, int prot )
    {
        super (itemName, des, dam, HG,prot );
       

    }
}