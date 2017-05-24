package transformers;

/**
 * This class represents a single Transformer object.
 */
public class Transformer implements Comparable<Transformer> {

	public String name;

	public String team;

	public boolean isAutobot;

	public int strength = 0;

	public int intelligence = 0;

	public int speed = 0;

	public int endurance = 0;

	public int rank = 0;

	public int courage = 0;

	public int firepower = 0;

	public int skill = 0;

	public int rating = 0;

	public Transformer(String theName, String theTeam, int theStrength, int theIntelligence, int theSpeed,
			int theEndurance, int theRank, int theCourage, int theFirepower, int theSkill) {
		name = theName.trim();
		team = theTeam.trim();

		setIsAutobot();

		strength = theStrength;
		intelligence = theIntelligence;
		speed = theSpeed;
		endurance = theEndurance;
		rank = theRank;
		courage = theCourage;
		firepower = theFirepower;
		skill = theSkill;

		setRating();
	}

	public Transformer(String theName, String theTeam, String theStrength, String theIntelligence, String theSpeed,
			String theEndurance, String theRank, String theCourage, String theFirepower, String theSkill) {
		name = theName.trim();
		team = theTeam.trim();

		setIsAutobot();

		try {
			strength = Integer.parseInt(theStrength.trim());
			intelligence = Integer.parseInt(theIntelligence.trim());
			speed = Integer.parseInt(theSpeed.trim());
			endurance = Integer.parseInt(theEndurance.trim());
			rank = Integer.parseInt(theRank.trim());
			courage = Integer.parseInt(theCourage.trim());
			firepower = Integer.parseInt(theFirepower.trim());
			skill = Integer.parseInt(theSkill.trim());
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid input for transformer numeric specifications");
		}

		setRating();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setIsAutobot() {
		if (team.equals("A")) {
			isAutobot = true;
		} else if (team.equals("D")) {
			isAutobot = false;
		} else {
			System.out.println("Invalid input for transformer specification - no team specified");
		}
	}

	public boolean isAutobot() {
		return isAutobot;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getCourage() {
		return courage;
	}

	public void setCourage(int courage) {
		this.courage = courage;
	}

	public int getFirepower() {
		return firepower;
	}

	public void setFirepower(int firepower) {
		this.firepower = firepower;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public void setRating() {
		this.rating = strength + intelligence + speed + endurance + firepower;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public int compareTo(Transformer t) {
		int rankCmp = new Integer(this.getRank()).compareTo(new Integer(t.getRank()));
		return rankCmp;
	}
}
