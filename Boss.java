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
    public Boss(int myHP)
    {
        // initialisation des variables d'instance
        super(myHP);
    }

    
}
