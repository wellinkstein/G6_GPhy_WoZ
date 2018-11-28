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
    private Player player; 
    private LesserBoss monster; 
    private Character fighter; 
    private Spot spot; 
    private Legendary legendary, HermesSandals; 
    private Common common; 
    private ArrayList<Item> itemInSpot;
    private ArrayList<Character> characterInSpot; 

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
        itemInSpot= new ArrayList <Item> ();
        characterInSpot= new ArrayList <Character> ();
        spot= new Spot(characterInSpot, itemInSpot); 
        player= new Player(20,"Jimmy",2,2,0);
        legendary = new Legendary("Ariadne’s golden thread", "description", 1, 3,1); 
        HermesSandals= new Legendary("Hermes's sandals","",0,0,0);; 
        monster= new LesserBoss(30,"Chimera", 0, 2,2, "io", legendary); 
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
     * Test if the people who begins is well the fighter if the player has the Hermes's sandals.
     */
    @Test
    public void testWhoBegins(){
        player.takeItem(HermesSandals); 
        myGame.getCurrentSpot().addCharacterSpot(monster); 
        myGame.getCurrentSpot().addCharacterSpot(player); 
        boolean test=false; 
        if(myGame.whoBegins()==player){
            test=true; 
        }; 
        assertTrue(test); 
        
    }
    /**
     * Test the method fight(), if the monster lost, 
     * the items must be free and add at the spot
     */
    @Test
    public void testMonsterDead()
    {
        myGame.getCurrentSpot().addCharacterSpot(player); 
        myGame.getCurrentSpot().addCharacterSpot(monster);
        myGame.getCurrentSpot().monsterDead(); 
        
        
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
