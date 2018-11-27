import java.util.*;

/**
 * This class is the base class (super class) for all of the characters of the game.
 * These characters are the player and monsters, which are split into two sub classes.
 *
 * @author (Group 6)
 * @version (2018-11-27)
 */
public class Character
{
    
    protected int HP;
    //HP is an attribute which reflects health points.
    //HP cannot be below 0, if HP is 0 the character dies.
    private String Name;
    // The name of the character
    protected int xp;
    //The XP of the character, XP can be gained, not lost
    private int Damage;
    //This attribute represents the damage that a character inflicts in a single hit
    protected ArrayList<Item> inventory = new ArrayList<Item>();
    //A list of items that the character possesses
    
    /**
     * The constructor for the character class
     */
    public Character(int myHP, String myName, int myXp, int myDamage)
    {
        
        HP = myHP;
        Name = myName;
        xp = myXp;
        Damage = myDamage;
    }
    
    /**
     * Method that returns the HP
     */
    public int getHP()
    {
        return HP;
    }
    
    /**
     * Method that returns the Xp
     */
    public int getXp()
    { 
        return xp;
    }
    
    /**
     * Method that returns the name
     */
    public String getName()
    {
        return Name;
    }
    
    /**
     * Method that returns that damage
     */
    public int getDamage()
    {
        return Damage;
    }
    
    /**
     * Get for the inventory
     */
    public Item getInventory(int emplacement)
    {
        return(inventory.get(emplacement));
    }
    /**
     * Method that reduces the HP based on the damage attribute of another character.
     * The value damage will always be a positive interger
     * If the value of damage (HP inflicted) is superior to current HP, HP is set to 0
     */
    public void loseHp(int damage)
    {
        if(damage>0)
        {
            if((HP-damage)<0)
            {
                HP=0;
            }
            else
            {
                HP-=damage;
            }
        }
    }
    
    /**
     * Method that gives Xp based on the gainXP attribute
     * Xp can only be gained if the xp that is supposed to be gained is above 0
     */
    public void gainXp(int gainXP)
    {
        if (gainXP>0)
        {
            xp+=gainXP;
        }
        else
        {
            xp=xp;
        }
    }
    
    /**
     * A method that exists to test functions related to Hp
     */
    protected void setHp(int setHp)
    {
        HP=setHp;
    }
    
    /**
     * A method that exists to test functions related to Xp
     */
    protected void setXp(int setXp)
    {
        xp=setXp;
    }
    
    /**
     * Method that increases the damage attribute of the character
     * based on the damage attribute of items
     * To increase damage, the increase amount must be a positive value
     */
     public void increaseDamage(int DamageIncrease)
     {
         if(DamageIncrease>=0)
        {
            Damage+=DamageIncrease;
        }
        else
        {
            Damage=Damage;
        }
     }
     
    /**
    * Method that decreases the damage attribute of the character,
    * this may occur if a player drops an item
    * To decrease damage, the decrease amount must be a positive value
    */
    public void decreaseDamage(int DamageDecrease)
    {
        if(DamageDecrease>=0)
        {
            if((Damage-DamageDecrease)<0)
            {
                Damage=0;
            }
            else
            {
               Damage-=DamageDecrease; 
            }
        }
        else
        {
            Damage=Damage;
        } 
    }
}
