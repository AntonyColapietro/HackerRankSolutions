/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerranksolutions;

import hackerranksolutions.Player;
import java.util.Comparator;

/**
 *
 * @author tony
 */
public class Checker implements Comparator {

      @Override
    public int compare(Object o1, Object o2) {

     if (!(o1 instanceof Player) || !(o2 instanceof Player)){
            throw new IllegalArgumentException();
    }
        Player p1 = (Player) o1;
        Player p2 = (Player) o2;
        
        if (p1.score != p2.score)
            return p1.score > p2.score ? -1:1;
        
        else{
   
            int index = 0;
            char p1NameLetter;
            char p2NameLetter; 
        do
        {
            p1NameLetter = p1.name.charAt(index);
            p2NameLetter = p2.name.charAt(index);
        
            index++;
            
          if (p1NameLetter != p2NameLetter)
            return p1NameLetter > p2NameLetter ? 1 : -1 ;
           
        }
        while(index < p1.name.length() && index < p2.name.length());
        
            if(p1.name.length() > p2.name.length())
                return 1;
            else if( p1.name.length() < p2.name.length())
                return -1;
            
       return 0;
          
        }
        
    }
 }
