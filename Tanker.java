/* Anusha Prasad 
 * apsmileyface@gmail.com
 * This class is meant to have the appropriate results for when a tanker is hit by an opponent
*/
public class Tanker extends Ship 
{
    //constructor
    public Tanker()
    {
        super("Tanker",3);
    }
    
    //overriden isSunk()
    public boolean isSunk()
    {
        if (getNumHits() >= 1)
        {
            return true;
        }
        return false;
    }
}