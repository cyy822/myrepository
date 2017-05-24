package castlecounter;

import java.util.ArrayList;

public class CastleCounter {

	/**
	 * This method takes an array of int elements and ensures that if any two or
	 * more adjacent elements are identical, that the duplicate elements are
	 * removed, leaving only one element
	 * 
	 * @param landHeights
	 *            an array of int elements
	 * @return the array of int elements with duplicate elements removed
	 */
	protected static int[] removeDuplicateConsecutiveIntegers(int[] landHeights) {

		ArrayList landHeightsList = new ArrayList();

		// special handling to keep initial element in the array
		landHeightsList.add(landHeights[0]);

		// create ArrayList of elements to be returned, only copying over the
		// non-duplicate elements
		for (int i = 1; i < landHeights.length; i++) {
			if (landHeights[i - 1] != landHeights[i]) {
				landHeightsList.add(landHeights[i]);
			}
		}

		// convert ArrayList back into array
		int[] landHeightsArray = new int[landHeightsList.size()];
		for (int j = 0; j < landHeightsArray.length; j++) {
			landHeightsArray[j] = (int) landHeightsList.get(j);
		}

		return landHeightsArray;
	}

	/**
	 * This method reads an array of int elements and returns the number of
	 * castles to be built on that land
	 * 
	 * @param landHeightsWithDuplicates
	 *            an array of int elements
	 * @return the number of castles to be build on that land
	 */
	protected static int castleCount(int[] landHeightsWithDuplicates) {

		// immediately returns 0 if array is empty
		if (landHeightsWithDuplicates.length == 0) {
			return 0;
		}

		int[] landHeights = removeDuplicateConsecutiveIntegers(landHeightsWithDuplicates);

		// special handling for initial element in array, as a castle is always
		// permitted at the start of the array
		int castleCount = 1;

		for (int i = 2; i < landHeights.length; i++) {
			// array must contain at least 3 elements to have a peak or a valley
			// given 3 consecutive integers, determine whether this integer is
			// smaller
			// than the integers immediately preceding and following it
			int a = landHeights[i - 2];
			int b = landHeights[i - 1];
			int c = landHeights[i];

			if ((b > a) && (b > c)) {
				// increment castle count by one if b is a peak
				castleCount++;
			} else if ((b < a) && (b < c)) {
				// increment castle count by one if b is a valley
				castleCount++;
			}
		}

		return castleCount;
	}

}
