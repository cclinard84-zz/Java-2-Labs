/*
 * File: AddressBookDriver.java
 * Author: Christopher Clinard
 * Date: 3/25/2017
 * This program utilizes the Person, Address, and AddressBook classes to create a contact list.
 * This is completed by reading in all information from an "Addresses.txt" file and put into an
 * Array List. Once the information is read in the data is sorted in alphabetical order by last name.
 * The user is then presented with a menu to navigate through the program so they can search by last name,
 * search by birth month, and output all contacts to a file to serve as a backup of any data they entered.
 * Once the user is done using the program the menu also has an option to exit the program.
 * 
 */
package lab3;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class AddressBookDriver{
  public static void main(String[] args) throws Exception{
      
        //Array List that holds as many entries as the user needs 
        ArrayList<AddressBook> aBook = new ArrayList<AddressBook>();
        
        
        File inputFile = new File("addresses.txt");
        Scanner input = new Scanner(inputFile);
        Scanner in = new Scanner(System.in);
      
        welcome();
        readData(inputFile, aBook);
        sortArray(aBook);
        menu(in, aBook);

      
      
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    // This method welcomes the user and gives them some instructions on how to use the program
    /////////////////////////////////////////////////////////////////////////////////////////////
    public static void welcome(){
      System.out.print("Welcome to your Address Book Program!"+
                       "\nThis program allows you to input new contacts into the addressbook"+
                       "sort them by last name,\nseach for a person by their last and view their contact "+
                       "info, print names of people whose birthdays are in a given month,"+
                       "\nand output all contact information to a file in alphabetical order by last name.");
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    // This method reads the data from a file and puts it in the ArrayList of type AddressBook
    //////////////////////////////////////////////////////////////////////////////////////////////
    public static void readData(File inputFile, ArrayList<AddressBook> aBook) throws Exception{
        
        //Open the File
        FileReader freader = new FileReader(inputFile);
        BufferedReader in = new BufferedReader(freader);
        
        //TempStrings to hold incoming data
        String tempName, tempFName, tempLName, tempBDay, tempPhoneNumber, tempAssociation, tempAddress, tempCStateZip, tempCity, tempState, tempZip;
        String[] names = new String[2];
        String[] cStateZip = new String[3];
        
        //While not EOF read data into a new entry
        while(in.ready()){
            tempName = in.readLine();
            names = tempName.split(" ");
            tempFName = names[0];
            tempLName = names[1];        
            tempAssociation = in.readLine();        
            tempBDay = in.readLine();        
            tempAddress = in.readLine();        
            tempCStateZip = in.readLine();
            cStateZip = tempCStateZip.split(" ");
            tempCity = cStateZip[0];
            tempState = cStateZip[1];
            tempZip = cStateZip[2];
            tempPhoneNumber = in.readLine();
        
            aBook.add(new AddressBook(tempAddress, tempCity, tempState, tempZip, tempFName, 
                    tempLName, tempAssociation, tempBDay, tempPhoneNumber));
        }
        in.close();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // This method creates a menu for the user and allows them to navigate the program based
    // on what they want to do.
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static void menu(Scanner in, ArrayList<AddressBook> aBook){
        String tempAns;
        int userAns = 0;
        
        while(true){
            System.out.print("Please choose one of the following menu items:"+
                         "\n1) Search for a contact by last name."+
                         "\n2) Print names of all contacts with birthday in a given month."+
                         "\n3) Output all contact information to a file."+
                         "\n4) Exit the Address Book Program.");
            tempAns = in.nextLine();
            userAns = UtilityMethods.verifyInt(in, tempAns);
            while(userAns < 1 || userAns > 4){
                System.out.print("Invalid menu selection. Please choose one of the following menu items:"+
                         "\n1) Search for a contact by last name."+
                         "\n2) Print names of all contacts with birthday in a given month."+
                         "\n3) Output all contact information to a file."+
                         "\n4) Exit the Address Book Program.\n"); 
                tempAns = in.nextLine();
                userAns = UtilityMethods.verifyInt(in, tempAns);
            }
            switch(userAns){
                case(1):
                    searchPerson(in, aBook);
                    break;
                case(2):
                    printBirthdays(in, aBook);
                    break;
                case(3):
                    try{
                        outputFile(aBook);
                    }
                    catch(Exception e){
                        System.out.print("Could not output to file.");
                    }
                    break;
                case(4):
                    System.exit(0);
            }
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // This method asks for the last name of the user and if found prints pertinent information. 
    // If the last name is not found an error message will print.
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public static void searchPerson(Scanner in, ArrayList<AddressBook> aBook){
      
      String userInput;
      String tempContact;
      boolean found = false;
      System.out.print("Please enter the last name of the contact you are searching for: ");
      userInput = in.nextLine();
      userInput = userInput.toLowerCase();
      for(int i = 0; i < aBook.size(); i++){
        tempContact = aBook.get(i).lastName;
        tempContact = tempContact.toLowerCase();
        if(tempContact.equals(userInput)){
          System.out.print("\n\nName: "+ aBook.get(i).firstName+ " "+ aBook.get(i).lastName+ "\n"+ 
                          "Address: "+ aBook.get(i).streetAddress + "\n"+ "         "+
                          aBook.get(i).city+ ", "+ aBook.get(i).state+ " "+ aBook.get(i).zipCode+ "\n"+
                          "Phone Number: "+ aBook.get(i).phoneNumber+ "\n"+ 
                          "Birthday: "+ aBook.get(i).birthday + "\n\n");
          found = true;
        }
        
        if(i+1 == aBook.size() && found == false){
            System.out.print("\nThere are no contacts found using the last name you entered.\n\n");            
        }
      }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // This method asks the user for the month they wish to search for and searches through 
    // through the ArrayList to find any matches. If a match is found a printout of the contacts
    // first and last name will be printed.
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void printBirthdays(Scanner in, ArrayList<AddressBook> aBook){
        
        String[] bdayArray = new String[3];
        String tempBD;
        String userInput;
        boolean found = false;
        
        System.out.print("Please enter the birth month you wish to see what contacts have birthdays in that month: ");
        userInput = in.next();
        
        for(int i = 0; i < aBook.size(); i++){
            tempBD = aBook.get(i).birthday;
            bdayArray = tempBD.split("/");
            if(bdayArray[0].equals(userInput)){
                System.out.print("Name: "+ aBook.get(i).firstName+ " "+ aBook.get(i).lastName+ "\n\n");
                found = true;
            }
            if(i+1 == aBook.size() && found == false){
                System.out.print("\nThere are no contacts with birthdays in this month.\n\n");
            }
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    // This method crates an output file prints all contact information into the output.txt 
    // file.
    ////////////////////////////////////////////////////////////////////////////////////////////
    public static void outputFile(ArrayList<AddressBook> aBook) throws Exception{
       String filename = "output.txt";
       FileWriter fwriter = new FileWriter(filename); 
       PrintWriter outputFile = new PrintWriter(fwriter);
       
       for(int i = 0; i < aBook.size(); i++){
           
           outputFile.println(aBook.get(i).firstName+ " "+ aBook.get(i).lastName);
           outputFile.println(aBook.get(i).association);
           outputFile.println(aBook.get(i).birthday);
           outputFile.println(aBook.get(i).streetAddress);
           outputFile.println(aBook.get(i).city+ ","+ aBook.get(i).state+ " "+
                   aBook.get(i).zipCode);
           outputFile.println(aBook.get(i).phoneNumber);
           
       }
       System.out.print("\nFile Write successful!");
       outputFile.close();
       System.out.print("\n"+ filename+ " is closed.\n\n");
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Sorts the Array using an instance of Comparator to get around having to use an abstract class.
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void sortArray(ArrayList<AddressBook> aBook){
        Collections.sort(aBook, new Comparator<AddressBook>(){
            public int compare(AddressBook aBook2, AddressBook aBook1){
                return aBook2.lastName.compareToIgnoreCase(aBook1.lastName);
            } 
        });
      
    }
}
