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
    //The variables/attributes necessary to test the functions
    private Common goodCommon;
    private Item goodItem;

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
     *Test that checks if the constructor works properly
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
     * Test that checks if the getters work properly
     */
    //@Test
   // public void testGoodItem()
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
        goodCommon.setHealthGain(-10);
        assertEquals(0, goodCommon.getHealthGain()); // the value of healthGain should remain at 0
    }
    
    
     /**
     * test if the set damage accepts a negative value
     * this should not be possible
     */
    @Test
    public void testSetNegativeDamage()
    {
        goodCommon.setDamage(-10);//Damage with a negative value
        assertEquals(2,goodCommon.getDamage());//The parameter "2" must remain defined as damage attribute
    }
    
    /**
     * test if the set damage method accepts a positive value
     * This should be possible
     */
    @Test
    public void testSetPositiveDamage()
    {
        goodCommon.setDamage(10);//Damage with a positive value
        assertEquals(10,goodCommon.getDamage());//The parameter "10" must be set as the damage attribute
    }
    /**
     * tests if the set protection method accepts a negative value
     * This should not be possible
     */
    @Test
    public void testSetNegativeProtection()
    {
        goodCommon.setProtection(-10);//Protection with a negative value
        assertEquals(2,goodCommon.getProtection());//The parameter "2" must remain defined as protection attribute
    }
    
    /**
     * tests if the set protection method accepts a positive value
     * this should be possible
     */
    @Test
    public void testSetPositiveProtection()
    {
        goodCommon.setProtection(10);//Protection with a positive value
        assertEquals(10,goodCommon.getProtection());//The parameter "10" must be set as the protection attribute
    }
    /**
     * test for good name
     *  Checks if the name given as parameter in the constructor is correctly set to the attribute
     */
    @Test
    public void testSetName()
    {
        goodCommon.setName("YousraDelphine");
        assertEquals("YousraDelphine",goodCommon.getName()); // The parameter "YousraDelphine" must be set as the name attribute
    }
    
    /**
     * Removes the set up
     */
    @After
    public void tearDown() 
    {
    }
}