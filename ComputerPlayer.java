/* Anusha Prasad 
 * apsmileyface@gmail.com
 * This program is for a computer player and has various checks to see if the next position is a smart move  
*/
import java.util.*;

public class ComputerPlayer extends Player
{
    //fields 
    private int[] lastHit = new int[2];
    private int row = lastHit[0]; //last row guess
    private int col = lastHit[1]; //last col guess
    private int count;
    
    //constructor
    public ComputerPlayer (String name)
    {
        super(name);
    }
    
    //accessors 
    public int getLastRow()
    {
        return this.row;
    }
    
    public int getLastCol()
    {
        return this.col;
    }
    
    public int getCount()
    {
        return this.count;
    }
    
    //checker methods to account for when the row and col guess is off from boundaries set by board
    public static int checkBoundary1 (int a)
    {
        if (a == 0)
        {
            return a;
        }
        else if (a < 0 || a > BattleshipGame.DIMENSION) 
        {
            return a - 1;
        }
        else 
        {
            return a - 1;
        }
    }
    
    public static int checkBoundary2 (int a)
    {
        if (a == BattleshipGame.DIMENSION-1)
        {
            return a;
        }
        else if (a < 0 || a > BattleshipGame.DIMENSION)
        {
            return a + 1;
        }
        else
        {
            return a - 1;
        }
        
    }
    
    //method to generate a random hit 
    public int[] generateRandomHit (Board otherBoard, int row, int col)
    {
           int[] randomHit = new int[2];
            do 
            {
                row = Board.RAND.nextInt(otherBoard.getDimension());
                col = Board.RAND.nextInt(otherBoard.getDimension());
                
            } while (otherBoard.hasBeenTried(row, col));
            randomHit[0] = row;
            randomHit[1] = col;
            return randomHit;
    }
    
    
    //overriden nextGuess method             
    public Guess nextGuess(Scanner console, Board otherBoard) 
    {
        int row = 0;
        int col = 0;
        
        //when the previous guess was a miss and no ship was sunk at the spot
        if (count == 0 || (otherBoard.previousMiss(this.row, this.col) && !(otherBoard.sunkShipAt(this.row, this.col))))
        {
            row = generateRandomHit(otherBoard, row, col)[0];
            col = generateRandomHit(otherBoard, row, col)[1];
            count++;
        }
        //when the previous guess was a hit and no ship was sunk at the spot 
        else if (otherBoard.previousHit(this.row, this.col) && !(otherBoard.sunkShipAt(this.row, this.col)))
        {
            //when the previous guess has not been tried yet first checks for boundary done 
            if (!(otherBoard.hasBeenTried(checkBoundary1(this.row),this.col)))
            {
                row = this.row + 1;
                col = this.col;
            }
            else if (!(otherBoard.hasBeenTried(this.row, checkBoundary1(this.col))))
            {
                row = this.row;
                col = this.col + 1;
            }
            //when the previous guess has not been tried yet second checks for boundary done
            else if (!(otherBoard.hasBeenTried(checkBoundary2(this.row),this.col)))
            {
                row = this.row - 1;
                col = this.col;
            }
            else if (!(otherBoard.hasBeenTried(this.row,checkBoundary2(this.col))))
            {
                row = this.row;
                col = this.col - 1;
            }
        }
        //any other situation random hit created
        else 
        {
           row = generateRandomHit(otherBoard, row, col)[0];
           col = generateRandomHit(otherBoard, row, col)[1];
        }
        
        
        this.row = row;
        this.col = col;
        
        //new guess created
        Guess guess = new Guess (row, col);
        return guess;
        
    }
    
}