/*
 * File: RetailItemTest.java
 * Author: Christopher Clinard
 * Date: 1/24/17
 * This program uses the RetailItem.java class to automatically create 3 objects with parameters and
 * one object utilizing a no argument contructor that the user will be able to modify. During the course
 * of this program RetailItemTest.java will welcome the user and give instructions, ask them if they wish to 
 * use the program, and print the automatically created objects. Then the program will ask the user if they 
 * want to add an item. If yes they will be given distinct instructions to do so, if no, the program will exit
 * with a farewell message.
 */
package lab1;

import lab2.UtilityMethods;
import java.util.Scanner;

public class RetailItemTest {
    
        
    public static void main(String[] args){
      
        //Scanner to get user input when necessary
        Scanner input = new Scanner(System.in);
        
        //Add items to the "database" automatically and creates one object for the user to create
        RetailItem item1 = new RetailItem("Jacket ", 59.95, 12);
        RetailItem item2 = new RetailItem("Designer Jeans", 34.95, 12);
        RetailItem item3 = new RetailItem("Shirt ", 24.95, 20);
        RetailItem item4 = new RetailItem();
        
        //Variable declaration and assignment
        char answer;
        int numItems = 3;
        String intStr;
        String item = "item";
               
        answer = welcome(input);
        while(answer == 'y'){
          printDB(item1);
          printDB(item2);
          printDB(item3);
          answer = askToAddToDB(input);
          while(answer == 'y'){
              addToDatabase(input, item4);
              addedObject(item4);
              answer = 'n';
          }            
        }
        farewell();
        
    }
    
    //This method welcomes the user and gives them instructions on the program.
    public static char welcome(Scanner input){
        char answer;
        System.out.print("Welcome to Retail Item Database!"+
                "\nThis program will print out the current database of items to you"+
                "\nand then prompt you to enter a new item."+ 
                "\nWould you like to continue?"+
                "\nEnter 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = Character.toLowerCase(answer);
        answer = UtilityMethods.askIfYesOrNo(input, answer);            
        return answer;
    }
    
    //This asks the user if he wants to add an item to the database.
    //This method also validates the user input via UtilityMethods class.
    public static char askToAddToDB(Scanner input){
        char answer;
        System.out.print("Would you like to add an item to the database?"+
                "\nEnter 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = Character.toLowerCase(answer);
        answer = UtilityMethods.askIfYesOrNo(input, answer);
        return answer;
    }
   
    //This method is used to print the objects that are automatically made
    public static void printDB(RetailItem object){
      System.out.println(object);
    }
    
    //This method is used to print the user created object.
    public static void addedObject(RetailItem object){
      System.out.println("You have entered: "+ object);
    }
    
    //This method asks the user for the description, price, and quantity and validates the user
    //input on quantity and price.
    public static void addToDatabase(Scanner input, RetailItem object){
        String description, units, priceStr;
        double price;
        int unitsOnHand;
        
        input.nextLine(); //eats the new line character that is present from previous uses of scanner
       
        System.out.print("Please enter a description of the item: ");
        description = input.nextLine();
        description = UtilityMethods.verifyString(input, description);
        object.setDescription(description);
        
        System.out.print("Please enter the price of the item: ");
        priceStr = input.next();
        price = UtilityMethods.verifyDouble(input, priceStr);
        object.setPrice(price);
        
        System.out.print("Please enter the how many items you have on hand: ");
        units = input.next();
        unitsOnHand = UtilityMethods.verifyInt(input, units);
        object.setUnitsOnHand(unitsOnHand); 
    }
    
    //This method thanks the user for using the program and exits.
    public static void farewell(){
      System.out.println("Thank you for using the Retail Item Database Program!"+
             "\nGoodbye!");
      System.exit(0);
    }
}
