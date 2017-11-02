
import java.util.*;

/*
        Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
        Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?
        Given two strings, and , that may or may not be of the same length, determine the minimum number of character deletions required to make and anagrams. Any characters can be deleted from either of the strings.
        
        Input Format
        The first line contains a single string, a .
        The second line contains a single string, b .
        
        Constraints
        1 <= |a|, |b| <=10^4

        It is guaranteed that and consist of lowercase English alphabetic letters (i.e., through ).
        
        Output Format
        Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.
        
        
        Sample Input
        cde
        abc
        
        Sample Output
        4
        
        Explanation
        
        We delete the following characters from our two strings to turn them into anagrams of each other:

        Remove d and e from cde to get c.
        Remove a and b from abc to get c.
        
        We must delete characters to make both strings anagrams, so we print on a new line.
     
*/

public class Solution {

    public static int numberNeeded(String first, String second) {

   
        int result = 0;
        
        
        //keep track of all the letters' frequencies
        int[] frequencyOfLetters = new int[26];
        
        
        //count frequency of each letter in the first string
        for(char letter : first.toCharArray()){
            
            //little trick : 
            //Consider the frequency array as a sorted collection of counter 
            //where you can induce the index through the numeric value of each char
            // for instance :
            //'a' as decimal is 97, b is 98, 
            // thus index of b == 98 - 97 = 01 
            int indexOfFrequency = letter -'a';
            
            frequencyOfLetters[indexOfFrequency]++;
            
        }
        //decrement frequency for each letter for the second string (if there are the same letters with the same frequency then the first
        // they will be nullified, otherwise we have the elements we need to sum and return to)
        for(char letter : second.toCharArray()){
            
            int indexOfFrequency = letter -'a';

            frequencyOfLetters[indexOfFrequency]--;            
            
        }
        
        //sum what's left, and if the frequency is negative (frequency of a specific letter is bigger to the first string)
        //then handle it accordingly  
        for (int lettersLeftAfterComparison : frequencyOfLetters){
            
              if(lettersLeftAfterComparison < 0)
                   result = result - lettersLeftAfterComparison;
            else
                   result = result + lettersLeftAfterComparison;
            
            
        }
            
        
        
        
        return result;
    }

    public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));

    }
}
