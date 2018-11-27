/**
 * The common class is a specific item to fight the lesser boss
 *
 * @author (groupe 6)
 * @version (2018-11-14)
 */
public class Common extends Item
{

    // instances variables
    private String type;

    /**
     * Constructor of a common item
     */
    public Common (String itemName, String des, int dam, int HG, int prot )
    {
        super (itemName, des, dam, HG, prot);
    
    }

}