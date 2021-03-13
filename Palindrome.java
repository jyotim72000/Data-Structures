public class Palindrome 
{
	public boolean isPalindrome(String word)
	{
		char[] charArray = word.toCharArray();
		int start = 0;
		int end = word.length() - 1;
		
		while(start<end)
		{
			if(charArray[start] != charArray[end])
			{
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		palindrome obj = new palindrome();
		if(obj.isPalindrome("madam"))
			System.out.println("The string is palindrome");
		else
			System.out.println("The string is not palindrome");
	}
}
