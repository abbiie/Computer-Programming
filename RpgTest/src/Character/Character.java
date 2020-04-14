package Character;

import Utility.Dice;
/**
 * Class Character is an abstract method, so that it could be accessible by the characters
 * @author Abi
 */
public abstract class Character {
    /** static variables */
    static Dice dice = new Dice();

    public String name;
    protected int strength;
    protected int dexterity;
    public int intelligence;
    public int maxLife;
    public int currentLife;
    protected int armor;
    public int hitRate;
    /**
     * this is a character constructor for the first activity where in there is only two character
     * @param n name
     * @param s strength
     * @param d dexterity
     * @param i intelligence
     */
    public Character(String n, int s, int d, int i){
      this.name=n;
      this.strength=s;
      this.dexterity=d;
      this.intelligence=i;
      this.maxLife=dice.Roll()+ 100;
      this.currentLife=maxLife;
      this.hitRate = 5;
    }
       /**
* Constructor that takes 5 parameters
* And uses the dice roll to assign a random
* number to MaxLife. CurrentLife is initialized to MaxLife
     * @param name
     * @param strength
     * @param dexterity
     * @param intelligence
     * @param armor
*/
     public Character(String n, int s, int d, int i, int a){
      this.name=n;
      this.strength=s;
      this.dexterity=d;
      this.intelligence=i;
      this.maxLife=dice.Roll() + 500;
      this.currentLife=maxLife;
      this.armor = a;
      this.hitRate = 5;
    }
     /**
     * attack method is modified by the strength
     * @return die roll plus the strength
     */
    public int attack(){
        return dice.Roll() + strength;
    } 
    /**
      * wound is modified with the damage parameter
      * @param damage will be deducted to the current life
      */
    public void wound(int damage){
        currentLife = currentLife - damage ;
        if(currentLife <=0 ){
            currentLife = 0;
        }
    }
       /**heal is modified with a parameter heal
      * and Increases CurrentLife by the heal parameter.
      * CurrentLife cannot be greater than MaxLife
      * @param heal is an integer that will be added to the current life
      */
    public void heal(int heal){
        heal=dice.Roll()+intelligence;
        if (currentLife>maxLife){
            currentLife = currentLife + heal;
        }
    } 
/**
      * a method that will get the name
      * @return name
      */
    public String getName(){
        return name;
    }
    /**
      *  a method that will get the strength
      * @return strength
      */
    public int getStrength(){
        return strength;
    } 
    /**
      * a method that will get the dexterity
      * @return dexterity
      */
    public int getDexterity(){
        return dexterity;
    }
    /**
      * a method that will get the intelligence
      * @return intelligence
      */
    public int getIntelligence(){
        return intelligence;
    }
    /**
      * a method that will get the max lIFE
      * @return max lIFE
      */
    public int getMaxLife(){
        return maxLife;
    }
    /**
      * a method that will get the LIFE
      * @return current LIFE
      */
    public int getCurrentLife(){
        return currentLife;
    }
   /**
    * @return an integer on summon pet method
    */
   public abstract int summonpet();    
}