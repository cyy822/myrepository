package transformers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformerBattle {

	private static String OPTIMUS_PRIME_NAME = "Optimus Prime";

	private static String PREDAKING_NAME = "Predaking";

	public static void main(String[] args) {

		try {

			ArrayList<Transformer> transformers = new ArrayList<Transformer>();

			String inputFilename = args[0];

			List<String> lines = Files.readAllLines(Paths.get(inputFilename));

			for (int i = 0; i < lines.size(); i++) {
				String[] tokens = lines.get(i).split(",");
				transformers.add(new Transformer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5],
						tokens[6], tokens[7], tokens[8], tokens[9]));
			}

			// sort input into Autobot vs. Decepticon teams
			ArrayList<Transformer> autobotTeam = new ArrayList<Transformer>();
			ArrayList<Transformer> decepticonTeam = new ArrayList<Transformer>();

			// if Optimus Prime and Predaking will face each other, the game
			// immediately ends with all competitors destroyed
			boolean isOptimusPrimePresent = false;
			boolean isPredakingPresent = false;

			for (int i = 0; i < transformers.size(); i++) {
				Transformer transformer = (Transformer) transformers.get(i);
				if (transformer.isAutobot()) {
					autobotTeam.add(transformer);
				} else {
					decepticonTeam.add(transformer);
				}

				if (transformer.getName().equals(OPTIMUS_PRIME_NAME)) {
					isOptimusPrimePresent = true;
				} else if (transformer.getName().equals(PREDAKING_NAME)) {
					isPredakingPresent = true;
				}
			}

			if (isOptimusPrimePresent && isPredakingPresent) {
				System.out.println("All competitors have been destroyed");
				return;
			}

			// sort teams by strength, in descending order
			Collections.sort(autobotTeam);
			Collections.reverse(autobotTeam);

			Collections.sort(decepticonTeam);
			Collections.reverse(decepticonTeam);

			// number of battles is identical to the size of the smallest team
			int numberOfBattles = 0;

			if (autobotTeam.size() > decepticonTeam.size()) {
				numberOfBattles = decepticonTeam.size();
			} else {
				numberOfBattles = autobotTeam.size();
			}

			if (numberOfBattles == 1) {
				System.out.println("1 battle");
			} else if (numberOfBattles >= 1) {
				System.out.println(numberOfBattles + " battles");
			}

			// individual battles between team members
			ArrayList<Transformer> autobotBattleSurvivors = new ArrayList<Transformer>();
			ArrayList<Transformer> decepticonBattleSurvivors = new ArrayList<Transformer>();
			for (int j = 0; j < numberOfBattles; j++) {
				Transformer autobot = (Transformer) autobotTeam.get(j);
				Transformer decepticon = (Transformer) decepticonTeam.get(j);

				if (autobot.getName().equals(OPTIMUS_PRIME_NAME)) {
					autobotBattleSurvivors.add(autobot);
				} else if (decepticon.getName().equals(PREDAKING_NAME)) {
					decepticonBattleSurvivors.add(decepticon);
				} else if ((autobot.getCourage() - decepticon.getCourage() >= 4)
						&& (autobot.getStrength() - decepticon.getStrength() >= 3)) {
					autobotBattleSurvivors.add(autobot);
				} else if ((decepticon.getCourage() - autobot.getCourage() >= 4)
						&& (decepticon.getStrength() - autobot.getStrength() >= 3)) {
					decepticonBattleSurvivors.add(decepticon);
				} else if (autobot.getSkill() - decepticon.getSkill() >= 3) {
					autobotBattleSurvivors.add(autobot);
				} else if (decepticon.getSkill() - autobot.getSkill() >= 3) {
					decepticonBattleSurvivors.add(decepticon);
				} else if (autobot.getRating() > decepticon.getRating()) {
					autobotBattleSurvivors.add(autobot);
				} else if (decepticon.getRating() > autobot.getRating()) {
					decepticonBattleSurvivors.add(decepticon);
				}
			}

			if (autobotBattleSurvivors.size() > decepticonBattleSurvivors.size()) {
				System.out.print("Winning team (Autobots): ");
				for (int i = 0; i < autobotTeam.size(); i++) {
					String transformerName = ((Transformer) autobotTeam.get(i)).getName();
					System.out.print(transformerName);
					if (i != autobotTeam.size() - 1) {
						System.out.print(", ");
					}
				}
				System.out.println();
				System.out.print("Survivors from the losing team (Decepticons): ");
				// losing team's survivors did not fight
				for (int j = numberOfBattles; j < decepticonTeam.size(); j++) {
					String transformerName = ((Transformer) decepticonTeam.get(j)).getName();
					System.out.print(transformerName + ", ");
					if (j != decepticonTeam.size() - 1) {
						System.out.print(", ");
					}
				}

			} else if (decepticonBattleSurvivors.size() > autobotBattleSurvivors.size()) {
				System.out.print("Winning team (Decepticons): ");
				for (int i = 0; i < decepticonTeam.size(); i++) {
					String transformerName = ((Transformer) decepticonTeam.get(i)).getName();
					System.out.print(transformerName);
					if (i != decepticonTeam.size() - 1) {
						System.out.print(", ");
					}
				}
				System.out.println();
				System.out.print("Survivors from the losing team (Autobots): ");
				// losing team's survivors did not fight
				for (int j = numberOfBattles; j < autobotTeam.size(); j++) {
					String transformerName = ((Transformer) autobotTeam.get(j)).getName();
					System.out.print(transformerName);
					if (j != autobotTeam.size() - 1) {
						System.out.print(", ");
					}
				}
			} else if (autobotBattleSurvivors.size() == decepticonBattleSurvivors.size()) {
				System.out.println("Teams are tied");
			}

		} catch (IOException e) {
			System.out.println("Unable to read input file");
		}
	}
}
