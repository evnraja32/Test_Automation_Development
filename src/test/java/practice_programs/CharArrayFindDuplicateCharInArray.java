package practice_programs;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CharArrayFindDuplicateCharInArray {

	@Test
	public void testMethod1() {
		char[] inputArray = { 'c', 'e', '7', 'q', 'c', 'p' };
		char expected = 'c';
		char actual = processAndFindDuplicateChar(inputArray);
		assertEquals(actual, expected);
	}

	@Test
	public void testMethod2() {
		char[] inputArray = { 'c', 'e', '7', 'q', 'c', 'p', 'a', 'p' };
		char expected = 'c';
		char actual = processAndFindDuplicateChar(inputArray);
		assertEquals(actual, expected);
	}

	private char processAndFindDuplicateChar(char[] inputArray) {
		char result = 0;
		char tempChar;
		int len = 0, maxLen = 0;

		String input = new String(inputArray);
		while (input.length() != 0) {
			tempChar = input.charAt(0);
			len = (input.length() - (input = input.replaceAll(tempChar + "", "")).length());
			if (len > maxLen) {
				result = tempChar;
				maxLen = len;
			}
		}
		return result;
	}
}
