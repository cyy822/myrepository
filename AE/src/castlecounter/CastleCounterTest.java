package castlecounter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CastleCounterTest {

	@Test
	public void testEmpty() {
		assertEquals(0, CastleCounter.castleCount(new int[0]));
	}

	@Test
	public void testNoPeaksNoValleys() {
		assertEquals(1, CastleCounter.castleCount(new int[] { 2, 3, 6, 9 }));
		assertEquals(1, CastleCounter.castleCount(new int[] { 6, 3, 2, 1 }));
	}

	@Test
	public void testCountDuplicatesOnly() {
		assertEquals(1, CastleCounter.castleCount(new int[] { 2, 2, 2 }));
	}

	@Test
	public void testCountSinglePeak() {
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 3, 2 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 3, 5, 4 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 3, 2, 1 }));

	}

	@Test
	public void testCountSinglePeakUsingDuplicates() {
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 3, 3, 2 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 3, 3, 3, 3, 3, 1 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 6, 6, 6, 3 }));
	}

	@Test
	public void testCountSingleValley() {
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 1, 2 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 4, 3, 2, 4 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 4, 3, 4, 5 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 6, 1, 4 }));
	}

	@Test
	public void testCountSingleValleyUsingDuplicates() {
		assertEquals(2, CastleCounter.castleCount(new int[] { 2, 1, 1, 2 }));
		assertEquals(2, CastleCounter.castleCount(new int[] { 4, 3, 3, 3, 3, 3, 5 }));
	}

	@Test
	public void testCountSinglePeakSingleValley() {
		assertEquals(3, CastleCounter.castleCount(new int[] { 2, 6, 5, 1, 3 }));
		assertEquals(3, CastleCounter.castleCount(new int[] { 2, 6, 6, 6, 5, 5, 1, 1, 1, 3 }));
	}

	@Test
	public void testCountMultiplePeaksMultipleValleys() {
		assertEquals(7, CastleCounter.castleCount(new int[] { 3, 5, 9, 9, 10, 5, 8, 6, 9, 2, 5, 5, 5 }));
		assertEquals(7, CastleCounter.castleCount(new int[] { 3, 5, 9, 9, 10, 10, 5, 5, 8, 6, 6, 9, 2, 5, 5, 5 }));
	}

	@Test
	public void testDuplicatesRemoval() {
		assertArrayEquals(new int[] { 2 }, CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 2, 2 }));
		assertArrayEquals(new int[] { 2, 1, 5 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 2, 1, 1, 5 }));
		assertArrayEquals(new int[] { 2, 1, 5 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 2, 2, 1, 1, 5, 5, 5 }));
		assertArrayEquals(new int[] { 2, 1, 5 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 1, 1, 5 }));
		assertArrayEquals(new int[] { 2, 1, 5 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 1, 1, 1, 5 }));
		assertArrayEquals(new int[] { 2, 1, 5 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 1, 1, 1, 1, 5 }));
		assertArrayEquals(new int[] { 2, 1, 5 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 1, 1, 1, 1, 1, 5 }));
		assertArrayEquals(new int[] { 2, 3, 5, 2 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 3, 3, 3, 5, 2 }));
		assertArrayEquals(new int[] { 2, 4, 6, 9, 7 },
				CastleCounter.removeDuplicateConsecutiveIntegers(new int[] { 2, 4, 4, 4, 4, 6, 6, 9, 9, 9, 7, 7, 7 }));
	}
}
