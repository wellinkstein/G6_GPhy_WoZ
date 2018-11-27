import java.util.*;
/**
 * The lesser boss class is a specific object of the monster class. 
 * It is a little monster.
 *
 * @author (group 6)
 * @version (2018-11-14)
 */
public class Lesser_Boss extends Monster
{

    private Legendary possessedLegendary; //This attributes dicates with legendary item is associated to a lesser monster
    private ArrayList<Common> itemsToKillMe;//Lists a suggestion of items to be able to kill the monster
    private boolean aggressive; //The aggressivity of the lesser boss
    
    /**
     * A constructor for the lesser boss class
     */
    public Lesser_Boss(int myHP, String myName, int myXp, int myDamage, String myDes)
    {
        super(myHP,myName,myXp,myDamage,myDes);
        aggressive=false;
    }
    
    /**
     * A method that returns the boolean of aggressive
     */
    public boolean getAggressive()
    {
        return aggressive;
    }
    
    /**
     * A method that sets aggressive to true
     */
    public void setAggressiveTrue()
    {
        aggressive=true;
    }
    
    /**
     * A method that sets aggressive to false
     */
    public void setAggressiveFalse()
    {
        aggressive=false;
    }

}
