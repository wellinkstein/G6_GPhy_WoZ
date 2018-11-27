import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test LegendaryTest.
 *
 * @author  (Yousra & Delphine)
 * @version (2018)
 
 */
public class LegendaryTest
{
    // instances variables
    private Legendary goodLegendary;

    /**
     * Constructeur de la classe-test LegendaryTest
     */
    public LegendaryTest()
    {
    }

    /**
     * Method used for each method test
     */
    @Before
    public void setUp() 
    {
        goodLegendary = new Legendary("Aries's Sword","Legendary sword", 2, 2, 0);
    }
     /**
     * Test that checks if the constructor work properly
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
    
     */
    @After
    public void tearDown()
    {}
}