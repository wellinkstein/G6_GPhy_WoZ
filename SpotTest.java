import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    
    Spot neighbor = new Spot();
    String direction = "Q";
    private Item it1, it2, it3, it4, it5, it6;
    private Player player; 
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
        it1 = new Item("name1", "description", 1, 3); 
        it2 = new Item("name2", "description", 1, 3);
        it3 = new Item("name3", "description", 1, 3);
        it4 = new Item("name4", "description", 1, 3);
        it5 = new Item("name5", "description", 1, 3);
        it6 = new Item("name6", "description", 1, 3);
        player= new Player(20, "player", 0, 2, 5, 5) ; 
        Spot spot = new Spot();

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
        spot.addItem(it1); 
        spot.addItem(it2);
        spot.addItem(it3);
        spot.addItem(it4);
        spot.addItem(it5);// rajouter 5 items
        assertEquals(5, spot.getNumberOfItemInSpot());
        spot.addItem(it6);// Rajouter 1 item
        assertEquals(5, spot.getNumberOfItemInSpot());
        
    }
    
    /**
     * Test Spot new exit
     */
    @Test
    public void setExits(String direction, Spot neighbor)
    {
        
    }
    
    /**
     * Test badSpot creation
     */
    @Test
    public void testBadRoom()
    {
        
        //assertfalse(badRoom.get(spotCorrect));
    }
    /**
     * Test which verify if character is added at the list.
     */
    public void verifyCharacterList(){
        spot.addCharacter(player);
        boolean test= false; 
        for (int i =0; i<spot.getListCharacter().size(); i++){
            if (spot.getListCharacter().get(i) == player){
                test=true;
            }
        }
        assertEquals(true, test);
        
    }
     /**
     * Test which verify if item is added at the list.
     */
    public void verifyItemList(){
        spot.addItem(it1);
        boolean test= false; 
        for (int i =0; i<spot.getListItem().size(); i++){
            if (spot.getListItem().get(i) == it1){
                test=true;
            }
        }
        assertEquals(true, test);
        
    }
    
    // Verifier si supprime bien de la liste
    //Si pas deux characters ou items à la même place
    
    
    /**
     * Test that when an Item is added, the number of items in the spot is updated
     */
    @Test
    public void testNumberItemAddItem()
    {
        
    }
    
    /**
     * Test that when an Item is removed, the number of items in the spot is updated
     */
    @Test
    public void testNumberItemRemoveItem()
    {
    }
    
    
}
