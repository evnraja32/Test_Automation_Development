package practice_programs;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LIS {

	@Test
	public void test1() {
		int[] inputArray = { 50, 3, 10, 7, 40, 80 };
		int[] expected = { 3, 10, 40, 80 };
		int[] actual = findLIS_Just_Approach(inputArray);

		assertEquals(actual, expected);
	}

	private int[] findLIS_DS_Method(int[] inputArray) {
		int[] result = null;
		int[] indexArray = new int[inputArray.length];
		int lengthOfLIS = 1;
		int highestIndex = 0;

		HashMap<Integer, ArrayList<Integer>> subStringCollection = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (inputArray[i] >= inputArray[j]) {
					indexArray[i] += 1;
//					if (indexArray[j] < indexArray[i]) {
					System.out.print(inputArray[j] + ",");
					lengthOfLIS = indexArray[i];
					highestIndex = i;
//					}
				}
			}
			System.out.println();
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

	private int[] findLIS_Just_Approach(int[] inputArray) {

		int[] result = null;

		HashMap<Integer, ArrayList<Integer>> collection = new HashMap<Integer, ArrayList<Integer>>();

		int len = inputArray.length;
		int indexLength;
		int indexNumber;
		int maxLenghtOfLIS = 1;

		for (int i = 0; i < len - 1; i++) {
			ArrayList<Integer> sortedOrderCollection = new ArrayList<Integer>();
			indexNumber = inputArray[i];
			sortedOrderCollection.add(indexNumber);
			for (int j = i + 1; j < len; j++) {
				if (inputArray[j] > indexNumber) {
					sortedOrderCollection.add(inputArray[j]);
					indexNumber = inputArray[j];
				}
			}
			indexLength = sortedOrderCollection.size();
//			if (collection.keySet().contains(indexLength)) {
			collection.put(indexLength, sortedOrderCollection);
//			} else {
//				collection.put(indexLength, sortedOrderCollection);
//			}

			if (indexLength > maxLenghtOfLIS)
				maxLenghtOfLIS = indexLength;

		}

		result = new int[maxLenghtOfLIS];
		for (int i = 0; i < maxLenghtOfLIS; i++) {
			result[i] = collection.get(maxLenghtOfLIS).get(i);
		}

		return result;
	}

}
