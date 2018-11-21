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
 *
 * @author  Ludivine H & Jeremie G
 * @version 2018-11
 *
 * Les classes-test sont documentees ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basees sur le document e 2002 Robert A. Ballance intitule
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associes aux classes e tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m?me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque methode Test e executer.  Il peut y avoir
 * plus d'une methode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ decouvrira automatiquement (par introspection) les methodes
 * Test de votre classe Test et generera la TestSuite consequente.
 * Chaque appel d'une methode Test sera precede d'un appel de setUp(),
 * qui realise les engagements, et suivi d'un appel e tearDown(), qui les
 * detruit.
 */
public class SpotTest
{
    private ArrayList<Character> characterInSpot;
    private ArrayList<Item> objectInSpot;
    String direction = "Q";
    private Item it1, it2, it3, it4, it5, it6;
    private Player player, player1;
    private Lesser_Boss monster1, monster; 
    private Lesser_Boss monster2; 
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
        player= new Player(20, "player", 1, 2); 
        Spot spot = new Spot(characterInSpot, objectInSpot);
        Spot neighbor = new Spot(characterInSpot, objectInSpot);
        Spot anotherSpot = new Spot(characterInSpot, objectInSpot);
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
    public void testCreationSpot()
    {
        assertNull(spot.getListCharacter());
        assertNull(spot.getListItem());
        assertFalse(spot.getVisible());
        assertFalse(spot.getCorrect());
        assertFalse(spot.getExitSpot());   
        assertFalse(spot.getStartSpot());
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
     * Test add new exit a spot
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
        spot.addCharacterSpot(player); 
        spot.addCharacterSpot(monster1); 
        spot.addCharacterSpot(monster2); 
        boolean test= true; 
        for (int i=0; i<spot.getListCharacter().size(); i++){
            if (spot.getListCharacter().get(i) == monster2){
                test=false;
            }
        }
        assertFalse(test);
        assertEquals(2, spot.getListCharacter().size()); 
        
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
     * Test which verifiy if there is only 2 characters and not 2 players on a spot at
     * the same time. The new player isn't added to the spot and the previous one will
     * stay there.
     */
    public void TestNot2Players(){
     spot.addCharacterSpot(player); 
     spot.addCharacterSpot(player1); 
     spot.addCharacterSpot(monster); 
     boolean test= true; 
        for (int i=0; i<spot.getListCharacter().size(); i++){
            if (spot.getListCharacter().get(i) == player1){
                test=false;
            }
        }
        assertFalse(test);
        assertEquals(2, spot.getListCharacter().size()); 
        
    }
    
    /**
     * Test than when an item is removed from the spot and that there is no
     * item in it, the list of items of the spot remains empty
     */
    @Test
    public void testRemoveNoItem()
    {
        spot.removeItemSpot(it1);
        boolean test = true;
        for (int i=0; i<spot.getListItem().size(); i++){
            if(spot.getListItem().get(i) == it1){
                test=false;
            }
        }
        assertEquals(0,spot.getListItem().size());
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
     * Test that it is not possible to remove a character in a spot if there are no
     * characters in it.
     */
    @Test
    public void testRemoveNoCharacter()
    {
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
