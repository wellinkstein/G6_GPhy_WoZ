
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
    
    /**
     * Constructor of the player class
     * Requires Hp, name, damage, posX, and posY
     */
    public Player(int myHP, String myName, int myXp, int myDamage, int myProtection)
    {
        super(myHP,myName,myXp,myDamage,myProtection);
    }
    
    /**
     * Getter for the attribute ariadnesThread
     * 
     */
    public boolean getThread()
    {
        return ariadnesThread;
    }
    
    /**
     * This method will allow the player to consume a health potion
     * if there is one in his inventory. The potion is removed after use.
     * A Potion gives 5HP. If the player has less than 
     * 5HP the potion gets him to full health.
     */
    public void drinkPotion()
    {
        boolean isPotion = false;
        for(int i=0; i<inventory.size();i++)
            {
                if(inventory.get(i).getName()=="Health Potion")
                {
                    isPotion = true;
                }
            }
        if(isPotion ==true && HP<20)
        {
            if(HP>(hpMax-5))
            {
                HP=hpMax;
            }
            else
            {
               HP=HP+5; 
            }
            for(int i=0; i<inventory.size();i++)
            {
                if(inventory.get(i).getName()=="Health Potion")
                {
                    inventory.remove(i);
                }
            }
        }    
    }

    /**
     * method that teleports the player to the exit if the minotaur is
     * killed while Ariadne's Thread is in the inventory
     */
    public void teleportation()
    {
    }
    
    /**
     * Allows the player to drop an item
     * A player may drop an item at any time except while in a fight
     */
    public void dropItem(Item itemDrop)
    {
        decreaseDamage(itemDrop.getDamage());
        decreaseProtection(itemDrop.getProtection());
        inventory.remove(itemDrop);
    }
    
    /**
     * Allows the player to pick up an item
     * if the item is the Ariadne's golden thread the boolean
     * associated to the thread is set to true.
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
        increaseDamage(myItem.getDamage());
        increaseProtection(myItem.getProtection());
    }   
    
    /**
     * getter for TimeToGo
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
     */
    public int getLimitItem()
    {
        return limitItem;
    }
    
    /**
     * A method that gets the items in the inventory at the given index
     */
    public Item getItems(int numItem)
    {
        return inventory.get(numItem);
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
     * The player starts at level 1 and each level give 5% of crit chance
     * it can exceed 50%.
     */
    public void adjustCritRate()
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
    }
    
    /**
     * A method that returns the crit rate
     */
    public int getCritRate()
    {
        return critRate;
    }

}
    

