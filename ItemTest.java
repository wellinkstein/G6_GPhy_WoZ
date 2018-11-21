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
 * Les classes-test sont documentees ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basees sur le document e 2002 Robert A. Ballance intitule
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associes aux classes e tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m?me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque methode Test e executer.  Il peut y avoir
 * plus d'une methode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ decouvrira automatiquement (par introspection) les methodes
 * Test de votre classe Test et generera la TestSuite consequente.
 * Chaque appel d'une methode Test sera precede d'un appel de setUp(),
 * qui realise les engagements, et suivi d'un appel e tearDown(), qui les
 * detruit.
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
        goodItem.setProtection(-10);
        assertEquals(2,goodItem.getProtection());
    }
    /**
     * test for good protection
     */
    @Test
    public void testSetPositiveProtection()
    {
        goodItem.setProtection(10);
        assertEquals(10,goodItem.getProtection());
    }
    /**
     * test for good name
     */
    @Test
    public void testSetName()
    {
        goodItem.setName("YousraDelphine");
        assertEquals("YousraDelphine",goodItem.getName());
    }
    /**
     * Supprime les engagements
     *
     * Methode appelee apres chaque appel de methode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Liberez ici les ressources engagees par setUp()
    }
    
}