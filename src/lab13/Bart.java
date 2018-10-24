package lab13;

public class Bart extends Player{

	String name;
	Roshambo strat;
	
	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}
	public Bart(String name, Roshambo strat) {
		super(name, strat);
	}
	public Bart() {
		// TODO Auto-generated constructor stub
	}

}
