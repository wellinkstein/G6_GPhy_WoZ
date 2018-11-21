/**
 * The class Monster is a specific object of the character class
 * It will contain Lesser Monsters and Boss Monsters
 * The descritption attribute is specific to this class as a monster will have to be described to the player
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
    public Monster(int myHP, String myName, int myXp, int myDamage, String myDes)
    {
        // initialisation des variables d'instance
        super(myHP,myName,myXp,myDamage);
        description = myDes;
    }
    
    /**
     * getter for the description
     */
    public String getDescription()
    {return description;}
    
    /**
     * setter for description
     */
    public void setDescription(String myDes)
    {
        description = myDes;
    }
    
    /**
     * 
     */
    public void follow()
    {}
    
    /**
     * delete the monster from the list
     */
    public boolean isDead()
    {
        if(HP==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}