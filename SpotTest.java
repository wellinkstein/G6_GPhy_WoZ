import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set; 

/**
 * Classe-test SpotTest.
 * Tests the different methods defined in the class Spot
 *
 * @author  Ludivine H & Jeremie G
 * @version 2018-11
 *
 */
public class SpotTest
{
    private ArrayList<Character> characterInSpot;
    private ArrayList<Item> objectInSpot;
    String direction = "Q";
    private Item it1, it2, it3, it4, it5, it6;
    private Player player, player1;
    private Lesser_Boss monster1, monster; 
    private Boss monster2; 
    private Spot spot, neighbor, anotherSpot;
      
    /**
     * Constructeur de la classe-test SpotTest
     */
    public SpotTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Methode appelee avant chaque appel de methode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        it1 = new Item("name1", "description", 1, 3,1); 
        it2 = new Item("name2", "description", 1, 3,1);
        it3 = new Item("name3", "description", 1, 3,1);
        it4 = new Item("name4", "description", 1, 3,1);
        it5 = new Item("name5", "description", 1, 3,1);
        it6 = new Item("name6", "description", 1, 3,1);
        objectInSpot= new ArrayList <Item> ();
        characterInSpot= new ArrayList <Character> ();
        player= new Player(20, "player", 1, 2,2);
        monster1= new Lesser_Boss(30,"Chimera", 0, 2,2, "io");  
        monster2=new Boss(75, "Minautor", 0, 15,7, "oiu"); 
        spot = new Spot(characterInSpot, objectInSpot);
        neighbor = new Spot(characterInSpot, objectInSpot);
        anotherSpot = new Spot(characterInSpot, objectInSpot);
    }

    /**
     * Supprime les engagements
     *
     * Methode appelee apres chaque appel de methode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Liberez ici les ressources engagees par setUp()
    }   
   
    /**
     * Check that the attributes values are set to the right one.
     */
    @Test
    public void testCreationSpot()
    {
        assertEquals(0, objectInSpot.size());
        assertEquals(0, spot.getNumberOfItemInSpot());
        assertEquals(0, spot.getListCharacter().size()); // getListCharacter returns an array
        assertEquals(0, spot.getListItem().size());
        assertFalse(spot.getVisible());
        assertFalse(spot.getCorrect());
        assertFalse(spot.getExitSpot());   
        assertFalse(spot.getStartSpot());
        assertEquals(5, spot.getNumberMaxItem());
        assertEquals(0,spot.getNumberExits());
    }
    
    /** 
     * Test verify if spot is corrected
     */
    @Test
    public void testSpotCorrect()

    {   spot.setExits("Q", neighbor);
        assertTrue(spot.getCorrect());    
    }
    
    /**
     * Test add new exit to a spot
     */
    @Test
    public void testSetExits()
    {
        spot.setExits("Q", neighbor);
        boolean test=false; 
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="Q" && mapentry.getValue()==neighbor){
                test= true; 
            }
        }
        assertTrue(test); 
        assertEquals(1, spot.getNumberExits());
    }
    
    /**
     * Test adding new exit to a spot, if there are already 4 exits
     */
    @Test
    public void testAdd5Exits()
    {
        spot.setExits("Q", neighbor);
        spot.setExits("Z", neighbor);
        spot.setExits("S", neighbor);
        spot.setExits("D", neighbor);
        assertEquals(4, spot.getNumberExits());
        spot.setExits("E", anotherSpot);
        boolean test=true; 
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="D" && mapentry.getValue()==anotherSpot){
                test= false; 
            }
        }
        assertFalse(test); 
        assertEquals(4, spot.getNumberExits());
    }
    
    /**
     * Test adding a new exit to the same direction as the previous one. It shoud not add
     * the new entry and keep the previous one.
     */
    @Test
    public void verifyNotSameDirectionHashmap()
    {
        spot.setExits("D", neighbor);
        spot.setExits("D", anotherSpot);
        int counter = 0;
        boolean test = false;
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="D"){
                counter+=1;
            }
        }
        assertEquals(1,counter);
        
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="D"&& mapentry.getValue()==neighbor){
                test=true;
            }
        }
        assertTrue(test);
    }
    
    /**
     * Test which verify if the character is added at the list when added to the spot.
     */
    @Test
    public void verifyAddCharacter()
    {
        spot.addCharacterSpot(player);
        boolean test= false; 
        for (int i =0; i<spot.getListCharacter().size(); i++){
            if (spot.getListCharacter().get(i) == player){
                test=true;
            }
        }
        assertEquals(true, test);
    }
    
    /**
     * Test which verify if an item is added at the list of the spot.
     */
    @Test
    public void verifyItemList(){
        spot.addItemSpot(it1);
        boolean test= false; 
        for (int i=0; i<spot.getListItem().size(); i++){
            if (spot.getListItem().get(i) == it1){
                test=true;
            }
        }
        assertEquals(true, test);
    }
    
    /**
     * Test Item can not be > numberMaxItem. If another item is added, the previous
     * ones are kept and the new one stays where it was.
     */
    @Test
    public void testItemsSupMaxItem()
    {
        spot.addItemSpot(it1); 
        spot.addItemSpot(it2);
        spot.addItemSpot(it3);
        spot.addItemSpot(it4);
        spot.addItemSpot(it5);
        assertEquals(spot.getNumberMaxItem(), spot.getNumberOfItemInSpot());
        spot.addItemSpot(it6);
        assertEquals(spot.getNumberMaxItem(), spot.getNumberOfItemInSpot());
        
    }
    
    /**
     * Test which verify if there is only one monster in a spot when another one is created.
     * The new one should not be part of the spot and the previous one stays in the spot.
     */
    @Test
    public void testOneMonsterSpot(){ 
        spot.addCharacterSpot(monster1); 
        spot.addCharacterSpot(monster2); 
        boolean test= false; 
        for (int i=0; i<spot.getListCharacter().size(); i++){
            if (spot.getListCharacter().get(i) == monster1 && spot.numberOfMonsterInSpot()==1){
                test=true;
            }
        }
        assertTrue(test); 
    }
    
    /**
     * Test that when an Item is removed, it is removed from the array list of the spot
     */
    @Test
    public void testItemRemoveItem()
    {
        spot.addItemSpot(it1);
        spot.removeItemSpot(it1);
        boolean test = true;
        for (int i=0; i<spot.getListItem().size(); i++){
            if (spot.getListItem().get(i) == it1){
                test=false;
            }
        }
        assertTrue(test);
    }
    
    // /**
     // * Test which verifiy if there is only 2 characters and not 2 players on a spot at
     // * the same time. The new player isn't added to the spot and the previous one will
     // * stay there.
     // */
    // @Test
    // public void TestNot2Players(){
     // spot.addCharacterSpot(player); 
     // spot.addCharacterSpot(player1); 
     // spot.addCharacterSpot(monster); 
     // boolean test= true; 
        // for (int i=0; i<spot.getListCharacter().size(); i++){
            // if (spot.getListCharacter().get(i) == player1){
                // test=false;
            // }
        // }
        // assertFalse(test);
        // assertEquals(2, spot.getListCharacter().size()); 
        
    // }
    
    /**
     * Test that a spot may be set to be a start spot
     */
    @Test
    public void testSartSpot()
    {
        spot.setStartSpot();
        assertTrue(spot.getStartSpot());
    }
    
    /**
     * Test that a spot may be set to be an exit spot
     */
    @Test
    public void testExitSpot()
    {
        spot.setExitSpot();
        assertTrue(spot.getExitSpot());
    }
    
    /**
     * Test that a spot may be set to be a visible
     */
    @Test
    public void testIsVisible()
    {
        spot.setVisible();
        assertTrue(spot.getVisible());
    }
    
    /**
     * Test than when a character is removed from the spot and that there is no
     * character in it, the list of characters for that room remains empty
     */
    @Test
    public void testRemoveCharacter()
    {
        spot.addCharacterSpot(player);
        spot.removeCharacterSpot(player);
        boolean test = true;
        for (int i=0; i<spot.getListCharacter().size(); i++){
            if(spot.getListCharacter().get(i) == player){
                test=false;
            }
        }
        assertEquals(0,spot.getListCharacter().size());
        assertTrue(test);
    }

    /**
     * Test to verify it is possible to set the boolean fighting to true if there are 2
     * characters
     */
    @Test
    public void testFightingTrue()
    {
     spot.addCharacterSpot(player1); 
     spot.addCharacterSpot(monster); 
     assertTrue(spot.getFighting());
    }
    
    /**
     * Test to verify it is possible to set the boolean fighting to false if there is 1
     * monster
     */
    @Test
    public void testFightingFalse1Monster()
    {
     spot.addCharacterSpot(monster); 
     assertFalse(spot.getFighting());
    }
    
    /**
     * Test to verify it is possible to set the boolean fighting to false if there is 1
     * player
     */
    @Test
    public void testFightingFalse1Player()
    {
     spot.addCharacterSpot(player); 
     assertFalse(spot.getFighting());
    }
    
}
