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
    private Item goodItem;

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
     * Test that checks if the getters work properly
     */
    //@Test
    //public void testGoodItem()
    {
        //assertEquals("Iron Sword",goodItem.getName());
        //assertEquals("Common sword",goodItem.getDescription());
        //assertEquals(2,goodItem.getDamage());
        //assertEquals (2,goodItem.getProtection());
        //assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test if it is possible to set a negative value for healGain
     */
    @Test
    public void testSetNegativeHPGain()
    {
        goodLegendary.setHealthGain(-10);
        assertEquals(0, goodLegendary.getHealthGain()); // the value of healthGain should remain at 0
    }
    
    
     /**
     * test if the set damage accepts a negative value
     * this should not be possible
     */
    @Test
    public void testSetNegativeDamage()
    {
        goodLegendary.setDamage(-10);//Damage with a negative value
        assertEquals(2,goodLegendary.getDamage());//The parameter "2" must remain defined as damage attribute
    }
    
    /**
     * test if the set damage method accepts a positive value
     * This should be possible
     */
    @Test
    public void testSetPositiveDamage()
    {
        goodLegendary.setDamage(10);//Damage with a positive value
        assertEquals(10,goodLegendary.getDamage());//The parameter "10" must be set as the damage attribute
    }
    /**
     * tests if the set protection method accepts a negative value
     * This should not be possible
     */
    @Test
    public void testSetNegativeProtection()
    {
        goodLegendary.setProtection(-10);//Protection with a negative value
        assertEquals(2,goodLegendary.getProtection());//The parameter "2" must remain defined as protection attribute
    }
    
    /**
     * tests if the set protection method accepts a positive value
     * this should be possible
     */
    @Test
    public void testSetPositiveProtection()
    {
        goodLegendary.setProtection(10);//Protection with a positive value
        assertEquals(10,goodLegendary.getProtection());//The parameter "10" must be set as the protection attribute
    }
    /**
     * test for good name
     *  Checks if the name given as parameter in the constructor is correctly set to the attribute
     */
    @Test
    public void testSetName()
    {
        goodLegendary.setName("YousraDelphine");
        assertEquals("YousraDelphine",goodLegendary.getName()); // The parameter "YousraDelphine" must be set as the name attribute
    }

    /**
     * Removes the set up
     */
    @After
    public void tearDown()
    {}
}