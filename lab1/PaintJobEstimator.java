/*
 * File: PaintJobEstimator.java
 * Author: Christopher Clinard
 * Date: 1/24/17
 * This program estimates a paint job for a house based on number of rooms,
 * the type of paint, and the square footage of the house. Once these calculations
 * are complete it gives the user the estimated value of the job.
 */
package lab1;

//imports for Scanner and Number Formatting
import lab2.UtilityMethods;
import java.text.*;
import java.util.*;

public class PaintJobEstimator {

    public static void main(String[] args){
        char answer;
        int numRooms, sqFeet;
        double totalCost;
        
        //Arrays to hold quality and costs of paints.
        String[] paintQuality = { "Regular", "High Quality", "Premium Quality"};
        double[] paintCost = {35.00, 40.00, 45.00};
        
        //Scanner for user input
        Scanner input = new Scanner(System.in);
        
        //Formatting for Currency and Decimal format for Gallons of paint needed as well as
        //hours worked.
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        DecimalFormat decimal = new DecimalFormat("#0.00");
        
        answer = welcome(input);
        while(answer == 'y'){
            numRooms = getRooms(input);
            sqFeet = getSquareFeet(input, numRooms);
            totalCost = getTotal(input, paintQuality, paintCost, currency, decimal, sqFeet);
            answer = reCalc(input);
        }
            farewell();            
    }
    
    //This method welcomes the user and gives simple instructions.
    public static char welcome(Scanner input){
        char answer;
        System.out.print("Welcome to the Paint Job Estimator Program!"+
                "\nThis program will allow you to estimate a paint job for your house."+
                "\nAll you'll have to know is the square footage for the rooms you will need painted."+
                "\nWould you like to estimate a new paint job now?"+
                "\nType 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = Character.toLowerCase(answer);
        answer = UtilityMethods.askIfYesOrNo(input, answer);
        return answer;
        
    }
    
    //This method thanks the user for using the program and exits.
    public static void farewell(){
        System.out.println("Thanks for using the Paint Job Estimator Program!"+
                "\nGoodbye!");
        System.exit(0);
    }    
    
    //This method asks the user to enter the total number of rooms and returns the data to main.
    public static int getRooms(Scanner input){
        int roomTotal;
        String roomStr;
        System.out.print("Please enter the total number of rooms as an integer inside your house: ");
        roomStr = input.next();
        roomTotal = UtilityMethods.verifyInt(input, roomStr);
        return roomTotal;
    }
    
    //This method asks the user for the square feet of each individual room and returns the data to main.
    public static int getSquareFeet(Scanner input, int rooms){
        int nRooms = 0;
        int sum = 0;
        String sqFtStr;
        System.out.print("Please enter the total square feet from the first room: ");
        sqFtStr = input.next();
        sum = UtilityMethods.verifyInt(input, sqFtStr);
        nRooms++;
        while(nRooms != rooms){
            System.out.print("Please enter the total square feet for the next room: ");
            sqFtStr = input.next();
            sum += UtilityMethods.verifyInt(input, sqFtStr);
            nRooms++;
        }
        return sum;        
    }
    
    public static int getPricePerGallon(Scanner input, String[] quality, double[] cost, NumberFormat currency){
        String choiceStr;
        int choice = 0;
        System.out.print("We have three (3) qualities of paint to choose from: ");
        for(int i = 0; i < 3; i++){
            System.out.print("\n"+ (i+1)+ "."+ "\t"+ quality[i]+ "\t"+ currency.format(cost[i]));
        }
        while(choice != 1 && choice != 2 && choice != 3){
            System.out.print("\nWhich paint would you like to use?"+
                    "\nEnter an integer between 1 and 3 to choose your paint: ");
            choiceStr = input.next();
            choice = UtilityMethods.verifyInt(input, choiceStr);
        }
        return choice;
    }
    
    public static double getTotal(Scanner input, String[] paintQuality, double[] paintCost, NumberFormat currency, DecimalFormat decimal, double squareFeet){
        int paintChoice;
        double price, galPrice, totalGallons, totalHours, totalLabor, totalJobCost;
        paintChoice = getPricePerGallon(input, paintQuality, paintCost, currency);
        paintChoice = paintChoice - 1;
        galPrice = paintCost[paintChoice];
        price = getPaintCost(squareFeet, galPrice);
        totalHours = getHours(squareFeet);
        totalLabor = getLabor(totalHours);
        totalJobCost = price + totalLabor;
        totalGallons = getGallons(squareFeet);
        printTotals(totalGallons, totalHours, price, totalLabor, totalJobCost, currency, decimal);
        return totalJobCost;
        
    }    
        
    public static double getPaintCost(double sqFeet, double galPrice){
        double price;
        price = (sqFeet / 115) * galPrice;
        return price;
    }
    
    public static double getGallons(double sqFeet){
        double totalGallons;
        totalGallons = sqFeet/115;
        return totalGallons;
    }
    
    public static double getHours(double sqFeet){
        double totalHours;
        totalHours = (sqFeet/115) * 8;
        return totalHours;
    }
    
    public static double getLabor(double hours){
        double laborCost;
        laborCost = hours * 18.00;
        return laborCost;
        
    }
    
    public static void printTotals(double totalGallons, double totalHours, double price, double totalLabor, double totalJobCost, NumberFormat currency, DecimalFormat decimal){
        System.out.print("\nYou are needing "+ decimal.format(totalGallons)+ " gallons of paint."+
                "\nThere will be "+ decimal.format(totalHours)+ " total hours of labor."+
                "\nThe cost of the paint will be "+ currency.format(price)+ "."+
                "\nThe total labor cost will be "+ currency.format(totalLabor)+ "."+
                "\nThe total job cost will be "+ currency.format(totalJobCost)+ ".");
    }
        
    public static char reCalc(Scanner input){
        char answer;
        System.out.print("\nWould you like to calculate another job?"+
                "\nEnter 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = Character.toLowerCase(answer);
        answer = UtilityMethods.askIfYesOrNo(input, answer);
        return answer;
    }
}
