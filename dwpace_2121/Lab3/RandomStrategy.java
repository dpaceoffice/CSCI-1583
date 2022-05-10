

import java.util.Random;

public class RandomStrategy implements JudgeStrategy {

	@Override
	public int scoreJoke(String joke) {
		Random random = new Random();
		return random.nextInt(11);//[0,11)
	}

}
