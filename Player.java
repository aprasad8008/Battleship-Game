/*
 * Player.java - blueprint class for objects that represent a single
 * "random" player in the game of Battleship.
 * 
 * Computer Science S-111, Harvard University
 */

import java.util.*;

public class Player {
    // a constant for the maximum number of ships per player
    public static final int SHIPS_PER_PLAYER = 5; 
    
    // fields
    private String name;
   
    
   // PS 5: add the fields for the player's collection of ships
    private Ship[] ships;
    private int shipCount;
    
    /*
     * constructor for a Player with the specified name
     */
    public Player(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name must have at least one character");
        }
        
        this.name = name;
    
        // PS 5: initialize the fields that you added above
        Ship[] temp = new Ship[SHIPS_PER_PLAYER];
        this.ships = temp;
        this.shipCount = 0;
        
    }
    
    /*
     * getName - returns the name of the player
     */
    public String getName() {
        return this.name;
    }
    
    /*
     * addShip - add the specified ship to the player's collection of ships
     */
    public void addShip(Ship s) 
    {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        
        // PS 5: add code to this method
        if (this.shipCount >= ships.length)
        {
            throw new IllegalStateException();
        }
        else 
        {
            ships[shipCount] = s;
            this.shipCount++;
        }
    }
    
    /*
     * removeShip - removes the specified ship from the player's collection of ships
     */
    public void removeShip(Ship s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        
        
        
        // PS 5: add code to this method
        for (int i = 0; i < ships.length; i++)
        {
            if (s.equals(ships[i]))
            {
                ships[i] = ships[lastIndex(ships)-1];
                ships[lastIndex(ships)-1] = null;
                shipCount--;
            }
        }
        return;
    }
    
    /*
     * printShips - prints whatever ships remain in the player's collection
     */
    public void printShips() {
        // PS 5: implement this method
        
        for (int i = 0; i < lastIndex(ships); i++)
        {
            System.out.println(ships[i].toString());
        }
    }
    
    /*
     * hasLost - has this player lost the game?
     * Returns true if this is the case, and false otherwise.
     */
    public boolean hasLost() {
        // PS 5: implement this method
        if (ships.length == 0)
        {
            return true;
        }
        return false;  
    }
    
    /*
     * nextGuess - returns a Guess object representing the player's
     * next guess for the location of a ship on the board specified
     * by the parameter otherBoard.
     */
    public Guess nextGuess(Scanner console, Board otherBoard) {
        int row;
        int col;
        
        // Keep randomly selecting coordinates until we get 
        // a position that has not already been tried.
        do {
            row = Board.RAND.nextInt(otherBoard.getDimension());
            col = Board.RAND.nextInt(otherBoard.getDimension());
        } while (otherBoard.hasBeenTried(row, col));
        
        Guess guess = new Guess(row, col);
        return guess;
    }
    
    /*
     * toString - returns a string representation of the player
     */
    public String toString() {
        return this.name;
    }
    
    //written to account for when there are nulls in the ship collection
    public int lastIndex (Ship[] s)
    {
        int indexOfLastVal = 0;
        for (int i = 0; i < s.length; i++)
        {
            if (s[i] != null)
            {
                indexOfLastVal++;
            }
        }
        return indexOfLastVal;
    }
}