
/**
 * The class Monster is a specific object of the character class
 *
 * @author (Groupe 6)
 * @version (2018-11-14)
 */
public class Monster extends Character
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String description; 
    /**
     * Constructeur d'objets de classe Monster
     */
    public Monster(int myHP)
    {
        // initialisation des variables d'instance
        super(myHP);
    }
    
    /**
     * getter for the description
     */
    public String getDescription()
    {return description;}
    
    /**
     * setter for description
     */
    public void setDescription()
    {}
    
    /**
     * 
     */
    public void follow()
    {}
    
    /**
     * delete the monster from the list
     */
    public void isDead()
    {}

}
