public class Character {
    static Dice dice = new Dice();
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int maxLife;
    protected int currentLife;
    protected int armor;
    protected int hitRate;

    
    public Character(String n, int s, int d, int i){
      this.name=n;
      this.strength=s;
      this.dexterity=d;
      this.intelligence=i;
      this.maxLife=dice.Roll()+ 10;
      this.currentLife=maxLife;
      this.hitRate = 3;
    }
     public Character(String n, int s, int d, int i, int a){
      this.name=n;
      this.strength=s;
      this.dexterity=d;
      this.intelligence=i;
      this.maxLife=dice.Roll()+ 100;
      this.currentLife=maxLife;
      this.armor = a;
      this.hitRate = 5;
    }
    
     public int attack(){
     return dice.Roll() + strength;
     } 
     
     public void wound(int damage){
        currentLife = (currentLife+ armor) - damage ;
     if(currentLife <=0 ){
         currentLife = 0;
     }
     }
     
     public void heal(int heal){
     if (currentLife>maxLife){
         currentLife = currentLife + heal;
        }
     } 
     
     public String getName(){
     return name;
     }
     
     public int getStrength(){
     return strength;
     } 
     
     public int getDexterity(){
     return dexterity;
     }
     
     public int getIntelligence(){
     return intelligence;
     }
     
     public int getMaxLife(){
     return maxLife;
     }
     
     public int getCurrentLife(){
     return currentLife;
     }
     
     
}