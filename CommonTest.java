

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test CommonTest.
 *
 * @author  (votre nom)
 * @version (un numero de version ou une date)
 *
 * Les classes-test sont documentees ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basees sur le document e 2002 Robert A. Ballance intitule
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associes aux classes a tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m?me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque methode Test executer.  Il peut y avoir
 * plus d'une methode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ decouvrira automatiquement (par introspection) les methodes
 * Test de votre classe Test et generera la TestSuite consequente.
 * Chaque appel d'une methode Test sera precede d'un appel de setUp(),
 * qui realise les engagements, et suivi d'un appel a tearDown(), qui les
 * detruit.
 */
public class CommonTest
{
    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).
    protected double fValeur1;
    protected double fValeur2;

    /**
     * Constructeur de la classe-test CommonTest
     */
    public CommonTest()
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
        // Initialisez ici vos engagements
        fValeur1= 2.0;
        fValeur2= 3.0;
    }

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
