package Character;

import Character.Character;
import Utility.Summon;
/**
 * the class Mage is an extended class of a character class 
 * that implements a summon so that it can call the summon method
 * @author abi
 */
public class Mage extends Character implements Summon{
    /** instance variables */
    private int manapoints;
     /**
     * Mage constructor overrides the constructor with the same signature in Character.
     * The super keyword will call the constructor in the character class 
    * and initializes Mana points. 
     * @param n = name
     * @param s = strength
     * @param d = dexterity
     */
    public Mage(String n, int s, int d){
        super(n, s, d, 25, 2);
        manapoints = 20;
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
     * if the mana points is less than 5 then it will return 0 
     * but if the mana points is equal to six then fireball will work  
     * and the mana points will also reduced by 5.
     * and will returns dice roll plus the modified intelligence of the character.
     * @param damage an integer that reduces the current life
     * @return 0 if the mana points is less than 5 
     * otherwise, it will return a dice roll plus intelligence
     */
    public int fireball(){
        if (manapoints < 5){
            return 0;
        }else{
            manapoints -= 5;
            return dice.Roll()+ intelligence;
        }
    }
    /**
     * @return mana points
     */
    public int getMana(){
        return manapoints;
    }
      /**
     * A method that overrides the abstract method summonpet()
     * from the abstract character class 
     * @return a dice roll minus one
     */ 
 @Override 
    public int summonpet(){
       return dice.Roll() - 1;
    }
    /**
    * it is a method that that was implemented by the summon class
    * that allows Mage to use the summon pet and check if the roll is an even number
    * If it is an even number, Mage will summons a pet! and
    * fireball damage will permanently increased by 5! 
    * and the intelligence will increase by 5.
    * Otherwise, Mage will fail to summon a pet 
    */
 @Override //implementation
    public void petability(){
        if((summonpet() % 2) ==0){
            System.out.println(this.name + " summons a FireDragon! Fireball damage is permanently increased by 5!");
            intelligence = intelligence + 5;
        }else{
            System.out.println(this.name + " fails to summon a pet!");
        }
        
    }
  
}
