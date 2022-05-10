public class NumberOfVowelsStrategy implements JudgeStrategy {

	@Override
	public int scoreJoke(String joke) {
		int vowels = 0;
		for(int i = 0; i < joke.length(); i++) {
			char letter = joke.toLowerCase().charAt(i);
			if(isVowel(letter))
				vowels ++;
		}
		if(vowels > 10)
			return 10;
		
		return vowels;
	}
	
	private boolean isVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}

}
