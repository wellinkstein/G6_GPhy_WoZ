

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
        Boss myBoss = new Boss(50,"Minotaure",0,20,0,"Le grand minotaure");
        assertEquals(50,myBoss.getHP());
        assertEquals("Minotaure",myBoss.getName());
        assertEquals(0,myBoss.getXp());
        assertEquals(20,myBoss.getDamage());
        assertEquals(0,myBoss.getProtection());
        
    }
}
