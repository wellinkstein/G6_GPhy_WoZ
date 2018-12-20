/**
 * This class creates the different items.
 * An Item represents an object that can be picked up and used by the player.
 * @author Groupe 6
 * @version 04/12/2018
 */

public abstract class Item
{
    private int damage; //dictates the damage attributed to an item
    private int protection; //dictates the protection attributed to an item
    private int healthGain; //determines the health an item will give to the player when the item is used
    protected String name; //name of the item
    private String description; //description of an item
    
    /**
     * Constructor for objects of class Item
     * @param itemName: the name of the object
     * @param des: the description of the object
     * @param dam: the value of damage of the item
     * @param prot: the value of protection of the item
     * @param HG: the value of health gained by the player when using the item (potion)
     */
    public Item(String itemName, String des, int dam, int prot, int HG)
    { 
        name = itemName;
        description = des;
        damage = dam;
        protection = prot;
        healthGain = HG;
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
    
    /**
     * A method to get the damage of the item
     * @return int damage: returns the value of damage of the item
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * A method to get the protection of the item
     * @return int protection: returns the value of protection of the item
     */
    public int getProtection()
    {
        return protection;
    }
    
    /**
     *  A method which return the name of the item
     *  @return String name: returns the name of the item
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * A method which return the descritpion of the item
     * @return String description: returns the description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * A method to get the health gain of the item
     * @return item healtGain: returns the value of health given to the player (potion)
     */
    public int getHealthGain()
    {
        return healthGain;
    }
}