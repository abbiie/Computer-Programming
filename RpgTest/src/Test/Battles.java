package Test;
import Character.Thief;
import Character.Mage;
import Character.Knight;
import Utility.Dice;
import java.io.*;
import java.util.Random;

public class Battles {
    static Dice dice = new Dice();
    public static BufferedReader br;
    static Knight p1 = new Knight ("Knight", 18, 17) {};
    static Mage p2 = new Mage ("Mage",23,15) {};
    static Thief p3 = new Thief ("Thief", 22 ,15) {};
    public static void game() throws IOException{
        br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("\nPlayer 1:" +p1.getName()+"\nHP :" +p1.getCurrentLife());
        System.out.println("\nPlayer 2:" +p2.getName()+"\nHP :" +p2.getCurrentLife());
        System.out.println("\nFirst Battle!");
        
        
    for(int i = 1; p1.getCurrentLife() >= 0 && p2.getCurrentLife() >= 0; i++){
        System.out.println("=========================\nRound: " + i);
            int dice1 = dice.Roll();
            int a = p1.attack();
            p2.wound(a);

            int b = p2.attack();
            p1.wound(b);
            if(dice1 <4){
                if(p1.getCurrentLife()  <= 0){
                System.out.println(p2.getName()+ " Won");
                Battle3();
                break;
                }else if(i % 6 == 0){
                p1.petability();
                p1.summonpet();
                }
                if(p1.hitRate > dice.Roll()) {
                    System.out.println(p1.getName()+" attacks " +p2.getName()+ " for " + a); 
                    System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());
                    if(p2.getCurrentLife() <= 0){
                        System.out.println(p1.getName()+" WON!!");
                        System.out.println("Total number of turns: "+i);
                        Battle2();
                        break;
                    }
                }
                else{
                    System.out.println(p1.getName()+" attacked "+p2.getName()+" but missed!");
                    System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());
                }
            }
            else if (dice1 >3){ 
                int roll = 3;
                if(roll >dice.Roll()){
                int k = p2.attack();
                int prevLife = p1.getCurrentLife();
                p1.block(k);
                    if (prevLife == p1.getCurrentLife()){
                        p1.block(k);
                        if(p2.getCurrentLife()  <= 0){
                            System.out.println(p1.getName()+ " Won");
                            Battle2();
                            break;
                            }else if(i % 2 == 0){
                            p2.petability();
                            p2.summonpet();
                        }
                        if(p1.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        Battle3();
                        break;
                        }else if(i % 6 == 0){
                        p1.petability();
                        if(p1.haspet == true){
                            Battle2();
                            System.exit(0);
                        }
                        }
                     System.out.println(p2.getName() + " attacked "+p1.getName()+" but was blocked\n"
                                        + p1.getName() +" HP:" + p1.getCurrentLife());
                        i=i+1;
                        System.out.println("=========================");
                        System.out.println("\nRound: "+i);
                        if(p1.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        Battle3();
                        break;
                        }else if(i % 6 == 0){
                        p1.petability();
                        p1.summonpet();
                        }
                        System.out.println(p1.getName()+" attacks " +p2.getName()+ " for " + a); 
                        System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());

                        if(p2.getCurrentLife() <= 0){
                            System.out.println("\n"+p1.getName()+" WON!!");
                            System.out.println("Total number of turns: "+i);
                            Battle2();
                            break;
                        }
                    }
                    else{
                        if(p1.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        Battle3();
                        break;
                        }else if(i % 6 == 0){
                        p1.petability();
                        p1.summonpet();
                        }
                    System.out.println(p1.getName()+" attacks " +p2.getName()+ " for " + a); 
                    System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());

                    if(p2.getCurrentLife() <= 0){
                        System.out.println(p1.getName()+" WON!!");
                        System.out.println("Total number of turns: "+i);
                        Battle2();
                        break;
                    }
                    }
                }else{
                    if(p1.getCurrentLife()  <= 0){
                    System.out.println(p2.getName()+ " Won");
                    Battle3();
                    break;
                    }else if(i % 6 == 0){
                    p1.petability();
                    p1.summonpet();
                    }
                healp1();   
                }
            }
            int dice2 = dice.Roll();
            if(dice2 <4){
                if(p2.getCurrentLife()  <= 0){
                    System.out.println(p1.getName()+ " Won");
                    Battle2();
                    break;
                    }else if(i % 2 == 0){
                    p2.petability();
                    p2.summonpet();
                }
                if(p2.hitRate > dice.Roll()) {
                    System.out.println(p2.getName() + " attacks "+p1.getName()+" for " + b);
                    System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());
                    if(p1.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " WON!!");
                        System.out.println("Total number of turns: "+i);
                        Battle3();
                        break;
                    }
                }
                else{ 
                    System.out.println(p2.getName()+" attacked "+p1.getName()+" but missed!");
                    System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());
                }
            }
            else if (dice2>3){
                    if(p2.getMana()>=4){
                    int f = p2.fireball();
                    p1.wound(f);  
                    if(p2.getCurrentLife()  <= 0){
                    System.out.println(p1.getName()+ " Won");
                    Battle2();
                    break;
                    }else if(i % 2 == 0){
                    p2.petability();
                    p2.summonpet();
                }
                    System.out.println(p2.getName()+ " attacks "+p1.getName()+" using Fireball\n"
                                    + "Damage taken: " + f);
                    System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());

                    if(p1.getCurrentLife()  <= 0){
                        System.out.println("\n"+p2.getName()+ " WON!!");
                        System.out.println("Total number of turns: "+i);
                        Battle3();
                        break;
                    }
                }else {
                    if(p2.getCurrentLife()  <= 0){
                    System.out.println(p1.getName()+ " Won");
                    Battle2();
                    break;
                    }else if(i % 2 == 0){
                    p2.petability();
                    p2.summonpet();
                    }
                    System.out.println(p2.getName() + " attacks "+p1.getName()+" for " + b);
                    System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());
                    if(p1.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " WON!!");
                        System.out.println("Total number of turns: "+i);
                        Battle3();
                        break;
                    }
                    }
            }
                else{
                if(p2.getCurrentLife()  <= 0){
                    System.out.println(p1.getName()+ " Won");
                    Battle2();
                    break;
                    }else if(i % 2 == 0){
                    p2.petability();
                    p2.summonpet();
                }
                healp2();
                }
            
            
    }
    }
    public static void Battle2() throws IOException {
        p1.currentLife = p1.maxLife;
        System.out.println("=========================");
        System.out.println("Press [ENTER] to continue");
        System.out.println("=========================");
        br.readLine();
        System.out.println("\nPlayer 1: "+p1.getName() +"\nHP: " + p1.getCurrentLife()
                          +"\nPlayer 3: "+ p3.getName()+"\nHP: " + p3.getCurrentLife());
        System.out.println("\nFinal Battle!");
        for(int i = 1; p1.getCurrentLife() >= 0 && p3.getCurrentLife() >= 0; i++){
            int diceplay1=dice.Roll();
            System.out.println("=========================");
            System.out.println("\nRound: " + i);
            int a = p1.attack();
            p3.wound(a);
            int b = p3.attack();
            p1.wound(b);
            if(diceplay1 <4) {
        if(p1.getCurrentLife()  <= 0){
                System.out.println(p3.getName()+ " Won");
                System.exit(0);
                }else if(i % 6 == 0){
                p1.petability();
                p1.summonpet();
                }
                if (p1.hitRate >dice.Roll()){
                    System.out.println(p1.getName()+" attacks " +p3.getName() + " for " + a); 
                    System.out.println(p3.getName()+" HP: " + p3.getCurrentLife());
                    
                    if(p3.getCurrentLife() <= 0){
                        System.out.println(p1.getName()+" WON!!");
                        break;
                    }
                }else{
                    System.out.println(p1.getName() + " attacked "+p3.getName() +" But Missed.");
                    System.out.println(p3.getName()+" HP: "+p3.getCurrentLife());
                }     
            }
            
            else if(diceplay1 >3){
                int ro = 3;
                if (ro > dice.Roll()){
                int k2 = p3.attack();
                int prevLife = p1.getCurrentLife();
                p1.block(k2);
                    if (prevLife == p1.getCurrentLife()){
                        if(p3.getCurrentLife()  <= 0){
                        System.out.println(p1.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                        if(i % 6 == 0){
                        p1.petability();
                        if(p1.haspet == true){
                            System.exit(0);
                        }
                    }
                        System.out.println(p3.getName() + " attacked "+p1.getName()+" but was blocked\n"
                                        + p1.getName() +" HP:" + p1.getCurrentLife());
                        i=i+1;
                        System.out.println("=========================");
                        System.out.println("\nRound: "+i);
                        if(p1.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 6 == 0){
                        p1.petability();
                        p1.summonpet();
                        }
                        System.out.println(p1.getName()+" attacks " +p3.getName()+ " for " + a); 
                        System.out.println(p3.getName()+" HP: " + p3.getCurrentLife());

                        if(p3.getCurrentLife() <= 0){
                            System.out.println("\n"+p1.getName()+" WON!!");
                            System.out.println("Total number of turns: "+i);
                            break;
                        }
                    }else{
                        if(p1.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 6 == 0){
                        p1.petability();
                        p1.summonpet();
                        }
                        System.out.println(p1.getName()+" attacks " +p3.getName() + " for " + a); 
                        System.out.println(p3.getName()+" HP: " + p3.getCurrentLife());

                        if(p3.getCurrentLife() <= 0){
                            System.out.println(p1.getName()+" WON!!");
                            break;
                        }
                    }
                }else{
                    if(p1.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 6 == 0){
                        p1.petability();
                        p1.summonpet();
                        }
                     healp1();
                    }
            } 
            int dicep3 = dice.Roll();
            if(dicep3 <4) {
                if(p3.getCurrentLife()  <= 0){
                        System.out.println(p1.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                if(p3.hitRate > dice.Roll()){
                    System.out.println(p3.getName() + " attacks " +p1.getName()+" for " + b);
                    System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());
                    if(p1.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                    }
                }else{
                    System.out.println(p3.getName() + " attacked "+p1.getName() +" But Missed.");
                    System.out.println(p1.getName()+" HP: "+p1.getCurrentLife());
                }
            }
            else if( dicep3 >3){
                int rollin =3;
                if(p3.getCurrentLife()  <= 0){
                        System.out.println(p1.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                if(rollin > dice.Roll()){
                    int e = p1.attack();
                    int prev = p3.getCurrentLife() - e; //evde did not work
                    p3.evade(e);
                    if(prev != p3.getCurrentLife()){
                        System.out.println(p3.getName() + " attacks " +p1.getName()+" for " + b);
                        System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());
                        if(p1.getCurrentLife()  <= 0){
                            System.out.println(p3.getName()+ " Won");
                            System.exit(0);
                        }
                        i= i+1;
                        System.out.println("=========================");
                        System.out.println("\nRound: "+i);
                            if(p3.getCurrentLife()  <= 0){
                        System.out.println(p1.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                        System.out.println(p3.getName() + " evaded "+p1.getName()+" attack\n"
                        + p3.getName()+" HP:" + p3.getCurrentLife());
                        if(p1.getCurrentLife()  <= 0){
                            System.out.println(p3.getName()+ " Won");
                            System.exit(0);
                        }
                    }else{
                        if(p3.getCurrentLife()  <= 0){
                        System.out.println(p1.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                        System.out.println(p3.getName() + " attacks " +p1.getName()+" for " + b);
                        System.out.println(p1.getName()+" HP: " + p1.getCurrentLife());
                        if(p1.getCurrentLife()  <= 0){
                            System.out.println(p3.getName()+ " Won");
                            System.exit(0);
                        }
                    }
                }else{
                    healp3();
                }  
            } 
        }
    }
    public static void Battle3() throws IOException{
        p2.currentLife = p2.maxLife;
        System.out.println("=========================");
        System.out.println("Press [ENTER] to continue");
        System.out.println("=========================");
        br.readLine();
        br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("\nPlayer 2: "+p2.getName()+"\nHP: " + p2.getCurrentLife()
                          +"\nPlayer 3: "+ p3.getName()+"\nHP: " + p3.getCurrentLife());
        System.out.println("\nFinal Battle!");
        for(int i = 1; p3.getCurrentLife() >= 0 && p2.getCurrentLife() >= 0; i++){
            int diceplay3 = dice.Roll();
            System.out.println("=========================");
            System.out.println("\nRound: " + i);
            int a = p3.attack();
            p2.wound(a);

            int b = p2.attack();
            p3.wound(b);
        if(diceplay3 <4) {
                if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                if (p3.hitRate >dice.Roll()){
                    System.out.println(p3.getName()+" attacks " +p2.getName() + " for " + a); 
                    System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());
                    if(p2.getCurrentLife() <= 0){
                        System.out.println(p3.getName()+" WON!!");
                        break;
                    }
                }else{
                    System.out.println(p3.getName() + " attacked "+p2.getName() +" But Missed.");
                    System.out.println(p2.getName()+" HP: "+p2.getCurrentLife());
                }     
            }
            else if(diceplay3 >3){
                int rolls =3;
                if(rolls > dice.Roll()){
                    int e = p2.attack();
                    int prev = p3.getCurrentLife() - e; //evde did not work
                    p3.evade(e);
                    if(prev != p3.getCurrentLife()){
                        if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                        System.out.println(p3.getName() + " evaded "+p2.getName()+" attack");
                        System.out.println(p3.getName()+" HP:" + p3.getCurrentLife());
                        if(p2.getCurrentLife()  <= 0){
                            System.out.println(p3.getName()+ " Won");
                            System.exit(0);
                        }
                        i=i+1;
                        System.out.println("=========================");
                        System.out.println("\nRound: "+i);
                        if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                            System.out.println(p3.getName() + " attacks " +p2.getName()+" for " + a);
                            System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());
                            if(p2.getCurrentLife()  <= 0){
                                System.out.println(p3.getName()+ " Won");
                                System.exit(0);
                            }
                    }else{
                        if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 1){
                            p3.petability();
                            p3.summonpet();
                        }
                        System.out.println(p3.getName() + " attacks " +p2.getName()+" for " + a);
                        System.out.println(p2.getName()+" HP: " + p2.getCurrentLife());
                        if(p2.getCurrentLife()  <= 0){
                            System.out.println(p3.getName()+ " Won");
                            System.exit(0);
                        }
                    }
                }else{
                    if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                    }else if(i % 2 == 1){
                        p3.petability();
                        p3.summonpet();
                    }
                    healp3();
                }   
            }
            
            int diceplay2 = dice.Roll();
            if(diceplay2 < 4) {
                if(p2.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 0){
                            p2.petability();
                            p2.summonpet();
                        }
                if(p2.hitRate > dice.Roll()){
                    System.out.println(p2.getName() + " attacks "+p3.getName()+" for " + b);
                    System.out.println(p3.getName()+" HP: " + p3.getCurrentLife());
                    if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                    }
                } else{
                    System.out.println(p2.getName() + " attacked "+p3.getName() +" But Missed.");
                    System.out.println(p3.getName()+" HP: "+p3.getCurrentLife());
                }
            }
            else if( diceplay2 >3){
                int f = p2.fireball();
                p3.wound(f);
                if(p2.getMana()>=4){
                    if(p2.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 0){
                            p2.petability();
                            p2.summonpet();
                     }
                    System.out.println(p2.getName() + " used Fireball \nDamage Taken " + f);
                    System.out.println(p3.getName()+" HP: " + p3.getCurrentLife()); 
                    if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " Won");
                        System.exit(0);
                    }else if(i % 2 == 1){
                        p3.petability();
                        p3.summonpet();
                    }
                }else{
                   if(p2.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 0){
                            p2.petability();
                            p2.summonpet();
                        }
                    System.out.println(p2.getName() + " attacks "+p3.getName()+" for " + b);
                    System.out.println(p3.getName()+" HP: " + p3.getCurrentLife());
                    if(p3.getCurrentLife()  <= 0){
                        System.out.println(p2.getName()+ " WON!!");
                        System.out.println("Total number of turns: "+i);
                        Battle3();
                        break;
                    }
                }
                }else{
                if(p2.getCurrentLife()  <= 0){
                        System.out.println(p3.getName()+ " Won");
                        System.exit(0);
                        }else if(i % 2 == 0){
                            p2.petability();
                            p2.summonpet();
                        }
                    healp2();
            }
        }
    }
    public static void healp1(){
        int healp1 = dice.Roll()+p1.intelligence;
        p1.currentLife = p1.getCurrentLife() + healp1;
        if(p1.currentLife > p1.maxLife) p1.currentLife = p1.maxLife;
        System.out.println(p1.getName()+ " use heal\n"
        + p1.getName()+" HP: "+p1.getCurrentLife()+ "/"+ p1.maxLife);
    }
     public static void healp2(){
        int healp2 = dice.Roll()+ p2.intelligence;
        p2.currentLife = p2.getCurrentLife() + healp2;
        if(p2.currentLife > p2.maxLife) p2.currentLife = p2.maxLife;
        System.out.println(p2.getName()+ " use heal\n"
        + p2.getName()+" HP: "+p2.getCurrentLife()+ "/"+ p2.maxLife);
    }
      public static void healp3(){
        int healp3 = dice.Roll()+p3.intelligence;
        p3.currentLife = p3.getCurrentLife() + healp3;
        if(p3.currentLife > p3.maxLife) p3.currentLife = p3.maxLife;
        System.out.println(p3.getName()+ " use heal\n"
        + p3.getName()+" HP: "+p3.getCurrentLife()+ "/"+ p3.maxLife);
    }
}