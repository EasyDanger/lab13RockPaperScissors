package lab13;

import java.util.Random;

public class Danny extends Player {
	public Roshambo strat;
	Random rand = new Random();

	@Override
	public Roshambo generateRoshambo() {
		int x = rand.nextInt(3) + 1;
		switch (x) {
		case 1:
			strat = Roshambo.ROCK;
			break;
		case 2:
			strat = Roshambo.PAPER;
			break;
		case 3:
			strat = Roshambo.SCISSORS;
			break;
		default:
			strat = Roshambo.PAPER;
		}
		return strat;
	}

	public Danny() {
	}
}
