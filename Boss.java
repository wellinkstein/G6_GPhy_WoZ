import java.util.*;

/**
 * The class Boss is a specific object of the class Monster. 
 * It is a specific Monster (Minautor), the final boss of the game
 *
 * @author (Group 6)
 * @version (2018-11-14)
 */
public class Boss extends Monster
{
    private ArrayList<Legendary> itemToKillMe; //A list of items needed to kill the boss

    /**
     * Constructor for the Boss class
     * @param int myHP: number of hp of the boss
     * @param String myName: name of the boss
     * @param int myXp: Xp of the boss
     * @param int myDamage: damage value of the boss
     * @param int myProtection: protection value of the boss
     * @param String myDes: description of the boss
     */
    public Boss(int myHP, String myName, int myXp, int myDamage,int myProtection, String myDes)
    {
        // initialisation des variables d'instance
        super(myHP,myName,myXp,myDamage,myProtection,myDes);

    }
}
