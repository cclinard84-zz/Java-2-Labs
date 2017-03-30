/*
 * File: Address.java
 * Author: Matt Clinard
 * Date: 3/21/17
 * This class is for use with the AddressBookDriver.java file.
 */
package lab3;


public class Address extends Person {
    
    public String streetAddress;
    public String city;
    public String state;
    public String zipCode;
    
    ///////////////////////////////////////////////////////////////////////
    // No arg constructor for Address Class
    ///////////////////////////////////////////////////////////////////////
    public Address(){
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Overloaded constructor for Address class
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Address(String address, String cities, String states, String zip, String fName, String lName, String association, String bDay){
        this.streetAddress = address;
        this.city = cities;
        this.state = states;
        this.zipCode = zip;
        this.firstName = fName;
        this.lastName = lName;
        this.association = association;
        this.birthday = bDay;
    }
    
    public void setAddress(String str1){
        this.streetAddress = str1;
    }
    
    public void setCity(String str1){
        this.city = str1;
    }
    
    public void setState(String str1){
        this.state = str1;
    }
    
    public void setZip(String str1){
        this.zipCode = str1;
    }
    
    public String getAddress(){
        return this.streetAddress;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public String getState(){
        return this.state;
    }
        
    public String getZip(){
        return this.zipCode;
    }
    
    public String toString(){
        return (this.firstName+ " "+ this.lastName);
    }
}
