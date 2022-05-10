public class ComedianRunner {

	public static void main(String[] args) {
		
		Comedian arthur = new Comedian("Arthur");
		JokeJudge dorothy = new JokeJudge("Dorothy", new LengthStrategy());
		JokeJudge blanche = new JokeJudge("Blanche", new NumberOfVowelsStrategy());
		JokeJudge rose = new JokeJudge("Rose", new RandomStrategy());
		
		arthur.addObserver(dorothy);
		arthur.addObserver(blanche);
		arthur.addObserver(rose);
		
		arthur.tellsAJoke("Why did the chicken cross the road? To get to the other side.");
		System.out.println(arthur.toString());
		
		for( MyObserver o : arthur.getJokeJudges() ) {
			JokeJudge j = (JokeJudge)o;
		
			//This Joke Score scale is from 1 to 10 with 10 being "the best", 
			//but the scale can be any range.
			if (j.getJokeScore() > 5) {
				System.out.println("Judge " + j.getName() + " says Great Joke!");
			} else {
				System.out.println("Judge " + j.getName() + " says Terrible Joke!");
			}
		}
	}		
}