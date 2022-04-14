package edu.aep.finalProject;

import java.util.Scanner;

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

    //method for showing previous transaction
    void getPreviousTransaction (){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn or sent: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occured.");
        }
    }

    //method for calculating the interest on current funds after a number of years
    void calculateInterest (int years){
        double interestRate = 0.02;
        double newBalance = balance * Math.pow(1 + interestRate,years);
        hypotheticalInterestBalance = newBalance; //hypotheticalInterestRateBalance introduced for testing purposes
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years your balance will be " + newBalance);
    }

    void sendMoney (Account ReceiverAccount, int amount){
        balance = balance - amount;
        ReceiverAccount.balance = ReceiverAccount.balance + amount;
    }



    //method for showing the main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check you balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Send Money");
        System.out.println("G. Exit");


    do {
        System.out.println();
        System.out.println("Enter an option: ");
        char option1 = scanner.next().charAt(0);
        option = Character.toUpperCase(option1);
        System.out.println();

        switch (option){
            case 'A':
                //check account balance
                System.out.println("==========================================");
                System.out.println("Balance = $" + balance);
                System.out.println("==========================================");
                System.out.println();
                break;
            case 'B':
                //deposit money
                System.out.println("Enter an amount to deposit: ");
                int amount = scanner.nextInt();
                deposit(amount);
                System.out.println();
                break;
            case 'C':
                //withdraw money
                System.out.println("Enter an amount to withdraw: ");
                int amount2 = scanner.nextInt();
                withdraw(amount2);
                System.out.println();
                break;
            case 'D':
                //view previous transaction
                System.out.println("==========================================");
                getPreviousTransaction();
                System.out.println("==========================================");
                System.out.println();
                break;
            case 'E':
                //calculates balance with interest
                System.out.println("Enter over how many years you want to compound interest: ");
                int years = scanner.nextInt();
                calculateInterest(years);
                break;
            case 'F':
             //   send money
                System.out.println("Enter the name of the receiver: ");
                String customerName = scanner.next();
                Account Receiver = new Account (customerName,"A00003"); //Hacky
                System.out.println();
                System.out.println("Enter the amount to be sent: ");
                int amountToBeSent = scanner.nextInt();
                sendMoney(Receiver,amountToBeSent);
                System.out.println("You have sent $" + amountToBeSent + " to " + Receiver);
                System.out.println("==========================================");
                System.out.println("Your new balance is: $" + balance);

            case 'G':
                //exit
                System.out.println("==========================================");
                break;
            default:
                System.out.print("Error: Invalid Option. Please enter one of the letters above.");
                break;
        }
        }
            while(option != 'G');
            System.out.println("Thank you for banking with us.");
    }





}
