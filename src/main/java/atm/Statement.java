package atm;

import java.util.ArrayList;
import java.util.Date;

public class Statement {

    Formatter formatter = new Formatter();
    private ArrayList<String> statment = new ArrayList<String>();

    public void newRecord(String operation, float value, Date dateOperation) {
        String record = String.format("%s | %s       | R$ %.2f", dateOperation, operation, value); 
        statment.add(record); 
    }

    public void readOperation(){
        for (String record : statment) {
            System.out.println(record);
        }        
    }
}