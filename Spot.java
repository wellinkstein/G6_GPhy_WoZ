 import java.util.*;

/**
 * Class Spot - a spot in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Spot" represents one location in the scenery of the game.  It is 
 * connected to other spots via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Groupe 6
 * @version 14/11/2018
 */
public class Spot
{
    public Item spotItem; //A spot contains between 0 and 5 items
    //public Character hereCharacter;
    private HashMap<String, Spot> exits; //list of the exits
    private ArrayList<Character> characterInSpot; //all the character in a spot
    private ArrayList<Item> objectInSpot; //all the item in a spot
    private boolean isVisible; //True if the spot is visible
    private boolean fighting; //boolean if a monster and a player are in the same spot

    /**
     * Create a spot with a Haspmap to know the direction of exit
     */
    public Spot() 
    {
        exits = new HashMap<String, Spot>();
    }
      /**
     * Method setExit: defines an exit from this spot
     * Replaces the setExits method
     *
     * @param direction the direction of the exit
     * @param neighbor the spot in the given direction

     * @version version 2018/11 
     */
    public void setExit(String direction, Spot neighbor){
        exits.put(direction, neighbor);
    }

   
     /**
     * Method getExit: returns the spot that we reach in the given direction
     * If there is no spot in that direction, returns null
     *
     * @param direction The exit's direction
     * @return The spot in the given direction
     * 
     * @version version 2018/11
     */
    public Spot getExit(String direction){
        return exits.get(direction);
    }
    
    /**
     * return the number of item in the spot
     */
    public int numberOfItemInSpot()
    {
    return 0;
    }
    
    /**
     * 
     */
    public void exit()
    {}
}
