import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test PlayerTest.
 *
 * @author  Group 6
 * @version 2018-11-27
 *
 * This class tested the methods of the class Player.
 */
public class PlayerTest

{
    protected Player myPlayer;
    /**
     * Constructor of the player class
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
        myPlayer = new Player(20,"Jimmy",2,2);
    }

    /**
     * Removes the set up at theend of the tests
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }

    /**
     * Tests that a player created receives the right amount of health
     */
    @Test
    public void testGoodHP()
    {
        assertEquals(20, myPlayer.getHP());
    }
    

    /**
     * Tests that a player can't be created with zero hp
     */
    public void testNullHP()
    {
        Player testBadPlayer = new Player(20,"Jimmy",2,2);
        assertNotSame(0, testBadPlayer.getHP());
    }

     /**
     * Tests that a player can't be created with a negative amount of hp
     */

    public void testBadHP()
    {
        Player testBadPlayer = new Player(-1,"Jimmy",2,2);
        assertNotSame(-1, testBadPlayer.getHP());
    }

    
    /**
     * Tests that a player can take a valid item
     */

    @Test
    public void testTakeItem()
    {
        Item potion = new Item("Health Potion","A potion that heals 5 HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(1,myPlayer.inventory.size());
        assertEquals(potion, myPlayer.getItems(0));
    }

    /**
     * Tests that a player can drink a potion and receives the correct amount of hp
     */

    @Test
    public void testDrinkPotion()
    {
        myPlayer = new Player(15,"Jimmy",2,2);
        Item potion = new Item("Health Potion","Heals for 5 hp",0,0,5);
        Item potion2 = new Item("Health Potion","Heals for 5 hp",0,0,5);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion2);
        myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP());
        assertEquals(1, myPlayer.inventory.size());

    }
    
    /**
     * Tests that a player keeps other items when drinking a health potion
     * He only "loses" the health potion used.
     */

    @Test
    public void testDrinkPotionWithSword()
    {
        myPlayer = new Player(15,"Jimmy",2,2);
        Item potion = new Item("Health Potion","Heals for 5 hp",0,0,5);
        Item sword = new Item("Iron Sword","A medium length blade",3,0,0);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(sword);
        myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP());
        assertEquals(1, myPlayer.inventory.size());

    }
    
    
    /**
     * Tests that a player cannot drink a potion if he
     * does not have a potion in his inventory
     */

    @Test
    public void testDrinkNoPotion()
    {
        myPlayer = new Player(15,"Jimmy",2,2);
        myPlayer.drinkPotion();
        assertEquals(15, myPlayer.getHP());     
    }

    /**
     * Tests that the player cannot have his hp over his maxHP after
     * taking a potion
     */

    @Test
    public void testDrinkPotionOverHp()
    {
        Item potion = new Item("Health Potion","Heals for 5 hp",0,0,5);
        myPlayer.takeItem(potion);
        myPlayer.setHp(19);
        myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP()); 
    }

    /**
     * Tests that the player can drop an item that he has in his inventory
     * He should be able to drop the item
     */

    @Test
    public void testDropItem()
    {
        Item potion = new Item ("Health Potion","A potion that heals five HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(potion, myPlayer.getItems(0));
        myPlayer.dropItem(potion);
        assertEquals(0, myPlayer.inventory.size());
    }
    
    /**
     * Tests that an item that is not in the inventory of the player
     * cannot be dropped
     */
    
    @Test
    public void testDropFalseItem()
    {
       Item potion = new Item ("Health Potion","A potion that heals five HP",0,0,5);
       Item potion2 = new Item ("Health Potion","A potion that heals five HP",0,0,5);
       myPlayer.takeItem(potion);
       assertEquals(potion, myPlayer.getItems(0));
       myPlayer.dropItem(potion2); 
       assertEquals(1,myPlayer.inventory.size());
    }
    
    /**
     * Tests that an item cannot be added to the inventory
     * if the player already carries the maximum amount of items
     */

    @Test
    public void testGetOverMaxItem()
    {
        Item potion = new Item ("Health Potion","A potion that heals five HP",0,0,5);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion);
        assertEquals(10,myPlayer.inventory.size());
    }
    
    /**
     * This method tests that the crit rate is 5 when xp is 2
     * As crit rate follow the following equation
     * critRate=(xp-1)*5
     */
    @Test
    public void testCritRateAt2XP()
    {
        myPlayer.adjustCritRate();
        assertEquals(5,myPlayer.getCritRate());
    }
    
    /**
     * This method tests that the crit rate cannot be over 50%
     */
    @Test
    public void testCritRateAt100XP()
    {
        myPlayer = new Player(15,"Jimmy",100,2);
        myPlayer.adjustCritRate();
        assertEquals(50,myPlayer.getCritRate());
    }
    
    /**
     * This method tests that CritRate is 0 when below 1xp
     * As crit rate follow the following equation
     * critRate=(xp-1)*5
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
     * The item limit should always be 10
     */
    @Test
    public void testItemLimit()
    {
        assertEquals(10,myPlayer.getLimitItem());
    }
    
    /**
     * This test checks if the boolean ariadnesThread is changed to true
     * if the player has the item
     */
    @Test
    public void testAriadnesThread()
    {
        Item GoldenThread = new Item ("Ariadne's golden thread","A mysterious piece of string",0,0,0);
        myPlayer.takeItem(GoldenThread);
        assertEquals(true,myPlayer.getThread());
    }

    /**
     * This test checks if the boolean ariadnesThread is false when picking
     * up items that are not ariadne's thread
     */
    @Test
    public void testAriadnesThreadBad()
    {
        Item GoldenThread = new Item ("Ariadne's golden thread","A mysterious piece of string",0,0,0);
        Item potion = new Item ("Health Potion","A potion that heals five HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(false,myPlayer.getThread());
    }
}
