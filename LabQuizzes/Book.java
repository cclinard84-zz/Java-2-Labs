//********************************************************************
//  Book.java       Author: Anthony Stooksbury && Matt Clinard
//
//  Represents a book. Used as the parent of a derived class to
//  demonstrate inheritance.
//********************************************************************
package LabQuizzes;
public class Book {

   protected int pages = 1500;
    Book(){
    
    }
     //  Pages mutator.
     public void setPages (int numPages)
   {
      pages = numPages;
   }

    //  Pages accessor.
      public int getPages ()
   {
      return pages;
   }
}
