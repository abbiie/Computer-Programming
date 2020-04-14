/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activity5;

public class Knight extends Character {
    private int durability;
    
    
    public Knight (String n, int s, int d, int i, int a){
    super(n, 25, d, i, 5);
    durability = 20;
    }
    
    public int block(){
         if (durability < 10){
            return 0;
        }else {
            durability -= 10;
            return currentLife;
        }
    }
    
    public void wound (int damage){
        currentLife = currentLife- damage;
        if(currentLife <=0 ){
         currentLife = 0;
        }
    }
}
