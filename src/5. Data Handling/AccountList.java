/* Import Required Modules & Packages */
import java.io.*;

public class AccountList {

    /* Create an Empty Array with 100 Spaces */
    BankAccount[] allAccounts = new BankAccount[100];
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
        String data = encrypt( record.toString() );

        try {
            FileWriter myFile = new FileWriter("MyData.txt", true);
            myFile.write(data + "\r\n");
            myFile.close();
        } catch (Exception Exc) { return false; };

        return true;
    };


    /* Import Accounts from a CSV File */
    public void importAllAccounts() {
        /* Reset the data within the Array */
        allAccounts = new BankAccount[100];
        totalRecords = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("RecordsOutputCommas.txt"));

            for (String line = br.readLine(); line != null; line = br.readLine()) {

                /* Split the CSVs */
                String stringData = decrypt( line );
                String[] data = stringData.split(",");

                BankAccount newAccount = new BankAccount();
                newAccount.accountNumber = data[0];
                newAccount.sortCode = data[1];

                newAccount.setBalance( Integer.parseInt( data[2] ) );
                newAccount.maxOverdraft = Integer.parseInt( data[3] );

                newAccount.userType = data[4].charAt(0);

                /* Add the Account to the List */
                addAccountToList(newAccount);
            };
            br.close();

        } catch (Exception exc) {
            System.out.println("File Reading Error");
            exc.printStackTrace();
        };
    };

    /* Search for an Account with a SearchQuery */
    public int searchByAccountNumber(String searchQuery) { 
        for (int index = 0; index < totalRecords; index++) {
            BankAccount baTemp = allAccounts[index];

            if (baTemp.accountNumber.equals(searchQuery)) {
                return index;
            };
        };
        return -1;
    };
    public int searchBySortCode(String searchQuery) { 
        for (int index = 0; index < totalRecords; index++) {
            BankAccount baTemp = allAccounts[index];

            if (baTemp.sortCode.equals(searchQuery)) {
                return index;
            };
        };
        return -1;
    };

    /* Sort the Accounts by Balance */
    public void sortByBalance() {
        /* Loop through all the Accounts */
        for (int outer = 0; outer < totalRecords; outer++) {
            for (int inner = 0; inner < (totalRecords - 1); inner++) {

                /* Fetch Account Balances */
                int balanceOne = allAccounts[inner].getBalance();
                int balanceTwo = allAccounts[inner + 1].getBalance();

                /* Swap the values if "Bal < Bal+1" */
                /* Largest => ... => Smallest */
                if (balanceOne < balanceTwo) {
                    BankAccount swappingValue = allAccounts[inner];
                    allAccounts[inner] = allAccounts[inner + 1];
                    allAccounts[inner + 1] = swappingValue;
                };
            };
        };
    };


    /* Encrypt and Decrypt data from TXT Files */
    public String encrypt(String data) {
        String encryptedData = "";

        for (int index = 0; index < data.length(); index++) {
            int ascii = data.charAt(index) + 48; // Caeser Shift +48
            encryptedData = encryptedData + (char)ascii;
        };
        return encryptedData;
    };
    public String decrypt(String encryptedData) {
        String data = "";

        for (int index = 0; index < encryptedData.length(); index++) {
            int ascii = encryptedData.charAt(index) - 48; // Caeser Shift -48
            data = data + (char)ascii;
        };
        return data;
    };
};
