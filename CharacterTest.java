

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CharacterTest.
 *
 * @author  (votre nom)
 * @version (un num�ro de version ou une date)
 *
 * Les classes-test sont document�es ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont bas�es sur le document � 2002 Robert A. Ballance intitul�
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associ�s aux classes � tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m?me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque m�thode Test � ex�cuter.  Il peut y avoir
 * plus d'une m�thode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ d�couvrira automatiquement (par introspection) les m�thodes
 * Test de votre classe Test et g�n�rera la TestSuite cons�quente.
 * Chaque appel d'une m�thode Test sera pr�c�d� d'un appel de setUp(),
 * qui r�alise les engagements, et suivi d'un appel � tearDown(), qui les
 * d�truit.
 */
public class CharacterTest
{
    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).
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
     * M�thode appel�e avant chaque appel de m�thode de test.
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
     * M�thode appel�e apr�s chaque appel de m�thode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Lib�rez ici les ressources engag�es par setUp()
    }
}
