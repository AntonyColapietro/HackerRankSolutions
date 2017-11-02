/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerranksolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Input Format

The first line contains two space-separated integers describing the respective values of (the number of words in the magazine) and (the number of words in the ransom note).
The second line contains space-separated strings denoting the words present in the magazine.
The third line contains space-separated strings denoting the words present in the ransom note.

Constraints

    1<= m, n <= 30000
    1 <= length of any word <= 5
    Each word consists of English alphabetic letters (i.e., to and to ).
    The words in the note and magazine are case-sensitive.

Output Format

Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

*/
public class Solution {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
      
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        //hashmap used to keep count of frequency of each word in the magazine and in the ransom
        Map<String,Integer> occrencesForWord = new HashMap();
        
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
           //check the hashmap , if no value is present yet then this is the first occurrence (1) 
           //otherwise increment the previous value
            int wordFrequency = occrencesForWord.get(magazine[magazine_i]) == null ? 1 : occrencesForWord.get(magazine[magazine_i])+1;
            occrencesForWord.put(magazine[magazine_i], wordFrequency);
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            //check the hashmap , if no value is present yet we have trouble to write the ransom (we need this word but is not present in the magazine, so frequency is negative)
           // otherwise subtrack the previous frequency value (we are using it for our ransom note)
            int wordFrequency = occrencesForWord.get(ransom[ransom_i]) == null ? -1 : occrencesForWord.get(ransom[ransom_i])-1;
            occrencesForWord.put(ransom[ransom_i], wordFrequency); 
        }
        
     //check if for any of the ransom word we got frequency >= 0, otherwise we can't write the ransom!
          for (String s : ransom){
             
                int wordFrequency = occrencesForWord.get(s);
             
                if(wordFrequency < 0){
                     System.out.println("No");
                    return;
                }
                    
                
        }
        
             System.out.println("Yes");    
    
}
}
