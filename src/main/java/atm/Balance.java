package atm;

import java.util.Date;
import java.util.Scanner;

public class Balance {
    private float balance = 0.0f;

    Scanner sc = new Scanner(System.in);
    Statement stat = new Statement();

    public void printBalance() {
        String formatededBalance = String.format("R$ %.2f", this.balance);
        System.out.println(formatededBalance);
    }
    
    public void deposit() {
        System.out.print("Digite o valor do depósito R$");
        
        String input = sc.next();
        float value = Float.parseFloat(input);

        balance += value;

        stat.newRecord("Deposit", value, new Date());
    }
    
    public void withdraw() {
        System.out.print("Digite o valor do saque R$");

        String input = sc.next();
        float value = Float.parseFloat(input);

        float possibleBalance = this.balance - value;
        if (possibleBalance <= 0) {
            String result = "Saldo insuficiente para realizar esse saque!";
            System.out.println(result);
        }else {
            balance -= value;
            stat.newRecord("Withdraw", value, new Date());
        }
    }

    public float getBalance() {
        return this.balance;
    }
}
