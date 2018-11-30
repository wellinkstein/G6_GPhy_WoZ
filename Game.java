import java.util.*;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Game 
{
    private Spot currentSpot; // position of player
    private boolean finished; // At the beginning of the game it's false (false: the player must kill the Minotaur; true: the Minotaur was killed and the player must get out)
    private int line = 8; //number of lines in the matrix;
    private int column = 9; //number of columns in the matrix;
    private ArrayList<Spot> listSpot = new ArrayList(); // list of spots in the labyrinth 
    private Character fighter;
    private Player Theseus;
    /** 
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createLabyrinth();
        
        Player theseus = new Player(20,"Theseus",1,1,0);
        
        
        Common ironSword= new Common ("Iron Sword","",3,0,0);
        Common ironDagger= new Common ("Iron Dagger","",1,0,0);
        Common standardBow= new Common ("Standard Bow","",2,0,0);
        Common ironArmor= new Common ("Iron Armor","",0,0,3);
        Common ironShield= new Common ("Iron Shield","",1,0,0);
        Common woodenShield= new Common ("Wooden Shield","",2,0,0);
        Common healthPotion= new Common ("Health Potion","",0,5,0);
        
        Legendary goldenThread = new Legendary("Ariadne's golden thread","",0,0,0);
        Legendary aresSword= new Legendary("Ares's sword","",6,0,0);
        Legendary artemisBow= new Legendary("Artemis's bow","",4,0,0);
        Legendary aegisShield= new Legendary("Aegis shield","",0,5,0);
        Legendary hermesSandals= new Legendary("Hermes's sandals","",0,0,0);
        
        LesserBoss chimera= new LesserBoss(30,"Chimera",5,2,2,"",hermesSandals);
        LesserBoss cerberus= new LesserBoss(40,"Cerberus",5,6,2,"",aresSword);
        LesserBoss medusa= new LesserBoss(20,"Medusa",5,4,1,"",artemisBow);
        LesserBoss cyclops= new LesserBoss(30,"Cyclops",5,5,5,"",aegisShield);
        LesserBoss arachne= new LesserBoss(40,"Arachne",5,4,4,"",goldenThread);
        
        Boss minotaur = new Boss(75,"Minotaur",5,15,7,"The great Minotaur");
        
        
        listSpot.get(9).addCharacterSpot(minotaur);
        listSpot.get(5).addCharacterSpot(cerberus);
        listSpot.get(6).addCharacterSpot(medusa);
        listSpot.get(7).addCharacterSpot(cyclops);
        listSpot.get(8).addCharacterSpot(chimera);
        listSpot.get(10).addCharacterSpot(arachne);

        
        
        ArrayList<Integer> listIronSword = new ArrayList();
        listIronSword.add(10);
        listIronSword.add(11);
        listIronSword.add(12);
        placeItem(ironSword,listIronSword); 
        
        ArrayList<Integer> listIronDagger = new ArrayList();
        listIronDagger.add(13);
        listIronDagger.add(14);
        listIronDagger.add(15);
        placeItem(ironDagger,listIronDagger); 
        
        ArrayList<Integer> listStandardBow = new ArrayList();
        listStandardBow.add(16);
        listStandardBow.add(17);
        listStandardBow.add(18);
        placeItem(standardBow,listStandardBow);
        
        ArrayList<Integer> listIronArmor = new ArrayList();
        listIronArmor.add(19);
        listIronArmor.add(20);
        listIronArmor.add(21);
        placeItem(ironArmor,listIronArmor);
        
        ArrayList<Integer> listIronShield = new ArrayList();
        listIronShield.add(19);
        listIronShield.add(20);
        listIronShield.add(21);
        placeItem(ironShield,listIronShield);
        
        ArrayList<Integer> listWoodenShield = new ArrayList();
        listWoodenShield.add(19);
        listWoodenShield.add(20);
        listWoodenShield.add(21);
        placeItem(woodenShield,listWoodenShield);
        
        ArrayList<Integer> listHealthPotion = new ArrayList();
        listHealthPotion.add(19);
        listHealthPotion.add(20);
        listHealthPotion.add(21);
        placeItem(healthPotion,listHealthPotion);
        
      
        exitAndStart();//initialize start spot (also current spot) and exit spot 
        currentSpot.addCharacterSpot(Theseus);
        setFinishedFalse();
    }

    /**
     * Create all the spots and link their exits together. Defines the start, exit and current spot.
     */
    private void createLabyrinth()
    {
        // Create spots
         for (int i = 0; i < line*column; i++) { 
              //listSpot.add(new Spot(null,null));
              listSpot.add(new Spot());
          }
        
        
        // initialise spot exits
        listSpot.get(0).setExits("D",listSpot.get(1));
        listSpot.get(1).setExits("Q",listSpot.get(0));
        listSpot.get(1).setExits("S",listSpot.get(10));
        listSpot.get(2).setExits("S",listSpot.get(11));
        listSpot.get(2).setExits("D",listSpot.get(3));
        listSpot.get(3).setExits("Q",listSpot.get(2));
        listSpot.get(3).setExits("S",listSpot.get(12));
        listSpot.get(4).setExits("S",listSpot.get(13));
        listSpot.get(4).setExits("D",listSpot.get(5));
        listSpot.get(5).setExits("Q",listSpot.get(4));
        listSpot.get(5).setExits("S",listSpot.get(14));
        listSpot.get(6).setExits("Z",null);
        listSpot.get(6).setExits("S",listSpot.get(15));
        listSpot.get(6).setExits("D",listSpot.get(7));
        listSpot.get(7).setExits("Q",listSpot.get(6));
        listSpot.get(7).setExits("D",listSpot.get(8));
        listSpot.get(8).setExits("Q",listSpot.get(7));
        listSpot.get(9).setExits("S",listSpot.get(18));
        listSpot.get(10).setExits("Z",listSpot.get(1));
        listSpot.get(10).setExits("S",listSpot.get(19));
        listSpot.get(11).setExits("Z",listSpot.get(2));
        listSpot.get(12).setExits("Z",listSpot.get(3));
        listSpot.get(12).setExits("S",listSpot.get(21));
        listSpot.get(13).setExits("Z",listSpot.get(4));
        listSpot.get(13).setExits("D",listSpot.get(14));
        listSpot.get(13).setExits("S",listSpot.get(22));
        listSpot.get(14).setExits("Z",listSpot.get(5));
        listSpot.get(14).setExits("Q",listSpot.get(13));
        listSpot.get(14).setExits("D",listSpot.get(15));
        listSpot.get(15).setExits("Z",listSpot.get(6));
        listSpot.get(15).setExits("Q",listSpot.get(14));
        listSpot.get(15).setExits("S",listSpot.get(24));
        listSpot.get(16).setExits("D",listSpot.get(17));
        listSpot.get(16).setExits("S",listSpot.get(25));
        listSpot.get(17).setExits("Q",listSpot.get(16));
        listSpot.get(18).setExits("Z",listSpot.get(9));
        listSpot.get(18).setExits("D",listSpot.get(11));
        listSpot.get(11).setExits("Q",listSpot.get(18));
        listSpot.get(11).setExits("Z",listSpot.get(10));
        listSpot.get(11).setExits("D",listSpot.get(20));
        listSpot.get(20).setExits("Q",listSpot.get(11));
        listSpot.get(20).setExits("D",listSpot.get(21));
        listSpot.get(21).setExits("Q",listSpot.get(20));
        listSpot.get(21).setExits("Z",listSpot.get(12));
        listSpot.get(21).setExits("S",listSpot.get(30));
        listSpot.get(22).setExits("Z",listSpot.get(13));
        listSpot.get(22).setExits("D",listSpot.get(23));
        listSpot.get(23).setExits("Q",listSpot.get(22));
        listSpot.get(23).setExits("S",listSpot.get(32));
        listSpot.get(24).setExits("Z",listSpot.get(15));
        listSpot.get(24).setExits("D",listSpot.get(25));
        listSpot.get(25).setExits("Q",listSpot.get(24));
        listSpot.get(25).setExits("Z",listSpot.get(16));
        listSpot.get(25).setExits("D",listSpot.get(26));
        listSpot.get(26).setExits("Q",listSpot.get(25));
        listSpot.get(26).setExits("S",listSpot.get(35));
        listSpot.get(27).setExits("S",listSpot.get(36));
        listSpot.get(27).setExits("D",listSpot.get(28));
        listSpot.get(28).setExits("Q",listSpot.get(27));
        listSpot.get(29).setExits("D",listSpot.get(30));
        listSpot.get(29).setExits("S",listSpot.get(38));
        listSpot.get(30).setExits("Z",listSpot.get(21));
        listSpot.get(30).setExits("Q",listSpot.get(29));
        listSpot.get(31).setExits("D",listSpot.get(32));
        listSpot.get(32).setExits("Q",listSpot.get(31));
        listSpot.get(32).setExits("Z",listSpot.get(23));
        listSpot.get(32).setExits("D",listSpot.get(33));
        listSpot.get(32).setExits("S",listSpot.get(41));
        listSpot.get(33).setExits("Q",listSpot.get(32));
        listSpot.get(33).setExits("D",listSpot.get(34));
        listSpot.get(34).setExits("Q",listSpot.get(33));
        listSpot.get(34).setExits("D",listSpot.get(35));
        listSpot.get(35).setExits("Q",listSpot.get(34));
        listSpot.get(35).setExits("Z",listSpot.get(26));
        listSpot.get(36).setExits("Z",listSpot.get(27));
        listSpot.get(36).setExits("D",listSpot.get(37));
        listSpot.get(37).setExits("Q",listSpot.get(36));
        listSpot.get(37).setExits("S",listSpot.get(46));
        listSpot.get(38).setExits("Z",listSpot.get(29));
        listSpot.get(38).setExits("D",listSpot.get(39));
        listSpot.get(39).setExits("Q",listSpot.get(38));
        listSpot.get(39).setExits("D",listSpot.get(40));
        listSpot.get(40).setExits("Q",listSpot.get(39));
        listSpot.get(40).setExits("S",listSpot.get(49));
        listSpot.get(41).setExits("Z",listSpot.get(32));
        listSpot.get(41).setExits("D",listSpot.get(42));
        listSpot.get(41).setExits("S",listSpot.get(50));
        listSpot.get(42).setExits("Q",listSpot.get(41));
        listSpot.get(42).setExits("D",listSpot.get(43));
        listSpot.get(43).setExits("Q",listSpot.get(42));
        listSpot.get(43).setExits("D",listSpot.get(44));
        listSpot.get(44).setExits("Q",listSpot.get(43));
        listSpot.get(44).setExits("S",listSpot.get(53));
        listSpot.get(54).setExits("Z",listSpot.get(45));
        listSpot.get(54).setExits("D",listSpot.get(55));
        listSpot.get(54).setExits("S",listSpot.get(63));
        listSpot.get(55).setExits("Z",listSpot.get(46));
        listSpot.get(55).setExits("Q",listSpot.get(54));
        listSpot.get(55).setExits("S",listSpot.get(64));
        listSpot.get(56).setExits("Z",listSpot.get(47));
        listSpot.get(56).setExits("S",listSpot.get(65));
        listSpot.get(57).setExits("D",listSpot.get(58));
        listSpot.get(57).setExits("S",listSpot.get(66));
        listSpot.get(58).setExits("Q",listSpot.get(57));
        listSpot.get(58).setExits("Z",listSpot.get(49));
        listSpot.get(58).setExits("D",listSpot.get(59));
        listSpot.get(59).setExits("Q",listSpot.get(58));
        listSpot.get(59).setExits("S",listSpot.get(68));
        listSpot.get(60).setExits("Z",listSpot.get(51));
        listSpot.get(60).setExits("D",listSpot.get(61));
        listSpot.get(61).setExits("Q",listSpot.get(60));
        listSpot.get(61).setExits("D",listSpot.get(62));
        listSpot.get(61).setExits("S",listSpot.get(70));
        listSpot.get(62).setExits("Q",listSpot.get(61));
        listSpot.get(62).setExits("S",listSpot.get(71));
        listSpot.get(63).setExits("Z",listSpot.get(54));
        listSpot.get(64).setExits("Z",listSpot.get(55));
        listSpot.get(64).setExits("D",listSpot.get(65));
        listSpot.get(65).setExits("Q",listSpot.get(64));
        listSpot.get(65).setExits("Z",listSpot.get(56));
        listSpot.get(66).setExits("Z",listSpot.get(57));
        listSpot.get(67).setExits("D",listSpot.get(68));
        listSpot.get(68).setExits("Q",listSpot.get(67));
        listSpot.get(68).setExits("Z",listSpot.get(59));
        listSpot.get(68).setExits("D",listSpot.get(69));
        listSpot.get(69).setExits("Q",listSpot.get(68));
        listSpot.get(69).setExits("D",listSpot.get(70));
        listSpot.get(70).setExits("Q",listSpot.get(69));
        listSpot.get(70).setExits("Z",listSpot.get(61));
        listSpot.get(71).setExits("Z",listSpot.get(62));
        
         
    }
    
       /**
     * Print out the opening message for the player.
     */
    private String printWelcome()
    {
        // System.out.println();
        // System.out.println("Welcome to the World of Zuul!");
        // System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        // System.out.println("Type 'help' if you need help.");
        // System.out.println();
        // System.out.println("You are " + currentSpot.getDescription());
        // System.out.print("Exits: ");
        // if(currentRoom.northExit != null)
            // System.out.print("Z");
        // if(currentRoom.eastExit != null)
            // System.out.print("D");
        // if(currentRoom.southExit != null)
            // System.out.print("S");
        // if(currentRoom.westExit != null)
            // System.out.print("Q");
        // System.out.println();
        return "welcome";
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        
        printWelcome();

        while (! finished) {
            
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
        
    
    
     /**
     *  Defines the only exit and the only start of the labyrinth (two separate spots)
     */
    public void exitAndStart()
    {
        listSpot.get(0).setStartSpot();
        setCurrentSpot(listSpot.get(0));
        listSpot.get(6).setExitSpot();
    }
    
 
    
    /**
     *  Get the Player
     */
    public Player getPlayer() 
    { 
        return Theseus;
    }

    
    
    /**
     * Places one type of commmon item in a definite number of spots. 
     */
    public void placeItem(Item item, ArrayList<Integer> spotIndexList)
    {
         for (int i = 0; i < spotIndexList.size(); i++) { 
              listSpot.get(spotIndexList.get(i)).addItemSpot(item);
          }
    }
     
    /**
     *  Get the value of finished
     */
    public boolean getFinished() 
    { 
        return finished;
    }
    
    /**
     *  Set the value of finished to true
     */
    public void setFinishedTrue() 
    { 
        finished= true;
    }
    
    /**
     *  Set the value of finished to false
     */
    public void setFinishedFalse() 
    { 
        finished= false;
    }
    /**
     *  Get the room where the player is 
     */
    public Spot getCurrentSpot() 
    { 
        return currentSpot;         
    }
    
    /**
     *  Set the room where the player is 
     */
    public void setCurrentSpot(Spot currentS) 
    { 
        currentSpot = currentS;         
    }
    
     /**
     *  Get the list of spots of the labyrinth 
     */
    public ArrayList<Spot> getListSpot() 
    { 
        return listSpot;         
    }
   
    /**
     * Gets the adjacent spot at a specific direction 
     * 
     */
    public Spot chooseDirection(String direction) 
    { 
        return currentSpot.getExits(direction);
    }
    /**
     * Changes the current spot to the spot according to the direction given
     * 
     */
    public void move(Spot spot) 
    { 
               
    }
    /**
     * gets the choice of the player to fight the monster or to run away.
     * 
     */
    public boolean runAwayOrFight() 
    { 
         return true;       
    }
    /**
     * If the player loses the fight
     * 
     */
    public boolean loseGame() 
    { 
         return true;         
    }
    
    /**
     * The fight starts. it ends when one the characters dies
     * 
     */
    public void fight() 
    { 
          
    }
    
    /**
     * Randomly chooses the first fighter to start
     * 
     */
    public Character whoBegins() 
    { 
       
        return Theseus;   
    }
    
    /**
     * The fighter inflicts damage to the other character in the spot
     * 
     */
    public void inflictDamage() 
    { 
          
    }
    
  
     /**
     * 
     * 
     */
    public void criticialHit() 
    { 
          
    }
    
    /**
     * Changes the fighter to a designed character
     * 
     */
    public void setFighter( Character character) 
    { 
          
    }
    
    /**
     * Gets the currently designed fighter 
     * 
     */
    public void getFighter( Character character) 
    { 
          
    }
    /**
     *  All monsters become aggressive and start chasing you.
     * 
     */
    public void setAggressiveAll() 
    { 
                
    }
    
    
    /**
     * gets if every monster is aggressive
     * 
     */
    public boolean getAggressiveAll() 
    { 
        return false;        
    }
    
    /**
     * if the player wins by giving the last blow, he wins. Otherwise he doesn't.
     * 
     */
    public void setWin(boolean win) 
    { 
                
    }
    
    /**
     * 
     * 
     */
    public boolean getWin() 
    { 
       return true;         
    }
    
    /**
     * returns the game over message
     * 
     */
    public String gameOver() 
    { 
      return "Game over";          
    }

    /**
     *  returns the winning message
     * 
     */
    public String youWon() 
    { 
      return "You won!";          
    }
    
    /**
     * 
     * Returns the message saying that it's not time to exit the labyrinth yet
     */
    public String NotTimeToGo() 
    { 
      return "You didn't kill the Minotaur";          
    }
    
    /**
     * Kills monster
     * 
     */
    public void monsterDead()
    {
          // parcourir la liste pour récupérer la valeur monstre
    // addItem(monstre.getLegendary())
    // removecharactermonstre()

    }
    
    /**
     * Kills monster
     * 
     */
    public void playerDropItem(Item itemDop)
    {
        //player.dropItem(itemDrop);
        //currentSpot.addItem(itemDrop);
    }
    
    /**
     * If the player killed the Minotaur, the game is finished. If the player goes to the exit without klling the Minotaur, he'll have to choose another direction
     * 
     */
    public void endGame() 
    { 
                
    }
    

    
}
