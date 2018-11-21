 import java.util.*;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.Iterator;
 import java.util.Set;

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
    private int numberMaxItem; //A spot contains between at most 5 items
    private HashMap<String, Spot> exits = new HashMap<String, Spot>(); //list of the exits
    private ArrayList<Character> characterInSpot; //all the character in a spot
    private ArrayList<Item> objectInSpot; //all the item in a spot
    private boolean isVisible; //True if the spot is visible
    private boolean fighting; //boolean if a monster and a player are in the same spot
    private boolean spotCorrect; //boolean if the spot is well created
    private boolean exitSpot; // boolean if the spot is an exit of the game
    private boolean startSpot; // boolean if the spot is the start of the game
    
    /**
     * Create a spot with a Haspmap to know the direction of exit.
     * The hashmap is empty and the boolean are all set to false.
     * The numberMaxItem is an attribute used to avoid hardcoding a value in several 
     * conditions.
     */
    public Spot(ArrayList<Character> characterSpot, ArrayList<Item>objectSpot) 
    {
        exits = new HashMap<String, Spot>();
        isVisible = false;
        fighting = false;
        spotCorrect = false;
        exitSpot = false;
        startSpot = false;
        numberMaxItem = 5;
        characterInSpot=characterSpot;
        objectInSpot=objectSpot;
    }
    
    /**
     * Method setExit: defines an exit from this spot. If the spot already has 4 exits,
     * a 5th one is not created.
     */
     public void setExits(String direction, Spot neighbor){
        exits.put(direction, neighbor);
        spotCorrect = true;
    }
    
    /**
     * Get the boolean for the attribute getCorrect. "True" if the spot is correct (meaning
     * that it has between 1 et 4 exits)
     */
    public boolean getCorrect()
    {
        return(this.spotCorrect);
    }
    
    /**
     * getter for the max number of items that may be available in a room
     */
     public int getNumberMaxItem()
     {
        return(this.numberMaxItem);
     }
  
    /**
     * Method getExit: returns the spot that we reach in the given direction
     * If there is no spot in that direction, returns null
     */
     public Spot getExits(String direction){
        return exits.get(direction);
     }
     
     /**
      * getter for the hashmap
      */
     public HashMap<String, Spot> getAllExit()
     {
        return exits;
     }

    /**
     * getter to know if the spot is an exit
     */
     public boolean getExitSpot()
     {
        return(this.exitSpot);
     }
    
    /**
     * setter to set if a spot is an exit
     */
    public void setExitSpot()
    {
        this.exitSpot=true;
    }
    
    /**
     * getter to get if the spot is a start
     */
    public boolean getStartSpot()
    {
        return(this.startSpot);
    }
    
    /**
     * setter to set if a spot is a start
     */
    public void setStartSpot()
    {
        this.startSpot=true;
    }
    
    /**
     * return the number of items in the spot
     */
    public int getNumberOfItemInSpot()
    {
        return (objectInSpot.size());
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
     * Add Item at Spot. If there are already the max number of items on the spot,
     * the item does not get in the room.
     */
    public void addItemSpot(Item items)
    {
    }
    
    /** 
     * Add Character at the spot. If there is already two characters, it does nothing
     * as there cannot be three caracters in a spot. 
     */
    public void addCharacterSpot(Character character)
    {
        
    }
    
    /**
     * Get the list of characters in the spot
     */
    public ArrayList getListCharacter()
    {
        return(characterInSpot);
    }
    
    /**
     * Get the list of items in the spot
     */
    public ArrayList getListItem()
    {
        return(objectInSpot);
    }
    
    /**
     * Remove item from a spot. If there is no character in that spot,
     * the method does nothing
     */
    public void removeItemSpot(Item item)
    {
    }
    
    /**
     * Remove character from a spot. If there is no character in that spot,
     * the method does nothing.
     */
    public void removeCharacterSpot(Character character)
    {
    }
    
     /**
     * Method getExitString *** to be commented
     * This method return all the key from the hashmap 
     * of the room
     */
     public String getExitString(){
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
   

}
