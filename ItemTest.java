import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class to test the various functions of the item class
 *
 * @author  (Group 6)
 * @version (2018-11-27)
 *
 */
public class ItemTest
{
    //private Item goodItem;
    //private Item goodDamage;
   // private Item goodProtection;
    //private Item myItem;

    /**
     * Constructor of the Item class test.
     */
    public ItemTest()
    {
    }

    /**
     * Sets up the constructor
     *Constructor layout (itemName, des, dam, prot, HG)
     * 
     */
    @Before
    public void setUp() 
    { 
        //goodItem = new Item("Iron Sword","Common sword", 2, 2, 0);

    }
    
     /**
     * Test that checks if the getters work properly
     */
    //@Test
    //public void testGoodItem()
    {
       // assertEquals("Iron Sword",goodItem.getName());
       // assertEquals("Common sword",goodItem.getDescription());
        //assertEquals(2,goodItem.getDamage());
        //assertEquals (2,goodItem.getProtection());
        //assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test if it is possible to set a negative value for healGain
     */
    //@Test
    //public void testSetNegativeHPGain()
    {
        //goodItem.setHealthGain(-10);
        //assertEquals(0, goodItem.getHealthGain()); // the value of healthGain should remain at 0
    }
    
    /**
     * test if the set damage accepts a negative value
     * this should not be possible
     */
    //@Test
    //public void testSetNegativeDamage()
    {
        //goodItem.setDamage(-10);//Damage with a negative value
        //assertEquals(2,goodItem.getDamage());//The parameter "2" must remain defined as damage attribute
    }
    
    /**
     * test if the set damage method accepts a positive value
     * This should be possible
     */
    //@Test
    //public void testSetPositiveDamage()
    {
        //goodItem.setDamage(10);//Damage with a positive value
        //assertEquals(10,goodItem.getDamage());//The parameter "10" must be set as the damage attribute
    }
    
    /**
     * tests if the set protection method accepts a negative value
     * This should not be possible
     */
    //@Test
    //public void testSetNegativeProtection()
    {
        //goodItem.setProtection(-10);//Protection with a negative value
        //assertEquals(2,goodItem.getProtection());//The parameter "2" must remain defined as protection attribute
    }
    
    /**
     * tests if the set protection method accepts a positive value
     * this should be possible
     */
    //@Test
    //public void testSetPositiveProtection()
    {
        //goodItem.setProtection(10);//Protection with a positive value
        //assertEquals(10,goodItem.getProtection());//The parameter "10" must be set as the protection attribute
    }
    
    /**
     * test for good name
     *  Checks if the name given as parameter in the constructor is correctly set to the attribute
     */
    //@Test
    //public void testSetName()
    {
        //goodItem.setName("YousraDelphine");
        //assertEquals("YousraDelphine",goodItem.getName()); // The parameter "YousraDelphine" must be set as the name attribute
    }
    
    /**
     *removes the set up
     */
    @After
    public void tearDown() 
    {
        
    }
}