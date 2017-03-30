/*
 * File: EmployeeDriver.java
 * Author: Christopher Clinard
 * Date: 3/21/2017
 * This is the driver to demonstrate use of the Employee, ProductionWorker, ShiftSupervisor, and Team Leader Classes.
 * This program welcomes the user, shows them a menu with multiple choices, allows the user to choose what kind of class object they want to
 * add to the Array List made within the main. When the user is satisfied with creation of the employees the program gives them the option to exit.
 */
package lab3;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDriver {
    public static void main(String[] args){
        
        //Array List used to hold all employees the user wants to enter
        ArrayList<Employee> newEmployee  = new ArrayList<Employee>();
        
        //Scanner used for user input
        Scanner input = new Scanner(System.in);
    
        welcome();
        menu(input, newEmployee);
    
    }
  
    //This method welcomes the user and explains what the user is able to do with the program.
    public static void welcome(){

        System.out.print("Welcome to the Human Resources Management System."+
                       "\nThis program allows you to add new employees and print all employees.");
      
    }
    
    //This method shows the user a menu and allows them to pick what kind of employee they
    //want to add, print all employees Name, Number, and Date of Hire, or exit the program.
    public static void menu(Scanner input, ArrayList<Employee> newEmployee){
        String menuAns;
        int userAnswer = 0;
        
        //Infinite loop until user selected exit
        while(true){
            System.out.print("\nWhat would you like to do at this time?"+
                       "\n1) Add Employee"+ 
                       "\n2) Add Shift Supervisor"+ 
                       "\n3) Add Production Worker"+
                       "\n4) Add Team Leader"+
                       "\n5) Print employees"+
                       "\n6) Exit the Program"+
                       "\nPlease enter a choice: ");
            menuAns = input.nextLine();
            userAnswer = UtilityMethods.verifyInt(input, menuAns);
            switch(userAnswer){
                case 1: 
                    addEmployee(input, newEmployee);
                    break;
                    
                case 2:
                    addShiftSupervisor(input, newEmployee);
                    break;
            
                case 3:
                    addProductionWorker(input, newEmployee);
                    break;
            
                case 4:
                    addTeamLeader(input, newEmployee);
                    break;

                case 5:
                    printEmployees(newEmployee);
                    break;
                    
                case 6:
                    farewell();
                    
            }
        }    
    }
  
    //This method allows the user to add a new general employee
    public static void addEmployee(Scanner input, ArrayList<Employee> newEmployee){
        Employee newEmp = new Employee();
        String empNumber, empHireDate;
        System.out.print("Please enter the employee's first and last name: ");
        newEmp.setName(input.nextLine());
        System.out.print("Please enter the new employee's Employee Number.\nThe Employee Number must match XXX-L including the dash where X is a digit and L is a letter A-M: ");
        empNumber = input.nextLine();
        newEmp.setNumber(verifyEmpNum(input, empNumber));
        System.out.print("Please enter the new employee's hire date.\nMake sure the date you enter matches IX/JX/KXXX including the slashes"
                       + "\nwhere I is a 0 or 1,J is 0-3, K is a 1 or 2, and X is a digit 0-9: ");
        empHireDate = input.nextLine();
        newEmp.setDate(verifyHireDate(input, empHireDate));
      
        newEmployee.add(newEmp);
      
  }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //This method is used to verify the correctness of the employee ID number via Regular Expression
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String verifyEmpNum(Scanner input, String tempNumber){
    
        //String used for regex verification of Employee number
        String theRegex = "[0-9][0-9][0-9][-][A-Ma-m]";
    
        //While tempNumber does not match theRegex
        while(!tempNumber.matches(theRegex)){
            System.out.print("The Employee Number you entered was invalid.\nThe Employee Number must match XXX-L including the dash "
            + "where X is a digit and L is a letter A-M: ");
            tempNumber = input.nextLine();
        }
        return tempNumber;
    }   
  
    ////////////////////////////////////////////////////////////////////////////////////
    //this method verifies the hire date of an employee via Regular Expression
    ////////////////////////////////////////////////////////////////////////////////////
    public static String verifyHireDate(Scanner input, String tempDate){
    
        //String used for regex verification of input date
        String theRegex = "[0-1][0-9][/][0-3][0-9][/][1-2][0-9][0-9][0-9]";
    
        //While tempDate does not match theRegex
        while(!tempDate.matches(theRegex)){
            System.out.print("The employee's hire date you entered was invalid.\nMake sure the date you enter matches IX/JX/KXXX including the slashes"
            + "\nwhere I is a 0 or 1, J is 0-3, K is a 1 or 2, and X is a digit 0-9: ");
            tempDate = input.nextLine();
        }
        return tempDate;    
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    //This method allows the user to add a Shift Supervisor
    /////////////////////////////////////////////////////////////////////////////////////////////////
    public static void addShiftSupervisor(Scanner input, ArrayList<Employee> newEmployee){
      
        ShiftSupervisor newSupervisor = new ShiftSupervisor();
        String empNumber, empHireDate, salary, bonus;
      
        System.out.print("Please enter the employee's first and last name: ");
        newSupervisor.setName(input.nextLine());
        System.out.print("Please enter the new employee's Employee Number.\nThe Employee Number must match XXX-L including the dash where X is a digit and L is a letter A-M: ");
        empNumber = input.nextLine();
        newSupervisor.setNumber(verifyEmpNum(input, empNumber));
        System.out.print("Please enter the new employee's hire date.\nMake sure the date you enter matches IX/JX/KXXX including the slashes"
                       + "\nwhere I is a 0 or 1, J is 0-3, K is a 1 or 2, and X is a digit 0-9: ");
        empHireDate = input.nextLine();
        newSupervisor.setDate(verifyHireDate(input, empHireDate));
        System.out.print("Please enter the salary the new Supervisor will be paid as a double: ");
        salary = input.nextLine();
        newSupervisor.setSalary(UtilityMethods.verifyDouble(input, salary));
        System.out.print("Please enter the bonus the new Supervisor could be paid as a double: ");
        bonus = input.nextLine();
        newSupervisor.setBonus(UtilityMethods.verifyDouble(input, bonus));
           
        newEmployee.add(newSupervisor);
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //This method allows the user to add a production worker
    ///////////////////////////////////////////////////////////////////////////////
    public static void addProductionWorker(Scanner input, ArrayList<Employee> newEmployee){
      
      ProductionWorker newWorker = new ProductionWorker();
      String empNumber, empHireDate, shift, payRate;
      int shiftNum;
      
      System.out.print("Please enter the employee's first and last name: ");
      newWorker.setName(input.nextLine());
      System.out.print("Please enter the new employee's Employee Number.\nThe Employee Number must match XXX-L including the dash where X is a digit and L is a letter A-M: ");
      empNumber = input.nextLine();
      newWorker.setNumber(verifyEmpNum(input, empNumber));
      System.out.print("Please enter the new employee's hire date.\nMake sure the date you enter matches IX/XX/XXXX including the slashes\nwhere I is a 0 or 1 and X is a digit 0-9: ");
      empHireDate = input.nextLine();
      newWorker.setDate(verifyHireDate(input, empHireDate));
      System.out.print("Please enter the Production workers shift, 1 for day shift and 2 for night shift: ");
      shift = input.nextLine();
      shiftNum = UtilityMethods.verifyInt(input, shift);
      newWorker.setShift(verifyShift(input, shiftNum));
      System.out.print("Please enter the pay rate of the Production worker as a double: ");
      payRate = input.nextLine();
      newWorker.setPayRate(UtilityMethods.verifyDouble(input, payRate));
      
      newEmployee.add(newWorker);
  }
  
  //This method allows the user to add a team leader
  public static void addTeamLeader(Scanner input, ArrayList<Employee> newEmployee){
    
      TeamLeader newTeamLeader = new TeamLeader();
    
      String empNumber, empHireDate, monthlyBonus, trainingHours, payRate, shift, requiredTrainingHours;
      int shiftNum;
      
      System.out.print("Please enter the employee's first and last name: ");
      newTeamLeader.setName(input.nextLine());
      System.out.print("Please enter the new employee's Employee Number.\nThe Employee Number must match XXX-L including the dash where X is a digit and L is a letter A-M: ");
      empNumber = input.nextLine();
      newTeamLeader.setNumber(verifyEmpNum(input, empNumber));
      System.out.print("Please enter the new employee's hire date.\nMake sure the date you enter matches IX/XX/XXXX including the slashes\nwhere I is a 0 or 1 and X is a digit 0-9: ");
      empHireDate = input.nextLine();
      newTeamLeader.setDate(verifyHireDate(input, empHireDate));
      System.out.print("Please enter the Production Team Leader's shift, 1 for day shift and 2 for night shift: ");
      shift = input.nextLine();
      shiftNum = UtilityMethods.verifyInt(input, shift);
      newTeamLeader.setShift(verifyShift(input, shiftNum));
      System.out.print("Please enter the pay rate of the Production Team Leader as a double: ");
      payRate = input.nextLine();
      newTeamLeader.setPayRate(UtilityMethods.verifyDouble(input, payRate));
      System.out.print("Please enter the monthly bonus that the Team Leader could receive: ");
      monthlyBonus = input.nextLine();
      newTeamLeader.setMonthlyBonus(UtilityMethods.verifyDouble(input, monthlyBonus));
      System.out.print("Please enter the number of training hours that the Team Leader requires as an integer: ");
      requiredTrainingHours = input.nextLine();
      newTeamLeader.setRequiredTrainingHours(UtilityMethods.verifyInt(input, requiredTrainingHours));
      System.out.print("Please enter the number of hours that the Team Leader has already acquired: ");
      trainingHours = input.nextLine();
      newTeamLeader.setTrainingHours(UtilityMethods.verifyInt(input, trainingHours));
            
      newEmployee.add(newTeamLeader);
  }
  
  //This method prints each employee entered into the Array List
  public static void printEmployees(ArrayList<Employee> newEmployee){
      for(int i = 0; i < newEmployee.size(); i++){
        System.out.print(newEmployee.get(i).toString());
      }
  }
  
  //This method thanks the user for using them program and exits
  public static void farewell(){
      System.out.print("Thank you for using the Human Resources Mangement System.\nGoodbye!");
      System.exit(0);
  }
  
  //This method verifies the shift input from the user to make sure it is a 1 or 2
  public static int verifyShift(Scanner input, int shift){
    String tempStr;
    while(shift != 1 && shift != 2){
      System.out.print("Please enter a 1 or 2 for day shift or night shift: ");
      tempStr = input.next();
      shift = UtilityMethods.verifyInt(input, tempStr);
    }
    return shift;
  }
}
