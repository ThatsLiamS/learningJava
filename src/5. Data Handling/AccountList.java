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

            System.out.println("Record Added.");
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

    /* Search for a Specific Element and use .toString() */
    public void outputAccount(int index) {
        BankAccount myRecord = allAccounts[index];
        System.out.println(myRecord.toString());
    };
};
