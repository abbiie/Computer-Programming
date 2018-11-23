package bubblesort;

import java.util.stream.*;

public class BubbleSort {  
    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] < arr[j]){
                              
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];
                                 arr[j] = temp;
                          }
                 }  
         }  
  
    }  
    public static void main(String[] args) {  
                int arr[] = IntStream.range(1, 101).toArray();//array 1 to 100
                
                System.out.println("Ascending Sort: ");  
                for(int i = 0; i < arr.length; i++){  
                        System.out.print(arr[i] + ",");  
                }
                System.out.println();
                bubbleSort(arr);//sorting array elements using bubble sort  
                 
                System.out.println("Descending Sort: ");  
                for(int i = 0; i < arr.length; i++){  
                        System.out.print(arr[i] + ",");  
                }                
                System.out.println();
                bubbleSort(arr);//sorting array elements using bubble sort  
                 
                System.out.println("Random Sort: ");  
                for(int i = 0; i < arr.length; i++){  
                        System.out.print((int)(Math.random()*arr[i]) + ",");//Generates Random 100 numbers  
                }
                }  
   
        }  