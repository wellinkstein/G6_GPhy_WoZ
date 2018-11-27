/**
 * The class Monster is a specific object of the character class
 * It will contain Lesser Monsters and Boss Monsters
 * The descritption attribute is specific to this class as a monster will have to be described to the player
 *
 * @author (Group 6)
 * @version (2018-11-14)
 */
public class Monster extends Character
{
    private boolean isDead = false;//A boolean used to indicate to the game is a monsters hp has reached zero
    private String description; //A description of the monster
    /**
     * The constructor for the monster class
     */
    public Monster(int myHP, String myName, int myXp, int myDamage, String myDes)
    {
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
     * This method will allow monsters to follow the player
     * The lesser monster Arachne will follow the player if the player
     * has reached a set distance from it.
     * Other lesser monsters will follow/hunt the player if the minotaur is 
     * killed and the lesser monster is still alive.
     */
    public void follow()
    {}
    
    /**
     * deletes the monster from the list
     * This will be used to remove dead monsters from the game
     */
    public boolean isDead()
    {
        if(HP==0)
        {
            isDead=true;
            return true;
        }
        else
        {
            isDead=false;
            return false;
        }
    }

}