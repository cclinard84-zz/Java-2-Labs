/*
 * File: ShiftSupervisor.java
 * Author: Christopher Clinard
 * Date: 3/21/2017
 * This class is for use with the EmployeeDriver.java program
 */
package lab3;

public class ShiftSupervisor extends Employee{
  
  public double salary;
  public double bonus;
  
  ShiftSupervisor(){
    
  }
  
  ShiftSupervisor(double num1, double num2){
    this.salary = num1;
    this.bonus = num2;
  }
  
  public void setSalary(double num1){
    this.salary = num1;
  }
  
  public void setBonus(double num1){
    this.bonus = num1;
  }
  
  public double getSalary(){
    return this.salary;
  }
  
  public double getBonus(){
    return this.bonus;
  }
  
}
