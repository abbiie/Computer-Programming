package Character;

import Character.Character;
import Utility.Summon;
/**
 * the class knight is an extended class of a character class 
 * that implements a summon so that it can call the summon method
 * @author abi
 */
public class Knight extends Character implements Summon {
    /** instance variables */
    private int durability;
    /**
     * knight constructor overrides the constructor with the same signature in Character.
     * with the use of super keyword, it will call the constructor in the character class 
    * and initializes durability. 
     * @param n = name
     * @param d = dexterity
     * @param i = intelligence
     */
    public Boolean haspet = false;
    public Knight (String n, int d, int i){
        super(n, 25, d, i, 5);
        durability = 20;
    }
    /**
     * Current life is deducted by the damage parameter minus the armor
     * with override notation
     * @param damage an integer that decreases the current life
     */
    @Override
    public void wound(int damage){
        currentLife = (currentLife + armor) -damage;
        if(currentLife <=0 ){
            currentLife = 0;
        }
    }
   /**
     * if the durability is less than 10 then current life takes damage minus the armor 
     * and if the durability is equal to six then block will work 
     * and durability will reduced by 6.
     * and returns current Life.
     * @param damage an integer that reduces the current life
     * @return current life
     */
    public int block(int damage){
        if (durability < 10){
            currentLife = currentLife - (damage - armor);
            return currentLife;
        }else {
            durability -= 10;
            return currentLife;
        }
    }
   /**
     * A method that overrides the abstract method summonpet()
     * from the abstract character class 
     * @return a dice roll
     */ 
 @Override
    public int summonpet(){
       return dice.Roll();
    }
    /**
    * it is a method that was implemented by the summon class
    * that allows Knight to use the summon pet and check if the roll is multiple of 6
    * If it is, Knight will summons a pet! and
    * will automatically wins! 
    * Otherwise, Knight will fail to summon a pet 
    */
 @Override
    public void petability(){
        if(summonpet() == 6){
            System.out.println(this.name + " summons a Legendary White Dragon!");
            System.out.println(this.name + " WINS");
           haspet = true;
        }else{
            System.out.println(this.name + " fails to summon a pet!");
        }
    }
  
}