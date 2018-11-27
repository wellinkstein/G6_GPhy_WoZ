

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class exists to test various functions of the Character class
 *
 * @author  (Group6)
 * @version (V1)
 *
 */
public class CharacterTest
{
    //These are the attributes necessary to perform the required tests of this class
    protected Character myCharacter;
    protected Item  myItem;

    /**
     * The constructor for the character test class
     */
    public CharacterTest()
    {
    }

    /**
     * Sets up the constructor
     * Constructor layout (Hp, name, xp, damage)
     */
    @Before
    public void setUp()
    {
        myCharacter = new Character(20,"Jimmy",2,2);
    }

    
    /**
     * tests the getters of all the attributes
     */
    @Test
    public void testGettersCharOK()
    {
        assertEquals(20,myCharacter.getHP());
        assertEquals(2,myCharacter.getXp());
        assertEquals("Jimmy",myCharacter.getName());
        assertEquals(2,myCharacter.getDamage());
    }
    
    /**
     * Tests if the decrease hp functions as intended with a positive integer
     */
    @Test
    public void testLoseHP()
    {
        assertEquals(20,myCharacter.getHP());
        myCharacter.loseHp(10);
        assertEquals(10,myCharacter.getHP());
    }
    
    /**
     * test for loseHP with negative parameters
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseNegativeHP()
    {
        myCharacter.loseHp(-10);
        assertEquals(20,myCharacter.getHP());
    }
    
    /**
     * test for loseHP with 0 value
     * The loseHP method should always be a positive value above zero
     */
    @Test
    public void testLoseZeroHP()
    {
        myCharacter.loseHp(0);
        assertEquals(20,myCharacter.getHP());
    }
    
    /**
     * tests the gain xp method, xp is gained when a monster is slain
     * this method should only function with an integer above 0
     */
    @Test
    public void testGainXP()
    {
        myCharacter.gainXp(2);
        assertEquals(4,myCharacter.getXp());
    }
    
    /**
     * Tests if XP can be lost using a negative value
     * XP cannot be lost within this game
     */
    @Test
    public void testGainNegativeXP()
    {
        myCharacter.gainXp(-10);
        assertEquals(2,myCharacter.getXp());
    }
    
    /**
     * Tests if a player can gain 0 xp
     * This should not be possible, no action should occur
     */
    @Test
    public void testGainZeroXP()
    {
        myCharacter.gainXp(0);
        assertEquals(2,myCharacter.getXp());
    }
    
    /**
     * test for increaseDamage
     */
    @Test
    public void testIncreaseDamage()
    {
        myCharacter.increaseDamage(10);
        assertEquals(12,myCharacter.getDamage());
    }
    
    /**
     * test for increaseDamage with negative value
     * This should not be possible
     */
    @Test
    public void testIncreaseNegativeDamage()
    {
        myCharacter.increaseDamage(-10);
        assertEquals(2,myCharacter.getDamage());
    }
    
    /**
     * test for increaseDamage with zero value
     * This should not be possible
     */
    @Test
    public void testIncreaseZeroDamage()
    {
        myCharacter.increaseDamage(0);
        assertEquals(2,myCharacter.getDamage());
    }
    
    /**
     * test for decreaseDamage
     * The decrease value must be an integer above zero
     * damage cannot be below 0
     */
    @Test
    public void testDecreaseDamage()
    {
        myCharacter.decreaseDamage(10);
        assertEquals(0,myCharacter.getDamage());
    }
    
    /**
     * tests for decreaseDamage with negative parameters
     * This should not work
     */
    @Test
    public void testDecreaseNegativeDamage()
    {
        myCharacter.decreaseDamage(-10);
        assertEquals(2,myCharacter.getDamage());
    }
    
    /**
     * tests for decreaseDamage with zero value
     * This should not work
     */
    @Test
    public void testDecreaseZeroDamage()
    {
        myCharacter.decreaseDamage(0);
        assertEquals(2,myCharacter.getDamage());
    }

    /**
     *This function removes the set up of the test class
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }

}
