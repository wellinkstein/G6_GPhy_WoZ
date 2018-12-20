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
        myPlayer = new Player(20,"Jimmy",2,2,0);
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
        Player testBadPlayer = new Player(20,"Jimmy",2,2,0);
        assertNotSame(0, testBadPlayer.getHP());
    }

     /**
     * Tests that a player can't be created with a negative amount of hp
     */

    public void testBadHP()
    {
        Player testBadPlayer = new Player(-1,"Jimmy",2,2,0);
        assertNotSame(-1, testBadPlayer.getHP());
    }

    
    /**
     * Tests that a player can take a valid Common
     */

    @Test
    public void testtakeItem()
    {
        Common potion = new Common("Health Potion","A potion that heals 5 HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(1,myPlayer.inventory.size());
        assertEquals(potion, myPlayer.getItems(0));
    }

    // /**
     // * Tests that a player can drink a potion and receives the correct amount of hp
     // */

<<<<<<< HEAD
    // @Test
    // public void testDrinkPotion()
    // {
        // myPlayer = new Player(15,"Jimmy",2,2,0);
        // Common potion = new Common("Health Potion","Heals for 5 hp",0,0,5);
        // Common potion2 = new Common("Health Potion","Heals for 5 hp",0,0,5);
        // myPlayer.takeItem(potion);
        // myPlayer.takeItem(potion2);
        // myPlayer.drinkPotion();
        // assertEquals(20, myPlayer.getHP());
        // assertEquals(1, myPlayer.inventory.size());
=======
    @Test
    public void testDrinkPotion()
    {
        myPlayer = new Player(15,"Jimmy",2,2,0);
        Common potion = new Common("Health Potion","Heals for 5 hp",0,0,5);
        Common potion2 = new Common("Health Potion","Heals for 5 hp",0,0,5);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(potion2);
        //myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP());
        assertEquals(1, myPlayer.inventory.size());
>>>>>>> bf73cb6ed90aa15f7971392522b8422ed240edd0

    // }
    
    // /**
     // * Tests that a player keeps other Commons when drinking a health potion
     // * He only "loses" the health potion used.
     // */

<<<<<<< HEAD
    // @Test
    // public void testDrinkPotionWithSword()
    // {
        // myPlayer = new Player(15,"Jimmy",2,2,0);
        // Common potion = new Common("Health Potion","Heals for 5 hp",0,0,5);
        // Common sword = new Common("Iron Sword","A medium length blade",3,0,0);
        // myPlayer.takeItem(potion);
        // myPlayer.takeItem(sword);
        // myPlayer.drinkPotion();
        // assertEquals(20, myPlayer.getHP());
        // assertEquals(1, myPlayer.inventory.size());
=======
    @Test
    public void testDrinkPotionWithSword()
    {
        myPlayer = new Player(15,"Jimmy",2,2,0);
        Common potion = new Common("Health Potion","Heals for 5 hp",0,0,5);
        Common sword = new Common("Iron Sword","A medium length blade",3,0,0);
        myPlayer.takeItem(potion);
        myPlayer.takeItem(sword);
        //myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP());
        assertEquals(1, myPlayer.inventory.size());
>>>>>>> bf73cb6ed90aa15f7971392522b8422ed240edd0

    // }
    
    
    // /**
     // * Tests that a player cannot drink a potion if he
     // * does not have a potion in his inventory
     // */

<<<<<<< HEAD
    // @Test
    // public void testDrinkNoPotion()
    // {
        // myPlayer = new Player(15,"Jimmy",2,2,0);
        // myPlayer.drinkPotion();
        // assertEquals(15, myPlayer.getHP());     
    // }
=======
    @Test
    public void testDrinkNoPotion()
    {
        myPlayer = new Player(15,"Jimmy",2,2,0);
        //myPlayer.drinkPotion();
        assertEquals(15, myPlayer.getHP());     
    }
>>>>>>> bf73cb6ed90aa15f7971392522b8422ed240edd0

    // /**
     // * Tests that the player cannot have his hp over his maxHP after
     // * taking a potion
     // */

<<<<<<< HEAD
    // @Test
    // public void testDrinkPotionOverHp()
    // {
        // Common potion = new Common("Health Potion","Heals for 5 hp",0,0,5);
        // myPlayer.takeItem(potion);
        // myPlayer.setHp(19);
        // myPlayer.drinkPotion();
        // assertEquals(20, myPlayer.getHP()); 
    // }
=======
    @Test
    public void testDrinkPotionOverHp()
    {
        Common potion = new Common("Health Potion","Heals for 5 hp",0,0,5);
        myPlayer.takeItem(potion);
        myPlayer.setHp(19);
        //myPlayer.drinkPotion();
        assertEquals(20, myPlayer.getHP()); 
    }
>>>>>>> bf73cb6ed90aa15f7971392522b8422ed240edd0

    /**
     * Tests that the player can drop a Common Item that he has in his inventory
     * He should be able to drop the Common Item
     */

    @Test
    public void testDropCommon()
    {
        Common potion = new Common ("Health Potion","A potion that heals five HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(potion, myPlayer.getItems(0));
        myPlayer.dropItem(potion);
        assertEquals(0, myPlayer.inventory.size());
    }
    

    
    /**
     * Tests that an Item that is not in the inventory of the player
     * cannot be dropped
     */
    
    @Test
    public void testDropFalseCommon()
    {
       Common potion = new Common ("Health Potion","A potion that heals five HP",0,0,5);
       Common potion2 = new Common ("Health Potion","A potion that heals five HP",0,0,5);
       myPlayer.takeItem(potion);
       assertEquals(potion, myPlayer.getItems(0));
       myPlayer.dropItem(potion2); 
       assertEquals(1,myPlayer.inventory.size());
    }
    
      /**
     * Tests that a players damage stats are modified according to an 
     * Item attribute.
     */

    @Test
    public void testCommonSword()
    {
        Common sword = new Common ("Iron Sword","An iron sword",2,0,0);
        myPlayer.takeItem(sword);
        assertEquals(sword, myPlayer.getItems(0));
        assertEquals(4, myPlayer.getDamage());
        myPlayer.dropItem(sword);
        assertEquals(0, myPlayer.inventory.size());
        assertEquals(2,myPlayer.getDamage());
    }
    
        /**
     * Tests that a players protection stats are modified according to an 
     * Commons attribute.
     */

    @Test
    public void testCommonShield()
    {
        Common shield = new Common ("Wooden shield","A wooden shield",0,2,0);
        myPlayer.takeItem(shield);
        assertEquals(shield, myPlayer.getItems(0));
        assertEquals(2, myPlayer.getProtection());
        myPlayer.dropItem(shield);
        assertEquals(0, myPlayer.inventory.size());
        assertEquals(0,myPlayer.getProtection());
    }
    
    /**
     * Tests that an Common cannot be added to the inventory
     * if the player already carries the maximum amount of Commons
     */

    @Test
    public void testGetOverMaxCommon()
    {
        Common potion = new Common ("Health Potion","A potion that heals five HP",0,0,5);
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
        myPlayer = new Player(15,"Jimmy",100,2,0);
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
     * This method tests if the Common limit is 10
     * The Common limit should always be 10
     */
    @Test
    public void testCommonLimit()
    {
        assertEquals(10,myPlayer.getLimitItem());
    }
    
    /**
     * This test checks if the boolean ariadnesThread is changed to true
     * if the player has the Common
     */
    @Test
    public void testAriadnesThread()
    {
        Common GoldenThread = new Common ("Ariadne's golden thread","A mysterious piece of string",0,0,0);
        myPlayer.takeItem(GoldenThread);
        assertEquals(true,myPlayer.getThread());
    }

    /**
     * This test checks if the boolean ariadnesThread is false when picking
     * up Commons that are not ariadne's thread
     */
    @Test
    public void testAriadnesThreadBad()
    {
        Common GoldenThread = new Common ("Ariadne's golden thread","A mysterious piece of string",0,0,0);
        Common potion = new Common ("Health Potion","A potion that heals five HP",0,0,5);
        myPlayer.takeItem(potion);
        assertEquals(false,myPlayer.getThread());
    }
    
        /**
     * tests the getters of all the attributes
     */
    @Test
    public void testGettersCharOK()
    {
        assertEquals(20,myPlayer.getHP());
        assertEquals(2,myPlayer.getXp());
        assertEquals("Jimmy",myPlayer.getName());
        assertEquals(2,myPlayer.getDamage());
        assertEquals(0,myPlayer.getProtection());
    }
    
    /**
     * Tests if the decrease hp functions as intended with a positive integer
     */
    @Test
    public void testLoseHP()
    {
        assertEquals(20,myPlayer.getHP());
        myPlayer.loseHp(10);
        assertEquals(10,myPlayer.getHP());
    }
    
    /**
     * test for loseHP with negative parameters
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseNegativeHP()
    {
        myPlayer.loseHp(-10);
        assertEquals(20,myPlayer.getHP());
    }
    
    /**
     * test for loseHP with 0 value
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseZeroHP()
    {
        myPlayer.loseHp(0);
        assertEquals(20,myPlayer.getHP());
    }
    
    /**
     * tests the gain xp method, xp is gained when a monster is slain
     * this method should only function with an integer above 0
     */
    @Test
    public void testGainXP()
    {
        myPlayer.gainXp(2);
        assertEquals(4,myPlayer.getXp());
    }
    
    /**
     * Tests if XP can be lost using a negative value
     * XP cannot be lost within this game
     */
    @Test
    public void testGainNegativeXP()
    {
        myPlayer.gainXp(-10);
        assertEquals(2,myPlayer.getXp());
    }
    
    /**
     * Tests if a player can gain 0 xp
     * This should not be possible, no action should occur
     */
    @Test
    public void testGainZeroXP()
    {
        myPlayer.gainXp(0);
        assertEquals(2,myPlayer.getXp());
    }
    
    /**
     * test for increaseDamage
     */
    @Test
    public void testIncreaseDamage()
    {
        myPlayer.increaseDamage(10);
        assertEquals(12,myPlayer.getDamage());
    }
    
    /**
     * test for increaseDamage with negative value
     * This should not be possible
     */
    @Test
    public void testIncreaseNegativeDamage()
    {
        myPlayer.increaseDamage(-10);
        assertEquals(2,myPlayer.getDamage());
    }
    
    /**
     * test for increaseDamage with zero value
     * This should not be possible
     */
    @Test
    public void testIncreaseZeroDamage()
    {
        myPlayer.increaseDamage(0);
        assertEquals(2,myPlayer.getDamage());
    }
    
    /**
     * test for decreaseDamage
     * The decrease value must be an integer above zero
     * damage cannot be below 0
     */
    @Test
    public void testDecreaseDamage()
    {
        myPlayer.decreaseDamage(10);
        assertEquals(0,myPlayer.getDamage());
    }
    
    /**
     * tests for decreaseDamage with negative parameters
     * This should not work
     */
    @Test
    public void testDecreaseNegativeDamage()
    {
        myPlayer.decreaseDamage(-10);
        assertEquals(2,myPlayer.getDamage());
    }
    
    /**
     * tests for decreaseDamage with zero value
     * This should not work
     */
    @Test
    public void testDecreaseZeroDamage()
    {
        myPlayer.decreaseDamage(0);
        assertEquals(2,myPlayer.getDamage());
    }
    
    /**
     * test for decrease protection, increase protection
     * Protection cannot drop below 0
     */
    @Test
    public void testProtection()
    {
        myPlayer.increaseProtection(4);
        assertEquals(4,myPlayer.getProtection());
        myPlayer.decreaseProtection(2);
        assertEquals(2,myPlayer.getProtection());
        myPlayer.decreaseProtection(4);
        assertEquals(0,myPlayer.getProtection());
    }
    
    /**
     * test for increase protection
     * Value must be an integer above zero
     */
    @Test
    public void testGainNegativeProtection()
    {
        myPlayer.increaseProtection(-4);
        assertEquals(0,myPlayer.getProtection());
    }
    
    /**
     * test for decrease protection
     * Integer must be a value above 0
     */
    @Test
    public void testDecreaseNegativeProtection()
    {
        myPlayer.decreaseProtection(-4);
        assertEquals(0,myPlayer.getProtection());
    }
}
