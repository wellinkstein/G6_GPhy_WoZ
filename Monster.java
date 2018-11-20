/**
 * The class Monster is a specific object of the character class
 *
 * @author (Groupe 6)
 * @version (2018-11-14)
 */
public class Monster extends Character
{

    private String description; 
    /**
     * Constructeur d'objets de classe Monster
     */
    public Monster(int myHP, String myName, int myXp, int myDamage, int myPosX, int myPosY)
    {
        // initialisation des variables d'instance
        super(myHP,myName,myXp,myDamage,myPosX,myPosY);
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