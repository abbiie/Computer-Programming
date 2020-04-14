package Character;

import Character.Character;
import Utility.Summon;
/**
 * the class thief is an extended class of a character class 
 * that implements a summon so that it can call the summon method
 * @author abi
 */
public class Thief extends Character implements Summon{
    /** instance variables */
    private int stamina;
    /**
     * Thief constructor overrides the constructor with the same signature in Character.
     * The super keyword will call the constructor in the character class 
    * and initializes stamina. 
     * @param n = name
     * @param s = strength
     * @param i = intelligence
     */
    public Thief (String n, int s, int i){
        super(n, s, 25, i, 3);
        stamina = 20;
    }
    /**
     * Current life is deducted by the damage parameter minus the armor
     * with override notation
     * @param damage an integer that decreases the current life
     */
    @Override
    public void wound(int damage){
        currentLife = (currentLife) -(damage - armor);
        if(currentLife <=0 ){
            currentLife = 0;
        }
    }
    /**
     * if the stamina is less than 6 then current life takes damage minus the armor 
     * and if the stamina is equal to six then evade will work 
     * then damage will be deducted to the value of the current life plus the dexterity
     * and the stamina will also reduced by 6.
    * Otherwise, returns 0.
     * @param damage an integer that reduces the current life
     * @return current life
     */
    public int evade(int damage){
        if (stamina < 6){
            currentLife = currentLife -(damage - armor);
            return currentLife;
        }else {
            stamina -= 6;
           currentLife = (currentLife +dexterity)-damage;
            return currentLife;
        }
    }
    /**
     * A method that overrides the abstract method summonpe()
     * from the abstract character class 
     * @return a dice roll plus one
     */
 @Override
    public int summonpet(){
       return dice.Roll() + 1;
    }
    /**
    * it is a method that that was implemented by the summon class
    * that allows thief to use the summon pet and check if the roll is an odd numbers
    * If it is an odd number, Thief will summons a pet! and
    * Evade reduces additional 5 damage permanently! and the dexterity will increase by 5.
    * Otherwise, thief will fail to summon a pet 
    */
 @Override
     public void petability(){
        if((summonpet() % 2) ==1){
            System.out.println(this.name + " summons a Dark Dragon! Evade reduces additional 5 damage permanently!");
            dexterity = dexterity + 5;
        }else{
            System.out.println(this.name + " fails to summon a pet!");
        }
    }
  
}