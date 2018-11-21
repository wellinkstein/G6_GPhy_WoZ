/**
 * This class creates the different items.
 * An Item represents an object that can be picked up and used by the player.

 * @author Delphine et Yousra

 * @version 2018
 */
public class Item
{
    
    private int damage; //damage of the item
    private int protection; //protection of the item
    private int healthGain; //health gain of the item
    private String name; //name of the item
    private String description; //description of the item
    private int count = 0;
    private int itemID; // Unique ID of the item.

    /**
     * Constructeur of an Item
     * 
     */
    public Item(String itemName, String des, int dam, int prot, int HG)
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
     