package edu.aep.finalProject;

//Understands the different banking operations a customer can do.
public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    double hypotheticalInterestBalance;
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

    //mehtod for showing previous transaction
    void getPreviousTransaction (){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occured.");
        }
    }

    //method for calculating the interest on current funds after a number of years
    void calculateInterest (int years){
        double interestRate = 0.02;
        double newBalance = balance * Math.pow(1 + interestRate,years);
        hypotheticalInterestBalance = newBalance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years your balance will be " + newBalance);
    }





}
