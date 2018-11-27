import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test ItemTest.
 *
 * @author  (votre nom)
 * @version (un numero de version ou une date)
 *
 */
public class ItemTest
{
    private Item goodItem;
    private Item goodDamage;
    private Item goodProtection;
    private Item myItem;

    /**
     * Constructor of the Item class test.
     */
    public ItemTest()
    {
    }

    /**
     * Set up the constructor
     *Constructor layout (itemName, des, dam, prot, HG)
     * 
     */
    @Before
    public void setUp() 
    { 
        goodItem = new Item("Iron Sword","Common sword", 2, 2, 0);

    }
        /**
     * Test that checks if the getters work properly
     */
    @Test
    public void testGoodItem()
    {
        assertEquals("Iron Sword",goodItem.getName());
        assertEquals("Common sword",goodItem.getDescription());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    /**
     * test for bad damage
     */
    @Test
    public void testSetNegativeDamage()
    {
        goodItem.setDamage(-10);
        assertEquals(2,goodItem.getDamage());
    }
    /**
     * test for good damage
     */
    @Test
    public void testSetPositiveDamage()
    {
        goodItem.setDamage(10);
        assertEquals(10,goodItem.getDamage());
    }
    /**
     * test for bad protection
     */
    @Test
    public void testSetNegativeProtection()
    {
        goodItem.setProtection(-10);//Protection with a negative value
        assertEquals(2,goodItem.getProtection());//The parameter "2" must remain defined as protection attribute
    }
    /**
     * test for good protection
     */
    @Test
    public void testSetPositiveProtection()
    {
        goodItem.setProtection(10);//Protection with a positive value
        assertEquals(10,goodItem.getProtection());//The parameter "10" must be set as the protection attribute
    }
    
    /**
     * test for good name
     *  Checks if the name given as parameter in the constructor is correctly set to the attribute
     */
    @Test
    public void testSetName()
    {
        goodItem.setName("YousraDelphine");
        assertEquals("YousraDelphine",goodItem.getName()); // The parameter "YousraDelphine" must be set as the name attribute
    }
    /**
     *
     */
    @After
    public void tearDown() 
    {
        //Liberez ici les ressources engagees par setUp()
    }
    
}