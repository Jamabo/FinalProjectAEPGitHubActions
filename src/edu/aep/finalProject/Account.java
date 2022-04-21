package edu.aep.finalProject;

import java.util.Scanner;

//Understands the different banking operations a customer can access.
public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    int additionalSavingsNeeded;
    double hypotheticalInterestBalance;
    double hypotheticalBalanceAfterBondInvest;
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
        int newBalance = (int) (balance * Math.pow(1 + interestRate,years));
        hypotheticalInterestBalance = newBalance; //hypotheticalInterestRateBalance introduced for testing purposes
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years your balance will be " + newBalance);
    }

    void sendMoney (Account ReceiverAccount, int amount){
        balance = balance - amount;
        ReceiverAccount.balance = ReceiverAccount.balance + amount;
    }

    boolean checkRetirement (int age, int lifeExpectancy, int yearlyExpenses){
        int yearsToBeCovered = lifeExpectancy - age;
        if (yearlyExpenses * yearsToBeCovered <= balance){
            return true;
        }
        else
        return false;
    }

    void calculateAdditionalSavingsNeededForRetirement (int age, int lifeExpectancy, int yearlyExpenses){

        if (checkRetirement(age, lifeExpectancy, yearlyExpenses) == false){
            additionalSavingsNeeded = (lifeExpectancy - age) * yearlyExpenses - balance;
            System.out.println("You need to save an additional $" + additionalSavingsNeeded +" to retire.");
        }
    }

    boolean checkBalanceSufficiency (int amount){
        if (amount <= balance) return true;
        return false;
    }

    void investInBond (int investmentAmount, int interestRate, int years){
    if (checkBalanceSufficiency(investmentAmount)){
        hypotheticalBalanceAfterBondInvest = (int)((balance - investmentAmount) + investmentAmount * Math.pow(1 + (double)interestRate/100,years));
    }
    else
        System.out.println("You do not have enough money in your bank account for this investment.");
    }

    void openNewAccount (int startMoney, String newAccountName) {
        Account newAccount = new Account(newAccountName, "A0002");
        newAccount.balance = startMoney;
        balance = balance - startMoney;
    }

    void closeAccount() {
        int cashPayout = balance;
        balance = balance - cashPayout;
        //set status_active boolean to false
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
        System.out.println("F. Send money");
        System.out.println("G. Check if retirement possible");
        System.out.println("H. Calculate additional savings needed for retirement");
        System.out.println("I. Invest in bond");
        System.out.println("J. Open new (sub)account");
        System.out.println("K. Exit");


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
                //send money
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
                break;
            case 'G':
                //retirement possible?
                System.out.println("Enter your age: ");
                int age = scanner.nextInt();
                System.out.println("Enter your life expectancy: ");
                int lifeExpectancy = scanner.nextInt();
                System.out.println("Enter your estimated yearly expenses: ");
                int yearlyExpenses = scanner.nextInt();
                if (checkRetirement(age, lifeExpectancy, yearlyExpenses) == true){
                    System.out.println("Congratulations! You have enough money in the bank to retire.");
                } else
                    System.out.println("You do not have enough money in the bank to retire. We hope your job is fulfilling. Think about starting to invest with us.");
                break;
            case 'H':
                //calculate additionally needed savings for retirement
                System.out.println("Enter your age: ");
                int age2 = scanner.nextInt();
                System.out.println("Enter your life expectancy: ");
                int lifeExpectancy2 = scanner.nextInt();
                System.out.println("Enter your estimated yearly expenses: ");
                int yearlyExpenses2 = scanner.nextInt();
                if (checkRetirement(age2,lifeExpectancy2,yearlyExpenses2)==true){
                    System.out.println("You have enough money in the bank to retire. No need to save more.");
                } else calculateAdditionalSavingsNeededForRetirement(age2,lifeExpectancy2,yearlyExpenses2);
                break;

            case 'I':
                //invest in bond
                System.out.println("Enter the amount you want to invest in a bond: ");
                int amountInvest = scanner.nextInt();

                System.out.println("Enter the interest rate (in %) the investment promises: ");
                int interestRateBond = scanner.nextInt();

                System.out.println("Enter the number of years you want to invest: ");
                int investmentYears = scanner.nextInt();

                investInBond(amountInvest, interestRateBond, investmentYears);
                System.out.println("Your future bank balance after this investment would be $" + hypotheticalBalanceAfterBondInvest);
                System.out.println("This means that the investment yields a profit of $" + (hypotheticalBalanceAfterBondInvest-balance));
                break;
            case 'J':
                //open new account
                System.out.println("Enter the name for the new account: ");
                String newAccountName = scanner.next();

                System.out.println("Enter the amount you want to transfer as a starting balance of the new account: ");
                int startMoney = scanner.nextInt();

                openNewAccount(startMoney, newAccountName);
                System.out.println("Great! You have opened a new account with the name " + newAccountName + " and an initial balance of $" + startMoney + ".");
                break;
            case 'K':
                //close account
                System.out.println("We understand you want to close your account. We will now pay out your remaining balance of $" + balance + ". Thank you.");
                closeAccount();
                break;
            case 'L':
                //exit
                System.out.println("==========================================");
                break;
            default:
                System.out.print("Error: Invalid Option. Please enter one of the letters above.");
                break;
        }
        }
            while(option != 'L');
            System.out.println("Thank you for banking with us.");
    }





}
