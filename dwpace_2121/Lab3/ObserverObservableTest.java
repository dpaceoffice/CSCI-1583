import org.junit.*;
import static org.junit.Assert.*;

public class ObserverObservableTest {

	Comedian david;
	JokeJudge jokeOfAJudge1;
	JokeJudge jokeOfAJudge2;
	JokeJudge jokeOfAJudge3;
	
	@Before
	public void setUp() {
		david = new Comedian("David");
		jokeOfAJudge1 = new JokeJudge("Jefferson Parish", new LengthStrategy());
		jokeOfAJudge2 = new JokeJudge("New Orleans", new NumberOfVowelsStrategy());
		jokeOfAJudge3 = new JokeJudge("St Plaquamines", new RandomStrategy());
		
		david.addObserver(jokeOfAJudge1);
		david.addObserver(jokeOfAJudge2);
		david.addObserver(jokeOfAJudge3);
	}
	
	@Test
	public void testGetNameOfJokeJudge() {
		assertEquals("Jefferson Parish", jokeOfAJudge1.getName());
		assertEquals("New Orleans", jokeOfAJudge2.getName());
		assertEquals("St Plaquamines", jokeOfAJudge3.getName());
	}
	
	@Test
	public void testGetJokeScore() {
		david.tellsAJoke("Whose the real comedian here? The judges!");
		for(MyObserver o : david.getJokeJudges() ) {
			JokeJudge j = (JokeJudge)o;
			int score = j.getJokeScore();
			System.out.println(score);
			assertEquals(0, score, 10);//because this is subject to be 1-10, delta is 10
		}
	}
	
	@Test
	public void testUpdate() {
		jokeOfAJudge1.update("test1");
		assertEquals(5, jokeOfAJudge1.getJokeScore());//because he judges based off length
		jokeOfAJudge2.update("a");
		assertEquals(1, jokeOfAJudge2.getJokeScore());//because this judge is based off vowels
		//its impossible to test the third judge's update, but if these two objects work, so will the third
	}
	
	@Test
	public void testGetNameOfComedian() {
		assertEquals("David", david.getName());
	}
	
	@Test
	public void testGetCurrentJoke() {
		david.tellsAJoke("test");
		assertEquals("test", david.getCurrentJoke());
	}
	
	@Test
	public void testGetJokeJudges() {
		assertEquals(3, david.getJokeJudges().size());
	}
	
	@Test
	public void testTellsAJoke() {
		david.tellsAJoke("test");
		assertEquals("test", david.getCurrentJoke());
	}
	
}//End of class ObserverObservableTest.