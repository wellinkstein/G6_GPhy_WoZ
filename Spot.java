 import java.util.*;

/**
 * Class Spot - a spot in an adventure game.
 *
 * This class is part of the "Daedalus" application. 
 * "Daedalus" is a very simple, text based adventure game.  
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
    private int numberItem; //A spot contains between 0 and 5 items
    private HashMap<String, Spot> exits; //list of the exits
    private ArrayList<Character> characterInSpot; //all the character in a spot
    private ArrayList<Item> objectInSpot; //all the item in a spot
    private boolean isVisible; //True if the spot is visible
    private boolean fighting; //boolean if a monster and a player are in the same spot
    private boolean spotCorrect; //boolean if the spot is well created

    /**
     * Create a spot with a Haspmap to know the direction of exit
     */
    public Spot(ArrayList<Character> characterSpot, ArrayList<Item>objectSpot) 
    {
        exits = new HashMap<String, Spot>();
        isVisible = false;
        fighting = false;
        spotCorrect = false;
        numberItem = 0;
        characterInSpot=characterSpot;
        objectInSpot=objectSpot;
    }
    
     /**
     * Method setExit: defines an exit from this spot
     * Replaces the setExits method
     *
     * @param direction the direction of the exit
     * @param neighbor the spot in the given direction

     * @version version 2018/11 
     */
     public void setExits(String direction, Spot neighbor){
        exits.put(direction, neighbor);
        spotCorrect = true;
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
     public Spot getExits(String direction){
        return exits.get(direction);
    }
    
    /**
     * return the number of item in the spot
     */
    public int getNumberOfItemInSpot()
    {
    return 0;
    }
    
    /**
     * Delete Spot
     */
    public void deleteSpot(Spot spot)
    {
        
    }
    
    /**
     * Method to exit a Spot
     */
    public void exit()
    {
    }
    
    /**
     * setter of isVisible
     */
    public void setVisible()
    {
        isVisible=true;
    }
    
    /**
     * getter of isVisible
     */
    public boolean getVisible()
    {
        return(isVisible);
    }
    
    /**
     * Add Item at Spot
     */
    public void addItemSpot(Item items){
    }
    
    /** 
     * Add Character at Spot
     */
    public void addCharacterSpot(Character Player){
    }
    
    /**
     * Get the list of character
     */
    public ArrayList getListCharacter()
    {
        return(characterInSpot);
    }
    
    /**
     * Get the list of items
     */
    public ArrayList getListItem()
    {
        return(objectInSpot);
    }

}
