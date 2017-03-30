/*
 * File: 
 * Author:
 * Date:
 * This program
 */
package lab1;

public class Test {
    public static void main(String[] args){
        int i = 3, j = 5;
        
        System.out.println(sum(i, j));
        printSum(i,j);
        
        int x = 1;
        p(x);
        System.out.println("x is "+ x+ ".");
        
        System.out.println("The grade is "+ getGrade(78.5)+ ".");
    }
    
    public static int sum(int i, int j){
        int sum;
        sum = i + j;
        return sum;
    }
    
    public static void printSum(int i, int j){
        System.out.println(sum(i,j));
        
    }
    
    public static void p(int x){
        x = x + 1;
    }
    
    public static char getGrade(double score){
        if(score >= 90.0)
            return 'A';
        else if(score >= 80.0)
            return 'B';
        else if(score >= 70.0)
            return 'C';
        else if(score >= 60.0)
            return 'D';
        else
            return 'F';
    }
                    
}
