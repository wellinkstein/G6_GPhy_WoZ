/**
 * The common class is a specific item to fight the lesser boss. Common items are found in pre-set areas.
 *
 * @author (group 6)
 * @version (2018-11-14)
 */
public class Common extends Item
{
     private int damage; //dictates the damage attributed to an item
     private int protection;
     protected String name; 
     private String description; 
     private int healthGain; //determines the health an item will give to the player when the item is used
     
    /**
     * Constructor of a common item
     */
    public Common (String itemName, String des, int dam, int HG, int prot )
    {
        super (itemName, des, dam, HG, prot);
    
    }
    /**
     * setter for the damage
     * the damage can be equal to 0 but cannot be negative
     * @param dam: value of the damage of the item
     */
     public void setDamage (int dam)
    {
        if (dam>=0) //If the value of the damage is over or equal to 0
        {
            damage = dam; //The value of the damage does  change
        }
     }
    
     /**
     * setter for the protection
     * the protection can be equal to 0 but cannot be negative
     * @param prot: the value of protection of the item
     */
    public void setProtection(int prot)
    {
        if (prot>=0) //If the value of the protection is over or equal to 0
        {
            protection = prot;  //The value of the protection does change
        }
    }
    
     /**
     * setter for the name
     * @param myName: the name of the item
     */
    public void setName(String myName)
    {
        name = myName;
    }
    
     /**
     * A mothod to set the description of the item
     * @param String description: the description of the item
     */
    public void setDescription(String description)
    {
        this.description=description;
    }
    
    /**
     * A method to set the value of healh given by the item (potion)
     * This value cannot be set under 0
     * @param int healthGain: integer of the value of health gain
     */
    
    public void setHealthGain(int healthGain)
    {
        if(healthGain>=0)
        {
            this.healthGain = healthGain;
        }
    }
   

}