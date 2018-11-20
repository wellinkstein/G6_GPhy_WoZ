
/**
 * The Player class is the player of the game
 * This class extends the character class and has attributes specific to the player
 * @author (groupe 6)
 * @version (2018-11-14)
 */
public class Player extends Character
{
    private int limitItem=10; //Maximal Item number of the player 
    private int hpMax=20; //Maximal Heart Point of the player
    private int critRate=0; //Defines the chances of the player rolling a crit
    
    /**
     * Constructor of the player class
     * Requires Hp, name, damage, posX, and posY
     */
    public Player(int myHP, String myName, int myXp, int myDamage, int myPosX, int myPosY)
    {
        // initialisation des variables d'instance
        super(myHP,myName,myXp,myDamage,myPosX,myPosY);
    }
    
    /**
     * This method will allow the player to consume a health potion
     * if there is one in his inventory
     */
    public void drinkPotion()
    {}

    /**
     * method that teleports the player to the exit if the minotaur is
     * killed while Ariadne's Thread is in the inventory
     */
    public void teleportation()
    {
    }
    
    /**
     * Allows the player to drop an item
     */
    public void dropItem(int itemDrop)
    {
        inventory.remove(itemDrop);
    }
    
    /**
     * Allows the player to pick up an item
     */
    public void takeItem(Item myItem)
    {
        inventory.add(myItem);
    }
    
    /**
     * A method that returns the item limit
     */
    public int getLimitItem()
    {
        return limitItem;
    }
    
    /**
     * A method that returns the max Hp
     */
    public int getHPMax()
    {
        return hpMax;
    }
    
    /**
     * A method that modifies the crit rate based on XP
     */
    public void adjustCritRate()
    {
        if(xp<2)
        {
            critRate=0;
        }
        else if (xp==2)
        {
            critRate=5;
        }
        else if (xp==3)
        {
            critRate=10;
        }
        else if (xp==4)
        {
            critRate=15;
        }
        else if (xp==5)
        {
            critRate=20;
        }
        else if (xp==6)
        {
            critRate=25;
        }
        else
        {
            System.out.println("something went wrong");
        }
    }
    
    /**
     * A method that returns the crit rate
     */
    public int getCritRate()
    {
        return critRate;
    }
}
    

