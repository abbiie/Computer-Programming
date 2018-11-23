package magicsquare;
import java.util.*;
class magicSquare
{ 
    static void generateSquare(int n) 
    { 
        int[][] magicSquare = new int[n][n]; 
          
        int i = n/2; 
        int j = n-1; 
   
        for (int num=1; num <= n*n; ) 
        { 
            if (i==-1 && j==n)
            { 
                j = n-2; 
                i = 0; 
            } 
            else
            { 
                if (j == n) 
                    j = 0; 
                      
                if (i < 0) 
                    i=n-1; 
            } 
              
            if (magicSquare[i][j] != 0)  
            { 
                j -= 2; 
                i++; 
                continue; 
            } 
            else 
                magicSquare[i][j] = num++;  
                  
            j++;  i--;  
        } 
        
        for(i=0; i<n; i++) 
        { 
            for(j=0; j<n; j++) 
                System.out.printf("%5d",magicSquare[i][j]); 
            
            System.out.print(" = "+n*(n*n+1)/2);
            System.out.println();
        }
        System.out.println();
        System.out.printf("The Sum of Column is = "+"%5d",n*(n*n+1)/2);
        System.out.println("\n--------------------------------");
    } 
      
    public static void main (String[] args)  
    { 
        Scanner sc = new java.util.Scanner(System.in);
        String tryAgain = "y";
        int n = 0;
        
        do{
        System.out.println("--------------------------------");
        System.out.print("Please Input Odd Number For Magic Square: ");
        n = sc.nextInt();
        
        if(n % 2 == 0 || n < 3){
            System.out.println("Invalid Input. Please Input an Even Number and must not be less than 3");
        }else{
        generateSquare(n); 
        }
            System.out.println("Would you like to try again? Y/N: ");
            sc.nextLine();
            tryAgain = sc.nextLine();
            tryAgain = tryAgain.toLowerCase();
        }
        while(!tryAgain.equals("n"));
        
    } 
}
