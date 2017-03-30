/*
 * File: Employee.java
 * Author: Christopher Clinard
 * Date: 3/21/2017
 * This class is for use with the EmployeeDriver.java program
 */
package lab3;

public class Employee {
  public String name;
  public String number;
  public String date;
  
  Employee(){
      
  }
  
  public void setName(String str1){
    this.name = str1;
  }
  
  public void setNumber(String str1){
    this.number = str1;
  }
  
  public void setDate(String str1){
    this.date = str1;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getNumber(){
    return this.number;
  }
  
  public String getDate(){
    return this.date;
  }
  
  public String toString(){
    return name+ " "+ number+ " "+ date+ "\n";
  }
}
