
/**
 * The Legendary class is a specific item obtained after fight a monster
 * @author (Groupe 6)
 * @version (2018-11-14)
 */
public class Legendary extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vetre
    private int x;
    

    /**
     * Constructeur d'objets de classe Legendary
     */
    // liée a un monstre, mettre variabele monstre dans parametre ??
    public Legendary(String itemName, String des, int dam, int HG, int prot )
    {
        // initialisation des variables d'instance
        super (itemName, des, dam, HG,prot );
<<<<<<< HEAD
        
=======
>>>>>>> 0b0a9b248f895ea0819a249d2e4f09449359cecc
    }

    /**
     * Un exemple de methode - remplacez ce commentaire par le vetre
     *
     * @param  y   le parametre de la methode
     * @return     la somme de x et de y
     */
    
    public int sampleMethod(int y)
    {
        // Inserez votre code ici
        return x + y;
    }
}
