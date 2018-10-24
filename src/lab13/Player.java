package lab13;

public abstract class Player {
	String name;
	Roshambo strat;

	public Player() {
		name = "player";
		strat = Roshambo.ROCK;
	}

	public Player(String name2, Roshambo strat2) {
		name = name2;
		strat = strat2;
	}

	public abstract Roshambo generateRoshambo();

}
