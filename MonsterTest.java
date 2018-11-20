import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test MonsterTest.
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
public class MonsterTest
{
    private Monster myMonster;
    private Monster goodMonster;
    private Monster badMonster;

    /**
     * Constructeur de la classe-test MonsterTest
     */
    public MonsterTest()
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
        myMonster = new Monster(10,"Medusa",1,2,5,5,"Snake Lady");
    }
    
        /**
     * This test checks if Minotaur is a valid name and that the constructor and getters work
     */
    @Test
    public void CheckGoodMonsterNameMinotaur()
    {
        goodMonster= new Monster(10,"Minotaur",1,5,0,0,"Le terrible minotaure");
        assertEquals(10,goodMonster.getHP());
        assertEquals("Minotaur",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * Method that tests the get description function
     */
    @Test
    public void CheckMonsterDescription()
    {
        assertEquals ("Snake Lady",myMonster.getDescription());
    }
    
    /**
     * Tests if the monster is really dead (HP=0)
     */
    @Test
    public void CheckMonsterDeathTrue()
    {
        myMonster.loseHp(15);
        assertEquals (true,myMonster.isDead());
    }
    
    /**
     * Checks if the monster is still alive (HP > 0)
     */
    @Test
    public void CheckMonsterDeathFalse()
    {
        myMonster.loseHp(9);
        assertEquals (false,myMonster.isDead());
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