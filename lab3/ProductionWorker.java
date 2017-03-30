/*
 * File: ProductionWorker.java
 * Author: Christopher Clinard
 * Date: 3/21/2017
 * This class is for use with the EmployeeDriver.java program
 */
package lab3;
import java.util.*;
public class ProductionWorker extends Employee {
  public int shift;
  public double payRate;
  public Scanner input = new Scanner(System.in);
  
  ProductionWorker(){
      
  }
  
  ProductionWorker(int num1, double num2){
    this.shift = num1;
    this.payRate = num2;
  }
  
  public void setShift(int num1){
      this.shift = num1;
  }
  
  public void setPayRate(double num1){
    this.payRate = num1;
  }
  
  public int getShift(){
    return this.shift;
  }
  
  public double getPayRate(){
    return this.payRate;
  }
}
