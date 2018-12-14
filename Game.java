import java.util.*;
import java.util.Random;
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
    private Player theseus;
    private boolean win;
    private Legendary hermesSandals;
    /** 
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createLabyrinth();
        
        theseus = new Player(20,"Theseus",1,1,0);
        
        
        Common ironSword= new Common ("Iron Sword","a rusty looking sword, it has been here for a while. Increases your damage by 3.",3,0,0);
        Common ironDagger= new Common ("Iron Dagger","looks like a toothpick, might work well in combat. Increases your damage by 1.",1,0,0);
        Common standardBow= new Common ("Standard Bow","is a common item that increases your damage by 2. You have to be highly skilled in the use of the bow to get long-distance shots.",2,0,0);
        Common ironArmor= new Common ("Iron Armor","the armor of a fallen adventurer. It adds you 3 protections points.",0,3,0);
        Common ironShield= new Common ("Iron Shield","I wonder who left this here… Adds 2 protection points.",0,2,0);
        Common woodenShield= new Common ("Wooden Shield","even a piece of wood could help.  Adds 1 protection point.",0,1,0);
        Common healthPotion= new Common ("Health Potion","is a healing item that restores a maximum of 5 health points. Healing Potions can be found naturally in the labyrinth.",0,0,5);
        
        Legendary goldenThread = new Legendary("Ariadne's golden thread","Ariadne’s golden thread, named after the legend of Ariadne, it allows immediate escape upon killing the Minotaur. It was obtained from the monster Arachne.",0,0,0);
        Legendary aresSword= new Legendary("Ares's sword","Ares’s Sword is a weapon for melee combat that can deliver multiple hits to enemies in a single moment. Each attack of the Sword of Ares is an onslaught capable of slaying opponents in a swift and fierce fashion. Ares’s Sword increases your damage by 6. It was obtained from the monster Cerberus.",6,0,0);
        Legendary artemisBow= new Legendary("Artemis's bow","The bow and the arrow are the symbol of Artemis, daughter of Zeus and Leto. She was one of the most widely venerated gods of the Ancient Greek deities. Artemis’s bow was obtained from the monster Medusa. It increases your damage by 4.",4,0,0);
        Legendary aegisShield= new Legendary("Aegis shield","The Aegis shield was born by Athena in battle. It had been interpreted as an animal skin or a shield, bearing the head of a Gorgon. It was obtained from Cyclops and increases your protection by 5.",0,5,0);
        hermesSandals= new Legendary("Hermes's sandals","Talaria are winged sandals, a symbol of the Greek messenger god Hermes. They can fly as fast as any other bird. Hermes’s sandals are obtained from the monster Chimera and allow you to always attacks first in combat.",0,0,0);
        
        LesserBoss chimera= new LesserBoss(30,"Chimera",5,2,2,"The Chimera is a fire-breathing monster who is light on its feet, strong and has three heads, one is that of a grim-eyed lion, the one in the middle is that of a goat, and snakes head at its tail. It scares you ? It should!",hermesSandals);
        LesserBoss cerberus= new LesserBoss(40,"Cerberus",5,6,2,"Cerberus is a three-headed dog of hell. To fight and kill this creature, if may be wise to have a sharp sword at your disposal.",aresSword);
        LesserBoss medusa= new LesserBoss(20,"Medusa",5,4,1,"Medusa is a powerful creature. She is generally portrayed as the embodiment of all things feminine. Her hair is made of snakes, try to not look her in the eyes. To fight and kill medusa it is recommended to have a shiny shield.",artemisBow);
        LesserBoss cyclops= new LesserBoss(30,"Cyclops",5,5,5,"Cyclops is a giant monster, which has a single eye in the center of his forehead. To fight and kill the cyclops you may require a ranged weapon.",aegisShield);
        LesserBoss arachne= new LesserBoss(40,"Arachne",5,4,4,"Arachne was once the most beautiful women to have ever walked the earth, but out of jealousy, the god Athena transformed her and condemned her to the Labyrinth. To fight and kill Arachne you will need to be fully equiped or very charming.",goldenThread);
        
        Boss minotaur = new Boss(75,"Minotaur",5,15,7,"Congratulations, you have gone through all the steps! Here you are facing the scariest and deadliest of all monsters. The Minotaur!!! he is a monster with the head and the tail of a bull and the body of a man. He is not to be underestimated...");
        
        
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
        
        currentSpot = new Spot();
        exitAndStart();//initialize start spot (also current spot) and exit spot 
        addToCurrentSpot(theseus);
        
        
        setFinishedFalse();
    }
    
    /**
     * Getter for hermessandals
     */
    public Legendary getHermes()
    {
        return hermesSandals;
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
        listSpot.get(19).setExits("Q",listSpot.get(18));
        listSpot.get(19).setExits("Z",listSpot.get(10));
        listSpot.get(19).setExits("D",listSpot.get(20));
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
     * @return String: return a message for the player
     */
    public String printWelcome()
    {
        return "Hello Theseus! \n Your mission is to explore the labyrinth, find the Minotaur, kill it";
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
     *  @return Player thesus: returns the player
     */
    public Player getPlayer() 
    { 
        return theseus;
    }

    /**
     *  add player to current spot
     *  @param Player player: add the player to the spot
     */
    public void addToCurrentSpot(Player player) 
    { 
        currentSpot.addCharacterSpot(theseus); //player is placed at current spot, which is the start position
    }
    
    /**
     *  add item to current spot
     *  @param Item item: add item to the current spot
     */
    public void addItemToCurrentSpot(Item item) 
    { 
        currentSpot.addItemSpot(item);
    }
    
    /**
     * Places one type of commmon item in a definite number of spots. 
     * @param Item item: item to add
     * @param ArrayList<Integer> spotIndexList: list of spots
     */
    public void placeItem(Item item, ArrayList<Integer> spotIndexList)
    {
         for (int i = 0; i < spotIndexList.size(); i++) { 
              listSpot.get(spotIndexList.get(i)).addItemSpot(item);
          }
    }
     
    /**
     *  Get the value of finished
     *  @return boolean finishde: return a boolean true if finished
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
     *  @return Spot currentSpot: return the current spot
     */
    public Spot getCurrentSpot() 
    { 
        return currentSpot;         
    }
    
    /**
     *  Set the room where the player is 
     *  @param Spot currentS: returns the current spot
     */
    public void setCurrentSpot(Spot currentS) 
    { 
        currentSpot = currentS;         
    }
    
    /**
     *  Get the list of spots of the labyrinth 
     *  @return ArrayList<Spot> listSpot: return a list of spots
     */
    public ArrayList<Spot> getListSpot() 
    { 
        return listSpot;         
    }
   
    /**
     * Gets the adjacent spot at a specific direction 
     * @return Spot direction: get the direction of adjacent spot
     * @param String direction
     */
    public Spot chooseDirection(String direction) 
    { 
        return currentSpot.getExits(direction);
    }
    
    /**
     * Changes the current spot to the spot according to the direction given. 
     * The aggressive monsters will randomly go to a nearby spot. If they end up in the player's spot 
     * a fight starts without giving the player a choice.
     * @param Spot spot: spot where Thesus goes
     */
    public void move(Spot spot) 
    { 
        
        //spot.removeCharacterSpot(getPlayer());
        setCurrentSpot(spot);
        spot.addCharacterSpot(getPlayer()); //move the player to the defined spot
        
        for (int i = 0; i < listSpot.size(); i++) { // parcours des spots du labyrinthe
           if (listSpot.get(i).getLesserBoss()!=null && listSpot.get(i).getLesserBoss().getAggressive()) { //
                Random rand = new Random();
                ArrayList<String> listExits = listSpot.get(i).getSpotExitable();
                int dirIndex = rand.nextInt(listExits.size()-1); 
                listSpot.get(i).removeCharacterSpot(listSpot.get(i).getMonster());
                listSpot.get(i).getExits(listExits.get(dirIndex)).addCharacterSpot(listSpot.get(i).getMonster());
                
           }
        }
        
         
    }
  
    /**
     * LE FIGHT SE DéROULE MAINTENANT DANS FIGHT INTERFACE
     * RUN YOU FOOLS
     */
    
    /**
     * If the player loses the fight
     * @return boolean true: the player loses the fight
     * 
     */
    public boolean loseGame() 
    { 
         return true;         
    }
    
    /**
     * The fight starts. it ends when one of the characters dies
     * @return List<Integer> listDamage: the list of all the damage
     * that were inflicted during the fight.
     * If the list begins by "-1", it means that Theseus began the fight.
     * 
     */
    public List<Integer> fight() 
    { 
          int damFighter;
          List<Integer> listDamage = new ArrayList<>();
          whoBegins();
          if(fighter==theseus)
          {
              listDamage.add(-1);
          }
          
          while (fighter.HP!=0){
              damFighter=inflictDamage();
              if (fighter==theseus){
                  damFighter=damFighter+criticalHit();
              }
              setFighter(fighter);
          }
          
          if (fighter==theseus) { 
              setWinTrue();
          }
          else setWinFalse(); 
          return (listDamage);
    }
    
    /**
     * Randomly chooses the first fighter to start
     * @return Character fighter: returns the character that starts the fight
     * 
     */
    public Character whoBegins() 
    { 
        if (theseus.getHermesSandals()){
            fighter=theseus;
           
        }
        else
        {
            
            Random rand = new Random();
            int beginner = rand.nextInt(2); 
             
            switch(beginner){
                case 0: fighter = theseus; 
                 
                break;
             
                default:  fighter = currentSpot.getMonster();
                
                break;
            }
        }
        return fighter;   
    }
    
     /**
     * The fighter inflicts damage to the other character in the spot
     * 
     */
    public int inflictDamage() 
    { 
        int dam=0;
        for (int i = 0; i < currentSpot.getListCharacter().size(); i++)
        {
            if (currentSpot.getListCharacter().get(i) != fighter){
                currentSpot.getListCharacter().get(i).loseHp(fighter.getDamage());
                dam = currentSpot.getListCharacter().get(i).valLoseHp(fighter.getDamage());
                //System.out.println("The not fighter of inflict damage: "+currentSpot.getListCharacter().get(i));
                //System.out.println(dam);
                //System.out.println("In the if");
                //System.out.println("the hp  of the fighter after damage: "+currentSpot.getListCharacter().get(i).getHP());
            }
            else
            {
                //System.out.println("In the else");
            }
            
        }
        return dam;
    }
  
     /**
     * 
     * @return int dam: return the damage with or without critical strike
     */
    public int criticalHit() 
    { 
        Random rand = new Random();
        int crit = rand.nextInt(100); 
        if (theseus.getCritRate()<=crit){
            int dam = (fighter.getDamage())/2;
            
            for (int i = 0; i < currentSpot.getListCharacter().size(); i++)
            {
                if (currentSpot.getListCharacter().get(i) != fighter){
                    currentSpot.getListCharacter().get(i).loseHp(dam);
                    
                }
            }
            return dam;
        }
        else return 0;
    }
    
    /**
     * Changes the fighter to a designed character
     * @param Character fighter: the character is set to be the fighter
     */
    public Character setFighter(Character fighter) 
    { 
        
        Character myFighter ;
        if (fighter==theseus){
            myFighter=currentSpot.getMonster();
            //System.out.println("the who begins fighter in the if: "+myFighter);
            
        }
        else{
            myFighter=theseus;
            //System.out.println("the who beings fighter in the else: "+myFighter);
            
        }
        //System.out.println("before return : "+myFighter);
        this.fighter=myFighter;
        return myFighter;
    }
    
    /**
     * Gets the currently designed fighter 
     * @return Character fighter: returns the current fighter
     * 
     */
    public Character getFighter() 
    { 
          return fighter;
    }
    
    /**
     *  All monsters become aggressive and start chasing you.
     * 
     */
    public void setAggressiveAll() 
    { 
        for (int i = 0; i < listSpot.size(); i++) { // parcours des spots du labyrinthe 
            listSpot.get(i).getLesserBoss().setAggressiveTrue();
        }
    }
    
    /**
     * if the player wins by giving the last blow, he wins. Otherwise he doesn't.
     * 
     */
    public void setWinTrue() 
    { 
        win=true;        
    }
    /**
     * if the player wins by giving the last blow, he wins. Otherwise he doesn't.
     * 
     */
    public void setWinFalse()  
    { 
        win=false;         
    }
    /**
     * 
     * 
     */
    public boolean getWin() 
    { 
       return win;         
    }
    
    /**
     * returns the game over message
     * @return String "Game over": returns this string when game over
     */
    public String gameOver() 
    { 
      return "Game over";          
    }

    /**
     *  returns the winning message
     * @return String
     */
    public String youWon() 
    { 
      String endScreen = "Theseus, you have successfully killed the Minotaur and left the labyrinth!";  
      int nbMonsters = 0;
      for (int i = 0; i < listSpot.size(); i++){
          nbMonsters+= listSpot.get(i).numberOfMonsterInSpot();
      }
      endScreen+= " \n Score: You killed "+nbMonsters+" of 6 monsters";
      return endScreen;
    }
    
    /**
     * 
     * Returns the message saying that it's not time to exit the labyrinth yet
     * @return String
     */
    public String NotTimeToGo() 
    { 
      return "You didn't kill the Minotaur";          
    }
    
    /**
     * Kills lesserBoss
     * 
     */
    public void monsterDead()
    {
           currentSpot.addItemSpot(currentSpot.getLesserBoss().getPossessedLegendary()); //the monster drops the item in the spot
           currentSpot.removeCharacterSpot(currentSpot.getMonster()); //the monster dies and disappears from the spot
    }
    
    /**
     * Kills lesserBoss
     * 
     */
    public void bossDead()
    {
           //the monster drops the item in the spot
           currentSpot.removeCharacterSpot(currentSpot.getMonster()); //the monster dies and disappears from the spot
           theseus.setTrueTimeToGo();
           if (theseus.getThread()){
             youWon();
             setFinishedTrue();
           }
           else{
             setAggressiveAll(); 
           }
            
    }
    
    /**
     * player drops item
     * 
     */
    public void playerDropItem(Item itemDrop)
    {
        theseus.dropItem(itemDrop);
        addItemToCurrentSpot(itemDrop);
    }
    
   

    
}
