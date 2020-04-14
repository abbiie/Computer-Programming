package Utility;
import java.util.Random;
/**
 * The dice class is where it creates a rolling die
 * @author Abi
 */
public class Dice {
    /** instance variables */
    private Random roll;
  
    /**
    * Instantiate the object roll where in, 
    * it crates a dice method with a random values
    */
    public Dice(){
        roll = new Random();
    }
    /**
   * Rolls dice 
   * @return an integer between 1 and 6
   */
    public int Roll(){
        return roll.nextInt(6)+1;
    }
}