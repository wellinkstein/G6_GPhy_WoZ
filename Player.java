import java.util.*;
/**
 * The Player class is the player of the game
 * This class extends the character class and has attributes specific to the player
 * @author (group 6)
 * @version (2018-11-14)
 */
public class Player extends Character
{
    private int limitItem=10; //Maximal Item number of the player 
    private int hpMax=20; //Maximal Heart Point of the player
    private int critRate=0; //Defines the chances of the player rolling a crit
    private boolean timeToGo = false;//Boolean stating if the player can exit the labyrinth
    private boolean ariadnesThread = false; //Boolean that checks if the player has Ariadne's thread
    private boolean hermesSandals = false; //Boolean that checks if the player has hermes's sandals
    protected ArrayList<Item> inventory = new ArrayList<Item>();//A list of items that the character possesses

    /**
     * Constructor of the player class
     * Requires Hp, name, damage, posX, and posY
     * @param int myHP: value of the HP of the player
     * @param String myName: name of the player
     * @param int myXp: xp of the player
     * @param int myDamage: value of damage of the player
     * @param int myProtection: value of the protection of the player
     */
    public Player(int myHP, String myName, int myXp, int myDamage, int myProtection)
    {
        super(myHP,myName,myXp,myDamage,myProtection);
    }

    /**
     * Getter for the attribute ariadnesThread
     * @return boolean ariadnesThread: returns true if the player has the item.
     * Returns false otherwise
     */
    public boolean getThread()
    {
        return ariadnesThread;
    }

    /**
     * Getter for the attribute hermesSandals
     * @return boolean hermesSandals: returns true if the player has the item.
     * Returns false otherwise
     */
    public boolean getHermesSandals()
    {
        return hermesSandals;
    }

    /**
     * This method will allow the player to consume a health potion
     * if there is one in his inventory. The potion is removed after use.
     * A Potion gives 5HP. If the player has less than 
     * 5HP the potion gets him to full health.
     * @param int i: i is the index of item in the inventory
     */
    public void drinkPotion(int i)
    {
        boolean isPotion = false;
        if(HP<20)
        {
            if(HP>(hpMax-5))
            {
                HP=hpMax;
            }
            else
            {
                HP=HP+5; 
            }
            inventory.remove(i);
        }    
    }

    /**
     * Allows the player to drop an item
     * A player may drop an item at any time except while in a fight
     * @param Item itemDrop: the item that the player wants to drop
     */
    public void dropItem(Item itemDrop)
    {
        decreaseDamage(itemDrop.getDamage());
        decreaseProtection(itemDrop.getProtection());
        inventory.remove(itemDrop);
    }

    /**
     * Allows the player to drop an item using the index of the item
     * A player may drop an item at any time except while in a fight
     * @param Item itemDrop: the item that the player wants to drop
     */
    public void dropItemNb(int itemDrop)
    {
        decreaseDamage(getItems(itemDrop).getDamage());
        decreaseProtection(getItems(itemDrop).getProtection());
        inventory.remove(itemDrop);
    }

    /**
     * Allows the player to pick up an item
     * if the item is the Ariadne's golden thread the boolean
     * associated to the thread is set to true.
     * @param Item myItem: the item that the player wants tot take
     */
    public void takeItem(Item myItem)
    {
        if(inventory.size()<limitItem)
        {
            inventory.add(myItem);
        }
        if(myItem.getName()=="Ariadne's golden thread")
        {
            ariadnesThread = true;
        }
        if(myItem.getName()=="Hermes's Sandals")
        {
            hermesSandals = true;
        }
        increaseDamage(myItem.getDamage());
        increaseProtection(myItem.getProtection());
    }   

    /**
     * getter for TimeToGo
     * @return boolean timeToGo: return true if the player can exit the labyrinth
     */
    public boolean getTimeToGo()
    {
        return timeToGo;
    }

    /**
     * A method that set TimeToGo to true
     */
    public void setTrueTimeToGo()
    {
        timeToGo = true;
    }

    /**
     * A method that set TimeToGo to false
     */
    public void setFalseTimeToGo()
    {
        timeToGo = false;
    }

    /**
     * A method that returns the item limit
     * @return int limitItem: returns the item limit for the player
     */
    public int getLimitItem()
    {
        return limitItem;
    }

    /**
     * a method that return the number of item possess
     * @return int inventory.size(): returns the size of inventory
     */
    public int getNumberItemPossess()
    {
        return inventory.size();
    }

    /**
     * A method that gets the items in the inventory at the given index
     * @return Item inventory.get(numItem): returns the item
     * @param int numItem: the number index of the item in the inventory
     */
    public Item getItems(int numItem)
    {
        return inventory.get(numItem);
    }

    /**
     * A method that returns the max Hp
     * @return int hpMax: returns the max Hp of the player
     */
    public int getHPMax()
    {
        return hpMax;
    }

    /**
     * A method that modifies the crit rate based on XP
     * The player starts at level 1 and each level give 5% of crit chance
     * it cannot exceed 50%.
     * @return int critRate: returns the crit rate of the player
     */
    public int adjustCritRate()
    {
        if(xp<2)
        {
            critRate=0;
        }
        else
        {
            critRate=(xp-1)*5;
            if(critRate>50)
            {
                critRate = 50;
            }
        }
        return critRate;
    }

    /**
     * A method that returns the crit rate
     * @return int critRate: returns the critical rate of the player
     */
    public int getCritRate()
    {
        return critRate;
    }

}

