package atm;

import org.junit.Test;
import junit.framework.*;

public class TestBalance extends TestCase {
    
    BalanceWithReturn balance = new BalanceWithReturn();
    
    @Test
    public void testPrintBalance() {
        String result = balance.printBalance();
        assertEquals("R$ 0,00", result);
    }

    @Test
    public void testDeposit() {
        float result = balance.deposit("25");

        assertEquals(25.0f, result);
    }

    @Test
    public void testWithdraw() {
        balance.deposit("25");

        String result = balance.withdraw("2.5");

        assertEquals("22.5", result);
    }

    @Test
    public void testWithoutMoneyToWithdraw() {
        balance.deposit("25");

        String expected = "Saldo insuficiente para realizar esse saque!";
        String result = balance.withdraw("27");

        assertEquals(expected, result);
    }
}
