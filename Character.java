import java.util.*;

/**
 * This class is the base class (super class) for all of the characters of the game.
 * These characters are the player and monsters, which are split into two sub classes.
 *
 * @author (Yohan/Corentin)
 * @version (V1)
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
    private int posX;
    //The X axis position of the character
    private int posY;
    //The Y axis position of the character
    protected ArrayList<Item> inventory;
    //A list of items that the character possesses
    
    /**
     * Constructeur d'objets de classe Character
     */
    public Character(int myHP, String myName, int myXp, int myDamage, int myPosX, int myPosY)
    {
        
        HP = myHP;
        Name = myName;
        xp = myXp;
        Damage = myDamage;
        posX = myPosX;
        posY = myPosY;
        
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
     * Method that returns posX
     */
    public int getPosX()
    {
        return posX;
    }

    /**
     * Method that returns posY
     */
    public int getPosY()
    {
        return posY;
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
     * Method that moves the player forward
     */
    public void moveUp()
    {
        posY += 1;
    }
    
    /**
     * Method that moves the players backwards
     */
    public void moveDown()
    {
        posY -= 1;
    }
    
    /**
     * Method that moves the player to the right
     */
    public void moveRight()
    {
        posX += 1;
    }
    
    /**
     * Method that moves the player to the left
     */
    public void moveLeft()
    {
        posX -= 1;
    }
    
    
    /**
     * Methode that gives HP based on the gainHP attribute that is found in items.
     */
    public void gainHP(int gainHP)
    {
        if (gainHP>0)
        {
            HP+=gainHP;
        }
        else
        {
            HP=HP;
        }
    }
    
    /**
     * Method that gives Xp based on the gainXP attribute
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
     * setter of posX
     */
    public void setPosX(int position)
    {
        posX=position;
    }
    
    /**
     * setter of posY
     */
    public void setPosY(int position)
    {
        posY=position;
    }
    
    /**
     * A method that exists to test functions related to Xp
     */
    protected void setHp(int setHp)
    {
        HP=setHp;
    }
    
    /**
     * A method that exists to test function related to Xp
     */
    protected void setXp(int setXp)
    {
        xp=setXp;
    }
    
    /**
     * Method that increases the damage attribute of the character
     * based on the damage attribute of items
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
