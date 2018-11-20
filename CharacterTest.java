import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CharacterTest.
 *
 * @author  (votre nom)
 * @version (un numero de version ou une date)
 *
 * Les classes-test sont documentees ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basees sur le document 2002 Robert A. Ballance intitule
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associes aux classes a tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m?me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque methode Test a executer.  Il peut y avoir
 * plus d'une methode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ decouvrira automatiquement (par introspection) les methodes
 * Test de votre classe Test et generera la TestSuite consequente.
 * Chaque appel d'une methode Test sera procede d'un appel de setUp(),
 * qui realise les engagements, et suivi d'un appel a tearDown(), qui les
 * detruit.
 */
public class CharacterTest
{
    // Definissez ici les variables d'instance necessaires a vos engagements;
    // Vous pouvez egalement les saisir automatiquement du presentoir
    // a l'aide du menu contextuel "Presentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du presentoir (les objets sans constructeur, comme int, float, etc.).
    protected Character myCharacter;
    protected Item  myItem;

    /**
     * Constructeur de la classe-test CharacterTest
     */
    public CharacterTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Methode appelee avant chaque appel de methode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        myCharacter = new Character(50);
        myItem = new Item(); //on cree un item
    }

    
    /**
     * test for all attributes
     */
    @Test
    public void testGettersCharOK()
    {
        assertEquals(50,myCharacter.getHP());
        assertEquals(50,myCharacter.getXp());
        assertEquals("Name",myCharacter.getName());
        assertEquals(50,myCharacter.getDamage());
        assertEquals(50,myCharacter.getPosX());
        assertEquals(50,myCharacter.getPosY());
    }
    
    /**
     * test for the gainHP method
     */
    @Test
    public void testGainHP()
    {
        myCharacter = new Character(30);
        myCharacter.gainHP(20);
        assertEquals(50,myCharacter.getHP());
    }
    
    /**
     * test for negative gain of HP
     */
    @Test
    public void testGainNegativeHP()
    {
        myCharacter.gainHP(-10);
        assertEquals(50,myCharacter.getHP());
    }
    
    /**
     * test for decrease HP
     */
    @Test
    public void testLoseHP()
    {
        myCharacter.loseHp(-10);
        assertEquals(40,myCharacter.getHP());
    }
    
    /**
     * test for loseHP with negative parameters
     */
    @Test
    public void testLosePositiveHP()
    {
        myCharacter.loseHp(10);
        assertEquals(50,myCharacter.getHP());
    }
    
    /**
     * test for adding an item to the inventory
     */
    @Test
    public void testGainXP()
    {
        myCharacter.gainXp(10);
        assertEquals(10,myCharacter.getXp());
    }
    
    /**
     * test for adding an item to the inventory
     */
    @Test
    public void testGainNegativeXP()
    {
        myCharacter.gainXp(-10);
        assertEquals(0,myCharacter.getXp());
    }
    
    /**
     * test for increaseDamage
     */
    @Test
    public void testIncreaseDamage()
    {
        myCharacter.increaseDamage(10);
        assertEquals(20,myCharacter.getDamage());
    }
    
    /**
     * test for increaseDamage with negative 
     */
    @Test
    public void testIncreaseNegativeDamage()
    {
        myCharacter.increaseDamage(-10);
        assertEquals(10,myCharacter.getDamage());
    }
    
    /**
     * test for decreaseDamage
     */
    @Test
    public void testDecreaseDamage()
    {
        myCharacter.decreaseDamage(-10);
        assertEquals(0,myCharacter.getDamage());
    }
    
    /**
     * test for decreaseDamage with positive parameters
     */
    @Test
    public void testDecreasePositiveDamage()
    {
        myCharacter.decreaseDamage(10);
        assertEquals(10,myCharacter.getDamage());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveUp()
    {
        myCharacter.moveUp();
        assertEquals(1,myCharacter.getPosY());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveDown()
    {
        myCharacter.moveDown();
        assertEquals(0,myCharacter.getPosY());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveRight()
    {
        myCharacter.moveRight();
        assertEquals(1,myCharacter.getPosX());
    }
    
    /**
     * test for moveUp
     */
    @Test
    public void testMoveLeft()
    {
        myCharacter.moveLeft();
        assertEquals(-1,myCharacter.getPosX());
    }
    
    /**
    /**
     * Supprime les engagements
     *
     * Methode appelee apres chaque appel de methode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Lib�rez ici les ressources engag�es par setUp()
    }
}
