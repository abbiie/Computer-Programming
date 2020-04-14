public class Thief extends Character {
    private int stamina;
    
    public Thief (String n, int s, int i){
    super(n, s, 25, i, 3);
    stamina = 20;
    }
     @Override
    public void wound(int damage){
        currentLife = currentLife -damage;
        if(currentLife <=0 ){
         currentLife = 0;
        }
    }
    public int evade(int damage){
        if (stamina < 6){
            currentLife = currentLife-damage;
            return currentLife;
        }else {
            stamina -= 6;
            currentLife = currentLife - (damage /(dexterity+dice.Roll()));
        return currentLife;
        }
    }
}