/* Import Required Modules & Packages */
import java.util.Scanner;

public class BankAccount {

    /* Declare Global Variables */
    public String accountNumber;
    public String sortCode;
    private int balance = 0;
    public int maxOverdraft = -1000;
    public char userType = 'C';

    public void setAllValues() {
        /* Reset These Values */
        accountNumber = "";
        sortCode = "";

        Scanner inputScanner = new Scanner(System.in);

        /* Enter AccountNumber as 8 Digits: 12345678 */
        while (accountNumber.matches("\\d{8}") == false) {
            System.out.print("Enter Account Number: ");
            accountNumber = inputScanner.nextLine();
        };

        /* Enter SortCode as 6 Digits: 123456 */
        while (sortCode.matches("\\d{6}") == false) {
            System.out.print("Enter SortCode: ");
            sortCode = inputScanner.nextLine();
        };

        inputScanner.close();

        /* Automatically Set These Values */
        balance = 0;
        maxOverdraft = -1000;
        userType = 'C';
    };
    
    /* Return a Comma Separation List of the Attributes */
    public String toString() {
        return "%s,%s,%s,%s,%s".formatted(
            accountNumber,
            sortCode,
            balance,
            maxOverdraft,
            userType
        );
    };

    /* Add an Amount to the Balance */
    public void makeDeposit(int amount) {
        balance = balance + amount;
        System.out.println("Your new balance is £" + balance + ".00");
    };

    /* Subtract an Amount from the Balance */
    public void makeWithdrawal(int amount) {
        balance = balance - amount;

        /* Compare with the MaxOverdraft Limit */
        if (balance < maxOverdraft) {
            System.out.println("You cannot withdraw £%s and go past the £%s overdraft...".formatted(
                amount, maxOverdraft
            ));
            balance = balance + amount;
            return;
        };
        System.out.println("Your new balance is £" + balance + ".00");
    };

    /* Fetch the Value of the Balance */
    public int getBalance() {
        return balance;
    };
};
