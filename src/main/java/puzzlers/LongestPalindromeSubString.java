package puzzlers;

public class LongestPalindromeSubString {

	public String getLongestPalindrome(String inputStr) {
		String longestPalindrome= "";
		if ( inputStr == null )
		{
			return longestPalindrome;
		}
		char[] inputChars = inputStr.toCharArray();
		switch ( inputStr.length() )
		{
		case 1:
			return inputStr;
		case 2:
			if (inputChars[0] == inputChars[1] )
			return inputStr;
		}
		
		
		return longestPalindrome;
	}

}
