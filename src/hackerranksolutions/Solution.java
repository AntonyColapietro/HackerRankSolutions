/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerranksolutions;

import java.util.Scanner;

/**
 *Given a number of dollars, , and a list of dollar values for distinct coins,
 *find and print the number of different ways you can make change for dollars if each coin is available in an infinite quantity.
 *
 */
public class Solution {

      
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] coins = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i]=in.nextInt();
        }
        
        long numberOfChanges = changeDollarsWithCoins(n,coins);
        
        System.out.println(numberOfChanges);
        
        
    }

    private static long changeDollarsWithCoins(int n, int[] coins) {

        
     //create an array, where index represent amounts of money ( 1 -> 1 dollar , 2 -> 2 dollars etc...)
     //so the array has to have a length of n+1 (to reach index N, where N is our target amount)
        long[] amountArray = new long[n+1];
     //base case, if amount is 0 we set the value to 1
        amountArray[0] = 1;
         
        // for each coin we need to use
            for (Integer coin : coins)
                //run through the amount array
                for(int i = 1; i < amountArray.length ; i++) {
                    //if amount is more or equal then the value of the coin 
                    if(i >=coin)
                        //amount of index I has value equal to its current value + the value of "I - coin" dollars left
                        //for instance: 
                        //Amount : 3 dollars   
                        //amountArray = int[4] ([0 0 0 0]) 
                        //coins : 3,1
                        //First iteration with coin = 3
                        //amountArray[3 dollars] = amountArray[3 dollars] + amountArray[(3 dollars - 3 Dollar Coin ) --> 0 dollars]
                        //So if the first coin is 3 we get 1 (due to the base case) --> and it refers to representation: {3}
                        //and it's correct because {COIN} is the only representation of AMOUNT 
                        //when AMOUNT == COIN (base case amount[0])
                        //
                        //but if we'll have coin=1 at the next iteration of external for loop
                        //amount[3] = amount[3] + amount[2]
                        //so if we can represent 2 dollars this will be increased by 1
                        //and that's the case (amount[2] has been already in the previous iteration of the inner loop calculated with i==2 for coin == 1)
                        //Coin 3 :   amount[0] = 1          | Coin 1:  amount[0] = 1 
                        //           amount[1] = 0                     amount[1] = 1 --> {1} 
                        //           amount[2] = 0                     amount[2] = 1 --> {1,1}
                        //           amount[3] = 1 --> {3}             amount[3] = 2 --> {3}, {1,1,1} 
                        //
                        //So the number of ways to represent an amount given a Coin is dependant/incremented by number of ways to represent the rest 
                        // (amount - Coin) with the available coins
                        amountArray[i]= amountArray[i] + amountArray[i-coin];
          
   
                }
        
        
        return amountArray[n];
    }
    

}
