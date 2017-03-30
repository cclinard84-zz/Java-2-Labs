//********************************************************************
//  Dictionary.java       Author: Anthony Stooksbury && Matt Clinard
//
//  Represents a dictionary, which is a book. Used to demonstrate
//  inheritance.
//********************************************************************
package LabQuizzes;
public class Dictionary extends Book
{
   private int definitions = 52500;

   //-----------------------------------------------------------------
   //  Prints a message using both local and inherited values.
   //-----------------------------------------------------------------
   public double computeRatio ()
   {
      return definitions/pages;
   }

   //----------------------------------------------------------------
   //  Definitions mutator.
   //----------------------------------------------------------------
   public void setDefinitions (int numDefinitions)
   {
      this.definitions = numDefinitions;
       
   }

   //----------------------------------------------------------------
   //  Definitions accessor.
   //----------------------------------------------------------------
   public int getDefinitions ()
   {
      return definitions;
   }
}
