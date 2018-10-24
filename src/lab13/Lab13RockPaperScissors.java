package lab13;

import java.util.Scanner;

public class Lab13RockPaperScissors {
	//	A Scanner!
	static Scanner read = new Scanner(System.in);
	//player subclass objects created for each possible player.
	static Youser you = new Youser();
	static Bart bart = new Bart();
	static Danny danny = new Danny();
	//variables to store user's record.
	static int d = 0;
	static int w = 0;
	static int l = 0;
	//found a way to convert the Roshambo enum into a more programmer friendly format. This lets me use math to determine the winner, instead of a bunch of if/else statements or switch cases.
	static Roshambo[] roshambo = Roshambo.values();
	//my looping boolean
	static boolean finished = false;

	public static void main(String[] args) {
		//startup greeting
		System.out.println("Oh, so you wanna play?");
		//loop for main menu.
		String pname = Vali.getString(read, "What's your name, buddy?");
		Youser.setName(pname);
		do {
			System.out.println("\n\nChoose an opponent, " + Youser.getName() + "!\n");
			//user can choose opponent's name or number.
			System.out.println(
					"1. Bart. \nBart knows what he wants and knows how to get it.\nChallenge him if you're the same.\n");
			System.out.println(
					"2. Danny. \nDanny may not even know the rules of the game. \nChoose him if you like to party!\n");
			System.out.println("3 Quit.\nNot an opponent.\nPick this one if you want to give up and go home.");
			//user navigation variable
			String opp = read.nextLine();
			//calls to bart method. I feel there's probably a way to use one method for both opponents, but this was simpler.
			if (opp.equalsIgnoreCase("1") || opp.equalsIgnoreCase("bart")) {
				bart();
				System.out.println("Are you finished playing?");
				//combined checkyes method and finished boolean to one line. just had to word the question right.
				finished = Vali.checkYes(read.nextLine());
			} 
			//calls the danny method
			else if (opp.equalsIgnoreCase("2") || opp.equalsIgnoreCase("Danny")) {
				danny();
				System.out.println("Are you finished playing?");
				finished = Vali.checkYes(read.nextLine());
			} 
			//I don't know why, but I want the user to explicitly express a desire to quit, and not to do it accidentally.
			else if (opp.equalsIgnoreCase("3") || opp.equalsIgnoreCase("quit")) {
				finished = true;
			} else {
				System.out.println("Sorry, " + Youser.getName() + " we didn't get that. please choose another option.");
			}
		} while (!finished);
		//goodbye.
		System.out.println("Thanks for playing!");
		//Prints the user's record.
		System.out.println("(This session " + Youser.getName() + " got: " + w + " wins/" + l + " losses/" + d + " draws)");
	}
//lets the user play Danny, who chooses randomly.
	private static void danny() {
		//generate instances of each player's throw
		Roshambo youThrow = you.generateRoshambo();
		Roshambo dannyThrow = bart.generateRoshambo();
		//display what each throw was.
		System.out.println(Youser.getName() + " threw " + youThrow + ". Danny threw " + dannyThrow + ".");
		//equal throws are a draw
		if (dannyThrow == youThrow) {
			System.out.println("You reached a draw.\n");
			d++;
		} 
		//this renders each element of the Roshambo Enum to a number in the array. since they are sequential, a user winning play will always have an index that is one more than the opponent's or -2 if the user chooses the 0 index item, since there are three options. Pretty proud of this one. 
		else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == 1)
				|| ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == (-2))) {
			System.out.println("You win! Way to go!\n");
			w++;
		} else {
			System.out.println("Sorry, you lose.\n");
			l++;
		}
		//the l, d, and w variables increment with losses, draws, and wins, respectively.
	}
//let's the user play Bart, who always chooses rock. Good old dependable rock.
	private static void bart() {
		Roshambo youThrow = you.generateRoshambo();
		Roshambo bartThrow = bart.generateRoshambo();

		System.out.println(Youser.getName() + " threw " + youThrow + ". Bart threw " + bartThrow + ".");

		if (bartThrow == youThrow) {
			System.out.println("You reached a draw.\n");
			d++;
		} else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, bartThrow)) == 1)
				|| ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, bartThrow)) == (-2))) {
			System.out.println("You win! Way to go!\n");
			w++;
		} else {
			System.out.println("Sorry, you lose.\n");
			l++;
		}
	}
}
