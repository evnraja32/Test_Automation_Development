package practice_programs;

import java.util.HashMap;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LIS {

	@Test
	public void test1() {
		int[] inputArray = { 50, 3, 10, 7, 40, 80 };
		int[] expected = { 3, 7, 40, 80 };
		int[] actual = findLIS(inputArray);

		assertEquals(actual, expected);
	}

	private int[] findLIS(int[] inputArray) {
		int[] result = null;
		int[] indexArray = new int[inputArray.length];
		int lengthOfLIS = 1;
		int highestIndex = 0;

		HashMap<Integer, ArrayList<Integer>> subStringCollection = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.println(i + " - " + j);
				if (inputArray[i] >= inputArray[j]) {
					indexArray[i] += 1;
					System.out.print(inputArray[j] + ",");
					if (lengthOfLIS > indexArray[i]) {
						lengthOfLIS = indexArray[i];
						highestIndex = i;
					}
				}
				System.out.println();
			}
			System.out.println("========");
		}
		for (int i : indexArray)
			System.out.print(i + " ");

		System.out.println();

		for (int i : inputArray)
			System.out.print(i + " ");

		System.out.println(highestIndex);

		return result;
	}
}
