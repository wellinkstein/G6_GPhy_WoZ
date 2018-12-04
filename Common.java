/**
 * The common class is a specific item to fight the lesser boss. Common items are found in pre-set areas.
 *
 * @author (group 6)
 * @version (2018-11-14)
 */
public class Common extends Item
{

    /**
     * Constructor of a common item
     * @param String itemName: name of the item
     * @param String des: description of the item
     * @param int dam: value of item's damage
     * @param int HG: health gain by item
     * @param int prot: protection value of item
     */
    public Common (String itemName, String des, int dam, int HG, int prot )
    {
        super (itemName, des, dam, HG, prot);
    
    }
}