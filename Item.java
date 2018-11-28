/**
 * This class creates the different items.
 * An Item represents an object that can be picked up and used by the player.

 * @author Delphine et Yousra

 * @version 2018
 */
public abstract class Item
{
    private int damage; //dictates the damage attributed to an item
    private int protection; //dictates the protection attributed to an item
    private int healthGain; //determines the health an item will give to the player when the item is used
    protected String name; //name of the item
    private String description; //description of an item
    private static int count = 0;//the auto incrementation of id item
    private int itemID; // Unique ID of the item, each item will have it's id incremented by 1.

    /**
     * Constructor for objects of class Item
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
     * the damage can be equal to 0 but cannot be negative
     */
    public void setDamage (int Dam)
    {
        if (Dam<0) //If the value of the damage is less than 0
        {
            damage = damage; //The value of the damage does not change
        }
        else 
        {
            damage = Dam; //The value of the damage takes on a new value
        }
       
         
    }
    
    /**
     * setter for the protection
     * the protection can be equal to 0 but cannot be negative
     */
    public void setProtection(int Prot )
     {if (Prot<0) //If the value of the protection is less than 0
        {
            protection = protection; //The value of the protection does not change
        }
        else 
        {
            protection = Prot; // The value of the protection takes a new value
        }
    }
    
    /**
     * setter for the name
     */
    public void setName(String myName)
    {name = myName;}
    
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
     * A method which returns the name of the item
     */
    public int getItemID()
     {return itemID; }
    }