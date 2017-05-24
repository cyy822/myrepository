package transformers;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TransformerBattleTest {

	final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputContent));
	}

	@Test
	public void testNonexistentInputFile() {

		String[] args = { "src\\transformers\\dummyfilename" };
		TransformerBattle.main(args);
		String expected = "Unable to read input file" + System.getProperty("line.separator");
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testDefault() {

		String[] args = { "src\\transformers\\input.txt" };
		TransformerBattle.main(args);
		String expected = "1 battle" + System.getProperty("line.separator") + "Winning team (Decepticons): Soundwave"
				+ System.getProperty("line.separator") + "Survivors from the losing team (Autobots): Hubcap";
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testOptimusPrimePredaking() {

		String[] args = { "src\\transformers\\inputOptimusPrimePredaking.txt" };
		TransformerBattle.main(args);
		String expected = "All competitors have been destroyed" + System.getProperty("line.separator");
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testOptimusPrimeWin() {

		String[] args = { "src\\transformers\\inputOptimusPrimeWin.txt" };
		TransformerBattle.main(args);
		String expected = "1 battle" + System.getProperty("line.separator")
				+ "Winning team (Autobots): Optimus Prime, Hubcap" + System.getProperty("line.separator")
				+ "Survivors from the losing team (Decepticons): ";
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testPredakingWin() {

		String[] args = { "src\\transformers\\inputPredakingWin.txt" };
		TransformerBattle.main(args);
		String expected = "1 battle" + System.getProperty("line.separator") + "Winning team (Decepticons): Predaking"
				+ System.getProperty("line.separator") + "Survivors from the losing team (Autobots): Hubcap";
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testTie() {

		String[] args = { "src\\transformers\\inputTie.txt" };
		TransformerBattle.main(args);
		String expected = "1 battle" + System.getProperty("line.separator") + "Teams are tied"
				+ System.getProperty("line.separator");
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testRunawayOpponent() {

		String[] args = { "src\\transformers\\inputRunawayOpponent.txt" };
		TransformerBattle.main(args);
		String expected = "1 battle" + System.getProperty("line.separator")
				+ "Winning team (Autobots): Bluestreak, Hubcap" + System.getProperty("line.separator")
				+ "Survivors from the losing team (Decepticons): ";
		assertEquals(expected, outputContent.toString());
	}

	@Test
	public void testSkilledOpponent() {

		String[] args = { "src\\transformers\\inputSkilledOpponent.txt" };
		TransformerBattle.main(args);
		String expected = "1 battle" + System.getProperty("line.separator")
				+ "Winning team (Autobots): Bluestreak, Hubcap" + System.getProperty("line.separator")
				+ "Survivors from the losing team (Decepticons): ";
		assertEquals(expected, outputContent.toString());
	}
	
	@Test
	public void testMultipleBattlesNoSurvivors() {

		String[] args = { "src\\transformers\\inputMultipleBattles.txt" };
		TransformerBattle.main(args);
		String expected = "2 battles" + System.getProperty("line.separator") + "Winning team (Decepticons): Soundwave, Runabout"
				+ System.getProperty("line.separator") + "Survivors from the losing team (Autobots): ";
		assertEquals(expected, outputContent.toString());
	}
	
	@Test
	public void testMultipleBattlesOneSurvivor() {

		String[] args = { "src\\transformers\\inputMultipleBattlesOneSurvivor.txt" };
		TransformerBattle.main(args);
		String expected = "2 battles" + System.getProperty("line.separator") + "Winning team (Decepticons): Soundwave, Runabout"
				+ System.getProperty("line.separator") + "Survivors from the losing team (Autobots): Hubcap";
		assertEquals(expected, outputContent.toString());
	}
}
