package practice_programs;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MaxProductNumberInArray {

	private int[] findMaxProductNumberInArray(int[] inputArray) {
		int[] result = new int[2];
		int temp = 0;
		int maxProduct = 0;

		for (int i = 1; i < inputArray.length - 1; i++) {

			temp = inputArray[i - 1] * inputArray[i];

			if (temp > maxProduct) {
				maxProduct = temp;
				result[0] = inputArray[i - 1];
				result[1] = inputArray[i];
			}
		}

		return result;
	}

	@Test(testName = "Set 1 positive numbers")
	public void testCase1() {
		int inputArray[] = { 1, 4, 3, 6, 7, 0 };
		int expected[] = { 6, 7 };
		assertEquals(findMaxProductNumberInArray(inputArray), expected);
	}

	@Test(testName = "Set 2 negative numbers")
	public void testCase2() {
		int inputArray[] = { -1, -3, -4, 2, 0, -5 };
		int expected[] = { -3, -4 };
		assertEquals(findMaxProductNumberInArray(inputArray), expected);
	}

	@Test(testName = "Set 3 repeated set")
	public void testCase3() {
		int inputArray[] = { 1, 4, 7, 6, 3, 6, 7, 0, 7, 6 };
		int expected[] = { 7, 6 };
		assertEquals(findMaxProductNumberInArray(inputArray), expected);
	}
}
