import java.util.*;

/**
 * The Character class is the characteristic of the Monster and the Player
 *
 * @author (Groupe 6)
 * @version (2018-11-14)
 */
public class Character
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int HP; //The heart point
    private String Name;
    private int xp; //The level of the game
    private int Damage; 
    private int posX; //position of the character
    private int posY; //position of the character
    private ArrayList<Item> inventaire;
    
    /**
     * Constructeur d'objets de classe Character
     */
    public Character(int myHP)
    {
        // initialisation des variables d'instance
        HP = myHP;
    }
    
    /**
     * getter pour les HP
     */
    public int getHP()
    {
        return HP;
    }
    
    /**
     * getter pour l'xp
     */
    public int getXp()
    { 
        return xp;
    }
    
    /**
     * getter pour posX
     */
    public int getPosX()
    {return posX;}

    /**
     * getter pour posY
     */
    public int getPosY()
    {return posY;}
    
    /**
     * getter for the name
     */
    public String getName()
    {
        return Name;
    }
    
    /**
     * getter pour les dommage
     */
    public int getDamage()
    {
        return Damage;
    }
    
    
    
    /**
     * MEthod qui descend les HP
     */
    public void loseHp(int damage)
    {
        HP -= damage;
    }
    
    /**
     * Method qui fait avancer le charater vers le haut
     */
    public void moveUp()
    {
        posY += 1;
    }
    
    /**
     * Method qui fait avancer le charater vers le bas
     */
    public void moveDown()
    {
        posY -= 1;
    }
    
    /**
     * Method qui fait avancer le charater vers la droite
     */
    public void moveRight()
    {
        posX += 1;
    }
    
    /**
     * Method qui fait avancer le charater vers la gauche
     */
    public void moveLeft()
    {
        posX -= 1;
    }
    
    /**
     * Method qui initie un combat
     */
    public void fight()
    {}
    
    /**
     * methode qui redonne des HP
     */
    public void gainHP(int gainHP)
    {}
    
    /**
     * methode qui donne de l'xp
     */
    public void gainXp(int gainXP)
    {}
    
    /**
     * setter de posX
     */
    public void setPosX(int position)
    {}
    
    /**
     * setter de posY
     */
    public void setPosY(int position)
    {}
    
    /**
     * methode qui augmente les dommages
     */
     public void increaseDamage(int Damage)
     {}
     
     /**
     * methode qui diminue les dommages
     */
     public void decreaseDamage(int Damage)
     {}
}
