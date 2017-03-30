/*
 * FileName: PasswordVerifier.java
 * Names: Gregory Corujo && Christopher Clinard
 */
package LabQuizzes;

public class PasswordVerifier {

// Constant for minimum password length
   public static final int MIN_PASSWORD_LENGTH = 8;
   
   /**
        isValid method
    */
   public static boolean isValid(String str)
   {
      boolean status = false, digit, upperCase, lowerCase; // Validity status
      

    //Check to see if password is valid(contains one digit, one lowercase, one uppercase
    // may use if statement
    upperCase = hasUpperCase(str);
    lowerCase = hasLowerCase(str);
    digit = hasDigit(str);
    if (str.length() >= MIN_PASSWORD_LENGTH && upperCase && lowerCase && digit)
        status = true;
    
      return status;
   }

   /**
        hasUpperCase method
    */
   
   private static boolean hasUpperCase(String str)
   {
      boolean status = false; // Validity status
      for (int i = 0; i<str.length();i++)
      {
          if (Character.isUpperCase(str.charAt(i)))
          {
              status = true;
              return status;
          }
      }

   // check to see if password contains at least one uppercase
   // may use a loop to check each character
   
      return status;
   }

   /**
        hasLowerCase method
    */
   private static boolean hasLowerCase(String str)
   {
      boolean status = false; // Validity status
      for (int i = 0; i<str.length();i++)
      {
          if (Character.isLowerCase(str.charAt(i)))
          {
              status = true;
              return status;
          }
      }

     //check to see if password contains at least one lowercase
    //may use a loop to check each character 
      return status;
   }

   /**
        hasDigit method
    */
   private static boolean hasDigit(String str)
   {
      boolean status = false; // Validity status
      for (int i = 0; i<str.length();i++)
      {
          if (Character.isDigit(str.charAt(i)))
          {
              status = true;
              return status;
          }
      }

    //check to see if password contains at least one digit
   //may use a loop to check each character 
      return status;
}
}