/*
 * File: DriverExam.java
 * Author: Christopher Clinard
 * Date: 2/14/2017
 * This class is used for the DriverExamTest.java program.
 */
package lab2;

public class DriverExam {
  
    //Constants declared that were used more than once
    public final int MAX_ARRAY_SIZE = 20;
    public final int MIN_ANS_TO_PASS = 15;
    
    //Arrays to hold the answer key, students answers, and questions missed.
    public char[] answerArray = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B',
                          'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
    public char[] studentAnswers = new char[MAX_ARRAY_SIZE];
    public int[] questionsMissed = new int[MAX_ARRAY_SIZE];
    
    char answer;
    
    //No arg constructor used to create new objects of the DriverExam class
    DriverExam(){
        
    }
    
    //This method returns true if the student answers 15 or more questions
    //otherwise this method returns false.
    public boolean Passed(){
        if(totalCorrect() >= MIN_ANS_TO_PASS) {
            return true;
        }       
        return false;
    }
    
    //This method keeps track of the number of correct answers by checking them against the answerArray
    //and keeping a running total.
    public int totalCorrect(){
        int numCorrect = 0;
        for(int i = 0; i < MAX_ARRAY_SIZE; i++){
            if(answerArray[i] == studentAnswers[i]){
                numCorrect++;
            } 
            else {
            }
        }
        return numCorrect;
    }
    
    //This method keeps track of the number incorrect answers by checking them against the answerArray
    //and keeping a running total. This method also keeps track of which questions were missed.
    public int totalIncorrect(){
        int numWrong = 0;
        for(int i = 0; i < MAX_ARRAY_SIZE; i++){
            if(studentAnswers[i] != answerArray[i]){
                questionsMissed[numWrong] = (i+1);
                numWrong++;
            }
        }
        return numWrong;
    }
}
