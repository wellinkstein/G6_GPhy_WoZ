import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * Class Spot  
 *
 * A "Spot" represents one location in the scenery of the game.  It is 
 * connected to other spots via exits. There cannot be more than 4 exits for one spot.
 * The exits are labelled north, east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * There cannot have more than 2 characters in a spot and not more than 1 monster.
 * A Spot contains at most 5 items
 * 
 * @author  Groupe 6
 * @version 14/11/2018
 */
public class Spot
{
    private int numberMaxItem;
    private HashMap<String, Spot> exits = new HashMap<String, Spot>(); //list of the exits.
    private ArrayList<Character> characterInSpot; //all the character in a spot. 
    private ArrayList<Item> objectInSpot; //all the item in a spot, cannot be greater than number max item.
    private boolean exitSpot; // boolean if the spot is an exit of the game
    private boolean startSpot; // boolean if the spot is the start of the game
    private String imageSpot; // name of the image representing a spot

    /**
     * Create a spot with a Haspmap to know the direction of exit.
     * The hashmap is empty and the boolean are all set to false.
     * The numberMaxItem is an attribute used to avoid hardcoding a value in several 
     * conditions.
     * @param characterSpot : all the character in the spot
     * @param objectSpot : all the objects (Items) in the spot
     */
    public Spot() 
    {
        exits = new HashMap<String, Spot>();
        exitSpot = false;
        startSpot = false;
        numberMaxItem = 5;
        characterInSpot= new ArrayList<Character>(); //characterSpot;
        objectInSpot= new ArrayList<Item>(); //objectSpot;
        setImageSpotExistDirections(); //set the picture of the spot
    }

    /**
     * Method setExit: defines an exit from this spot. If the spot already has 4 exits,
     * a 5th one is not created and the 4 previously created stay the same.
     * @param direction : the direction of the exit
     * @param neighbor : the neighbor spot
     */
    public void setExits(String direction, Spot neighbor)
    {
        boolean exist=false; 
        if (this.getNumberExits()<4)
        {
            for (Map.Entry mapentry: this.getAllExit().entrySet())
            {
                if (mapentry.getKey()==direction || mapentry.getValue()==neighbor)
                {
                    exist=true; 
                }
            }
        }
        if (exist ==false)
        {
            exits.put(direction, neighbor);
        }
        setImageSpotExistDirections(); //set the picture of the spot
    }

    /**
     * Get the image value for the spot
     * @return string imageSpot: returns the name of the image of the spot
     */
    public String getImageSpot()
    {
        return(this.imageSpot);
    }

    /**
     * Set the image value for the spot
     * @param imageString: the name of the image for the spot
     */
    public void setImageSpot(String imageSpot)
    {
        this.imageSpot = imageSpot;
    }

    /**
     * Set the image of the spot depending of the number of exits
     * and there direction
     * Z : 1
     * D : 2
     * S : 3
     * Q : 4
     */
    public void setImageSpotExistDirections()
    {
        String valueExits = ""; //gives the list of exits and their direction
        Set<String> keys = exits.keySet();
        for(String exit : keys) 
        {
            switch(exit){
                case "Z": valueExits += "Z";
                break;

                case "D": valueExits += "D";
                break;

                case "S": valueExits += "S";
                break;

                default: valueExits += "Q";
                break;
            }
        }

        switch(valueExits)
        {
            case "": setImageSpot("0");
            break;

            case "Z": setImageSpot("1");
            break;

            case "D": setImageSpot("2");
            break;

            case "S": setImageSpot("3");
            break;

            case "Q": setImageSpot("4");
            break;

            case "ZD":
            case "DZ": 
            setImageSpot("12");
            break;

            case "ZS":
            case "SZ":
            setImageSpot("13");
            break;

            case "ZQ":
            case "QZ":
            setImageSpot("14");
            break;

            case "DS":
            case "SD":
            setImageSpot("23");
            break;

            case "DQ":
            case "QD":
            setImageSpot("24");
            break;

            case "SQ":
            case "QS":
            setImageSpot("34");
            break;

            case "ZDS":
            case "ZSD":
            case "DZS":
            case "DSZ":
            case "SDZ":
            case "SZD":
            setImageSpot("123");
            break;

            case "ZDQ":
            case "ZQD":
            case "DQZ":
            case "DZQ":
            case "QZD":
            case "QDZ":
            setImageSpot("124");
            break;

            case "ZSQ":
            case "ZQS":
            case "SQZ":
            case "SZQ":
            case "QZS":
            case "QSZ":
            setImageSpot("134");
            break;

            case "DSQ":
            case "DQS":
            case "SQD":
            case "SDQ":
            case "QSD":
            case "QDS":
            setImageSpot("234");
            break;

            default:
            setImageSpot("1234");
            break;

        }
    }

    /**
     * getter for the max number of items that may be available in a spot
     * @return int numberMaxItem : The number max of Item in a spot
     */
    public int getNumberMaxItem()
    {
        return(this.numberMaxItem);
    }

    /**
     * Method getExit: returns the spot that we reach in the given direction
     * If there is no spot in that direction, returns null
     * @param direction : The direction of the exit of spot
     * @return Spot : The spot which have an exit at the direction given
     */
    public Spot getExits(String direction){
        return exits.get(direction);
    }

    /**
     * Remove an exit 
     * @param direction The direction of the exit of spot
     */
    public void removeExit(String direction)
    {
        exits.remove(direction);
        setImageSpotExistDirections(); //change the picture of the room
    }

    /**
     * Get the number of exits in the hashmap
     * @return int : the number of the exits in a spot
     */
    public int getNumberExits()
    {
        return(this.exits.size());
    }

    /**
     * getter for the hashmap
     * @return the exits of the haspmap
     */
    public HashMap<String, Spot> getAllExit()
    {
        return exits;
    }

    /**
     * getter for the spot reachable from the current spot
     * @return ArrayList<String> spotExitable: return a list of the 
     */
    public ArrayList<String> getSpotExitable()
    {
        ArrayList<String> spotExitable;
        spotExitable = new ArrayList<String>();
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            spotExitable.add(exit);
        }
        return spotExitable;
    }

    /**
     * getter to know if the spot is an exit
     * @return a boolean : if the spot is an exit
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
     * @return boolean: True if the spot is a start
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
     * @return int number of item in a spot
     */
    public int getNumberOfItemInSpot()
    {
        return (objectInSpot.size());
    }

    /**
     * Add Item at Spot. If there are already the max number of items on the spot,
     * the item does not get in the room.
     * @param Items The Item that we want to add in a spot
     */
    public void addItemSpot(Item items)
    {
        if(getNumberOfItemInSpot()<numberMaxItem)
        {
            objectInSpot.add(items);
        }
    }

    /** 
     * Add Character at the spot. If there is already two characters, it does nothing
     * as there cannot be three caracters in a spot. 
     * @param character The character that we want to add in a spot
     */
    public void addCharacterSpot(Character character)
    {   
        if(getIfCharacterInSpot(character)==false || numberOfMonsterInSpot()==0)
        {
            this.characterInSpot.add(character);
        }
    }

    /**
     * True if the character is in the spot
     * @param character : To verify if the character is in the spot
     */
    public Boolean getIfCharacterInSpot(Character character){
        if(this.getListCharacter().contains(character)) 
        {
            return (true); 
        }
        else 
        {
            return(false); 
        }
    }

    /**
     * Get the list of characters in the spot
     * @return arraylist characterInSpot
     */
    public ArrayList<Character> getListCharacter()
    {
        return(characterInSpot);
    }

    /**
     * Getter to return the number of Monster in a spot
     * @return number of the Monster in a spot
     */
    public int numberOfMonsterInSpot(){
        int number=0; 
        for (Character character : this.characterInSpot){
            if(character.getName()== "Chimera" || character.getName()== "Cerberus" ||character.getName()== "Medusa" 
            || character.getName()== "Cyclops" || character.getName()== "Arachne"|| character.getName()=="Minotaur"){
                number++; 
            }  
        }
        return (number); 
    }

    /**
     * Get the list of items in the spot
     * @return objectInSpot
     */
    public ArrayList<Item> getListItem()
    {
        return(objectInSpot);
    }
    
    /**
     * Get the item at this index
     * @return an item
     */
    public Item getOneItem(int i)
    {
        return(objectInSpot.get(i));
    }


    /**
     * Remove item from a spot. If there is no character in that spot,
     * the method does nothing
     * @param item The Item that we want to remove
     */
    public void removeItemSpot(Item item)
    {
        objectInSpot.remove(item);
    }

    /**
     * Remove character from a spot. If there is no character in that spot,
     * the method does nothing.
     * @param character The character that we want to remove
     */
    public void removeCharacterSpot(Character character)
    {
        characterInSpot.remove(character);
    }

    /**
     * Return monster in the spot. If there is no monster in that spot,
     * the method returns nothing.
     * @return Character monster: returns the monster in the spot
     */
    public Monster getMonster()
    {
        for (int i =0; i<getListCharacter().size(); i++){
            if(getListCharacter().get(i)!=null){
                if(getListCharacter().get(i).getName()== "Chimera" || getListCharacter().get(i).getName()== "Cerberus" 
                ||getListCharacter().get(i).getName()== "Medusa" 
                || getListCharacter().get(i).getName()== "Cyclops" || getListCharacter().get(i).getName()== "Arachne"
                || getListCharacter().get(i).getName()=="Minotaur"){
                    return((Monster)getListCharacter().get(i));
                }
            }  
        }
        return(null);

    }

    /**
     * Return lesser boss in the spot. If there is no monster in that spot,
     * the method returns nothing.
     * @return LesserBoss monster: returns the lesser boss in the spot
     */
    public LesserBoss getLesserBoss()
    {
        for (int i =0; i<getListCharacter().size(); i++){
            if(getListCharacter().get(i)!=null){
                if(getListCharacter().get(i).getName()== "Chimera" || getListCharacter().get(i).getName()== "Cerberus" 
                ||getListCharacter().get(i).getName()== "Medusa" 
                || getListCharacter().get(i).getName()== "Cyclops" || getListCharacter().get(i).getName()== "Arachne"){
                    return((LesserBoss)getListCharacter().get(i));
                }
            }  
        }
        return(null);

    }

    /**
     * Return boss in the spot. If there is no monster in that spot,
     * the method returns nothing.
     * @return Boss monster: returns the boss in the spot
     */
    public Boss getBoss()
    {
        for (int i =0; i<getListCharacter().size(); i++){
            if(getListCharacter().get(i)!=null){
                if(getListCharacter().get(i).getName()== "Minotaur"){
                    return((Boss)getListCharacter().get(i));
                }
            }  
        }
        return(null);

    }

    /**
     * Return player in the spot. If there is no player in that spot,
     * the method returns null.
     * @return Player character: returns the player in the spot
     */
    public Player getPlayer()
    {
        for (int i =0; i<getListCharacter().size(); i++){
            if(getListCharacter().get(i)!=null){
                if( getListCharacter().get(i).getName()=="Theseus"){
                    return ((Player)getListCharacter().get(i));
                }
            }
        }
        return(null);        
    }

    /**
     * This method return all the key from the hashmap 
     * of the room
     * @return returnString all the key from the hashmap
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
