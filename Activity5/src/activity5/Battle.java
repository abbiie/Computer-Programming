package activity5;

import java.io.*;
import java.util.Random;

public class Battle {
    static Dice dice = new Dice();
    public static BufferedReader br;
    static  Knight p1 = new Knight ("Knight", 25, 13, 23,5);
    static Mage p2 = new Mage ("Mage", 25, 13, 23,5);
    static Thief p3 = new Thief ("Thief", 25, 13, 23,5);
    
    
    
    public static void game()throws IOException{
        br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Your Character is: "+p1.name+"\n your Enemies are the "+ p2.name+" and "+p3.name);
        System.out.println("Lets the battle begin!");
        System.out.println("____________________________________");
        battle();
        
    }
    
       public static void battle() throws IOException{
       System.out.println("Your Character: " + p1.name 
               + "HP: " + p1.currentLife);
       System.out.println("Player 2: " + p2.name 
               + "HP: " + p2.currentLife);
       System.out.println("Player 3: " + p3.name
               + "HP: " + p3.currentLife);
       
       
       
 for(int i = 1; p1.currentLife >= 0 && p2.currentLife >= 0 && p3.currentLife >=0 ; i++){
        System.out.println("____________________________________");
        System.out.println("\nRound: " + i);
        System.out.println("What do you want to do? ");
         System.out.println("[1]Attack\n"
                           +"[2]Heal");
        short no = Short.parseShort (br.readLine ());
        switch(no){
            case 1:
                if(p1.hitRate > dice.Roll()) {
                int aa = p1.attack();
                p2.wound(aa);
           System.out.println("you attacks " +p2.name + " for " + aa); 
           System.out.println (p2.name+" HP: " + p2.currentLife);
           
            if(p2.currentLife <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("Remaining HP: "+ p1.currentLife);
                kgame();
               System.exit(0);
                break;
            }
             }
                else {
                System.out.println("You attacked " +p2.name+ " but missed");
            System.out.println(p2.name +" HP: " + p2.currentLife);
                }
                
                  Random ran = new Random ();
                int mRate = ran.nextInt (11);
                if(p1.hitRate > mRate) {
        int B = p1.attack();
        p3.wound(B);
        System.out.println("you attacks " +p3.name + " for " + B);
           System.out.println(p3.name+ " HP: " + p3.currentLife);
           
            if(p3.currentLife <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("Remaining HP: "+ p1.currentLife);
                TestCharacter.game();
                System.exit(0);
                break;
            }
                }
                else {
                System.out.println("You attacked " + p3.name+" but missed!");
            System.out.println(p3.name +" HP: " + p3.currentLife);
        }
           
            
                Random randy = new Random ();
                int misssRate = randy.nextInt (11);
                Random rans = new Random ();
                int choice = rans.nextInt (2)+1;
                if (choice == 1){
                    
           if(p2.hitRate > misssRate) {
            int b = p2.attack();
        p1.wound(b);
        System.out.println(p2.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        egame();
        System.exit(0);
        break;
        
        }
           }
        else { 
                System.out.println( "The " + p2.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }
             }else if (choice ==2){
                    
                    
                int oo = dice.Roll()+p2.intelligence;
                p2.currentLife = p2.currentLife + oo;
                if(p2.currentLife > p2.maxLife) p2.currentLife = p2.maxLife;
                
                System.out.println(p2.name+ " use heal"
                        + "\nEnemy HP is now: "+p2.currentLife+ "/"+ p2.maxLife);
             }     
           
           Random randd = new Random ();
                int misssRte = randd.nextInt (11);
                Random ranss = new Random ();
                int choices = ranss.nextInt (2)+1;
                if (choices == 1){
           if(p3.hitRate > misssRte) {
            int C = p3.attack();
        p1.wound(C);
        System.out.println(p3.name + " attacks you for " + C);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        kgame2();
        System.exit(0);
        break;
        }
           }
        else { 
                System.out.println( "The " + p3.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }
           
               
                }else if (choice ==2){
                    
                    
                int oo = dice.Roll()+p3.intelligence;
                p3.currentLife = p3.currentLife + oo;
                if(p3.currentLife > p3.maxLife) p3.currentLife = p3.maxLife;
                
                System.out.println(p3.name+ " use heal"
                        + "\nEnemy HP is now: "+p3.currentLife+ "/"+ p3.maxLife);
                
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
            Random randds = new Random ();
                int missssRate = randds.nextInt (11);
           if(p2.hitRate > misRate) {
            int b = p2.attack();
        p1.wound(b);
        System.out.println(p2.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        egame();
        System.exit(0);
        break;
        } 
           } 
        else { 
                System.out.println( "The " + p2.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }//h
        
         if(p3.hitRate > missssRate) {
            int b = p3.attack();
        p1.wound(b);
        System.out.println(p3.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        egame();
        System.exit(0);
        break;
        }
           }
        else { 
                System.out.println( "The " + p3.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }
           break;
           
        }
        
 }
 }
       public static void kgame()throws IOException{
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
        public static void kgame2() throws IOException{
              System.out.println("name :" +p1.name);
     System.out.println("HP :" +p1.currentLife);
     System.out.println("Enemy name :" +p3.name);
     System.out.println("HP :" +p3.currentLife);
 for(int i = 1; p1.currentLife >= 0 && p3.currentLife >= 0; i++){
     
     
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
        p3.wound(a);
          
           System.out.println("you attacks " +p3.name + " for " + a); 
           System.out.println("Enemy HP: " + p3.currentLife);
           
            if(p3.currentLife <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: "+i);
                System.out.println("Remaining HP: "+ p1.currentLife);
                System.exit(0);
                break;
            }
        }    
            else{
                System.out.println("You attacked but missed!");
            System.out.println("Enemy HP: " + p3.currentLife);
        }
                Random randy = new Random ();
                int misssRate = randy.nextInt (11);
                Random ran = new Random ();
                int choice = ran.nextInt (2)+1;
                if (choice == 1){
           if(p3.hitRate > misssRate) {
            int b = p3.attack();
        p1.wound(b);
        System.out.println(p3.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        System.exit(0);
        }
           }
        else { 
                System.out.println( "The " + p3.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }//h
                }else if (choice ==2){
                int oo = dice.Roll()+p3.intelligence;
                p3.currentLife = p3.currentLife + oo;
                if(p3.currentLife > p3.maxLife) p3.currentLife = p3.maxLife;
                
                System.out.println(p3.name+ " use heal"
                        + "\nEnemy HP is now: "+p3.currentLife+ "/"+ p3.maxLife);
                
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

           if(p3.hitRate > misRate) {
            int b = p3.attack();
        p1.wound(b);
        System.out.println(p3.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p1.currentLife);
        if(p1.currentLife  <= 0){
        System.out.println("GAME OVER!");
        System.exit(0);
        }
           }
        else { 
                System.out.println( "The " + p3.name+" attacked you but missed!");
            System.out.println("Remaining HP: " + p1.currentLife);
        }//h
           break;
        }
       
 }
    
       }
         public static void egame(){
             System.out.println("Player 2 :" +p2.name);
     System.out.println("HP :" +p2.currentLife);
     System.out.println("Player 3:" +p3.name);
     System.out.println("HP :" +p3.currentLife);
 for(int i = 1; p3.currentLife >= 0 && p2.currentLife >= 0; i++){
     
     
System.out.println("\nRound: " + i);
       
                Random rand = new Random ();
                int missRate = rand.nextInt (11);
                Random ranf = new Random ();
                int choiice = ranf.nextInt (2)+1;
                if (choiice ==1){
                if(p3.hitRate > missRate) {
        int a = p3.attack();
        p2.wound(a);
          
           System.out.println(p3.name +" attacks " +p2.name + " for " + a); 
           System.out.println("Enemy HP: " + p2.currentLife);
           
            if(p2.currentLife <= 0){
                System.out.println(p2.name +" fell down!");
                System.out.println(p3.name+" Win!!! \nTotal number of turns: "+i);
                System.out.println("Remaining HP: "+ p3.currentLife);
                System.exit(0);
                break;
            }
        }    
            else{
                System.out.println(p3.name + " attacked"+p2.name+" but missed!");
            System.out.println(p2.name+" HP: " + p2.currentLife);
        }
                }
                else if (choiice ==2){
                int oo = dice.Roll()+p3.intelligence;
                p3.currentLife = p3.currentLife + oo;
                if(p3.currentLife > p3.maxLife) p3.currentLife = p3.maxLife;
                
                System.out.println(p3.name+ " use heal"
                        + p3.name+"\n HP: "+p3.currentLife+ "/"+ p3.maxLife);
                
                }
                
                Random randy = new Random ();
                int misssRate = randy.nextInt (11);
                Random ran = new Random ();
                int choice = ran.nextInt (2)+1;
                if (choice == 1){
           if(p2.hitRate > misssRate) {
            int b = p2.attack();
        p3.wound(b);
        System.out.println(p2.name + " attacks "+p3.name+" for " + b);
        System.out.println("Remaining HP: " + p3.currentLife);
        if(p3.currentLife  <= 0){
        System.out.println("GAME OVER!");
        System.exit(0);
        }
           }
        else { 
                System.out.println( p2.name+" attacked "+p3.name+" but missed!");
            System.out.println(p3.name+ " HP: " + p3.currentLife);
        }//h
                }else if (choice ==2){
                int oo = dice.Roll()+p2.intelligence;
                p2.currentLife = p2.currentLife + oo;
                if(p2.currentLife > p2.maxLife) p2.currentLife = p2.maxLife;
                
                System.out.println(p2.name+ " use heal"
                        + p2.name+ "\n HP: "+p2.currentLife+ "/"+ p2.maxLife);
                
                }
                
            Random randyy = new Random ();
                int misRate = randyy.nextInt (11);

           if(p2.hitRate > misRate) {
            int b = p2.attack();
        p3.wound(b);
        System.out.println(p2.name + " attacks you for " + b);
        System.out.println("Remaining HP: " + p3.currentLife);
        if(p3.currentLife  <= 0){
            System.out.println(p3.name+" fell down");
         System.out.println(p2.name+" Win!!! \nTotal number of turns: "+i);
                System.out.println("Remaining HP: "+ p2.currentLife);
                System.exit(0);
                break;
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