package edu.aep.finalProject;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    //Tests deposit method
    @Test
    public void DepositingTwoThousandIntoNewAccountWithBalanceZeroShouldMakeBalanceTwoThousand(){
        Account testAccount = new Account("test","testID");
        testAccount.deposit(2000);
        assertEquals(2000, testAccount.balance);
    }

    //Tests withdraw method
    @Test
    public void WithdrawingTwoThousandFromNewAccountWithBalanceZeroShouldMakeBalanceNegativeTwoThousand(){
        Account testAccount = new Account("test","testID");
        testAccount.withdraw(2000);
        assertEquals(-2000, testAccount.balance);
    }

  //Tests interest calculation
    @Test
    public void OneThousandWithTwoPercentInterestOverFiveYearsShouldGiveUsANewBalanceOf1104()
    {
        Account testAccount = new Account("test","testID");
        testAccount.deposit(1000);
        testAccount.calculateInterest(5);
        assertEquals(1104,(int)(testAccount.hypotheticalInterestBalance));
    }

    //Tests sendMoney
    @Test
    public void SendingOneThousandToOtherAccountShouldLowerBalanceByOneThousand()
    {
        Account testSendAccount = new Account("sender","testID");
        Account testReceiveAccount = new Account ("receiver", "testID");
        testSendAccount.deposit(1000);
        testSendAccount.sendMoney(testReceiveAccount, 1000);
        assertEquals(0,testSendAccount.balance);
    }

    //Tests checkRetirement
    @Test
    public void RetirementCheckShouldWorkWithFollowingInput()
    {
        Account testAccount = new Account("test","testID");
        testAccount.deposit(1000000);
        assertEquals(true,testAccount.checkRetirement(50, 80, 20000));
    }

    @Test
    public void RetirementCalculatorShouldAskForXAdditionalSavings(){
        Account testAccount = new Account("test","testID");
        testAccount.deposit(1);
        testAccount.calculateAdditionalSavingsNeededForRetirement(50,100,1);
        assertEquals(49,testAccount.additionalSavingsNeeded);
    }

    @Test
    public void DepositOf2000ShouldBeEnoughToPay1000 (){
        Account testAccount = new Account("test","testID");
        testAccount.deposit(2000);
        assertEquals(true, testAccount.checkBalanceSufficiency(1000));
    }

    @Test
    public void DepositOf500ShouldNotBeEnoughToPay1000 (){
        Account testAccount = new Account("test","testID");
        testAccount.deposit(500);
        assertEquals(false, testAccount.checkBalanceSufficiency(1000));
    }

   /** @Test
    public void Investing10kInBondAt5PercentFor2YearsShouldYield11025(){
        Account testAccount = new Account("test","testID");
        testAccount.deposit(20000);
        testAccount.investInBond(50,100,1); //investmentAmount, interestRate, years
        assertEquals(11025,testAccount.hypotheticalBalanceAfterBondInvest);
    }
   **/
}
