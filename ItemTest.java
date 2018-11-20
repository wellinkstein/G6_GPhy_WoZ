import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test ItemTest.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 *
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m?me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque méthode Test à exécuter.  Il peut y avoir
 * plus d'une méthode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ découvrira automatiquement (par introspection) les méthodes
 * Test de votre classe Test et générera la TestSuite conséquente.
 * Chaque appel d'une méthode Test sera précédé d'un appel de setUp(),
 * qui réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class ItemTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    private Item goodItem;
    private Item badItem;
    private Item goodDamage;
    private Item badDamage;
    private Item goodProtection;
    private Item badProtection;

    /**
     * Constructeur de la classe-test ItemTest
     */
    public ItemTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {

    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
        /**
     * Test that checks if the getters work properly
     */
    @Test
    public void testGoodItem()
    {
        goodItem = new Item("Iron Sword", 2, 2, 0);
        assertEquals("Iron Sword",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks if items can have a negative damage
     */
    @Test
    public void testBadItemNegativeDamage()
    {
        badItem = new Item("Iron Sword", -2 , 2, 0);
        assertEquals("Iron Sword",badItem.getName());
        assertEquals(-2,badItem.getDamage());
        assertEquals (2,badItem.getProtection());
        assertEquals (0,badItem.getHealthGain());
    }
    
    /**
     * Test that checks if item can have a negative protection
     */
    @Test
    public void testBadItemNegativeProtection()
    {
        badItem = new Item("Iron Sword", 2 , -2, 0);
        assertEquals("Iron Sword",badItem.getName());
        assertEquals(2,badItem.getDamage());
        assertEquals (-2,badItem.getProtection());
        assertEquals (0,badItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Adriane's golden thread
     */
    @Test
    public void testGoodItemGoldenThread()
    {
        goodItem = new Item("Ariadne's golden thread", 2 , 2, 0);
        assertEquals("Ariadne's golden thread",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Ares's sword
     */
    @Test
    public void testGoodItemAresSword()
    {
        goodItem = new Item("Ares's sword", 2 , 2, 0);
        assertEquals("Ares's sword",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Artemise's bow
     */
    @Test
    public void testGoodItemArtemisBow()
    {
        goodItem = new Item("Artemis's bow", 2 , 2, 0);
        assertEquals("Artemis's's bow",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name The Aegis Shield
     */
    @Test
    public void testGoodItemAegisShield()
    {
        goodItem = new Item("Aegis shield", 2 , 2, 0);
        assertEquals("Aegis shield",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Hermes's Sandals
     */
    @Test
    public void testGoodItemHermesSandals()
    {
        goodItem = new Item("Hermes's sandals", 2 , 2, 0);
        assertEquals("Hermes's sandals",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
     /**
     * Test that checks item name Iron sword
     */
    @Test
    public void testGoodItemIronSword()
    {
        goodItem = new Item("Iron sword", 2 , 2, 0);
        assertEquals("Iron sword",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Iron dagger
     */
    @Test
    public void testGoodItemIronDagger()
    {
        goodItem = new Item("Iron dagger", 2 , 2, 0);
        assertEquals("Iron dagger",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Standard bow
     */
    @Test
    public void testGoodItemStandardBow()
    {
        goodItem = new Item("Standard bow", 2 , 2, 0);
        assertEquals("Standard bow",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Health Potion
     */
    @Test
    public void testGoodItemHealthPotion()
    {
        goodItem = new Item("Health potion", 0 , 0, 5);
        assertEquals("Health potion",goodItem.getName());
        assertEquals(0,goodItem.getDamage());
        assertEquals (0,goodItem.getProtection());
        assertEquals (5,goodItem.getHealthGain());
    }
    
    
    /**
     * Test that checks item name Iron Armor
     */
    @Test
    public void testGoodItemIronArmor()
    {
        goodItem = new Item("Iron Armor", 2 , 2, 0);
        assertEquals("Iron Armor",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
    
    /**
     * Test that checks item name Iron Armor
     */
    @Test
    public void testBadItemName()
    {
        goodItem = new Item("Blarg", 2 , 2, 0);
        assertEquals("Blarg",goodItem.getName());
        assertEquals(2,goodItem.getDamage());
        assertEquals (2,goodItem.getProtection());
        assertEquals (0,goodItem.getHealthGain());
    }
}