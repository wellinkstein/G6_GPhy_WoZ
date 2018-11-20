import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test PlayerTest.
 *
 * @author  Jérémie Guilbaud
 * @version 14/11/2018
 *
 * This class tested the methods of the class Player.
 */
public class PlayerTest
{
    /**
     * Constructeur de la classe-test PlayerTest
     */
    public PlayerTest()
    {
        Player testPlayer = new Player(20);
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {

    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    /**
     * Test that a player created receives the right amount of health
     */
    @Test
    public void testGoodHP()
    {
        Player testPlayer = new Player(5);
        assertEquals(5, testPlayer.getHP());

    }

    /**
     * Test that a player can't be created with a null amount of hp
     */


    public void testNullHP()
    {
    Player testBadPlayer = new Player(0);
    assertNotSame(0, testBadPlayer.getHP());
    }

     /**
     * Test that a player can't be created with a negative amount of hp
     */

    public void testBadHP()
    {
    Player testBadPlayer = new Player(-1);
    assertNotSame(-1, testBadPlayer.getHP());
    }

    
    /**
     * Test that a player can take a correct item
     */

    @Test
    public void testTakeItem()
    {
        Item potion = new Item(0,0,5);
        testPlayer.takeItem(potion);
        assertEquals(potion, testPlayer.getItem(0));
    }

    /**
     * Test that a player can take a correct item
     */

    @Test
    public void testTakeWrongItem()
    {
        Item potion = new Item (1,2,-3);
        testPlayer.takeItem(potion);
        assertEquals(null, testPlayer.getItem(0));
    }

    /**
     * Test that a player can drink a potion and receives the right amount of hp
     */

    @Test
    public void testDrinkPotion()
    {
        testPlayer.setHP(10);
        Item potion = new Item(0,0,5);
        testPlayer.takeItem(potion);
        testPlayer.drinkPotion();
        assertEquals(15, testPlayer.getHP());
        assertEquals(null, testPlayer.getItem(0));

    }
    
    /**
     * Test that a player cannot drink a potion if he
     * hasn't anay potion in the inventory
     */

    @Test
    public void testDrinkNoPotion()
    {
        testPlayer.setHP(10);
        testPlayer.drinkPotion();
        assertEquals(10, testPlayer.getHP());     
    }

    /**
     * Test that the player cannot have his hp over his maxHP after
     * taking a potion
     */

    @Test
    public void testDrinkPotionOverHp()
    {
        testPlayer.setHP(19);
        testPlayer.drinkPotion();
        assertEquals(20, testPlayer.getHP()); 
    }

    /**
     * Test that the player can drop an item that he has in his inventory
     */

    @Test
    public void testDropItem()
    {
        Item potion = new Item (0,0,5);
        testPlayer.takeItem(potion);
        assertEquals(potion, testPlayer.getItem(0));
        testPlayer.dropItem(0);
        assertEquals(null, testPlayer.getItem(0));
    }
    
    /**
     * Test that an item that is not in the inventory of the player
     * cannot be dropped
     */
    
    @Test
    public void testDropFalseItem()
    {
        
    }
    
    /**
     * Test that an item cannot be added to the inventory
     * if the player carries the maximum amount of items
     */

    @Test
    public void testGetOverMaxItem()
    {
        
    }
    
    @Test
    public void testTeleportSansFil() {
        player.getTimeToGo() = true;
        player.getAriadneThread() = false;
        player.teleportation();
        assertEquals(game.sortieX,player.posX);
        assertEquals(game.sortieY,player.posY);
  
    }

}
