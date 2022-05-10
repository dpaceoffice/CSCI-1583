public class JokeJudge implements MyObserver {

	private String myName;	/** @invariant	myName!="" */
	private int jokeScore;
	private JudgeStrategy strategy;
	
	/**
	* @param	name		The name of the JokeJudge.
	* @param	strategy	The JokeJudge's secret strategy to score a joke.
	* @custom.require name != ""
	*/
	public JokeJudge(String name, JudgeStrategy strategy) {
		this.myName = name;
		this.strategy = strategy;
		this.jokeScore = 0;
	}

	/**
	* @return	String		A string corresponding to the JokeJudge's name.
	* @custom.ensure  getName() != ""
	*/
	public String getName() {
		return myName;
	}

	/**
	* @return	int		The JokeJudge's score for a particular Comedian's joke.
	* @custom.ensure  getName() != ""
	*/
	public int getJokeScore() {
		return jokeScore;
	}
	
	/**
	* {@inheritdoc}
	*/
	@Override
	public void update(Object o) {
		String currentJoke = (String)o;
		this.jokeScore = this.strategy.scoreJoke(currentJoke);
	}

	/**
	* @return	String		Returns a string representation of the JokeJudge.
	*/
	@Override
	public String toString() {
		String returnVal = "";
		returnVal += "JokeJudge " + myName;
		return returnVal;
	}
}//End class JokeJudge.