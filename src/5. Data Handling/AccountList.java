/* Import Required Modules & Packages */
import java.io.FileWriter;

public class AccountList {

    /* Create an Empty Array with 20 Spaces */
    BankAccount[] allAccounts = new BankAccount[20];
    int totalRecords = 0;
    
    /* Add a BankAccount to the Array */
    public void addAccountToList(BankAccount record) {
        
        /* Is there Space in the Array */
        if (totalRecords < allAccounts.length) {
            allAccounts[totalRecords] = record;
            totalRecords = totalRecords + 1;

            /* Export to the CSV */
            boolean status = exportAccount(record);
            String response = (status == true) ? "and Exported" : "but not Exported";
            
            System.out.println("Record Added %s.".formatted(response));
        }
        else { /* The Array has been Filled */
            System.out.println("Database is full...");
        };
    };

    /* Loop through the Array and run .toString() on every Element */
    public void outputAllAccounts() {
        
        for (int index = 0; index < totalRecords; index++) {
            BankAccount myRecord = allAccounts[index];
            System.out.println(myRecord.toString());
        };
    };
    /* Export all Accounts to a CSV File */
    public void exportAllAccounts() {

        try {
            FileWriter myFile = new FileWriter("MyData.txt", false);

            for (int index = 0; index < totalRecords; index++) {
                BankAccount myRecord = allAccounts[index];
                myFile.write(myRecord.toString() + "\r\n");
            };

            myFile.close();
            System.out.println("Successfully exported all accounts.");

        } catch (Exception Exc) {
            System.out.println("Woah. An error occurred.");
        };
    };

    
    /* Search for a Specific Element and use .toString() */
    public void outputAccount(int index) {
        BankAccount myRecord = allAccounts[index];
        System.out.println(myRecord.toString());
    }; 
    /* Export a Specific Account to a CSV File */
    public boolean exportAccount(BankAccount record) {
        try {
            FileWriter myFile = new FileWriter("MyData.txt", true);

            myFile.write(record.toString() + "\r\n");
            myFile.close();

        } catch (Exception Exc) {
            return false;
        };

        return true;
    };
};
