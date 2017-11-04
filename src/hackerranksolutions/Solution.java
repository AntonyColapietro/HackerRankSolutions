/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerranksolutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your dataset of integers in non-decreasing order, then:
 *
 *  If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted dataset , is the median.
 *  If your dataset contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted dataset , is the median.
 *
 *  Given an input stream of integers, you must perform the following task for each integer:
 *
 *  Add the integer to a running list of integers.
 *  Find the median of the updated list (i.e., for the first element through the element).
 *  Print the list's updated median on a new line. The printed value must be a double-precision number scaled to decimal place (i.e., format).
 * 
 * Input Format
 *
 * The first line contains a single integer, , denoting the number of integers in the data stream.
 * Each line of the subsequent lines contains an integer, , to be added to your list.
 *
 * Constraints
 * 
 * 1 <= n <= 10^5
 * 0 <= number <= 10^5
 * Output Format
 *
 * After each new integer is added to the list, print the list's updated median on a new line as a single double-precision number scaled to decimal place (i.e., format).
 */
public class Solution {
    
    //This is gonna store or the lower values in the array as a Max Heap
    //For instance :
    
    // 3 1 2 7 5 -> 3 1 2  where peek/poll gives 3
      static  PriorityQueue<Integer> lowerValuesOfTheArray = new PriorityQueue<Integer>(new Comparator<Integer> () {
        @Override
        public int compare(Integer o1, Integer o2) {
        
            return -1 * o1.compareTo(o2); // max heap order comparator
        }
    });
    //This is gonna store or the higer values in the array as a Min Heap
    //For instance :
    
    // 3 1 2 7 5 -> 5 7  where peek/poll gives 5
       static PriorityQueue<Integer> higherValuesOfTheArray = new PriorityQueue<>(); //min heap
      
      

      
    public static void addNumber(Integer numberToAdd, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher ){
        
        if( lower.isEmpty() || numberToAdd < lower.peek()) //minor of the top of the lower values == is a lower number, add it to the heap
        
            lower.add(numberToAdd);
        
        else
            higher.add(numberToAdd);
        
        
    }
    
    
     public static void balance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher ){
        
         PriorityQueue<Integer> biggerHeap =  lower.size() > higher.size()? lower : higher;
         PriorityQueue<Integer> smallerHeap = lower.size() < higher.size()? lower : higher;
         
         
        if( biggerHeap.size() - smallerHeap.size() >= 2 ) //max balance difference allowed between 2 heaps is 1 element
           
            smallerHeap.add(biggerHeap.poll()); //move it from bigger to smaller heap
     
        
    }
     
      public static float  getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher ){
        
          int lowerSize = lower.size();
          int higherSize = higher.size();
          
        
         
        if( lowerSize == higherSize ) // heaps are balanced, so peek the values and calculate the average
           return ((float) higher.peek() + lower.peek()) /2;
        
        //otherwise peek from the biggest heap
        
        if (lower.size() > higherSize)
            return lower.peek();
        
        return higher.peek();
        
        
    }
      
      
      

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            addNumber(a[a_i], lowerValuesOfTheArray, higherValuesOfTheArray);
            balance(lowerValuesOfTheArray, higherValuesOfTheArray);
            System.out.println(getMedian(lowerValuesOfTheArray, higherValuesOfTheArray));
            
            
        }
    }
}

