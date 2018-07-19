package puzzlers;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeSubStringTest {

	LongestPalindromeSubString ls = new LongestPalindromeSubString();
	
	@Test
	public void testNull()
	{
		Assert.assertEquals("",ls.getLongestPalindrome(null));
	}
	
	@Test
	public void testSingleLetter()
	{
		Assert.assertEquals("a",ls.getLongestPalindrome("a"));
	}
	
	@Test
	public void testSmallString()
	{
		Assert.assertEquals("aa",ls.getLongestPalindrome("aa"));
		Assert.assertEquals("",ls.getLongestPalindrome("ab"));
	}
	
}
