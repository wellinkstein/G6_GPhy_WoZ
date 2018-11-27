

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
public class Lesser_BossTest
{

    /**
     * Constructor for the lesser boss test class
     */
    public Lesser_BossTest()
    {
    }

    /**
     * Sets up the test class
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {

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
        Lesser_Boss myBoss = new Lesser_Boss(50,"Meduse",0,20,0,"La hideuse meduse",myLegen);
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
        Lesser_Boss myBoss = new Lesser_Boss(50,"Meduse",0,20,0,"La hideuse meduse",myLegen);
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
        Lesser_Boss myBoss = new Lesser_Boss(50,"Meduse",0,20,0,"La hideuse meduse",myLegen);
        myBoss.setAggressiveFalse();
        assertEquals(false,myBoss.getAggressive());
    }
    
}
