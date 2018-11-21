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
    private boolean exitSpot;
    private boolean startSpot;
    
    /**
     * Create a spot with a Haspmap to know the direction of exit
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
    
    public boolean getCorrect()
    {
        return(this.spotCorrect);
    }
    
    public int getNumberMaxItem()
    {
        return(this.numberMaxItem);
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
<<<<<<< HEAD
=======
    
    /**
     * Method : returns the exits of 
     */
    public Spot getExits()
    {
       return this.exits.getKey() + this.exits.getValue(); 
    }
>>>>>>> e1acea3e38f1d881f8de2b86d6b235569e995a46
    
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
     * return the number of item in the spot
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
     * Add Item at Spot
     */
    public void addItemSpot(Item items)
    {
    }
    
    /** 
     * Add Character at Spot
     */
    public void addCharacterSpot(Character character)
    {
        
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
    
    /**
     * Remove item from a spot
     */
    public void removeItemSpot(Item item)
    {
    }
    
    /**
     * Remove charactere from a spot
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
