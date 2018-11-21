import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Classe-test SpotTest.
 *
 * @author  Ludivin H & Jeremie G
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
    Spot neighbor = new Spot(characterInSpot, objectInSpot);
    String direction = "Q";
    private Item it1, it2, it3, it4, it5, it6;
    private Player player, player1;
    private Lesser_Boss monster1, monster; 
    private Lesser_Boss monster2; 
    private Spot spot; 
      
     /**
     * Constructeur de la classe-test RoomTest
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
        player= new Player(20, "player", 0, 2, 5, 5) ; 
        Spot spot = new Spot(characterInSpot, objectInSpot);
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
     * Test Spot creation
     */
    @Test
    public void testGoodRoom()
    {
        
        
    }
    
    /**
     * Test Item can not be >5 
     */
    @Test
    public void testItemsup5()
    {
        spot.addItemSpot(it1); 
        spot.addItemSpot(it2);
        spot.addItemSpot(it3);
        spot.addItemSpot(it4);
        spot.addItemSpot(it5);// rajouter 5 items
        assertEquals(5, spot.getNumberOfItemInSpot());
        spot.addItemSpot(it6);// Rajouter 1 item
        assertEquals(5, spot.getNumberOfItemInSpot());
        
    }
    
    /**
     * Test Spot new exit
     */
    @Test
    public void testSetExits(String direction, Spot neighbor)
    {
        
    }
    
    /**
     * Test badSpot creation
     */
    @Test
    public void testBadRoom()
    {
        assertFalse(spot.getCorrect());
    }
    
    /**
     * Test which verify if the character is added at the list.
     */
    public void verifyCharacterList(){
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
     * Test that when a Spot is not correct, the boolean is not correct. 
     */
    @Test
    public void testSpotNotCorrect(){
        
    }
    
    /**
     * Test which verify if there is only one monster in a spot
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
    public void testNumberItemRemoveItem()
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
    
    // Vérifier si un lesser monster ne peut pas aller dans la salle du boss
    // Vérifier 2 caractères --> fait
    // Vérifier pas 3 caratères --> fait
    // Vérifier removeCharactere quand list vide ne change pas la liste
    // Verifier si supprime bien item  de la liste --> fait
    // Vérifier si pas plus de 2 charactères dans la classe --> fait
    // Verifier si un spot pas correct et bien pas correcte (avec le boolean)
    
    /**
     * Test which verifiy if there is only 2 characters and not 2 players 
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
     * Test than when an item is removed from the array list and that there is no
     * item in that list, the list remains empty
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
    
    @Test
    public void testExitSpot()
    {
        spot.setExitSpot();
        assertTrue(spot.getExitSpot());
    }
    
    @Test
    public void testRemoveNoCharacter();
    
    
}
