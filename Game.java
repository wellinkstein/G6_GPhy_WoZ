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
    private Spot currentRoom;
    private boolean finished;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createLabyrinth();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createLabyrinth()
    {
        Spot start11, spot21, spot31, spot41, spot51, spot61, exit71, spot81, spot91;
        Spot spot12, spot22, spot32, spot42, spot52, spot62, spot72, spot82, spot92;
        Spot spot13, spot23, spot33, spot43, spot53, spot63, spot73, spot83, spot93;
        Spot spot14, spot24, spot34, spot44, spot54, spot64, spot74, spot84, spot94;
        Spot spot15, spot25, spot35, spot45, spot55, spot65, spot75, spot85, spot95;
        Spot spot16, spot26, spot36, spot46, spot56, spot66, spot76, spot86, spot96;
        Spot spot18, spot28, spot38, spot48, spot58, spot68, spot78, spot88, spot98;
        Spot spot17, spot27, spot37, spot47, spot57, spot67, spot77, spot87, spot97;
        
      
        // create the rooms
        start11 = new Spot();
        spot21 = new Spot();
        spot31 = new Spot();
        spot41 = new Spot();
        spot51 = new Spot();
        spot61 = new Spot();
        exit71 = new Spot();
        spot81 = new Spot();
        spot91 = new Spot();
        spot12 = new Spot();
        spot22 = new Spot();
        spot32 = new Spot();
        spot42 = new Spot();
        spot52 = new Spot();
        spot62 = new Spot();
        spot72 = new Spot(); 
        spot82 = new Spot();
        spot92 = new Spot();
        spot13 = new Spot();
        spot23 = new Spot();
        spot33 = new Spot();
        spot43 = new Spot();
        spot53 = new Spot();
        spot63 = new Spot();
        spot73 = new Spot();
        spot83 = new Spot();
        spot93 = new Spot();
        spot14 = new Spot(); 
        spot24 = new Spot();
        spot34 = new Spot();
        spot44 = new Spot();
        spot54 = new Spot();
        spot64 = new Spot();
        spot74 = new Spot();
        spot84 = new Spot();
        spot94 = new Spot();
        spot15 = new Spot();
        spot25 = new Spot();
        spot35 = new Spot();
        spot45 = new Spot();
        spot55 = new Spot();
        spot65 = new Spot();
        spot75 = new Spot();
        spot85 = new Spot();
        spot95 = new Spot();
        spot16 = new Spot();
        spot26 = new Spot();
        spot36 = new Spot();
        spot46 = new Spot();
        spot56 = new Spot();
        spot66 = new Spot(); 
        spot76 = new Spot();
        spot86 = new Spot();
        spot96 = new Spot();
        spot18 = new Spot();
        spot28 = new Spot();
        spot38 = new Spot();
        spot48 = new Spot();
        spot58 = new Spot();
        spot68 = new Spot();
        spot78 = new Spot();
        spot88 = new Spot();
        spot98 = new Spot();
        spot17 = new Spot();
        spot27 = new Spot();
        spot37 = new Spot();
        spot47 = new Spot();
        spot57 = new Spot();
        spot67 = new Spot();
        spot77 = new Spot();
        spot87 = new Spot();
        spot97 = new Spot();
        
        
        // initialise room exits
        start11.setExits("D",spot21);
        spot21.setExits("Q",start11);
        spot21.setExits("S",spot22);
        spot31.setExits("S",spot32);
        spot31.setExits("D",spot41);
        spot41.setExits("Q",spot31);
        spot41.setExits("S",spot42);
        spot51.setExits("S",spot52);
        spot51.setExits("D",spot61);
        spot61.setExits("Q",spot51);
        spot61.setExits("S",spot62);
        exit71.setExits("S",spot72);
        exit71.setExits("D",spot81);
        spot81.setExits("Q",exit71);
        spot81.setExits("D",spot91);
        spot91.setExits("Q",spot81);
        spot12.setExits("S",spot13);
        spot22.setExits("Z",spot21);
        spot22.setExits("S",spot23);
        spot32.setExits("Z",spot31);
        spot42.setExits("Z",spot41);
        spot42.setExits("S",spot43);
        spot52.setExits("Z",spot51);
        spot52.setExits("D",spot62);
        spot52.setExits("S",spot53);
        spot62.setExits("Z",spot61);
        spot62.setExits("Q",spot52);
        spot62.setExits("D",spot72);
        spot72.setExits("Z",exit71);
        spot72.setExits("Q",spot62);
        spot72.setExits("S",spot73);
        spot82.setExits("D",spot92);
        spot82.setExits("S",spot83);
        spot92.setExits("Q",spot82);
        spot13.setExits("Z",spot12);
        spot13.setExits("D",spot23);
        spot23.setExits("Q",spot13);
        spot23.setExits("Z",spot22);
        spot23.setExits("D",spot33);
        spot33.setExits("Q",spot23);
        spot33.setExits("D",spot43);
        spot43.setExits("Q",spot33);
        spot43.setExits("Z",spot42);
        spot43.setExits("S",spot44);
        spot53.setExits("Z",spot52);
        spot53.setExits("D",spot63);
        spot63.setExits("Q",spot53);
        spot63.setExits("S",spot64);
        spot73.setExits("Z",spot72);
        spot73.setExits("D",spot83);
        spot83.setExits("Q",spot73);
        spot83.setExits("Z",spot82);
        spot83.setExits("D",spot93);
        spot93.setExits("Q",spot83);
        spot93.setExits("S",spot94);
        spot14.setExits("S",spot15);
        spot14.setExits("D",spot24);
        spot24.setExits("Q",spot14);
        spot34.setExits("D",spot44);
        spot34.setExits("S",spot35);
        spot44.setExits("Z",spot43);
        spot44.setExits("Q",spot34);
        spot54.setExits("D",spot64);
        spot64.setExits("Q",spot54);
        spot64.setExits("Z",spot63);
        spot64.setExits("D",spot74);
        spot64.setExits("S",spot65);
        spot74.setExits("Q",spot64);
        spot74.setExits("D",spot84);
        spot84.setExits("Q",spot74);
        spot84.setExits("D",spot94);
        spot94.setExits("Q",spot84);
        spot94.setExits("Z",spot93);
        spot15.setExits("Z",spot14);
        spot15.setExits("D",spot25);
        spot25.setExits("Q",spot15);
        spot25.setExits("S",spot26);
        spot35.setExits("Z",spot34);
        spot35.setExits("D",spot45);
        spot45.setExits("Q",spot35);
        spot45.setExits("D",spot55);
        spot55.setExits("Q",spot45);
        spot55.setExits("S",spot56);
        spot65.setExits("Z",spot64);
        spot65.setExits("D",spot75);
        spot65.setExits("S",spot66);
        spot75.setExits("Q",spot65);
        spot75.setExits("D",spot85);
        spot85.setExits("Q",spot75);
        spot85.setExits("D",spot95);
        spot95.setExits("Q",spot85);
        spot95.setExits("S",spot96);
        spot17.setExits("Z",spot16);
        spot17.setExits("D",spot27);
        spot17.setExits("S",spot18);
        spot27.setExits("Z",spot26);
        spot27.setExits("Q",spot17);
        spot27.setExits("S",spot28);
        spot37.setExits("Z",spot36);
        spot37.setExits("S",spot38);
        spot47.setExits("D",spot57);
        spot47.setExits("S",spot48);
        spot57.setExits("Q",spot47);
        spot57.setExits("Z",spot56);
        spot57.setExits("D",spot67);
        spot67.setExits("Q",spot57);
        spot67.setExits("S",spot68);
        spot77.setExits("Z",spot76);
        spot77.setExits("D",spot87);
        spot87.setExits("Q",spot77);
        spot87.setExits("D",spot97);
        spot87.setExits("S",spot88);
        spot97.setExits("Q",spot87);
        spot97.setExits("S",spot98);
        spot18.setExits("Z",spot17);
        spot28.setExits("Z",spot27);
        spot28.setExits("D",spot38);
        spot38.setExits("Q",spot28);
        spot38.setExits("Z",spot37);
        spot48.setExits("Z",spot47);
        spot58.setExits("D",spot68);
        spot68.setExits("Q",spot58);
        spot68.setExits("Z",spot67);
        spot68.setExits("D",spot78);
        spot78.setExits("Q",spot68);
        spot78.setExits("D",spot88);
        spot88.setExits("Q",spot78);
        spot88.setExits("Z",spot87);
        spot98.setExits("Z",spot97);
       

        currentRoom = start11;  // start game 
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentSpot.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null)
            System.out.print("Z");
        if(currentRoom.eastExit != null)
            System.out.print("D");
        if(currentRoom.southExit != null)
            System.out.print("S");
        if(currentRoom.westExit != null)
            System.out.print("Q");
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Spot nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print("Exits: ");
            if(currentRoom.northExit != null)
                System.out.print("north ");
            if(currentRoom.eastExit != null)
                System.out.print("east ");
            if(currentRoom.southExit != null)
                System.out.print("south ");
            if(currentRoom.westExit != null)
                System.out.print("west ");
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * method linked to the end of the game
     */
    public void exit()
    {}
}
