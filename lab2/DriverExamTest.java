/*
 * File: DriverExamTest.java
 * Author: Christopher Clinard 
 * Date: 2/15/2017
 * Version: 2
 * This program is used to gather the answers for a Drivers Exam and test them against the answer key.
 * once the user has completed the test it will give how many correct answers, how many incorrect, and which 
 * questions were answered incorrectly. Once that is done the program gives a farewell message indicating a 
 * pass or fail and exits the program.
 */
package lab2;

//Used for scanner
import java.util.*;

public class DriverExamTest {
    
    public static void main(String[] args){
        //Variable Declaration and Objects used
        char option;
        Scanner input = new Scanner(System.in);
        DriverExam student = new DriverExam();
        
        //zeroArray(student);
        option = welcome(input);
        if(option == 'n'){
            farewell1();
        }
        getAnswers(input, student);
        correct(student);
        incorrect(student);
        printIncorrect(student);
        if(student.Passed())
            congrats();
        else
            farewell();
    }
    
    //This method welcomes the user,gives the user instructions, and asks them if they want to begin.
    public static char welcome(Scanner input){
        char answer;
        System.out.print("Welcome to the Driver's License Testing Program!"+
                         "\nThis test has 20 questions. To pass this test you must"+
                         "\nanswer atleast 15 questions correctly. Only answers A, B, C, or D are valid.\nAre you ready to begin?"+
                         " Enter 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = UtilityMethods.askIfYesOrNo(input, answer);
        return answer;
    }
    
    //This method gets the answers from the user and puts them into the student.studentAnswers array
    public static void getAnswers(Scanner input, DriverExam student){
        String ans;
        int test;
        for(int i = 0; i < student.MAX_ARRAY_SIZE; i++){
           //Used for testing purposes to print the correct answer before each question
           //System.out.println(student.answerArray[i]);
           System.out.print("Enter your answer for question "+ (i+1)+ ":");
           student.answer = input.next().charAt(0);
           student.answer = Character.toUpperCase(student.answer);
           while(!validAnswer(student.answer)){
               System.out.print("Your answer was not 'A', 'B', 'C', or 'D'."+
                       "\nEnter a valid answer for question "+ (i+1)+ ":");
               student.answer = input.next().charAt(0);
               student.answer = Character.toUpperCase(student.answer);
           }
                   
           student.studentAnswers[i] = student.answer;
        }
        
    }
    
    //This method prints the total number of correct answers
    public static void correct(DriverExam student){
        System.out.println("You answered "+ student.totalCorrect()+ " questions correctly.");
    }
    
    //This method prints the total number of incorrect answers
    public static void incorrect(DriverExam student){
        System.out.println("You answered "+ student.totalIncorrect()+ " questions incorrectly.");
    }
    
    //This method congratulates the user for passing the exam and exits the program
    public static void congrats(){
        System.out.println("\nCongratulations you passed the exam! You will now move onto the driving test!");
        System.exit(0);
    }
    
    //This method validates the answer given to make sure it is an a, b, c, or d
    public static boolean validAnswer(char answer){
        if(answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D')
            return true;
        else
            return false;
    }
    
    //This method prints the numbers of the questions the student failed to answer correctly
    public static void printIncorrect(DriverExam student){
        if(student.questionsMissed[0] == 0){ 
            System.out.print("error"+ student.questionsMissed[0]);
            return;
        }
        else{
          System.out.print("You missed questions: ");
          for(int i = 0; i < student.MAX_ARRAY_SIZE; i++){
            if(student.questionsMissed[i] != 0)
              System.out.print(student.questionsMissed[i]+ " ");
          }
            
        }
       
    }
    
    //This farewell prints if the student did not pass and exits the program
    public static void farewell(){
        System.out.println("\nYou did not pass.\nPlease study the material and try again in 2 weeks.");
        System.exit(0);
    }
 
    //This method prints if the user is not ready to take the exam
    public static void farewell1(){
        System.out.println("Please let a test proctor know when you are ready to begin your test."+
                "\nGoodbye.");
        System.exit(0);
    }
    
    //This method zero's every element of the questionsMissed array
    public static void zeroArray(DriverExam student){
        for(int i = 0; i < student.MAX_ARRAY_SIZE; i++){
            student.questionsMissed[i] = 0;
        }
    }
}
