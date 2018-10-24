package lab13;

public enum Roshambo {
	ROCK, PAPER, SCISSORS;

	public String toString(String name, Roshambo strat) {
		return name + " played " + strat;

	}
}
