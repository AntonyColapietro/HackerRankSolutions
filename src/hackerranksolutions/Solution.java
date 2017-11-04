/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerranksolutions;

import java.util.Scanner;

/**
 *
 * @author tony
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt();
    
        int[] a = new int[numberOfElements]; 
    
        for (int i = 0; i < numberOfElements; i ++){
            
            a[i] = in.nextInt();
           
            
        }
        
        
        boolean isSorted = false;
        Integer lenghtToSort = a.length -1;
        Integer  numberOfSwaps = 0; 
        
        
        while(!isSorted){
            
            isSorted = true;
            
            for (int i = 0; i < lenghtToSort; i++){
                
                if(a[i] > a[i+1]){
                    
                    swap(a,i,i+1);
                    numberOfSwaps = numberOfSwaps + 1;
                    isSorted = false;
                    
                }
                 
            }
            lenghtToSort--;
            
            
            
            
        }
        
          System.out.println("Array is sorted in "+ numberOfSwaps + " swaps.");
          System.out.println("First Element: "+ a[0]); 
          System.out.println("Last Element: "+ a[numberOfElements-1]);

        
        
        
       
            
    
    }

    private static void swap(int[] a, int i, int i0) {

        a[i] = a[i]+ a[i0];
        a[i0] = a[i] - a[i0];
        a[i] = a[i] - a[i0];
        


    }
}