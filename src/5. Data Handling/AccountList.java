import java.io.FileWriter;

/**
 * This class conforms to the regulations set forth within the
 * "Bank Project" EBook's Day 2 & 3 Task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class AccountList
{
	BankAccount[] allAccounts = new BankAccount[20];
	int currentIndex = 0;
	
	/**
	 * Polymorphism
	 * 
	 * This method will interate over every non-null value of the
	 * allAccounts array, and print the toString() value of each.
	 */
	public void displayAccounts()
	{
		// Interates over all non-null elements
		for (int index = 0; index < currentIndex; index++)
		{
			String stringAccount = allAccounts[index].toString();
			System.out.println(stringAccount);
		}
	}

	/**
	 * Polymorphism
	 * 
	 * This method will display the toString() value
	 * of the specific account provided.
	 * 
	 * @param   indexPoint    The account position to display
	 */
	public void displayAccounts(int indexPoint)
	{
		String stringAccount = allAccounts[indexPoint].toString();
		System.out.println(stringAccount);
	}


	/**
	 * This method will interate over every non-null value of the
	 * allAccounts array, and export the toString() value of each
	 * to the BankAccountDB file.
	 */
	public void exportAccounts()
	{
		try {
			FileWriter file = new FileWriter("BankAccountDB.txt");
		
			// Interates over all non-null elements
			for (int index = 0; index < currentIndex; index++)
			{
				String stringAccount = allAccounts[index].toStringEncrypted();
				file.write(stringAccount + "\r\n");
			}
		}
		catch (Exception exc)
		{
			System.out.println("exportAccounts: file writing error");
		}
	}


	/**
	 * This method will take BankAccount parameter, and add it to the
	 * next non-null element of the array.
	 * 
	 * @param   newAccount    The BankAccount to append to the array
	 */
	public void addAccountToList(BankAccount newAccount)
	{
		// Ensures there is still non-null elements in the array
		if (currentIndex >= allAccounts.length - 1)
		{
			System.out.println("addAccountToList: unsuccessful - allAccounts array is full.");
			return;
		}
		
		// Ensures no account has matching accountNumber & sortCode
		String accountInformation = getAccountInformation(newAccount);
		
		for (int index = 0; index < currentIndex; index++)
		{
			BankAccount otherAccount = allAccounts[index];
			String otherAccountInformation = getAccountInformation(otherAccount);
			
			if (otherAccountInformation.equals(accountInformation))
			{
				System.out.println("addAccountToList: unsuccessful - replication of account information.");
				return;
			}
		}
				
		allAccounts[currentIndex] = newAccount;
		currentIndex++;
	}

	/**
	 * This method used within the addAccountToList() as validation,
	 * it will return the string combination of the AccountNumber and
	 * SortCode to allow for unique checking.
	 * 
	 * @return     CSV of AccountNumber and SortCode
	 */
	public String getAccountInformation(BankAccount theAccount)
	{
		return "%s,%s".formatted(
			theAccount.getAccountNumber(),
			theAccount.getSortCode()
		);
	}
}
