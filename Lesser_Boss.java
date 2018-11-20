import java.util.*;
/**
 * The lesser boss class is a specific object of the monster class. 
 * It is a little monster.
 *
 * @author (groupe 6)
 * @version (2018-11-14)
 */
public class Lesser_Boss extends Monster
{

    private Legendary possessedLegendary;
    private ArrayList<Common> itemsToKillMe;
    private boolean aggressive; //The aggressivity of the lesser boss
    
    /**
     * Constructeur d'objets de classe Lesser_Boss
     */
    public Lesser_Boss(int myHP)
    {
        // initialisation des variables d'instance
        super(myHP);
    }

}
