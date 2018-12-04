import java.util.*;

/**
 * This class is the base class (super class) for all of the characters of the game.
 * These characters are the player and monsters, which are split into two sub classes.
 *
 * @author (Group 6)
 * @version (2018-11-27)
 */
public abstract class Character
{
    
    protected int HP;
    //HP is an attribute which reflects health points.
    //HP cannot be below 0, if HP is 0 the character dies.
    private String name;
    // The name of the character
    protected int xp;
    //The XP of the character, XP can be gained, not lost
    private int damage;
    //This attribute represents the damage that a character inflicts in a single hit
    private int protection;
    //This attribute represent the damage reduction of the character
    protected ArrayList<Item> inventory = new ArrayList<Item>();
    //A list of items that the character possesses
    
    /**
     * The constructor for the character class
     * @param myHP: HP of character
     * @param String myName: name of character
     * @param int myXp: XP of character
     * @param int myDamage: damage of character
     * @param int myProtction: protection value of character
     */
    public Character(int myHP, String myName, int myXp, int myDamage, int myProtection)
    {
        HP = myHP;
        name = myName;
        xp = myXp;
        damage = myDamage;
        protection = myProtection;
    }
    
    /**
     * Method that returns the HP
     * @return int HP: return HP value
     */
    public int getHP()
    {
        return HP;
    }
    
    /**
     * Method that returns the Xp
     * @return int xp: return the XP
     */
    public int getXp()
    { 
        return xp;
    }
    
    /**
     * Method that returns the name
     * @return String Name: return name character
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method that returns that damage
     * @return int Damage: return damage of character
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Method that returns the protection
     * @return int Protection: return protection of character
     */
    public int getProtection()
    {
        return protection;
    }
    
    /**
     * Get for the inventory
     * @param int emplacement: item index in Inventory
     * @return Item: return the item found
     */
    public Item getInventory(int emplacement)
    {
        return(inventory.get(emplacement));
    }
    
    /**
     * Method that reduces the HP based on the damage attribute of another character.
     * The value damage will always be a positive interger
     * If the value of damage (HP inflicted) is superior to current HP, HP is set to 0
     * @param int damage: damage value inflicted
     */
    public void loseHp(int damage)
    {
        if(damage>0)
        {
            if((HP-damage+protection)<0)
            {
                HP=0;
            }
            else
            {
                HP=HP-damage+protection;
            }
        }
    }
    
    /**
     * Method that gives Xp based on the gainXP attribute
     * Xp can only be gained if the xp that is supposed to be gained is above 0
     * @param int gainXP: XPgained
     */
    public void gainXp(int gainXP)
    {
        if (gainXP>0)
        {
            xp+=gainXP;
        }
    }
    
    /**
     * A method that exists to test functions related to Hp
     * @param int setHP: HP value set to the character
     */
    protected void setHp(int setHp)
    {
        HP=setHp;
    }
    
    /**
     * A method that exists to test functions related to Xp
     * @param int setXp: set value of XP to character
     */
    protected void setXp(int setXp)
    {
        xp=setXp;
    }
    
    /**
     * Method that increases the damage attribute of the character
     * based on the damage attribute of items
     * To increase damage, the increase amount must be a positive value
     * @param int DamageIncrease: increase value of damage
     */
     public void increaseDamage(int damageIncrease)
     {
         if(damageIncrease>=0)
        {
            damage+=damageIncrease;
        }
     }
     
     /**
     * Method that increases the Protection attribute of the character
     * based on the damage attribute of items
     * To increase Protection, the increase amount must be a positive value
     * @param int ProtectionIncrease: increase protection by the value
     */
     public void increaseProtection(int protectionIncrease)
     {
        if(protectionIncrease>=0)
        {
            protection+=protectionIncrease;
        }
     }
     
    /**
    * Method that decreases the damage attribute of the character,
    * this may occur if a player drops an item
    * To decrease damage, the decrease amount must be a positive value
    * @param int DamageDecrease: decrease damage by the value
    */
    public void decreaseDamage(int damageDecrease)
    {
        if(damageDecrease>=0)
        {
            if((damage-damageDecrease)<0)
            {
                damage=0;
            }
            else
            {
               damage-=damageDecrease; 
            }
        }
    }
    
    /**
    * Method that decreases the Protection attribute of the character,
    * this may occur if a player drops an item
    * To decrease protection, the decrease amount must be a positive value
    * @param int ProtectionDecrease: decreases Protection by value
    */
    public void decreaseProtection(int protectionDecrease)
    {
        if(protectionDecrease>=0)
        {
            if((protection-protectionDecrease)<0)
            {
                protection=0;
            }
            else
            {
               protection-=protectionDecrease; 
            }
        }
    }
    
}
