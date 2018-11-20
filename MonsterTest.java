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
    
    /**
     * This test checks if Minotaur is a valid name
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
     * This test checks if Medusa is a valid monster name 
     */
    @Test
    public void CheckGoodMonsterNameMedusa()
    {
        goodMonster= new Monster(10,"Medusa",1,5,0,0,"La hideuse meduse");
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
        goodMonster= new Monster(10,"Chimera",1,5,0,0,"La terrifiante chimere");
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
        goodMonster= new Monster(10,"Arachne",1,5,0,0,"La vile Arachne");
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
        goodMonster= new Monster(10,"Cyclops",1,5,0,0,"Le grand cyclope");
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
        goodMonster= new Monster(10,"Cerberus",1,5,0,0,"Le chien a 3 tête");
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
        badMonster= new Monster(10,"Blarg",1,5,0,0,"Aucune idée");
        assertEquals(10,badMonster.getHP());
        assertEquals("Blarg",badMonster.getName());
        assertEquals(1,badMonster.getXp());
        assertEquals(5,badMonster.getDamage());
        assertEquals(0,badMonster.getPosX());
        assertEquals(0,badMonster.getPosY());
    }
    
}