/*
 * File: UtilityMethods.java
 * Author: Christopher Matthew Clinard
 * Date: 11/10/16
 * This class is the beginning of a library of methods that
 * I have created and I use on a regular basis. 
 */
package lab2;
import java.util.*;

public class UtilityMethods {
  
  //This method verifies if the input is an integer.
  public static int verifyInt(Scanner input, String str){
    int length, age = -1;
    length = str.length();
    while(age == -1){
    
        try{
            age = Integer.parseInt(str);
        }
        catch(Exception e){
            System.out.print("Enter a valid integer: ");
            str = input.next();
        }
    }
    return age;
  }
  
  //This method is used for verification of yes or no inputs.
  public static char askIfYesOrNo(Scanner input, char optionChar){
      char option;
      
        while(optionChar != 'y' && optionChar != 'n'){
            System.out.print("Enter a 'y' or 'n': ");
            option = input.next().charAt(0);
            optionChar = Character.toLowerCase(option);
        }
        return optionChar;
  }
  
  //This method verifies that user input is a valid string with no numbers.
  public static String verifyString(Scanner input, String str){
      int length = str.length();
      char c;
      
      for(int i = 0; i < length; i++){
          if(!(Character.isLetter(str.charAt(i)) || str.charAt(i) == ' ')){
              while(!(Character.isLetter(str.charAt(i)) || str.charAt(i) == ' ')){ 
                  System.out.print("Enter a word or a sentence with no numbers or punctuation: ");
                  str = input.nextLine();
                  str = str.toLowerCase();
                  length = str.length();
                  i = 0;
              }
          }
      }
      return str; 
  }
  
  //This method utilizes try and catch to make sure user input will at least parse to a double.
  public static double verifyDouble(Scanner input, String str){
    double retNum = -1;
    int numPeriods = 0;
    int length;
    
    while(retNum == -1){
      try{
        retNum = Double.parseDouble(str);
      }
      catch(Exception e){
        System.out.print("Enter a valid double: ");
        str = input.next();
      }
    }
    return retNum;
  }
}

  

