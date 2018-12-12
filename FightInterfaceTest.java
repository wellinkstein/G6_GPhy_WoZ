import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test FightInterfaceTest.
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
 * se nommera NameTest.java); les deux se retrouvent dans le męme paquetage.
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
public class FightInterfaceTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    private AffichMainYohan ibt;
    private Game myGame;
    private Spot mySpot;

    /**
     * Constructeur de la classe-test FightInterfaceTest
     */
    public FightInterfaceTest()
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
    
    @Test
    public void testFight()
    {
        ibt = new AffichMainYohan();
        mySpot = new Spot();
        Legendary artemisBow= new Legendary("Artemis's bow","",4,0,0);
        Legendary hermesSandals= new Legendary("Hermes's sandals","",0,0,0);
        LesserBoss medusa= new LesserBoss(20,"Medusa",5,4,1,"",artemisBow);
        Player theseus = new Player(20,"Theseus",1,1,0);
        
        theseus.takeItem(hermesSandals);
        mySpot.addCharacterSpot(medusa);
        ibt.getGame().setCurrentSpot(mySpot);
        ibt.getGame().addToCurrentSpot(theseus);
        
        ibt.getGame().fight();
        assertFalse(ibt.getGame().getWin());
    }
}
