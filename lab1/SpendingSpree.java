/*
 * File: SpendingSpree.java
 * Author: Christopher Clinard
 * Date: 1/18/2016
 * This program welcomes the user to the spending spree store and asks them if they want to use their
 * gift card now. If yes, the program allows the user to purchase at least 1 item and up to 3 items as long 
 * as the item total is not above $200.00. If the total reaches $200.00 or the item total is 3 the program
 * lets the user know how much they spent and how much is left on their gift card. If the user does not
 * want to spend their gift card right now they can exit immediately. 
 */

package lab1;
import lab2.UtilityMethods;
import java.text.NumberFormat;
import java.util.*;
public class SpendingSpree {
    
    //Setting Constants for use within the program
    final static double GIFTAMOUNT = 200.00;
    final static int NUMITEMSMAX = 3;
    
    public static void main(String[] args) {
      
        //Array Declarations for use as item lists, price lists, and items available
        String[] itemsArray = {"Vacuum", "Ball", "Calculator", "Lunch Bag",
            "Tie Clasp", "Pencil", "Pen", "Eraser", "Note Book", "Calendar"};
        String[] itemList = new String[5];
        double[] itemPrice = new double[5];
        
        //Variables declared for use within the program
        double sum = 0;
        int randomNumber, randomPrice, choice, choices = 0;
        char answer;
        
        //Number formats used to show currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        //Scanner object created for user input
        Scanner input = new Scanner(System.in);
        
        
        answer = welcome(input);
        if(answer == 'y'){
            for(int i = 0; i < 5; i++){
                itemList[i] = itemsArray[randomInt()];
                itemPrice[i] = randomDbl();
            }
            
            //Infinite loop to keep looping through the item menu as long as the item total is < 3 and
            //and the sum prices of the items are < $200.00
            while(true){
                choice = menu(currency, input, itemList, itemPrice);
                choices++;                
                if((sum+itemPrice[choice-1]) < GIFTAMOUNT && choices < NUMITEMSMAX){
                    sum += itemPrice[choice-1];
                    System.out.print("You have bought a(n) "+ itemList[choice-1]+ " for "+ currency.format(itemPrice[choice-1])+
                        ".\nYou have "+ currency.format(GIFTAMOUNT - sum)+ " left to spend."+
                        "\nWould you like to buy another item?"+
                        "\nEnter 'y' or 'n': ");
                    answer = input.next().charAt(0);
                    answer = Character.toLowerCase(answer);
                    answer = UtilityMethods.askIfYesOrNo(input, answer);
                    if(answer == 'n'){
                        if(choices > 0){    
                          farewell(currency, sum);
                        }
                    }
                    
                }
                else if(sum+itemPrice[choice-1] < GIFTAMOUNT && choices == NUMITEMSMAX){
                    sum += itemPrice[choice-1];
                    farewell(currency, sum);
                }
                else if(sum+itemPrice[choice-1] == GIFTAMOUNT){
                    sum += itemPrice[choice-1];
                    farewell(currency, sum);
                }
                else{
                    System.out.print("It seems the item you tried to purchase was more than you have left to spend."+
                            "\nWould you like to try and buy another item?"+
                            "\nType 'y' for yes or 'n' for no: ");
                    answer = input.next().charAt(0);
                    answer = Character.toLowerCase(answer);
                    answer = UtilityMethods.askIfYesOrNo(input, answer);
                    if( answer == 'n'){
                        farewell(currency, sum);
                    }
                    else{
                        
                    }   
                }
            } //ending of infinite loop
        }
        else{
            farewell(currency, sum);
        }        
    }
    
    //This method welcomes the user and asks them if they want to spend their gift card now
    //and returns the option to main.
    public static char welcome(Scanner in){
        char option, optionReturn;
        System.out.println("Welcome to the Spending Spree Store!" + 
                "\nIf you want to spend your gift card now you must"+
                "\nbuy atleast one item but no more than three items "+
                "\nand the total of the items must not exceed $200.00."+
                "\nYou may also buy the same item up to three times if it doesn't exceed $200.00.");
        System.out.print("Would you like to spend your gift card now?" +
                "\nType 'y' for yes or 'n' for no:");
        option = in.next().charAt(0);
        option = Character.toLowerCase(option);
        optionReturn = UtilityMethods.askIfYesOrNo(in, option);
        return optionReturn;
    }
    
    //This method creates a new random number object and returns it to main to dynamically create
    //an item list for the user
    public static int randomInt(){
        int randomNumber;
        Random generator = new Random();
        randomNumber = generator.nextInt(9);
        return randomNumber;
    }
    
    //This method creates a random double number to dynamically create prices for the items.
    public static double randomDbl(){
        double randomNumber;
        int rangeMin = 55;
        int rangeMax = 90;
        Random generator = new Random();
        randomNumber = rangeMin + ( rangeMax - rangeMin ) * generator.nextDouble();
        return randomNumber;
    }
    
    //This method creates and assigns the menu of the items and prices that the users are able to buy 
    //and gives them the options to buy.
    public static int menu(NumberFormat currency, Scanner input, String itemList[], double itemPrice[]){
        String choiceStr;
        int choice;
        System.out.println("The items available are as follows:");
        for(int i = 0; i < 5; i++){
            System.out.println((i+1)+ ". "+ itemList[i]+ "\t"+ currency.format(itemPrice[i]));
        }
        System.out.print("Please choose an item using numbers 1 through 5: ");
        choiceStr = input.next();
        choice = UtilityMethods.verifyInt(input, choiceStr);
        while(choice > 5 || choice < 1){
            System.out.print("Please choose an item using numbers 1 through 5: ");
            choiceStr = input.next();
            choice = UtilityMethods.verifyInt(input, choiceStr);    
        }
        return choice;        
          
    }
    
    //This method lets the customer lets the customer know how much they spent, how much is left on their 
    //gift card, thanks them for using the program, and bids them goodbye.
    public static void farewell(NumberFormat currency, double sum){
        System.out.println("You have spent "+ currency.format(sum)+ " and have "+
                currency.format(GIFTAMOUNT - sum)+ " left on your gift card."+
                "\nThanks for using the Spending Spree Store!"+
                "\nGoodbye!");
        System.exit(0);
    }
}
