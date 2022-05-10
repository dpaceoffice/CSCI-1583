public interface JudgeStrategy {
	
	/**
	* This is the only method that needs to be implemented 
	* by any class that implements JudgeStrategy.
	*
	* @param	String		The joke that is being scored by this judging strategy.
	* @return 	int 		The score.
	*/
	public int scoreJoke(String joke);
	
}