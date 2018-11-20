
/**
 * The Player class is the player of the game
 *
 * @author (groupe 6)
 * @version (2018-11-14)
 */
public class Player extends Character
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int limitItem; //Maximal Item number of the player 
    private int hpMax; //Maximal Heart Point of the player
    private int critRate;
    private int critDamage;
    
    /**
     * Constructeur d'objets de classe Player
     */
    public Player(int myHP)
    {
        // initialisation des variables d'instance
        super(myHP);
    }
    
    /**
     * 
     */
    public void drinkPotion()
    {}

    /**
     * method that teleport the player at the exit if the minotaur is dead and the Ariane thread is possessed
     */
    public void teleportation()
    {
    }
    
    /**
     * 
     */
    public void runAway()
    {}
    
    /**
     * 
     */
    public void dropItem()
    {}
    
    /**
     * 
     */
    public void takeItem()
    {}
    
    /**
     * 
     */
    public int getLimitItem()
    {return limitItem;}
    
    /**
     * 
     */
    public int getHPMax()
    {return hpMax;}
    
}
