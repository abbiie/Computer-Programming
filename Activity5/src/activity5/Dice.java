
package activity5;
import java.util.Random;
public class Dice {
    private Random roll;
  
 public Dice(){
     roll = new Random();
  }
  public int Roll(){
  return roll.nextInt(6)+1;
       
  }
  

}