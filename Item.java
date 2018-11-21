/**
 *  This class creates the different items.
 * An Item represents an object that can be picked up and used by the player.

 * @author Delphine et Yousra
>>>>>>> acc22fb149bf9a345ee4aebab817bbe6c5f9ac96
 * @version (un numero de version ou une date)
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le v�tre
    private int damage; //damage of the item
    private int protection; //protection of the item
    private int healthGain; //health gain of the item
    private String name; //name of the item
    private String description; //description of the item
    private int count = 0;
    private int itemID; // Unique ID of the item.

    /**
     * Constructeur of an Item
     * @name: the name of the item
     * @itemID: the id of the item
     * @description: the description of the item
     * @damage: the damage of the item
     * @healthGain: the health gain of the item
     */
    public Item(String itemName, String des, int id, int dam, int prot, int HG)
    { 
        name = itemName;
        description = des;
        itemID = ++count;
        damage = dam;
        protection = prot;
        healthGain = HG;
    }
    
    /**
     * setter for the damage
     */
    public void setDamage()
    {}
    
    /**
     * setter for the protection
     */
    public void setProtection()
    {}
    
    /**
     * setter for the name
     */
    public void setName()
    {}
    
    /**
     * A method to get the damage of the item
     */
    public int getDamage()
    {return damage;}
    
    /**
     * A method to get the protection of the item
     */
    public int getProtection()
    {return protection;}
    
    /**
     *  A method which return the name of the item
     */
    public String getName()
    {return name;}
    
    /**
     * A method which return the descritpion of the item
     */
    public String getDescription()
    {return description;}
    
    /**
     * A method to get the health gain of the item
     */
    public int getHealthGain()
    {return healthGain;}
    
    /**
     * A method which return the name of the item
     */
    public int getItemID()
     {return itemID; }
    }
     