

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CharacterTest.
 *
 * @author  (votre nom)
 * @version (un numero de version ou une date)
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
     * Constructor layout (Hp, name, xp, damage, posX, posY
     */
    @Before
    public void setUp()
    {
        myCharacter = new Character(20,"Jimmy",2,2,1,1);
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
        assertEquals(1,myCharacter.getPosX());
        assertEquals(1,myCharacter.getPosY());
    }
    
    /**
     * test for the gainHP method
     */
    @Test
    public void testGainHP()
    {
        myCharacter.gainHP(5);
        assertEquals(25,myCharacter.getHP());
    }
    
    /**
     * test for negative gain of HP
     * This should not be possible
     */
    @Test
    public void testGainNegativeHP()
    {
        myCharacter.gainHP(-10);
        assertEquals(20,myCharacter.getHP());
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
     * The loseHP method should always be a negative value
     */
    @Test
    public void testLoseNegativeHP()
    {
        myCharacter.loseHp(-10);
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
     * test for adding an item to the inventory
     * XP cannot be lost
     */
    @Test
    public void testGainNegativeXP()
    {
        myCharacter.gainXp(-10);
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
     * test for decreaseDamage with positive parameters
     * This should not work
     */
    @Test
    public void testDecreaseNegativeDamage()
    {
        myCharacter.decreaseDamage(-10);
        assertEquals(2,myCharacter.getDamage());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveUp()
    {
        myCharacter.moveUp();
        assertEquals(2,myCharacter.getPosY());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveDown()
    {
        myCharacter.moveDown();
        assertEquals(0,myCharacter.getPosY());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveRight()
    {
        myCharacter.moveRight();
        assertEquals(2,myCharacter.getPosX());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveLeft()
    {
        myCharacter.moveLeft();
        assertEquals(0,myCharacter.getPosX());
    }
    
    
    /**
     * Supprime les engagements
     *
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }
}
