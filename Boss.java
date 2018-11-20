import java.util.*;

/**
 * The class Boss is a specific object of the class Monster. 
 * It is a specific Monster (Minautor)
 *
 * @author (Groupe 6)
 * @version (2018-11-14)
 */
public class Boss extends Monster
{

    private ArrayList<Legendary> itemToKillMe;

    /**
     * Constructeur d'objets de classe Boss
     */
    public Boss(int myHP, String myName, int myXp, int myDamage, int myPosX, int myPosY)
    {
        // initialisation des variables d'instance
        super(myHP,myName,myXp,myDamage,myPosX,myPosY);
    }

    
}
