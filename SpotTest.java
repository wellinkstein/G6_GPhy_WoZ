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
    private Legendary it1, it2, it3;
    private Common it4, it5, it6;
    private Player player, player1;
    private LesserBoss monster1; 
    private Boss monster2; 
    private Spot spot, neighbor, anotherSpot, neighbor1, neighbor2, neighbor3;
      
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
        it1 = new Legendary("Ariadne’s golden thread", "description", 1, 3,1); 
        it2 = new Legendary("Ares’s Sword", "description", 1, 3,1);
        it3 = new Legendary("Hermes’s Sandals", "description", 1, 3,1);
        it4 = new Common("Iron sword", "description", 1, 3,1);
        it5 = new Common("Iron dagger", "description", 1, 3,1);
        it6 = new Common("Standard bow", "description", 1, 3,1);
        objectInSpot= new ArrayList <Item> ();
        characterInSpot= new ArrayList <Character> ();
        player= new Player(20, "Theseus", 1, 2,2);
        monster1= new LesserBoss(30,"Arachne", 0, 2,2, "io", it1);  
        monster2=new Boss(75, "Minautor", 0, 15,7, "oiu"); 
        spot = new Spot();
        neighbor = new Spot();
        neighbor1 = new Spot();
        neighbor2 = new Spot();
        neighbor3 = new Spot();
        anotherSpot = new Spot();
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
     * Test to verify that it is possible to set a string for the attribute imageSpot
     */
    @Test
    public void testSetImageSpot()
    {
        spot.setImageSpot("name_image");
        assertEquals("name_image", spot.getImageSpot());
    }
    
    /**
     * Test to verify the right picture will be given to the spot
     */
    @Test
    public void testSetImageSpotExistDirections()
    {
        spot.setExits("Q", neighbor);
        spot.setExits("Z", neighbor1);
        assertEquals("14.png", spot.getImageSpot());
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
        assertEquals("4.png", spot.getImageSpot());
    }
    
    /**
     * Test remove exit to a spot
     */
    @Test
    public void testRemoveExits()
    {
        spot.setExits("Q", neighbor);
        boolean test=false; 
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="Q" && mapentry.getValue()==neighbor){
                test= true; 
            }
        }
        assertTrue(test); 
        assertEquals("4.png", spot.getImageSpot());
        spot.removeExits("Q", neighbor);
        test=false;
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="Q" && mapentry.getValue()==neighbor){
                test= true; 
            }
        }
        assertFalse(test);
        assertEquals("0.png", spot.getImageSpot());
        assertFalse(spot.getCorrect());
    }
    
    /**
     * Test getSpotExitable
     */
    @Test
    public void testGetSpotExitable()
    {
        spot.setExits("Q", neighbor);
        spot.setExits("A", neighbor1);
        ArrayList<String> test;
        test = new ArrayList<String>();
        test.add("Q");
        test.add("A");
        assertEquals(test,spot.getSpotExitable());
    }
    
    /**
     * Test adding new exit to a spot, if there are already 4 exits
     */
    @Test
    public void testAdd5Exits()
    {
        spot.setExits("Q", neighbor);
        spot.setExits("Z", neighbor1);
        spot.setExits("S", neighbor2);
        spot.setExits("D", neighbor3);
        assertEquals(4, spot.getNumberExits());
        spot.setExits("D", anotherSpot);
        boolean test=true; 
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="D" && mapentry.getValue()==anotherSpot){
                test= false; 
            }
        }
        assertFalse(test); 
        assertEquals(4, spot.getNumberExits());
        assertEquals("1234.png", spot.getImageSpot());
    }
    
    /**
     * Test if 2 spot can be added to the Hashmap with the same direction, if two spots are created with the same direction 
     * only the first one is kept
     */
    @Test
    public void testSameDirection()
    {
        spot.setExits("Q", neighbor);
        spot.setExits("Q", neighbor1);
        boolean test=true; 
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="Q" && mapentry.getValue()==neighbor1){
                test= false; 
            }
        }
        assertTrue(test); 
        assertEquals(1, spot.getNumberExits());
        assertEquals("4.png", spot.getImageSpot());
    }
    
    /**
     * Test if the same spot can be added to the Hashmap with different directions, if the same spot is created with
     * different directions only the first one is kept
     */
    @Test
    public void testSameSpot()
    {
        spot.setExits("Q", neighbor);
        spot.setExits("Z", neighbor);
        boolean test=true; 
        for (Map.Entry mapentry: spot.getAllExit().entrySet()){
            if (mapentry.getKey()=="Z" && mapentry.getValue()==neighbor){
                test= false; 
            }
        }
        assertTrue(test); 
        assertEquals(1, spot.getNumberExits());
        assertEquals("4.png", spot.getImageSpot());
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
        assertEquals("2.png", spot.getImageSpot());
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
        spot.addItemSpot(it4);
        boolean test= false; 
        for (int i=0; i<spot.getListItem().size(); i++){
            if (spot.getListItem().get(i) == it4){
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
     * Test that when there is a monster in a spot, the method
     * getMonster gives the monster
     */
    @Test
    public void testGetMonster()
    {
        spot.addCharacterSpot(monster1); 
        assertEquals(monster1,spot.getMonster());
    }
    
    /**
     * That that when there is only a player in a spot,
     * the method getMonster returns nothing
     */
    @Test
    public void testGetNoMonster()
    {
        assertNull(spot.getMonster());
        spot.addCharacterSpot(player);
        assertNotEquals(player, spot.getMonster());
        assertNull(spot.getMonster());
    }
    
    /**
     * Test that when there is a player in a spot, the method
     * getPlayer gives the player
     */
    @Test
    public void testGetPlayer()
    {
        spot.addCharacterSpot(player); 
        assertEquals(player,spot.getPlayer());
        assertNotNull(spot.getPlayer());
    }
    
    /**
     * Test that when there is no player in the room,
     * the method returns nothing
     */
    @Test
    public void testGetNoPlayer()
    {
        assertNull(spot.getPlayer());
        spot.addCharacterSpot(monster1); 
        assertNotEquals(player,spot.getPlayer());
        assertNull(spot.getPlayer());
        assertNotEquals(monster1,spot.getPlayer());
    }
}
