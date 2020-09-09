package practice_programs;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MoveZerosToEnd {

	private int[] moveZerosToEnd(int inputArray[]) {
		int currentIndex = 0;
		int endIndex = (inputArray.length - 1);
		int temp;

		while (currentIndex != endIndex) {
			if (inputArray[currentIndex] == 0) {
				for (int i = currentIndex; i < endIndex; i++) {
					temp = inputArray[i];
					inputArray[i] = inputArray[i + 1];
					inputArray[i + 1] = temp;
				}
				--endIndex;
			}
			++currentIndex;
		}

		return inputArray;
	}

	@Test
	public void testMethod1() {
		int[] inputArray = { 1, 0, 8, 0, 7, 0, 5, 6 };
		int[] expected = { 1, 8, 7, 5, 6, 0, 0, 0 };
		assertEquals(moveZerosToEnd(inputArray), expected);
	}
}
