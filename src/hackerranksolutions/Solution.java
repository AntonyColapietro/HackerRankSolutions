/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerranksolutions;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author tony
 */

public class Solution {
    
   
   static HashMap<Integer,Long> memStep = new HashMap();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(countWays(n));
        }
    }

    private static long countWays(int n) {
    
 
        //added dynamic programming: if result is cached return directly from the static hashmap
        //otherwise calculate and store it for future queries
       if(!memStep.containsKey(n)) {

        if (n < 0) //wrong path, this does not count
            return 0;
        if (n == 0)//correct path, this count as a way to reach the destination
            return 1;
          
          //number of ways = sum of number of ways for each path taken from n with a possible step forward (step can be 3,2,1)            
           memStep.put(n, countWays(n-3) + countWays(n-2) + countWays(n-1));
        
       }
        return memStep.get(n);
        
    }
}