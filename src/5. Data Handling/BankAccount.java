import java.util.Scanner;
import java.io.FileWriter;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

/**
 * This class conforms to the regulations set forth within the
 * "Bank Project" EBook's Day 1 Task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class BankAccount
{
	private String accountNumber;
	private String sortCode;
	
	private int balance;
	private int maxOverdraft;
	
	private char userType;
	

	/**
	 * GETTER
	 * 
	 * This method will return the current value of the balance variable
	 * 
	 * @return  Integer value of the balance
	 */
	public int getBalance()
	{
		return balance;
	}
	/**
	 * GETTER
	 * 
	 * This method will return the current value of the accountNumber variable
	 * 
	 * @return  String value of the account number
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}
	/**
	 * GETTER
	 * 
	 * This method will return the current value of the sortCode variable
	 * 
	 * @return  String value of the sortCode
	 */
	public String getSortCode()
	{
		return sortCode;
	}
	
	/**
	 * SETTER
	 * 
	 * This method will set the current value of the balance variable
	 * 
	 * @param     amount   New balance amount
	 * @return             Setter Successful Flag
	 */
	public boolean setBalance(int amount)
	{
		if (amount < maxOverdraft)
		{
			System.out.println("setBalance: unsuccessful ~ cannot exceed maxoverdraft");
			return false;
		}
		
		balance = amount;
		System.out.println("setBalance: balance is now £" + balance);

		return true;
	}
	
	
	
	/**
	 * This method will deposit an amount into
	 * the user's balance and will record the
	 * transaction in a BankStatement file.
	 * 
	 * @param     Amount to be deposited
	 * @return    Deposit Successful Flag
	 */
	public boolean evidencedDeposit(int amount)
	{
		boolean status = debugMakeDeposit(amount);
		
		if (status == false)
		{
			System.out.println("evidencedDeposit: unsuccessful ~ invalid amount provided");
			return false;
		}
		
		try {
			FileWriter file = new FileWriter("BankStatements.txt", true);
			
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime currentTime = LocalDateTime.now();

			
			String statement = "%s  ~~  Deposit: £%s  ~~  Balance: £%s".formatted(
				dateFormatter.format(currentTime),
				amount,
				balance
			);
			
			file.write(statement);
			file.close();
			
			return true;
		}
		catch(Exception exc)
		{
			System.out.println("evidencedDeposit: file writer error");
			return false;
		}
	}
	

	/**
	 * DEBUG METHOD
	 * 
	 * This method will take an integer parameter, and
	 * adds that amount onto the current user balance.
	 * 
	 * @param   amount    The amount to increase the balance by
	 * @return            Deposit Successful Flag
	 */
	public boolean debugMakeDeposit(int amount)
	{
		if (amount <= 0)
		{
			System.out.println("debugMakeDeposit: unsuccessful ~ invalid amount provided");
			return false;
		}
		
		balance = balance + amount;
		System.out.println("debugMakeDeposit: balance is now £" + balance);

		return true;
	}

	/**
	 * DEBUG METHOD
	 * 
	 * This method will take an integer parameter, and
	 * substracts that amount from the current user balance.
	 * 
	 * @param   amount    The amount to decrease the balance by
	 * @return            Withdrawal Successful Flag
	 */
	public boolean debugMakeWithdrawal(int amount)
	{
		if (amount <= 0)
		{
			System.out.println("debugMakeWithdrawal: unsuccessful ~ invalid amount provided");
			return false;
		}
		
		if (amount > (balance - maxOverdraft))
		{
			System.out.println("debugMakeWithdrawal: unsuccessful ~ cannot exceed maxoverdraft");
			return false;
		}
		
		balance = balance - amount;
		System.out.println("debugMakeWithdrawal: balance is now £" + balance);
		return true;
	}


	/**
	 * DEBUG METHOD
	 * 
	 * This method acts as a constructor and sets the
	 * required values within the global variables. Through
	 * user inputs, and predefined options.
	 */
	public void debugSetAllValues()
	{
		Scanner inputScanner = new Scanner(System.in);
		
		accountNumber = "";
		while (accountNumber.matches("\\d{8}") == false)
		{
			System.out.print("Enter Account Number: ");
			accountNumber = inputScanner.nextLine();
		}

		sortCode = "";
		while (sortCode.matches("\\d{6}") == false)
		{
			System.out.print("Enter SortCode: ");
			sortCode = inputScanner.nextLine();
		}
		
		inputScanner.close();
		
		balance = 0;
		maxOverdraft = -1000;
		userType = 'C';
	}


	/**
	 * This method will return a string value, of each
	 * global variable concatenated with a comma seperator.
	 */
	public String toString()
	{
		return "%s,%s,%s,%s,%s".formatted(
			accountNumber,
			sortCode,
			balance,
			maxOverdraft,
			userType
		);
	}

	/**
	 * This method will return a string value, of each
	 * global variable concatenated with a comma seperator.
	 */
	public String toStringEncrypted()
	{
		CaesarCipher cipher = new CaesarCipher();

		return "%s,%s,%s,%s,%s".formatted(
			cipher.encrypt(accountNumber),
			cipher.encrypt(sortCode),
			cipher.encrypt(balance),
			cipher.encrypt(maxOverdraft),
			cipher.encrypt(userType)
		);
	}
}
