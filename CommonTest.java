import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CommonTest.
 *
 * @author Delphine - Yousra
 * @version 21 Novembre 2018
 *
 */
public class CommonTest
{
    
    private Common goodCommon;
    

    /**
     * Constructor of the class test CommonTest 
     */
    public CommonTest()
    {
    }

    /**
     *Set up the constructor
     *Constructor layout (itemName, des, dam, prot, HG)
     * 
     */
    @Before
    public void setUp() 
    { 
        goodCommon = new Common("Iron Sword","Common sword", 2, 2, 0);

    }
        /**
     *Test that checks if the constructor work properly
     */
    @Test
    public void testGoodCommon()
    {
        assertEquals("Iron Sword",goodCommon.getName());
        assertEquals("Common sword",goodCommon.getDescription());
        assertEquals(2,goodCommon.getDamage());
        assertEquals (2,goodCommon.getProtection());
        assertEquals (0,goodCommon.getHealthGain());
    }

    /**
     * 
     *
     */
    @After
    public void tearDown() 
    {
        //Lib�rez ici les ressources engag�es par setUp()
    }
}