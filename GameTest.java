
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameTest
{
    protected Game myGame;
    /**
     * Default constructor for test class GameTest
     */
    public GameTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        myGame = new Game();
    }
    
    /**
     * test value of finished at the beginning of game
     */
    @Test
    public void testFinishedBeginningGame()
    {
        assertEquals(false, myGame.getFinished());
    }
    
    /**
     * test value of finished at the beginning of game
     */
    @Test
    public void testFillListSpot()
    {
        assertEquals();
    }
    
    /**
     * test if the exit exists
     */
    @Test
    public void testExitExists()
    {
        boolean exist = false;
        ArrayList<Spot> listS = myGame.getListSpot();
        for(int i=0; i<listS.size(); i++){
            if(listS.get(i).getExitSpot()){
             exist = true;
             break;
            }
        }
        assertEquals(true, exist);
    }
    
    /**
     * test there is one exit
     */
    @Test
    public void testOneExitSpot()
    {
        int exist = 0;
        ArrayList<Spot> listS = myGame.getListSpot();
        for(int i=0; i<listS.size(); i++){
            if(listS.get(i).getExitSpot()){
             exist++;
            }
        }
        assertEquals(1, exist);
    }
    
    /**
     * test if the start exists
     */
    @Test
    public void testStartSpotExists()
    {
        boolean exist = false;
        ArrayList<Spot> listS = myGame.getListSpot();
        for(int i=0; i<listS.size(); i++){
            if(listS.get(i).getStartSpot()){
             exist = true;
             break;
            }
        }
        assertEquals(true, exist);
    }
    
    /**
     * test there is one start
     */
    @Test
    public void testOneStartSpot()
    {
        int exist = 0;
        ArrayList<Spot> listS = myGame.getListSpot();
        for(int i=0; i<listS.size(); i++){
            if(listS.get(i).getStartSpot()){
             exist++;
            }
        }
        assertEquals(1, exist);
    }
    
    /**
     * test if each spot has less than 1 exit
     */
    @Test
    public void testNoExit()
    {
        ArrayList<Spot> listS = myGame.getListSpot();
        for(int i=0; i<listS.size(); i++){   
            assertEquals(false,listS.get(i).getAllExit().isEmpty());   
        }
    }
    
    /**
     * test if each spot has more than 4 exits
     */
    @Test
    public void testTooManyExits()
    {
        int exist = 0;
        ArrayList<Spot> listS = myGame.getListSpot();
        for(int i=0; i<listS.size(); i++){   
            assertEquals(false,listS.get(i).getAllExit().size()>4);   
        }
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    
}
