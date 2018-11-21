import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test PlayerTest.
 *
 * @author  Jeremie Guilbaud
 * @version 14/11/2018
 *
 * This class tested the methods of the class Player.
 */
public class PlayerTest

{
    protected Player myPlayer;
    /**
     * Constructeur de la classe-test PlayerTest
     */
    public PlayerTest()
    {
    }

    /**
     * Sets up the constructor that will be tested if no other constructor is defined
     */
    @Before
    public void setUp()
    {
        myPlayer = new Player(20,"Jimmy",2,2,1,1);
    }

    /**
     * 
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }

    /**
     * Test that a player created receives the right amount of health
     */
    @Test
    public void testGoodHP()
    {
        assertEquals(20, myPlayer.getHP());
    }
    

    /**
     * Test that a player can't be created with a null amount of hp
     */


    public void testNullHP()
    {
        Player testBadPlayer = new Player(20,"Jimmy",2,2,1,1);
        assertNotSame(0, testBadPlayer.getHP());
    }

     /**
     * Test that a player can't be created with a negative amount of hp
     */

    public void testBadHP()
    {
        Player testBadPlayer = new Player(20,"Jimmy",2,2,1,1);
        assertNotSame(-1, testBadPlayer.getHP());
    }

    
    /**
     * Test that a player can take a correct item
     */

    @Test
    public void testTakeItem()
    {
        Item potion = new Item("Health Potion","A potion that heals 5 HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(potion, myPlayer.getItems(0));
    }

    /**
     * Test that a player can take a correct item
     */

    @Test
    public void testTakeWrongItem()
    {
        //Item potion = new Item (1,2,-3);
        //myPlayer.takeItem(potion);
        //assertEquals(null, myPlayer.getItem(0));
    }

    /**
     * Test that a player can drink a potion and receives the right amount of hp
     */

    @Test
    public void testDrinkPotion()
    {
        //Item potion = new Item(0,0,5);
        //myPlayer.takeItem(potion);
        //myPlayer.drinkPotion();
        //assertEquals(25, myPlayer.getHP());
        //assertEquals(null, myPlayer.getItem(0));

    }
    
    /**
     * Test that a player cannot drink a potion if he
     * hasn't anay potion in the inventory
     */

    @Test
    public void testDrinkNoPotion()
    {
        myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP());     
    }

    /**
     * Test that the player cannot have his hp over his maxHP after
     * taking a potion
     */

    @Test
    public void testDrinkPotionOverHp()
    {
        myPlayer.setHp(19);
        myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP()); 
    }

    /**
     * Test that the player can drop an item that he has in his inventory
     */

    @Test
    public void testDropItem()
    {
        //Item potion = new Item (0,0,5);
        //myPlayer.takeItem(potion);
        //assertEquals(potion, myPlayer.getItem(0));
        //myPlayer.dropItem(0);
        //assertEquals(null, myPlayer.getItem(0));
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
        //myPlayer.getTimeToGo() = true;
        //myPlayer.getAriadneThread() = false;
        //myPlayer.teleportation();
        //assertEquals(game.sortieX,myPlayer.posX);
        //assertEquals(game.sortieY,myPlayer.posY);
  
    }
    
    /**
     * This method tests that the crit rate is 5 when xp is 2
     */
    @Test
    public void testCritRateAt2XP()
    {
        myPlayer.adjustCritRate();
        assertEquals(5,myPlayer.getCritRate());
    }
    
    /**
     * This method tests that CritRate is 0 when below 1xp
     */
    @Test
    public void testCritRateAt1XP()
    {
        myPlayer.setXp(1);
        assertEquals(0,myPlayer.getCritRate());
    }

    /**
     * This method tests if maximum Hp is indeed 20
     */
    @Test
    public void testMaxHp()
    {
        assertEquals(20,myPlayer.getHPMax());
    }
    
    /**
     * This method tests if the item limit is 10
     */
    @Test
    public void testItemLimit()
    {
        assertEquals(10,myPlayer.getLimitItem());
    }

    
}
