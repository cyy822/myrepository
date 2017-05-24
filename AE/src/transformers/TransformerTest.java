package transformers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransformerTest {

	@Test
	public void testConstructorWithAllStrings() {
		Transformer d = new Transformer("Soundwave", "D", 8, 9, 2, 6, 7, 5, 6, 10);
		Transformer e = new Transformer("Soundwave", "D", "8", "9", "2", "6", "7", "5", "6", "10");
		assertEquals(d.getName(), e.getName());
		assertEquals(d.getTeam(), e.getTeam());
		assertEquals(d.isAutobot(), e.isAutobot());
		assertEquals(d.getStrength(), e.getStrength());
		assertEquals(d.getIntelligence(), e.getIntelligence());
		assertEquals(d.getSpeed(), e.getSpeed());
		assertEquals(d.getEndurance(), e.getEndurance());
		assertEquals(d.getRank(), e.getRank());
		assertEquals(d.getCourage(), e.getCourage());
		assertEquals(d.getFirepower(), e.getFirepower());
		assertEquals(d.getSkill(), e.getSkill());
	}

	@Test
	public void testIsAutobot() {
		Transformer d = new Transformer("Soundwave", "D", 8, 9, 2, 6, 7, 5, 6, 10);
		assertEquals(false, d.isAutobot());

		Transformer a = new Transformer("Bluestreak", "A", 6, 6, 7, 9, 5, 2, 9, 7);
		assertEquals(true, a.isAutobot());
	}

	@Test
	public void testGetRating() {
		Transformer t = new Transformer("Soundwave", "D", 8, 9, 2, 6, 7, 5, 6, 10);
		assertEquals(31, t.getRating());
	}

	@Test
	public void testCompareTo() {
		Transformer a = new Transformer("Bluestreak", "A", 6, 6, 7, 9, 5, 2, 9, 7);
		Transformer b = new Transformer("Hubcap", "A", 4, 4, 4, 4, 4, 4, 4, 4);

		assertEquals(1, a.compareTo(b));
	}
}
