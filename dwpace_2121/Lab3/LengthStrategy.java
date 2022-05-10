public class LengthStrategy implements JudgeStrategy {

	@Override
	public int scoreJoke(String joke) {
		if(joke.length() > 10)
			return 10;
		return joke.length();
	}

}
