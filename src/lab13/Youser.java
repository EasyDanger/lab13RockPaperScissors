package lab13;

import java.util.Scanner;

public class Youser extends Player {

	@Override
	public Roshambo generateRoshambo() {
		Scanner read = new Scanner(System.in);
		String s =Vali.getString(read, "What would you like to play?");
		if (s.equalsIgnoreCase("rock")) {
			return Roshambo.ROCK;
		}else if (s.equalsIgnoreCase("paper")) 
			return Roshambo.PAPER;
		else {
			return Roshambo.SCISSORS;
		}
		
	}

	
	public Youser() {
		
		
	}



}
