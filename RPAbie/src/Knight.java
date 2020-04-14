public class Knight extends Character {
    private int durability;
    
    public Knight (String n, int d, int i){
    super(n, 25, d, i, 5);
    durability = 20;
    }
     @Override
    public void wound(int damage){
        currentLife = currentLife -damage;
        if(currentLife <=0 ){
         currentLife = 0;
        }
    }
    public int block(int damage){
         if (durability < 10){
             currentLife = currentLife - damage;
            return currentLife;
        }else {
            durability -= 10;
            return currentLife;
        }
    }
}