/*
 * @author Gregory Corujo, Christopher Clinard
 */
package LabQuizzes;

import java.util.Scanner;
public class PasswordDriver {
    public static void main(String[] args){

        String input;  // To hold input

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get a password.
        do
        {
        System.out.print("Enter a password: ");
        input = keyboard.nextLine();

        // Check the password.
        
        if (!PasswordVerifier.isValid(input))
           System.out.println("Invalid password.");
        else
           System.out.println("Valid password.");
        }
        while (!PasswordVerifier.isValid(input));
                
        }
        
}


