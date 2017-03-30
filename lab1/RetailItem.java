/*
 * File: RetailItem.java
 * Author: Christopher Clinard
 * Date: 1/24/17
 * This class is for use in the RetailItemTest.java driver. 
 */
package lab1;

import java.text.NumberFormat;
public class RetailItem {
    
    //Declaration of variables
    private String description;
    private double price;
    private int unitsOnHand;
    
    //No Argument constructor
    public RetailItem(){
        
    }
    
    //Overloaded constructor 
    public RetailItem(String str1, double num1, int num2){
        description = str1;
        price = num1;
        unitsOnHand = num2;
    }
    
    //Setter for description string
    public void setDescription(String str1){
        description = str1;
    }
    
    //Setter for price
    public void setPrice(double num1){
        price = num1;
    }
    
    //Setter for unitsOnHand
    public void setUnitsOnHand(int num1){
        unitsOnHand = num1;
    }
    
    //Get method for description
    public String getDescription(){
        return description;
    }
    
    //Get method for price
    public double getPrice(){
        return price;
    }
    
    //Get method for unitsOnHand
    public int getUnitsOnHand(){
        return unitsOnHand;
    }
    
    //To string method to output a string
    public String toString(){
        NumberFormat formatter;
        String priceStr;
        formatter = NumberFormat.getNumberInstance();
        priceStr = formatter.format(price);
        
        
        return String.format("%-9s\t%10d\t$%.6s", description, unitsOnHand, priceStr);
    }
}
