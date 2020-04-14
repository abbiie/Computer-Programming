package activity5;

public class Mage extends Character{
    private int manapoints;
    
    public Mage(String n, int s, int d, int i, int a){
    super(n, s, d, 25, 2);
    manapoints = 20;
    }
    
    @Override
    public void wound(int damage){
        currentLife = currentLife -damage;
        if(currentLife <=0 ){
         currentLife = 0;
        }
    }
    
    public int fireball(){
         if (manapoints < 5){
            return 0;
        }else {
            manapoints -= 5;
        return dice.Roll()+ intelligence;
        }
    }
    
}

