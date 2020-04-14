/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.io.*;
/**
 *
 * @author crizamae montero
 */
public class Calculator {

    public static void main (String [] args) throws IOException {
    BufferedReader b= new BufferedReader (new InputStreamReader (System.in));

    System.out.print("Enter the amount of number you want to use: ");

    int a= Integer.parseInt (b. readLine());
    int total=0;
    int[] mjliit= new int[a];

    for (int i = 0; i<a; i+=1) {

        if(i==0){
System.out.print("Enter Number: ");
 mjliit[i]=Integer.parseInt (b. readLine());
total=total+mjliit[0];}
else{
System.out.print("1. Addition\n");
System.out.print("2. Subtraction\n");
System.out.print("3. Multiplication\n");
System.out.print("4. Division\n");
System.out.print("Enter Your Choice : ");
int s= Integer.parseInt (b. readLine());
System.out.print("Enter Number: ");
mjliit[i]=Integer.parseInt (b. readLine());
if(s==1){
total=total+mjliit[i];}

if(s==2){
total=total-mjliit[i];}
if(s==3){
total=total*mjliit[i];}
if(s==4){
total=total/mjliit[i];}
System.out.println("Total : "+total);

}

    }    // TODO code application logic here
    }
    
}
