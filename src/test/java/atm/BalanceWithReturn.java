package atm;

import java.util.Scanner;
import java.util.Date;

/* Same structure that Balance class on src/CashMachine.java, except the inputs are through functions parameters and the output through return */

public class BalanceWithReturn {
    
    private float balance = 0.0f;

    Scanner sc = new Scanner(System.in);
    Statement stat = new Statement();

    public String printBalance() {
        String formatededBalance = String.format("R$ %.2f", this.balance);
        System.out.println(formatededBalance);

        return formatededBalance;
    }
    
    public float deposit(String input) {
        float value = Float.parseFloat(input);

        balance += value;

        stat.newRecord("Deposit", value, new Date());

        return this.balance;
    }
    
    public String withdraw(String input) {
        float value = Float.parseFloat(input);
        
        float possibleBalance = this.balance - value;
        if (possibleBalance < 0) {
            String result = "Saldo insuficiente para realizar esse saque!";
            return result; 
        }
        this.balance -= value;
        stat.newRecord("Withdraw", value, new Date());

        return "" + this.balance;
    }
}
