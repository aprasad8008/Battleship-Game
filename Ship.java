/* Anusha Prasad
 * apsmileyface@gmail.com
 * This code is meant to be the blueprint for a ship object; having a length, type and number of hits
 */
public class Ship 
{
    //fields
    private String shipType;
    private int shipLength;
    private int shipHits;
    
    //constructor
    public Ship (String type, int length)
    {
        //in case of bad input
        if (type == null || length < 1)
        {
            throw new IllegalArgumentException();
        }
        //initialization
        this.shipType = type;
        this.shipLength = length;
        this.shipHits = 0;
    }
    
    //accessors
    public String getType()
    {
        return this.shipType;
    }
    
    public int getLength()
    {
        return this.shipLength;
    }
    
    public int getNumHits()
    {
        return this.shipHits;
    }
    
    public char getSymbol()
    {
        return this.shipType.charAt(0);
    }
    
    //mutators
    public void applyHit ()
    {
        this.shipHits += 1;
    }
    
    public boolean isSunk()
    {
        if (this.shipHits >= this.shipLength)
        {
            return true;
        }
        return false;
    }
    
    //overriden toString()
    public String toString()
    {
        return this.shipType + " of length " + this.shipLength;
    }
}