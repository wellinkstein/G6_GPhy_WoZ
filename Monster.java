/**
 * The class Monster is a specific object of the character class
 * It will contain Lesser Monsters and Boss Monsters
 * The descritption attribute is specific to this class as a monster will have to be described to the player
 *
 * @author (Group 6)
 * @version (2018-11-14)
 */
public abstract class Monster extends Character
{
    private String description; //A description of the monster
     /**
     * The constructor for the monster class
     * @param int myHP: the value of health of the monster
     * @param String myName: the name of the monster
     * @param int myXP: the xp of the monster
     * @param int myProtection: the value of protection of the monster
     * @param String myDes: the description of the monster
     */
    public Monster(int myHP, String myName, int myXp, int myDamage,int myProtection,String myDes)
    {
        super(myHP,myName,myXp,myDamage,myProtection);
        description = myDes;
    }
    
    /**
     * getter for the description
     * @return String description: returns the description of the monster
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * setter for description
     * @param String myDes: set the value for the description of the monster
     */
    public void setDescription(String myDes)
    {
        description = myDes;
    }

}