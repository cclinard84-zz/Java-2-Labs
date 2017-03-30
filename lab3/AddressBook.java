/*
 * File: AddressBook.java
 * Author: Matt Clinard
 * Date: 3/21/17
 * This program is for use with the AddressBookDriver.java program.
 */
package lab3;



public class AddressBook extends Address {
    
    //////////////////////////////////////////////////
    // No Arg Constructor for Addressbook class
    //////////////////////////////////////////////////
    AddressBook(){
      
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // Overloaded Constructor for the AddressBook class
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    AddressBook(String address, String cities, String states, String zip, 
            String fName, String lName, String association, String bDay, String phoneNumber){
        this.streetAddress = address;
        this.city = cities;
        this.state = states;
        this.zipCode = zip;
        this.firstName = fName;
        this.lastName = lName;
        this.association = association;
        this.birthday = bDay;
        this.phoneNumber = phoneNumber;
    }
}
    
