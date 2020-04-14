import java.io.*;
import java.util.Random;
public class TestCharacter {

    static Dice dice = new Dice();
    //static Battle battle = new Battle();
    static Battle battle = new Battle();
    public static BufferedReader br;
    static Character p1 = new Character("Abie", 30,50,20);
    static Character p2 = new Character("Ajie", 30,50,20);
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Welcome to the Battle Field!!!");
        System.out.println("===== *** =====\n"
                + "[1]New Game\n"
                + "[2]Exit");
        System.out.print("Enter your choice: ");
        short choice= Short.parseShort(br.readLine());
        switch (choice) {
            case 1:
                //game();
                //Battle.game();  
                //Battle1.game();
                Battle.Battle1();
                //Final.Battle1();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                break;
                
        }
    }
    
 public static void game() throws IOException{
    System.out.println("name :" +p1.name);
     System.out.println("HP :" +p1.currentLife);
     System.out.println("Enemy name :" +p2.name);
     System.out.println("HP :" +p2.currentLife);
     
 for(int i = 1; p1.currentLife >= 0 && p2.currentLife >= 0; i++){
     
     
System.out.println("\nRound: " + i);
        
        System.out.println("What do you want to do? ");
         System.out.println("[1]Attack\n"
                 + "[2]Heal");
        short no = Short.parseShort (br.readLine ());
        switch(no){
            case 1:
                
                Random rand = new Random ();
                int missRate = rand.nextInt (11);
                if(p1.hitRate > missRate) {
        int a = p1.attack();
        p2.wound(a);
          
           System.out.println("you attacks " +p2.name + " for " + a); 
           System.out.println("Enemy HP: " + p2.currentLife);
           
            if(p2.currentLife <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: "+i);
                System.out.println("Remaining HP: "+ p1.currentLife);
                System.exit(0);
                break;
            }
        }    
            else{
                System.out.println("You attacked but missed!");
            System.out.println("Enemy HP: " + p2.currentLife);
        }
                Random randy = new Random ();
                int misssRate = randy.nextInt (11);
                Random ran = new Random ();
                int choice = ran.nextInt (2)+1;
                if (choice == 1){
           if(p2.hitRate > misssRate) {
            int b = p2.attack();
        p1.wound(b);
        System.out.println(p2.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        System.exit(0);
        }
           }
        else { 
                System.out.println( "The " + p2.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }//h
                }else if (choice ==2){
                int oo = dice.Roll()+p2.intelligence;
                p2.currentLife = p2.currentLife + oo;
                if(p2.currentLife > p2.maxLife) p2.currentLife = p2.maxLife;
                
                System.out.println(p2.name+ " use heal"
                        + "\nEnemy HP is now: "+p2.currentLife+ "/"+ p2.maxLife);
                        
                }
                
                break;
        case 2:
            //int heal = 10;
            int aa = dice.Roll()+  p1.intelligence  ;
            p1.currentLife = p1.currentLife + aa;
            if(p1.currentLife > p1.maxLife)p1.currentLife = p1.maxLife;
            
             System.out.println("Your HP is now: " +p1.currentLife+ "/"+ p1.maxLife);
            
            Random randyy = new Random ();
                int misRate = randyy.nextInt (11);

           if(p2.hitRate > misRate) {
            int b = p2.attack();
        p1.wound(b);
        System.out.println(p2.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        System.exit(0);
        }
           }
        else { 
                System.out.println( "The " + p2.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }//h
           break;
        }
 }
 }

        
    }