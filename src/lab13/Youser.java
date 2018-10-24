package lab13;

import java.util.Scanner;

public class Youser extends Player {

	@Override
	public Roshambo generateRoshambo() {
		Scanner read = new Scanner(System.in);
		boolean finished = false;
		while (finished == false) {
			String s = Vali.getString(read, "What would you like to play?");
			if (s.equalsIgnoreCase("rock") || s.startsWith("r")) {
				return Roshambo.ROCK;
			} else if (s.equalsIgnoreCase("paper") || s.startsWith("p"))
				return Roshambo.PAPER;
			else if (s.equalsIgnoreCase("scissors") || s.startsWith("s")) {
				return Roshambo.SCISSORS;
			} else {
				System.out.println("Sorry. didn't get that. Enter another play, please.");
				finished = false;
			}
		}
		return null;
	}

	public Youser() {
	}

}
