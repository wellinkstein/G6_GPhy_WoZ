

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class exists to test functions with the lesser boss class
 *
 * @author  (Group 6)
 * @version (2018-11-27)
 */
public class LesserBossTest
{
    private LesserBoss myLesserBoss;
    private Legendary myLegen;
    /**
     * Constructor for the lesser boss test class
     */
    public LesserBossTest()
    {
    }

    /**
     * Sets up the test class
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        myLesserBoss = new LesserBoss(10,"Medusa",1,2,0,"Snake Lady",myLegen);
        Legendary myLegen = new Legendary("Legendary test","a legendary test",20,0,0);
    }

    /**
     * Removes the set up
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
    
    /**
     * This method tests if the constructor and the getters work appropriately
     */
    @Test
    public void testConstructeurLesserBoss()
    {
        Legendary myLegen = new Legendary("Legendary test","a legendary test",20,0,0);
        LesserBoss myBoss = new LesserBoss(50,"Meduse",0,20,0,"La hideuse meduse",myLegen);
        assertEquals(50,myBoss.getHP());
        assertEquals("Meduse",myBoss.getName());
        assertEquals(0,myBoss.getXp());
        assertEquals(20,myBoss.getDamage());
        assertEquals(false,myBoss.getAggressive());
    }
    
    /**
     * this method tests the setAggressiveTrue function
     * It should set the aggressive attribute to true
     */
    @Test
    public void testSetAggressiveTrue()
    {
        Legendary myLegen = new Legendary("Legendary test","a legendary test",20,0,0);
        LesserBoss myBoss = new LesserBoss(50,"Meduse",0,20,0,"La hideuse meduse",myLegen);
        myBoss.setAggressiveTrue();
        assertEquals(true,myBoss.getAggressive());
    }
    
    /**
     * this method tests the setAggressiveFalse function
     * It should set the aggressive attribute to false
     */
    @Test
    public void testSetAggressiveFalse()
    {
        Legendary myLegen = new Legendary("Legendary test","a legendary test",20,0,0);
        LesserBoss myBoss = new LesserBoss(50,"Meduse",0,20,0,"La hideuse meduse",myLegen);
        myBoss.setAggressiveFalse();
        assertEquals(false,myBoss.getAggressive());
    }
    
    /**
     * This test checks if Minotaur is a valid name and that the constructor and getters work
     */
    @Test
    public void CheckmyLesserBossNameMinotaur()
    {
        assertEquals(10,myLesserBoss.getHP());
        assertEquals("Medusa",myLesserBoss.getName());
        assertEquals(1,myLesserBoss.getXp());
        assertEquals(2,myLesserBoss.getDamage());
    }
    
    /**
     * Method that tests the get description function
     */
    @Test
    public void CheckMonsterDescription()
    {
        assertEquals ("Snake Lady",myLesserBoss.getDescription());
    }
    
    // /**
     // * Tests if the monster is really dead (HP=0)
     // */
    // @Test
    // public void CheckMonsterDeathTrue()
    // {
        // myLesserBoss.loseHp(15);
        // assertEquals (true,myLesserBoss.isDead());
    // }
    
    // /**
     // * Checks if the monster is still alive (HP > 0)
     // */
    // @Test
    // public void CheckMonsterDeathFalse()
    // {
        // myLesserBoss.loseHp(9);
        // assertEquals (false,myLesserBoss.isDead());
    // }
    
        /**
     * tests the getters of all the attributes
     */
    @Test
    public void testGettersCharOK()
    {
        assertEquals(10,myLesserBoss.getHP());
        assertEquals(1,myLesserBoss.getXp());
        assertEquals("Medusa",myLesserBoss.getName());
        assertEquals(2,myLesserBoss.getDamage());
        assertEquals(0,myLesserBoss.getProtection());
    }
    
    /**
     * Tests if the decrease hp functions as intended with a positive integer
     */
    @Test
    public void testLoseHP()
    {
        assertEquals(10,myLesserBoss.getHP());
        myLesserBoss.loseHp(10);
        assertEquals(0,myLesserBoss.getHP());
    }
    
    /**
     * test for loseHP with negative parameters
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseNegativeHP()
    {
        myLesserBoss.loseHp(-10);
        assertEquals(10,myLesserBoss.getHP());
    }
    
    /**
     * test for loseHP with 0 value
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseZeroHP()
    {
        myLesserBoss.loseHp(0);
        assertEquals(10,myLesserBoss.getHP());
    }
    
    /**
     * tests the gain xp method, xp is gained when a monster is slain
     * this method should only function with an integer above 0
     */
    @Test
    public void testGainXP()
    {
        myLesserBoss.gainXp(2);
        assertEquals(3,myLesserBoss.getXp());
    }
    
    /**
     * Tests if XP can be lost using a negative value
     * XP cannot be lost within this game
     */
    @Test
    public void testGainNegativeXP()
    {
        myLesserBoss.gainXp(-10);
        assertEquals(1,myLesserBoss.getXp());
    }
    
    /**
     * Tests if a player can gain 0 xp
     * This should not be possible, no action should occur
     */
    @Test
    public void testGainZeroXP()
    {
        myLesserBoss.gainXp(0);
        assertEquals(1,myLesserBoss.getXp());
    }
    
    /**
     * test for increaseDamage
     */
    @Test
    public void testIncreaseDamage()
    {
        myLesserBoss.increaseDamage(10);
        assertEquals(12,myLesserBoss.getDamage());
    }
    
    /**
     * test for increaseDamage with negative value
     * This should not be possible
     */
    @Test
    public void testIncreaseNegativeDamage()
    {
        myLesserBoss.increaseDamage(-10);
        assertEquals(2,myLesserBoss.getDamage());
    }
    
    /**
     * test for increaseDamage with zero value
     * This should not be possible
     */
    @Test
    public void testIncreaseZeroDamage()
    {
        myLesserBoss.increaseDamage(0);
        assertEquals(2,myLesserBoss.getDamage());
    }
    
    /**
     * test for decreaseDamage
     * The decrease value must be an integer above zero
     * damage cannot be below 0
     */
    @Test
    public void testDecreaseDamage()
    {
        myLesserBoss.decreaseDamage(10);
        assertEquals(0,myLesserBoss.getDamage());
    }
    
    /**
     * tests for decreaseDamage with negative parameters
     * This should not work
     */
    @Test
    public void testDecreaseNegativeDamage()
    {
        myLesserBoss.decreaseDamage(-10);
        assertEquals(2,myLesserBoss.getDamage());
    }
    
    /**
     * tests for decreaseDamage with zero value
     * This should not work
     */
    @Test
    public void testDecreaseZeroDamage()
    {
        myLesserBoss.decreaseDamage(0);
        assertEquals(2,myLesserBoss.getDamage());
    }
    
    /**
     * test for decrease protection, increase protection
     * Protection cannot drop below 0
     */
    @Test
    public void testProtection()
    {
        myLesserBoss.increaseProtection(4);
        assertEquals(4,myLesserBoss.getProtection());
        myLesserBoss.decreaseProtection(2);
        assertEquals(2,myLesserBoss.getProtection());
        myLesserBoss.decreaseProtection(4);
        assertEquals(0,myLesserBoss.getProtection());
    }
    
    /**
     * test for increase protection
     * Value must be an integer above zero
     */
    @Test
    public void testGainNegativeProtection()
    {
        myLesserBoss.increaseProtection(-4);
        assertEquals(0,myLesserBoss.getProtection());
    }
    
    /**
     * test for decrease protection
     * Integer must be a value above 0
     */
    @Test
    public void testDecreaseNegativeProtection()
    {
        myLesserBoss.decreaseProtection(-4);
        assertEquals(0,myLesserBoss.getProtection());
    }
}
