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



}
