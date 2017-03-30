/*
 * File: LetterCounter.java
 * Author: Christopher Clinard 
 * Date: 2/15/2017
 * The methods in this class class are for use with the LetterCounterTest.java driver. 
 */
package lab2;

import java.util.Scanner;

public class LetterCounter {
  
  //Scanner for user input
  static Scanner input = new Scanner(System.in);
  
  //This method welcomes the user, gives them instructions, and then asks the user if they wish to continue
  public static char welcome(){
    char answer;
    System.out.print("Welcome to the Letter Counter Application."+
                     "\nThis program will take in as much text as possible and tell you"+
                     "\nhow many occurences of each letter there are. Please enter only"+
                     "\nwords containing characters or the program will require you to"+
                     "\nretype your entry. Would you like to continue?\nEnter 'y' for yes or 'n' for no:");
    answer = input.next().charAt(0);
    answer = UtilityMethods.askIfYesOrNo(input, answer);
    return answer;
  }
  
  //This method gets the user input via the keyboard and then verifies the input 
  //via a UtilityMethods.verifyString method and returns the string
  public static String getInput(){
    String str;
    input.nextLine();
    System.out.print("Please enter a word or a sentence with no numbers or punctuation: ");
    str = input.nextLine();
    str = str.toLowerCase();
    str = UtilityMethods.verifyString(input, str);
    return str;
  }

  
  //This method counts the letters in the string and maintains the count in an array of integers
  //and then calls a print method to print the totals.
  public static void countLetters(String str, char[] letter, int[] count){
    for(int i = 0; i < 26; i++){
      for(int k = 0; k < str.length(); k++){
        if(str.charAt(k) == letter[i])
          count[i]++;
      }
    }
    printCounts(letter, count);
  }
  
  //This method is called by the countLetters method and just prints the letter and
  //how many times it appears.
  public static void printCounts(char[] letter, int[] count){
    System.out.println("\nThe word or phrase you typed has the following letter counts:");
    for(int i = 0; i < 26; i++){
        System.out.print(letter[i]+ ": "+ count[i]+ "    ");
    }
  }
  
  public static void farewell(){
    System.out.println("\nThanks for using this application!\nGoodbye!");
    System.exit(0);
  }
}
