import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class to test the various functions of the monster class
 *
 * @author  (Group 6)
 * @version (2018-11-27)
 *
 */
public class MonsterTest
{
    //The attributes/variables necessary to run the tests
    private Monster myMonster;
    private Monster goodMonster;

    /**
     * Constructor for the monster test class
     */
    public MonsterTest()
    {
    }

    /**
     * Sets up the constructor that will be used in the tests
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        //myMonster = new Monster(10,"Medusa",1,2,0,"Snake Lady");
    }
    
    // /**
     // * This test checks if Minotaur is a valid name and that the constructor and getters work
     // */
    // @Test
    // public void CheckGoodMonsterNameMinotaur()
    // {
        // goodMonster= new Monster(10,"Minotaur",1,5,0,"Le terrible minotaure");
        // assertEquals(10,goodMonster.getHP());
        // assertEquals("Minotaur",goodMonster.getName());
        // assertEquals(1,goodMonster.getXp());
        // assertEquals(5,goodMonster.getDamage());
    // }
    
    // /**
     // * Method that tests the get description function
     // */
    // @Test
    // public void CheckMonsterDescription()
    // {
        // assertEquals ("Snake Lady",myMonster.getDescription());
    // }
    
    // /**
     // * Tests if the monster is really dead (HP=0)
     // */
    // @Test
    // public void CheckMonsterDeathTrue()
    // {
        // myMonster.loseHp(15);
        // assertEquals (true,myMonster.isDead());
    // }
    
    // /**
     // * Checks if the monster is still alive (HP > 0)
     // */
    // @Test
    // public void CheckMonsterDeathFalse()
    // {
        // myMonster.loseHp(9);
        // assertEquals (false,myMonster.isDead());
    // }
    
        // /**
     // * tests the getters of all the attributes
     // */
    // @Test
    // public void testGettersCharOK()
    // {
        // assertEquals(10,myMonster.getHP());
        // assertEquals(1,myMonster.getXp());
        // assertEquals("Medusa",myMonster.getName());
        // assertEquals(2,myMonster.getDamage());
        // assertEquals(0,myMonster.getProtection());
    // }
    
    // /**
     // * Tests if the decrease hp functions as intended with a positive integer
     // */
    // @Test
    // public void testLoseHP()
    // {
        // assertEquals(10,myMonster.getHP());
        // myMonster.loseHp(10);
        // assertEquals(0,myMonster.getHP());
    // }
    
    // /**
     // * test for loseHP with negative parameters
     // * The loseHP method should always be a positive value above zero
     // */
    // @Test
    // public void testLoseNegativeHP()
    // {
        // myMonster.loseHp(-10);
        // assertEquals(10,myMonster.getHP());
    // }
    
    // /**
     // * test for loseHP with 0 value
     // * The loseHP method should always be a positive value above zero
     // */
    // @Test
    // public void testLoseZeroHP()
    // {
        // myMonster.loseHp(0);
        // assertEquals(10,myMonster.getHP());
    // }
    
    // /**
     // * tests the gain xp method, xp is gained when a monster is slain
     // * this method should only function with an integer above 0
     // */
    // @Test
    // public void testGainXP()
    // {
        // myMonster.gainXp(2);
        // assertEquals(3,myMonster.getXp());
    // }
    
    // /**
     // * Tests if XP can be lost using a negative value
     // * XP cannot be lost within this game
     // */
    // @Test
    // public void testGainNegativeXP()
    // {
        // myMonster.gainXp(-10);
        // assertEquals(1,myMonster.getXp());
    // }
    
    // /**
     // * Tests if a player can gain 0 xp
     // * This should not be possible, no action should occur
     // */
    // @Test
    // public void testGainZeroXP()
    // {
        // myMonster.gainXp(0);
        // assertEquals(1,myMonster.getXp());
    // }
    
    // /**
     // * test for increaseDamage
     // */
    // @Test
    // public void testIncreaseDamage()
    // {
        // myMonster.increaseDamage(10);
        // assertEquals(12,myMonster.getDamage());
    // }
    
    // /**
     // * test for increaseDamage with negative value
     // * This should not be possible
     // */
    // @Test
    // public void testIncreaseNegativeDamage()
    // {
        // myMonster.increaseDamage(-10);
        // assertEquals(2,myMonster.getDamage());
    // }
    
    // /**
     // * test for increaseDamage with zero value
     // * This should not be possible
     // */
    // @Test
    // public void testIncreaseZeroDamage()
    // {
        // myMonster.increaseDamage(0);
        // assertEquals(2,myMonster.getDamage());
    // }
    
    // /**
     // * test for decreaseDamage
     // * The decrease value must be an integer above zero
     // * damage cannot be below 0
     // */
    // @Test
    // public void testDecreaseDamage()
    // {
        // myMonster.decreaseDamage(10);
        // assertEquals(0,myMonster.getDamage());
    // }
    
    // /**
     // * tests for decreaseDamage with negative parameters
     // * This should not work
     // */
    // @Test
    // public void testDecreaseNegativeDamage()
    // {
        // myMonster.decreaseDamage(-10);
        // assertEquals(2,myMonster.getDamage());
    // }
    
    // /**
     // * tests for decreaseDamage with zero value
     // * This should not work
     // */
    // @Test
    // public void testDecreaseZeroDamage()
    // {
        // myMonster.decreaseDamage(0);
        // assertEquals(2,myMonster.getDamage());
    // }
    
    // /**
     // * test for decrease protection, increase protection
     // * Protection cannot drop below 0
     // */
    // @Test
    // public void testProtection()
    // {
        // myMonster.increaseProtection(4);
        // assertEquals(4,myMonster.getProtection());
        // myMonster.decreaseProtection(2);
        // assertEquals(2,myMonster.getProtection());
        // myMonster.decreaseProtection(4);
        // assertEquals(0,myMonster.getProtection());
    // }
    
    // /**
     // * test for increase protection
     // * Value must be an integer above zero
     // */
    // @Test
    // public void testGainNegativeProtection()
    // {
        // myMonster.increaseProtection(-4);
        // assertEquals(0,myMonster.getProtection());
    // }
    
    // /**
     // * test for decrease protection
     // * Integer must be a value above 0
     // */
    // @Test
    // public void testDecreaseNegativeProtection()
    // {
        // myMonster.decreaseProtection(-4);
        // assertEquals(0,myMonster.getProtection());
    // }
    
    /**
     * Removes the set up of the test function
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }
}