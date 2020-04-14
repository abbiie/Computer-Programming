package activity5;

public class Thief extends Character {
    private int stamina;
    
    public Thief (String n, int s, int d, int i, int a){
    super(n, s, 25, i, 3);
    stamina = 20;
    }
    
    public int evade(){
        if (stamina < 6){
            return 0;
        }else {
            stamina -= 6;
        return dexterity - dice.Roll();
        }
    }
    
    public void wound (int damage){
        currentLife = currentLife- damage;
        if(currentLife <=0 ){
         currentLife = 0;
        }
    }
}