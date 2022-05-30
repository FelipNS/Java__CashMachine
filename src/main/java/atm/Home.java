package atm;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Home extends Balance {
    
    private String label = "Escolha uma das opções abaixo: ";
    private String o1 = "Saldo";
    private String o2 = "Extrato";
    private String o3 = "Depósito";
    private String o4 = "Saque";
    private String o5 = "Sair";
    private String[] options = {o1, o2, o3, o4, o5};
    private byte idxOfSelectedOption;

    Formatter formatter = new Formatter();
    Scanner sc = new Scanner(System.in);

    public void showOptions(){
        System.out.println(label);

        for (String txt : options) {

            byte idx = (byte) Arrays.asList(options).indexOf(txt);
            String formatedOption = String.format("%d - %s", idx+1, txt);
            
            System.out.println(formatedOption);
        }

        this.idxOfSelectedOption = (byte) (sc.nextInt() - 1); /*Set the selected option*/ 
        this.openOption();
    }
    
    public void openOption(){
        switch (this.idxOfSelectedOption){
            case 0: 
                this.printBalance(); 
                break;
            case 1: 
                stat.newRecord("Balance", this.getBalance(), new Date()); 
                stat.readOperation(); 
                break;
            case 2: 
                this.deposit(); 
                break;
            case 3: 
                this.withdraw(); 
                break;
            case 4:
                this.quit();
                break;
        }

        System.out.println(formatter.createLine(50));
        this.showOptions();
    }

    public void quit(){
        String[] allowedInputs = {"S", "s", "N", "n"};            
        
        System.out.println("Deseja encerrar a sessão? [S / N]");
        String input = sc.next();

        if (Arrays.asList(allowedInputs).contains(input)) {
            char yesOrNo = input.charAt(0);

            if (yesOrNo == 'S' || yesOrNo == 's'){
                this.bye();
                System.exit(0);
            } else if (yesOrNo == 'N' || yesOrNo == 'n') {
                System.out.println(formatter.createLine(50));
                this.showOptions();
            }

        } else {
            System.out.println("Código invalido!");
        }
    }

    public void welcome() {
        System.out.println(this.formatter.createLine(50));
        System.out.println(this.formatter.centralizer("BEM VINDO", 50));
        System.out.println(this.formatter.createLine(50));    
    }
    
    public void bye() {
        System.out.println(this.formatter.createLine(50));
        System.out.println(this.formatter.centralizer("ATÉ A PRÓXIMA", 50));
        System.out.println(this.formatter.createLine(50));    
    }
}

class Formatter {

    public String centralizer(String text, int length){
        byte totalBlanckSpaces = (byte) (length - text.length());
        String sideBlanckSpaces = ""; 

        for (byte i = 0; i <= totalBlanckSpaces / 2; i++){
            sideBlanckSpaces += " ";
        }
        
        return sideBlanckSpaces + text + sideBlanckSpaces;
    }

    public String createLine(int length) {
        String line = "";
        while (line.length() < length) {
            line += "=";
        }
        return line;
    }
}
