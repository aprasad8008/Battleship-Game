/* Anusha Prasad 
 * apsmileyface@gmail.com
 * This program is for a human player and it just takes in row and col input 
*/

import java.util.*;

public class HumanPlayer extends Player
{
    //constructor
    public HumanPlayer(String name)
    {
        super(name);
    }
    
    //overriden nextGuess method (intakes input from user for row and col)
    public Guess nextGuess(Scanner console, Board otherBoard) 
    {
        System.out.println("Enter your guess.");
        System.out.print("row: ");
        int row = console.nextInt();
        System.out.println();
        System.out.print("column: ");
        int col = console.nextInt();
        System.out.println();
        System.out.println("you guessed: " + row + " , " + col);
        Guess guess = new Guess(row, col);
        return guess;
    }
}