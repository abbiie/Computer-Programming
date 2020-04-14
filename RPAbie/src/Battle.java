import java.io.*;
public class Battle {
    static Dice dice = new Dice();
    public static BufferedReader br;
    static Knight p1 = new Knight ("Knight", 25,25);
    static Mage p2 = new Mage ("Mage",25,2);
    static Thief p3 = new Thief ("Thief", 25 ,3);
   public static void Battle1() throws IOException {
   br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("\nPlayer 1: "+p1.getName()+"\nHP: " + p1.getCurrentLife()
                          +"\nPlayer 2: "+ p2.getName()+"\nHP: " + p2.getCurrentLife());
        System.out.println("\nFirst Battle!");
   for(int i = 1; p1.getCurrentLife() >= 0 && p2.getCurrentLife() >= 0; i++){
       
        System.out.println("\nRound: " + i);
        int diceroll = dice.Roll();
        
        if(diceroll <4) {
            if (p1.hitRate >dice.Roll()){
                int a = p1.attack();
                p2.wound(a);
                System.out.println(p1.getName()+" attacks " +p2.getName() + " for " + a); 
                System.out.println(p2.name+" HP: " + p2.getCurrentLife());
                 if(p2.getCurrentLife() <= 0){
                     System.out.println(p1.getName()+" WON!!");
                     System.out.println("Total number of turns: "+i);
                     System.out.println("\nPress Enter to start:");
                     br.readLine();
                     Battle2();
                     break;
                 }
            } else{
                System.out.println(p1.name + " attacked "+p2.name +" But Missed.");
                System.out.println(p2.getName()+" HP: "+p2.getCurrentLife());
            }     
        } else if(diceroll >3) {
                    int k = p2.attack();
                    int prevLife = p1.currentLife;
                    p1.block(k);
                    
                     if (prevLife == p1.currentLife){
                        System.out.println(p2.name + " attacked "+p1.getName()+" but was blocked\n"
                                + p1.name+" HP:" + p1.currentLife);
                     }else{
                        int aa = dice.Roll()+p1.intelligence;
                        p1.currentLife = p1.currentLife + aa;
                        if(p1.currentLife > p1.maxLife) p1.currentLife = p1.maxLife;
                        System.out.println(p1.name+ " use heal\n"
                                + p1.name+" HP: "+p1.currentLife+ "/"+ p1.maxLife);
                        
                        
                     }
           } 
        int roll = dice.Roll();
           if(roll <4) {
                if(p2.hitRate > dice.Roll()){
               int b = p2.attack();
        p1.wound(b);
        System.out.println(p2.name + " attacks you for " + b);
        System.out.println(p1.name+" HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
                System.out.println(p2.name+ " Won");
                System.out.println("\nPress Enter to start:");
                br.readLine();
                Battle3();
                System.exit(0);
                }
           } else{
              System.out.println(p2.name + " attacked "+p1.name +" But Missed.");
                System.out.println(p1.getName()+" HP: "+p1.getCurrentLife());
                }
            }else if( roll >3 ){
                
                int f = p2.fireball();
                p1.wound(f);
                if(p2.fireball()>0){
               System.out.println(p2.name + " used Fireball \nDamage Taken " + f);
               System.out.println(p1.name+" HP: " + p1.currentLife); 
                if(p1.currentLife  <= 0){
                System.out.println(p2.name+ " Won");
                System.out.println("\nPress Enter to start:");
                br.readLine();
                Battle3();
                System.exit(0);
                }
                }else{
              int oo = dice.Roll()+p2.intelligence;
                p2.currentLife = p2.currentLife + oo;
                if(p2.currentLife > p2.maxLife) p2.currentLife = p2.maxLife;
                System.out.println(p2.name+ " use heal\n"
                        + p2.name+" HP: "+p2.currentLife+ "/"+ p2.maxLife);
                }
    }
        }
   }
public static void Battle2() throws IOException {
   p1.currentLife = p1.maxLife;
        System.out.println("\nPlayer 1: "+p1.getName() +"\nHP: " + p1.getCurrentLife()
                          +"\nPlayer 3: "+ p3.getName()+"\nHP: " + p3.getCurrentLife());
        System.out.println("\nSecond Battle Battle!");
        for(int i = 1; p1.getCurrentLife() >= 0 && p3.getCurrentLife() >= 0; i++){
            int dicedice=dice.Roll();
        System.out.println("\nRound: " + i);
        if(dicedice <4) {
            if (p1.hitRate >dice.Roll()){
               int a = p1.attack();
                p3.wound(a);
                
           System.out.println(p1.getName()+" attacks " +p3.getName() + " for " + a); 
           System.out.println(p3.name+" HP: " + p3.getCurrentLife());
            if(p3.getCurrentLife() <= 0){
                System.out.println(p1.getName()+" WON!!");
                break;
            }
        } else{
                System.out.println(p1.name + " attacked "+p3.name +" But Missed.");
                System.out.println(p3.getName()+" HP: "+p3.getCurrentLife());
            }     
        }
           else if(dicedice >3) {
                    int k = p3.attack();
                    int prevLife = p1.currentLife;
                    p1.block(k);
                     if (prevLife == p1.currentLife){
                    System.out.println(p3.name + " attacked "+p1.getName()+" but was blocked\n"
                            + p1.name+" HP:" + p1.currentLife);
                   
                   }else{
             int aa = dice.Roll()+p1.intelligence;
                p1.currentLife = p1.currentLife + aa;
                if(p1.currentLife > p1.maxLife) p1.currentLife = p1.maxLife;
                
                System.out.println(p1.name+ " use heal\n"
                        + p1.name+" HP: "+p1.currentLife+ "/"+ p1.maxLife);
                     }
           } 
        
        int dr = dice.Roll();
            if(dr <4) {
                if(p3.hitRate > dice.Roll()){
               int b = p3.attack();
        p1.wound(b);
        System.out.println(p3.name + " attacks " +p1.name+" for " + b);
        System.out.println(p1.name+" HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
                System.out.println(p3.name+ " Won");
                System.exit(0);
                }
           } else{
              System.out.println(p3.name + " attacked "+p1.name +" But Missed.");
                System.out.println(p1.getName()+" HP: "+p1.getCurrentLife());
                }
            }
            else if( dr >3){
                int e = p1.attack();
                int prev = p3.currentLife - e; //evde did not work
                p3.evade(e);
                if(prev != p3.currentLife){
                 System.out.println(p3.name + " evaded "+p1.getName()+" attack\n"
                            + p3.name+" HP:" + p3.currentLife);
                    if(p1.currentLife  <= 0){
                        System.out.println(p3.name+ " Won");
                        System.exit(0);
                    }
                }
                else{
                    int o = dice.Roll()+p3.intelligence;
                      p3.currentLife = p3.currentLife + o;
                      if(p3.currentLife > p3.maxLife) p3.currentLife = p3.maxLife;

                      System.out.println(p3.name+ " use heal\n"
                              + p3.name+" HP: "+p3.currentLife+ "/"+ p3.maxLife);
                }  
            } 
        }
   }
public static void Battle3() throws IOException{
    p2.currentLife = p2.maxLife;
    br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("\nPlayer 2: "+p2.getName()+"\nHP: " + p2.getCurrentLife()
                           +"\nPlayer 3: "+ p3.getName()+"\nHP: " + p3.getCurrentLife());
            System.out.println("\nFinal Battle!");
            
        for(int i = 1; p3.getCurrentLife() >= 0 && p2.getCurrentLife() >= 0; i++){
            int di = dice.Roll();
        System.out.println("\nRound: " + i);
        if(di <4) {
            if (p3.hitRate >dice.Roll()){
               int a = p3.attack();
                p2.wound(a);
                
           System.out.println(p3.getName()+" attacks " +p2.getName() + " for " + a); 
           System.out.println(p2.name+" HP: " + p2.getCurrentLife());
            if(p2.getCurrentLife() <= 0){
                System.out.println(p3.getName()+" WON!!");
                break;
            }
        } else{
                System.out.println(p3.name + " attacked "+p2.name +" But Missed.");
                System.out.println(p2.getName()+" HP: "+p2.getCurrentLife());
            }     
        }
           else if(di >3){
               int e = p2.attack();
                int prev = p3.currentLife - e; //evde did not work
                p3.evade(e);
                if(prev != p3.currentLife){
                 System.out.println(p3.name + " evaded "+p2.getName()+" attack\n"
                            + p3.name+" HP:" + p3.currentLife);
                    if(p2.currentLife  <= 0){
                        System.out.println(p3.name+ " Won");
                        System.exit(0);
                    }
                }else{
              int o = dice.Roll()+p3.intelligence;
                p3.currentLife = p3.currentLife + o;
                if(p3.currentLife > p3.maxLife) p3.currentLife = p3.maxLife;
                
                System.out.println(p3.name+ " use heal\n"
                        + p3.name+" HP: "+p3.currentLife+ "/"+ p3.maxLife);
           }   
           }
        int dir = dice.Roll();
                if(dir < 4) {
                if(p2.hitRate > dice.Roll()){
               int b = p2.attack();
        p3.wound(b);
        System.out.println(p2.name + " attacks "+p3.name+" for " + b);
        System.out.println(p3.name+" HP: " + p3.currentLife);
        if(p3.currentLife  <= 0){
                System.out.println(p2.name+ " Won");
                System.exit(0);
                }
           } else{
              System.out.println(p2.name + " attacked "+p3.name +" But Missed.");
                System.out.println(p3.getName()+" HP: "+p3.getCurrentLife());
                }
            }
                else if( dir >3){
                int f = p2.fireball();
                p3.wound(f);
                if(p2.fireball()>0){
               System.out.println(p2.name + " used Fireball \nDamage Taken " + f);
               System.out.println(p3.name+" HP: " + p3.currentLife); 
                if(p3.currentLife  <= 0){
                System.out.println(p2.name+ " Won");
                System.exit(0);
                }
                }else{
              int ooo = dice.Roll()+p2.intelligence;
                p2.currentLife = p2.currentLife + ooo;
                if(p2.currentLife > p2.maxLife) p2.currentLife = p2.maxLife;
                
                System.out.println(p2.name+ " use heal\n"
                        + p2.name+" HP: "+p2.currentLife+ "/"+ p2.maxLife);
                }
    }
        }
   }
}