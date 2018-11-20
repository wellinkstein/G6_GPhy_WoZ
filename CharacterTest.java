

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CharacterTest.
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
public class CharacterTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
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
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        myCharacter = new Character(50);
        myItem = new Item();
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
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
}
