import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CommonTest.
 *
 * @author Delphine Yousra
 * @version 21 Novembre 2018
 *
 */
public class CommonTest
{
    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).
    private Common goodCommon;
    

    /**
     * Constructeur de la classe-test CommonTest
     */
    public CommonTest()
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
        goodCommon = new Common("Iron Sword","Common sword", 2, 2, 0);

    }
        /**
     * Test that checks if the getters work properly
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
    public void tearDown() // throws java.lang.Exception
    {
        //Lib�rez ici les ressources engag�es par setUp()
    }
}