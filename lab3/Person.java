/*
 * File: Person.java
 * Author: Matt Clinard
 * Date: 3/21/17
 * This program
 */
package lab3;

public class Person {
    
    public String firstName;
    public String lastName;
    public String association;
    public String birthday;
    public String phoneNumber;
    
    /////////////////////////////////////////////
    // No arg constructor
    ////////////////////////////////////////////
    Person(){
        
    }
    
    //////////////////////////////////////////////////////////////
    // Overloaded constructor for Person class
    //////////////////////////////////////////////////////////////
    Person(String str1, String str2, String str3){
        this.firstName = str1;
        this.lastName = str2;
        this.association = str3;
    }
    
    ////////////////////////////////////////////////////////////////////
    // Secondary Overloaded constructor for Person class
    ////////////////////////////////////////////////////////////////////
    Person(String str1, String str2, String str3, String bDayStr){
        this.firstName = str1;
        this.lastName = str2;
        this.association = str3;
        this.birthday = bDayStr;
    }
    
    public void setFirstName(String str1){
        this.firstName = str1;
    }
    public void setLastName(String str1){
        this.lastName = str1;
    }
    
    public void setAssociation(String str1){
        this.association = str1;
    }
    
    public void setBirthday(String bDayStr){
        this.birthday = bDayStr;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getAssociation(){
        return this.association;
    }
    
    public String getBirthday(){
        return this.birthday;
    }
}
