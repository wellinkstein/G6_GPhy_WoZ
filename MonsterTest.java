import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test MonsterTest.
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
public class MonsterTest
{
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
     * This test checks if Minotaur is a valid name
     */
    @Test
    public void CheckGoodMonsterNameMinotaur()
    {
        goodMonster= new Monster(10,"Minotaur",1,5,0,0);
        assertEquals(10,goodMonster.getHP());
        assertEquals("Minotaur",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * This test checks if Medusa is a valid monster name 
     */
    @Test
    public void CheckGoodMonsterNameMedusa()
    {
        goodMonster= new Monster(10,"Medusa",1,5,0,0);
        assertEquals(10,goodMonster.getHP());
        assertEquals("Medusa",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * This test checks if Chimera is a valid monster name
     */
    @Test
    public void CheckGoodMonsterNameChimera()
    {
        goodMonster= new Monster(10,"Chimera",1,5,0,0);
        assertEquals(10,goodMonster.getHP());
        assertEquals("Chimera",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * This test checks if Arachne is a valid monster name
     */
    @Test
    public void CheckGoodMonsterNameArachne()
    {
        goodMonster= new Monster(10,"Arachne",1,5,0,0);
        assertEquals(10,goodMonster.getHP());
        assertEquals("Arachne",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * This test checks if Cyclops is a valid monster name
     */
    @Test
    public void CheckGoodMonsterNameCyclops()
    {
        goodMonster= new Monster(10,"Cyclops",1,5,0,0);
        assertEquals(10,goodMonster.getHP());
        assertEquals("Cyclops",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * This test checks if Cerberus is a valid monster name
     */
    @Test
    public void CheckGoodMonsterNameCerberus()
    {
        goodMonster= new Monster(10,"Cerberus",1,5,0,0);
        assertEquals(10,goodMonster.getHP());
        assertEquals("Cerberus",goodMonster.getName());
        assertEquals(1,goodMonster.getXp());
        assertEquals(5,goodMonster.getDamage());
        assertEquals(0,goodMonster.getPosX());
        assertEquals(0,goodMonster.getPosY());
    }
    
    /**
     * This test checks for bad monster names
     */
    @Test
    public void CheckBadMonsterName()
    {
        badMonster= new Monster(10,"Blarg",1,5,0,0);
        assertEquals(10,badMonster.getHP());
        assertEquals("Blarg",badMonster.getName());
        assertEquals(1,badMonster.getXp());
        assertEquals(5,badMonster.getDamage());
        assertEquals(0,badMonster.getPosX());
        assertEquals(0,badMonster.getPosY());
    }
    
}