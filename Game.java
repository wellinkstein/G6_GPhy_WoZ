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
    private HashMap<String,Integer> monsters = new HashMap<String, Integer>();
    private Character fighter;
    private Player Theseus;
    /** 
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createLabyrinth();
        
        Player Theseus = new Player(20,"Theseus",1,1,0);
        
        Common IronSword= new Common ("Iron Sword","",3,0,0);
        Common IronDagger= new Common ("Iron Dagger","",1,0,0);
        Common StandardBow= new Common ("Standard Bow","",2,0,0);
        Common IronArmor= new Common ("Iron Armor","",0,0,3);
        Common IronShield= new Common ("Iron Shield","",1,0,0);
        Common WoodenShield= new Common ("Wooden Shield","",2,0,0);
        Common HealthPotion= new Common ("Health Potion","",0,5,0);
        
        Legendary GoldenThread = new Legendary("Ariadne's golden thread","",0,0,0);
        Legendary AresSword= new Legendary("Ares's sword","",6,0,0);
        Legendary ArtemisBow= new Legendary("Artemis's bow","",4,0,0);
        Legendary AegisShield= new Legendary("Aegis shield","",0,5,0);
        Legendary HermesSandals= new Legendary("Hermes's sandals","",0,0,0);
        
        Lesser_Boss Chimera= new Lesser_Boss(30,"Chimera",5,2,2,"",HermesSandals);
        Lesser_Boss Cerberus= new Lesser_Boss(40,"Cerberus",5,6,2,"",AresSword);
        Lesser_Boss Medusa= new Lesser_Boss(20,"Medusa",5,4,1,"",ArtemisBow);
        Lesser_Boss Cyclops= new Lesser_Boss(30,"Cyclops",5,5,5,"",AegisShield);
        Lesser_Boss Arachne= new Lesser_Boss(40,"Arachne",5,4,4,"",GoldenThread);
        
        Boss Minotaur = new Boss(75,"Minotaur",5,15,7,"The great Minotaur");
        
        placeMonster(Minotaur,9);  
        placeMonster(Cerberus,5);
        placeMonster(Medusa,6);
        placeMonster(Cyclops,7);
        placeMonster(Chimera,8);
        placeMonster(Arachne,10);
        //placePlayer(new Player)
        
        
        //placeItem(IronSword,); 
       
        //defineExits(); // définir les sorties pour chaque spot
        currentSpot=listSpot.get(2);
        exitAndStart();//initialize start spot and exit spot 
        setFinishedFalse();
    }

    /**
     * Create all the spots and link their exits together. Defines the start, exit and current spot.
     */
    private void createLabyrinth()
    {
        // Spot spot11, spot21, spot31, spot41, spot51, spot61, spot71, spot81, spot91;
        // Spot spot12, spot22, spot32, spot42, spot52, spot62, spot72, spot82, spot92;
        // Spot spot13, spot23, spot33, spot43, spot53, spot63, spot73, spot83, spot93;
        // Spot spot14, spot24, spot34, spot44, spot54, spot64, spot74, spot84, spot94;
        // Spot spot15, spot25, spot35, spot45, spot55, spot65, spot75, spot85, spot95;
        // Spot spot16, spot26, spot36, spot46, spot56, spot66, spot76, spot86, spot96;
        // Spot spot18, spot28, spot38, spot48, spot58, spot68, spot78, spot88, spot98;
        // Spot spot17, spot27, spot37, spot47, spot57, spot67, spot77, spot87, spot97;
        
    
        
        
        
        
         // for (int i = 0; i < line*column; i++) { 
              // listSpot.add(new Spot(null,null));
          // }
          
         
        // create the rooms
        
        
        // initialise room exits
        // spot11.setExits("D",spot21);
        // spot21.setExits("Q",spot11);
        // spot21.setExits("S",spot22);
        // spot31.setExits("S",spot32);
        // spot31.setExits("D",spot41);
        // spot41.setExits("Q",spot31);
        // spot41.setExits("S",spot42);
        // spot51.setExits("S",spot52);
        // spot51.setExits("D",spot61);
        // spot61.setExits("Q",spot51);
        // spot61.setExits("S",spot62);
        // spot71.setExits("Z",null);
        // spot71.setExits("S",spot72);
        // spot71.setExits("D",spot81);
        // spot81.setExits("Q",spot71);
        // spot81.setExits("D",spot91);
        // spot91.setExits("Q",spot81);
        // spot12.setExits("S",spot13);
        // spot22.setExits("Z",spot21);
        // spot22.setExits("S",spot23);
        // spot32.setExits("Z",spot31);
        // spot42.setExits("Z",spot41);
        // spot42.setExits("S",spot43);
        // spot52.setExits("Z",spot51);
        // spot52.setExits("D",spot62);
        // spot52.setExits("S",spot53);
        // spot62.setExits("Z",spot61);
        // spot62.setExits("Q",spot52);
        // spot62.setExits("D",spot72);
        // spot72.setExits("Z",spot71);
        // spot72.setExits("Q",spot62);
        // spot72.setExits("S",spot73);
        // spot82.setExits("D",spot92);
        // spot82.setExits("S",spot83);
        // spot92.setExits("Q",spot82);
        // spot13.setExits("Z",spot12);
        // spot13.setExits("D",spot23);
        // spot23.setExits("Q",spot13);
        // spot23.setExits("Z",spot22);
        // spot23.setExits("D",spot33);
        // spot33.setExits("Q",spot23);
        // spot33.setExits("D",spot43);
        // spot43.setExits("Q",spot33);
        // spot43.setExits("Z",spot42);
        // spot43.setExits("S",spot44);
        // spot53.setExits("Z",spot52);
        // spot53.setExits("D",spot63);
        // spot63.setExits("Q",spot53);
        // spot63.setExits("S",spot64);
        // spot73.setExits("Z",spot72);
        // spot73.setExits("D",spot83);
        // spot83.setExits("Q",spot73);
        // spot83.setExits("Z",spot82);
        // spot83.setExits("D",spot93);
        // spot93.setExits("Q",spot83);
        // spot93.setExits("S",spot94);
        // spot14.setExits("S",spot15);
        // spot14.setExits("D",spot24);
        // spot24.setExits("Q",spot14);
        // spot34.setExits("D",spot44);
        // spot34.setExits("S",spot35);
        // spot44.setExits("Z",spot43);
        // spot44.setExits("Q",spot34);
        // spot54.setExits("D",spot64);
        // spot64.setExits("Q",spot54);
        // spot64.setExits("Z",spot63);
        // spot64.setExits("D",spot74);
        // spot64.setExits("S",spot65);
        // spot74.setExits("Q",spot64);
        // spot74.setExits("D",spot84);
        // spot84.setExits("Q",spot74);
        // spot84.setExits("D",spot94);
        // spot94.setExits("Q",spot84);
        // spot94.setExits("Z",spot93);
        // spot15.setExits("Z",spot14);
        // spot15.setExits("D",spot25);
        // spot25.setExits("Q",spot15);
        // spot25.setExits("S",spot26);
        // spot35.setExits("Z",spot34);
        // spot35.setExits("D",spot45);
        // spot45.setExits("Q",spot35);
        // spot45.setExits("D",spot55);
        // spot55.setExits("Q",spot45);
        // spot55.setExits("S",spot56);
        // spot65.setExits("Z",spot64);
        // spot65.setExits("D",spot75);
        // spot65.setExits("S",spot66);
        // spot75.setExits("Q",spot65);
        // spot75.setExits("D",spot85);
        // spot85.setExits("Q",spot75);
        // spot85.setExits("D",spot95);
        // spot95.setExits("Q",spot85);
        // spot95.setExits("S",spot96);
        // spot17.setExits("Z",spot16);
        // spot17.setExits("D",spot27);
        // spot17.setExits("S",spot18);
        // spot27.setExits("Z",spot26);
        // spot27.setExits("Q",spot17);
        // spot27.setExits("S",spot28);
        // spot37.setExits("Z",spot36);
        // spot37.setExits("S",spot38);
        // spot47.setExits("D",spot57);
        // spot47.setExits("S",spot48);
        // spot57.setExits("Q",spot47);
        // spot57.setExits("Z",spot56);
        // spot57.setExits("D",spot67);
        // spot67.setExits("Q",spot57);
        // spot67.setExits("S",spot68);
        // spot77.setExits("Z",spot76);
        // spot77.setExits("D",spot87);
        // spot87.setExits("Q",spot77);
        // spot87.setExits("D",spot97);
        // spot87.setExits("S",spot88);
        // spot97.setExits("Q",spot87);
        // spot97.setExits("S",spot98);
        // spot18.setExits("Z",spot17);
        // spot28.setExits("Z",spot27);
        // spot28.setExits("D",spot38);
        // spot38.setExits("Q",spot28);
        // spot38.setExits("Z",spot37);
        // spot48.setExits("Z",spot47);
        // spot58.setExits("D",spot68);
        // spot68.setExits("Q",spot58);
        // spot68.setExits("Z",spot67);
        // spot68.setExits("D",spot78);
        // spot78.setExits("Q",spot68);
        // spot78.setExits("D",spot88);
        // spot88.setExits("Q",spot78);
        // spot88.setExits("Z",spot87);
        // spot98.setExits("Z",spot97);
        // à remplacer par deux listes utilisées dans defineExits
        
        
        

         
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
     *  Defines the exits of a spot. 
     */
    public void defineExits(ArrayList<String> listDirection, ArrayList<Spot> listSpot) 
    {
        //for len de listDreiction
            //this.setExits(listDirection[i],listSpot[i]
    }
    
     /**
     *  Defines the only exit and the only start of the labyrinth (two separate spots)
     */
    public void exitAndStart()
    {
    }
    
     /**
     * Get the Monsters and his Spot.
     */
    public HashMap<String,Integer> getMonsters()
    {
        return monsters;
         
    }
    /**
     * Places a lesser Monster in the adequate Spot. Each monster has only one spot. 
     */
    public void placeMonster(Monster monster, int spotIndex)
    {
         
    }
    /**
     * Places the Boss in the adequate Spot. The Boss is in a specific spot
       */
    public void placeBoss(Boss boss, int spotIndex)
    {
         
    }
    /**
     * Places one type of commmon item in a definite number of spots. 
     */
    public void placeItem(String name, ArrayList<Integer> spotIndexList)
    {
         
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
    public ArrayList getListSpot() 
    { 
        return listSpot;         
    }
   
    /**
     * Gets the adjacent spot at a specific direction 
     * 
     */
    public Spot chooseDirection() 
    { 
        return listSpot.get(2);//spot adjacent
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
     *  All mosters become aggressive and start chasing you.
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
     * If the player killed the Minotaur, the game is finished. If the player goes to the exit without klling the Minotaur, he'll have to choose another direction
     * 
     */
    public void endGame() 
    { 
                
    }
    
    
    

    

 

    
}
