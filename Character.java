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
    
    private int HP;
    //HP is an attribute which reflects health points.
    //HP cannot be below 0, if HP is 0 the character dies.
    private String Name;
    // The name of the character
    private int xp;
    //The XP of the character, XP can be gained, not lost
    private int Damage;
    //This attribute represents the damage that a character inflicts in a single hit
    private int posX;
    //The X axis position of the character
    private int posY;
    //The Y axis position of the character
    private ArrayList<Item> inventory;
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
     * Method that reduces the HP based on the damage attribute of another character.
     */
    public void loseHp(int damage)
    {
        HP -= damage;
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
     * Method that initiates combat
     */
    public void fight()
    {}
    
    /**
     * Method that causes a player to not initiate the combat sequence
     */
    public void runAway()
    {}
    
    /**
     * Methode that gives HP based on the gainHP attribute that is found in items.
     */
    public void gainHP(int gainHP)
    {}
    
    /**
     * Method that gives Xp based on the gainXP attribute
     */
    public void gainXp(int gainXP)
    {}
    
    /**
     * setter of posX
     */
    public void setPosX(int position)
    {}
    
    /**
     * setter of posY
     */
    public void setPosY(int position)
    {}
    
    /**
     * Method that increases the damage attribute of the character
     * based on the damage attribute of items
     */
     public void increaseDamage(int Damage)
     {}
     
     /**
     * Method that decreases the damage attribute of the character,
     * this may occur if a player drops an item
     */
     public void decreaseDamage(int Damage)
     {}
}
