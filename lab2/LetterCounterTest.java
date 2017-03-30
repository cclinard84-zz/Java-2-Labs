/*
 * File: LetterCounterTest.java
 * Author: Christopher Clinard 
 * Date: 2/15/2017
 * Version: 2
 * This driver utilizes the methods in the LetterCounter.java file. This program
 * first welcomes the user, gives instructions, and asks them if they 
 * wish to continue. If they do not the programs thanks them and exits,
 * otherwise the program asks them for their input and validates via
 * UtilityMethod and then prints the letter and how many times the letter
 * occurs within the string they input. The program then thanks them and exits
 */
package lab2;

public class LetterCounterTest {
  
  public static void main(String[] args){
    
    //String used to hold the user input string
    String userString;
    
    //Character array to hold alphabetical letters.
    char[] letterArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    
    //Int array to hold each occurence of each letter
    int[] countArray = new int[26];
    
    if(LetterCounter.welcome() == 'y'){
      userString = LetterCounter.getInput();
      LetterCounter.countLetters(userString, letterArray, countArray);
    }
    else{
      LetterCounter.farewell();
    }
    LetterCounter.farewell();
  }
  
}
