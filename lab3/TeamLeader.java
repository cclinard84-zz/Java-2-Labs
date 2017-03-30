/*
 * File: TeamLeader.java
 * Author: Christopher Clinard
 * Date: 3/21/2017
 * This class is for use with the EmployeeDriver.java program
 */
package lab3;

public class TeamLeader extends ProductionWorker{
  
  public double monthlyBonus;
  public int requiredTrainingHours;
  public int trainingHours;
  
  TeamLeader(){
    
  }
  
  TeamLeader(int num1, double num2, double num3, int num4){
   super(num1, num2);
   this.monthlyBonus = num3;
   this.trainingHours = num4;
  }
  
  public void setMonthlyBonus(double num1){
    this.monthlyBonus = num1;
  }
  
  public void setRequiredTrainingHours(int num1){
    this.requiredTrainingHours = num1;
  }
  
  public void setTrainingHours(int num1){
    this.trainingHours = num1;
  }
  
  public double getMonthlyBonus(){
    return this.monthlyBonus;
  }
  
  public int getRequiredTrainingHours(){
    return this.requiredTrainingHours;
  }
  
  public int getTrainingHours(){
    return this.trainingHours;
  }
}
