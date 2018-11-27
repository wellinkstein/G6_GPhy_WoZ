import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class to test the functions of legendary items
 *
 * @author  (Yousra & Delphine)
 * @version (2018)
 
 */
public class LegendaryTest
{
    //The necessary attribute/variable to test the functions of this class
    private Legendary goodLegendary;

    /**
     * Constructor of the legendary test class
     */
    public LegendaryTest()
    {
    }

    /**
     * Constructor used for each method test
     */
    @Before
    public void setUp() 
    {
        goodLegendary = new Legendary("Aries's Sword","Legendary sword", 2, 2, 0);
    }
     /**
     * Test that checks if the constructor works properly
     */
    @Test
    public void testGoodLegendary()
    {
        assertEquals("Aries's Sword",goodLegendary.getName());
        assertEquals("Legendary sword",goodLegendary.getDescription());
        assertEquals(2,goodLegendary.getDamage());
        assertEquals (2,goodLegendary.getProtection());
        assertEquals (0,goodLegendary.getHealthGain());
    }

    /**
     * Removes the set up
     */
    @After
    public void tearDown()
    {}
}