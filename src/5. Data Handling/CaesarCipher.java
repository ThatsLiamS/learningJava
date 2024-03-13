/**
 * This class conforms to the regulations set forth within the
 * "Bank Project" EBook's Day 3 Task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class CaesarCipher
{
	/**
	 * Polymorphism
	 * 
	 * This method will encrypt a String with
	 * a Caesar Cipher with a shift of 10
	 * 
	 * @param    Plain Text
	 * @return   Cipher Text
	 */
	public String encrypt(String plainText)
	{
		String cipherText = "";

		for (int i = 0; i < plainText.length(); i++) 
		{
			int ascii = plainText.charAt(i) + 10;
			cipherText = cipherText + (char)ascii;
		}

		return cipherText;
	}
	/**
	 * Polymorphism
	 * 
	 * This method will encrypt a Integer with
	 * a wrapping Caesar Cipher with a shift of 3
	 * 
	 * @param    Plain Text
	 * @return   Cipher Text
	 */
	public int encrypt(int plainText)
	{
		int cipherText = 0;
		int multiplier = 1;

		while (plainText != 0)
		{
			int digit = plainText % 10;
			int encryptedDigit = (digit + 3) % 10;

			cipherText += encryptedDigit * multiplier;

			multiplier *= 10;
			plainText /= 10;
		}

		return cipherText;
	}

	
	/**
	 * Polymorphism
	 * 
	 * This method will decrypt a String with
	 * a Caesar Cipher with a shift of 10
	 * 
	 * @param    Cipher Text
	 * @return   Plain Text
	 */
	public String decrypt(String cipherText)
	{
		String plainText = "";

		for (int i = 0; i < cipherText.length(); i++) 
		{
			int ascii = cipherText.charAt(i) - 10;
			plainText = plainText + (char)ascii;
		}

		return plainText;
	}
	/**
	 * Polymorphism
	 * 
	 * This method will decrypt a Integer with
	 * a wrapping Caesar Cipher with a shift of 3
	 * 
	 * @param    Cipher Text
	 * @return   Plain Text
	 */
	public int decrypt(int cipherText)
	{
		int plainText = 0;
		int multiplier = 1;

		while (cipherText != 0)
		{
			int digit = cipherText % 10;
			int decryptedDigit = (digit - 3 + 10) % 10;

			plainText += decryptedDigit * multiplier;
	
			multiplier *= 10;
			cipherText /= 10;
		}

		return plainText;
	}
}
