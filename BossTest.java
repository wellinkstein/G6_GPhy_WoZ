

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class exists to test functions with the boss class
 * @author  (Group6)
 * @version (2018-11-27)
 *
 */
public class BossTest
{
    private Boss myBoss;
        
    /**
     * Constructor for the boss test class
     */
    public BossTest()
    {
    }

    /**
     * Sets up the tests
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        myBoss = new Boss(10,"Medusa",1,2,0,"Snake Lady");
    }

    /**
     * removes the set up
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }
    
    /**
     * Tests if the constructor and the getters function appropriately
     */
    @Test
    public void testBossCreation()
    {
        Boss myBoss = new Boss(50,"Minotaur",0,20,0,"The great Minotaur");
        assertEquals(50,myBoss.getHP());
        assertEquals("Minotaur",myBoss.getName());
        assertEquals(0,myBoss.getXp());
        assertEquals(20,myBoss.getDamage());
        assertEquals(0,myBoss.getProtection());
        
    }
    
    /**
     * This test checks if Minotaur is a valid name and that the constructor and getters work
     */
    @Test
    public void CheckmyBossNameMinotaur()
    {
        myBoss= new Boss(10,"Minotaur",1,5,0,"Le terrible minotaure");
        assertEquals(10,myBoss.getHP());
        assertEquals("Minotaur",myBoss.getName());
        assertEquals(1,myBoss.getXp());
        assertEquals(5,myBoss.getDamage());
    }
    
    /**
     * Method that tests the get description function
     */
    @Test
    public void CheckBossDescription()
    {
        assertEquals ("Snake Lady",myBoss.getDescription());
    }

        /**
     * tests the getters of all the attributes
     */
    @Test
    public void testGettersCharOK()
    {
        assertEquals(10,myBoss.getHP());
        assertEquals(1,myBoss.getXp());
        assertEquals("Medusa",myBoss.getName());
        assertEquals(2,myBoss.getDamage());
        assertEquals(0,myBoss.getProtection());
    }
    
    /**
     * Tests if the decrease hp functions as intended with a positive integer
     */
    @Test
    public void testLoseHP()
    {
        assertEquals(10,myBoss.getHP());
        myBoss.loseHp(10);
        assertEquals(0,myBoss.getHP());
    }
    
    /**
     * test for loseHP with negative parameters
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseNegativeHP()
    {
        myBoss.loseHp(-10);
        assertEquals(10,myBoss.getHP());
    }
    
    /**
     * test for loseHP with 0 value
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseZeroHP()
    {
        myBoss.loseHp(0);
        assertEquals(10,myBoss.getHP());
    }
    
    /**
     * tests the gain xp method, xp is gained when a Boss is slain
     * this method should only function with an integer above 0
     */
    @Test
    public void testGainXP()
    {
        myBoss.gainXp(2);
        assertEquals(3,myBoss.getXp());
    }
    
    /**
     * Tests if XP can be lost using a negative value
     * XP cannot be lost within this game
     */
    @Test
    public void testGainNegativeXP()
    {
        myBoss.gainXp(-10);
        assertEquals(1,myBoss.getXp());
    }
    
    /**
     * Tests if a player can gain 0 xp
     * This should not be possible, no action should occur
     */
    @Test
    public void testGainZeroXP()
    {
        myBoss.gainXp(0);
        assertEquals(1,myBoss.getXp());
    }
    
    /**
     * test for increaseDamage
     */
    @Test
    public void testIncreaseDamage()
    {
        myBoss.increaseDamage(10);
        assertEquals(12,myBoss.getDamage());
    }
    
    /**
     * test for increaseDamage with negative value
     * This should not be possible
     */
    @Test
    public void testIncreaseNegativeDamage()
    {
        myBoss.increaseDamage(-10);
        assertEquals(2,myBoss.getDamage());
    }
    
    /**
     * test for increaseDamage with zero value
     * This should not be possible
     */
    @Test
    public void testIncreaseZeroDamage()
    {
        myBoss.increaseDamage(0);
        assertEquals(2,myBoss.getDamage());
    }
    
    /**
     * test for decreaseDamage
     * The decrease value must be an integer above zero
     * damage cannot be below 0
     */
    @Test
    public void testDecreaseDamage()
    {
        myBoss.decreaseDamage(10);
        assertEquals(0,myBoss.getDamage());
    }
    
    /**
     * tests for decreaseDamage with negative parameters
     * This should not work
     */
    @Test
    public void testDecreaseNegativeDamage()
    {
        myBoss.decreaseDamage(-10);
        assertEquals(2,myBoss.getDamage());
    }
    
    /**
     * tests for decreaseDamage with zero value
     * This should not work
     */
    @Test
    public void testDecreaseZeroDamage()
    {
        myBoss.decreaseDamage(0);
        assertEquals(2,myBoss.getDamage());
    }
    
    /**
     * test for decrease protection, increase protection
     * Protection cannot drop below 0
     */
    @Test
    public void testProtection()
    {
        myBoss.increaseProtection(4);
        assertEquals(4,myBoss.getProtection());
        myBoss.decreaseProtection(2);
        assertEquals(2,myBoss.getProtection());
        myBoss.decreaseProtection(4);
        assertEquals(0,myBoss.getProtection());
    }
    
    /**
     * test for increase protection
     * Value must be an integer above zero
     */
    @Test
    public void testGainNegativeProtection()
    {
        myBoss.increaseProtection(-4);
        assertEquals(0,myBoss.getProtection());
    }
    
    /**
     * test for decrease protection
     * Integer must be a value above 0
     */
    @Test
    public void testDecreaseNegativeProtection()
    {
        myBoss.decreaseProtection(-4);
        assertEquals(0,myBoss.getProtection());
    }
}
