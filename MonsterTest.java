import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test MonsterTest.
 *
 * @author  (Yohan et Corentin)
 * @version (V1)
 *
 */
public class MonsterTest
{
    private Monster myMonster;
    private Monster goodMonster;

    /**
     * Constructeur de la classe-test MonsterTest
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
        myMonster = new Monster(10,"Medusa",1,2,"Snake Lady");
    }
    
        /**
     * This test checks if Minotaur is a valid name and that the constructor and getters work
     */
    @Test
    public void CheckGoodMonsterNameMinotaur()
    {
        goodMonster= new Monster(10,"Minotaur",1,5,"Le terrible minotaure");
        assertEquals(10,goodMonster.getHP());
        assertEquals("Minotaur",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
    }
    
    /**
     * Method that tests the get description function
     */
    @Test
    public void CheckMonsterDescription()
    {
        assertEquals ("Snake Lady",myMonster.getDescription());
    }
    
    /**
     * Tests if the monster is really dead (HP=0)
     */
    @Test
    public void CheckMonsterDeathTrue()
    {
        myMonster.loseHp(15);
        assertEquals (true,myMonster.isDead());
    }
    
    /**
     * Checks if the monster is still alive (HP > 0)
     */
    @Test
    public void CheckMonsterDeathFalse()
    {
        myMonster.loseHp(9);
        assertEquals (false,myMonster.isDead());
    }
    
    
    /**
     * 
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }
        
}