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

}
