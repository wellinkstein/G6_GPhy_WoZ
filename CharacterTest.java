

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CharacterTest.
 *
 * @author  (Group6)
 * @version (V1)
 *
 */
public class CharacterTest
{
    protected Character myCharacter;
    protected Item  myItem;

    /**
     * Constructeur de la classe-test CharacterTest
     */
    public CharacterTest()
    {
    }

    /**
     * Sets up the constructor
     * Sets up the item
     * Constructor layout (Hp, name, xp, damage)
     */
    @Before
    public void setUp()
    {
        myCharacter = new Character(20,"Jimmy",2,2);
    }

    
    /**
     * test for all attributes
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
     * test for decrease HP
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
     * test for gaining XP
     */
    @Test
    public void testGainXP()
    {
        myCharacter.gainXp(2);
        assertEquals(4,myCharacter.getXp());
    }
    
    /**
     * XP cannot be lost
     */
    @Test
    public void testGainNegativeXP()
    {
        myCharacter.gainXp(-10);
        assertEquals(2,myCharacter.getXp());
    }
    
    /**
     * test for adding an item to the inventory
     * XP cannot be lost
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
     * damage cannot be below 0
     */
    @Test
    public void testDecreaseDamage()
    {
        myCharacter.decreaseDamage(10);
        assertEquals(0,myCharacter.getDamage());
    }
    
    /**
     * test for decreaseDamage with negative parameters
     * This should not work
     */
    @Test
    public void testDecreaseNegativeDamage()
    {
        myCharacter.decreaseDamage(-10);
        assertEquals(2,myCharacter.getDamage());
    }
    
    /**
     * test for decreaseDamage with zero value
     * This should not work
     */
    @Test
    public void testDecreaseZeroDamage()
    {
        myCharacter.decreaseDamage(0);
        assertEquals(2,myCharacter.getDamage());
    }

    /**
     *
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }

}
