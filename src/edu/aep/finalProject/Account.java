package edu.aep.finalProject;

//Understands the different banking operations a customer can do.
public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    //METHODS

    //method for depositing money
    void deposit (int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //method for withdrawing
    void withdraw (int amount){
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }





}
