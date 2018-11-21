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
    protected String name; //name of the item
    private String description; //description of an item
    private static int count = 0;//the auto incrementation of id item
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
     * the damage can be equal to 0 but not be negative
     */
    public void setDamage (int Dam)
    {
        if (Dam<0)
        {
            damage = damage;
        }
        else 
        {
            damage = Dam;
        }
       
         
    }
    
    /**
     * setter for the protection
     * the protection can be equal to 0 but not be negative
     */
    public void setProtection(int Prot )
     {if (Prot<0)
        {
            protection = protection;
        }
        else 
        {
            protection = Prot;
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
     * A method which return the name of the item
     */
    public int getItemID()
     {return itemID; }
    }