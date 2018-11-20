/**
 * Décrivez votre classe Item ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int damage; //damage of the item
    private int protection; //protection of the item
    private int healthGain; //health gain of the item
    private String name; //name of the item
    private String description; //description of the item

    /**
     * Constructeur d'objets de classe Item
     */
    public Item()
    {
    }
    
    /**
     * setter for the damage
     */
    public void setDamage()
    {}
    
    /**
     * setter for the protection
     */
    public void setProtection()
    {}
    
    /**
     * setter for the name
     */
    public void setName()
    {}
    
    /**
     * getter for the damage
     */
    public int getDamage()
    {return damage;}
    
    /**
     * getter for the protection
     */
    public int getProtection()
    {return protection;}
    
    /**
     * getter for the name
     */
    public String getName()
    {return name;}
    
    /**
     * getter for the description
     */
    public String getDescription()
    {return description;}
    
    /**
     * getter for the health gain
     */
    public int getHealthGain()
    {return healthGain;}
    

}