import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameTest.
 *
 * @author  (Groupe 6)
 * @version (28-11-2018)
 */
public class GameTest
{
    protected Game myGame;
    private Player player, theseus; 
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
        // itemInSpot= new ArrayList <Item> ();
        // characterInSpot= new ArrayList <Character> ();
        // //spot= new Spot(characterInSpot, itemInSpot); 
        // player= new Player(20,"Jimmy",2,2,0);
        // theseus= new Player(20, "Theseus", 2,2,0); 
       legendary = new Legendary("Ariadne’s golden thread", "description", 1, 3,1); 
         HermesSandals= new Legendary("Hermes's Sandals","",0,0,0); 
        monster= new LesserBoss(30,"Chimera", 0, 2,2, "io", legendary); 
        myGame = new Game();
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
        for(int i=0; i<myGame.getListSpot().size(); i++){
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
        myGame.getPlayer().takeItem(HermesSandals); 
        myGame.getCurrentSpot().addCharacterSpot(monster); 
        myGame.getCurrentSpot().addCharacterSpot(myGame.getPlayer()); 
        // assertEquals(myGame.getPlayer(),myGame.getCurrentSpot().getPlayer());
        boolean test=false; 
        if(myGame.whoBegins()==myGame.getPlayer()){
            test=true; 
        } 
        //assertTrue(myGame.getPlayer().getHermesSandals()); 
         assertTrue(test); 
        
    }
    
    /**
     * Test the method fight(), if the monster lost, 
     * the items must be free and add at the spot
     */
    @Test
    public void testMonsterDead()
    {
        //myGame.getCurrentSpot().addCharacterSpot(player); 
        myGame.move(myGame.getListSpot().get(45)); 
        myGame.getCurrentSpot().addCharacterSpot(monster);
        myGame.monsterDead();
        assertEquals(null, myGame.getListSpot().get(45).getMonster());
        assertEquals(true, myGame.getListSpot().get(45).getListItem().contains(legendary)); 
        
    }
    
    /**
     * Tests if there is no duplicate of the player in the maze after moving.
     */
    @Test
    public void testMoveOnePlayerInGame(){
        //myGame.getCurrentSpot().addCharacterSpot(theseus);
        myGame.move(myGame.getListSpot().get(1)); 
        //boolean test=false; 
       // for (int i =0; i<myGame.getListSpot().size(); i++){
            //if (myGame.getListSpot().get(i).getPlayer() != null){
               // test=false; 
            //}
            // if(myGame.getListSpot().get(0).getPlayer()== null && myGame.getListSpot().get(1).getPlayer() != null)
                // {test=true; }
        
      assertFalse(myGame.getListSpot().get(0).getIfCharacterInSpot(myGame.getPlayer())); 
      assertEquals(myGame.getPlayer(), myGame.getListSpot().get(1).getPlayer());
        }
       
    /**
     * Verify if the player is on the spot start
     */
    @Test
    public void testPlayerInStartSpot()
    {   
        boolean test=false;  
        for (int i =0; i<myGame.getListSpot().size(); i++){
            if (myGame.getListSpot().get(i).getStartSpot() == true && 
            myGame.getListSpot().get(i).getListCharacter().contains(myGame.getPlayer())== true){
                test=true;  
            }
        }
        assertTrue(test);

    }
    
    /**
     * Check if the player move in the good spot
     */
    @Test
    public void testPlayerMoveSpot(){
        myGame.move(myGame.getListSpot().get(1)); 
        boolean test=false; 
        if (myGame.getListSpot().get(1).getPlayer() != null){
            test=true; 
        }
        assertTrue(test);
        }
        
    /**
     * Check if the Item is in the good place.
     * Check if the Item ironSword is well in the spot 14.
     */   
    @Test
    public void testPlaceItem(){
        boolean test=false;
        for (int i=0; i<myGame.getListSpot().get(10).getListItem().size(); i++){
            if (myGame.getListSpot().get(10).getListItem().get(i).getName() == "Iron Sword"){
                test=true; 
            }
        }
        assertTrue(test);
    }
     /**
     * Check if adding an item to current spot is possible
     * 
     */   
    @Test
    public void testPlaceIteminCurrentSpot(){
        myGame.addItemToCurrentSpot(legendary); 
        boolean test=false;
        if (myGame.getCurrentSpot().getListItem().contains(legendary)){
            test=true; 
        }
        assertTrue(test); 
        
    }
    /**
     * Check if a Exit exists in the game
     */
    @Test
    public void testExit(){
        boolean test=false; 
        if (myGame.getListSpot().get(6).getExitSpot()==true){
            test=true; 
        }
        assertTrue(test);
    }
    /**
     * Check if a Start exists in the game
     */
    @Test
    public void testStart(){
        boolean test=false; 
        if (myGame.getListSpot().get(0).getStartSpot()==true){
            test=true; 
        }
        assertTrue(test);
    }
    
}