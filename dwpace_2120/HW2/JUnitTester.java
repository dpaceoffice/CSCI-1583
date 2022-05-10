/**
* @author David Pace
* @version 1.0
* @since 9/9/2019
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;

public class JUnitTester {

	/*
	 * Declaring instance variables
	 */
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	/*
	 * These are the observables
	 */
	Pokemon charmander;
    Pokemon pikachu;
    
    /*
     * These are the observers
     */
    PokemonTrainer brock;
    PokemonTrainer ash;
	
	
	/*
	 * Sets up the testing environment
	 * Redirects the System.out to place output in an array of bytes
	 * Sets up PokemonTrainer and Pokemon objects using observer pattern
	 */
	@Before
	public void setup() {
		System.setOut(new PrintStream(output));
		
		/*The Trainers*/
        brock = new PokemonTrainer("Brock");
        ash = new PokemonTrainer("Ash");
		
		/*The Pokemon*/
		charmander = new Pokemon("Charmander",40,20);
        pikachu = new Pokemon("Pikachu", 50, 25);

        /*Brock is watching two pokemon*/
        charmander.addObserver(brock);
        pikachu.addObserver(brock);
        
        /*Ash is in charge of one*/
        pikachu.addObserver(ash);
        
	} 

	/*
	 * In order to make sure the observer pattern is properly setup
	 * Lets just make sure we can count the amount of observers for pokemon
	 */
	@Test
	public void testObserverRelationship() {

		Assert.assertEquals(1, charmander.countObservers());
		Assert.assertEquals(2, pikachu.countObservers());
		
	}
	
	/*
	 * The observable pattern only notifys observers that something is changed, not what changes
	 * Therefore this test case only checks that the observer was notified that the observable was attacked
	 * It does this by reading what was originally printed to the terminal, but is now in our byte array stream object
	 */
	@Test
	public void testAttack() {
		pikachu.attack(charmander);
		
		Boolean actual = output.toString().contains(brock.toString());
		Assert.assertEquals(true, actual);
		
		actual = output.toString().contains(ash.toString());
		Assert.assertEquals(false, actual);
		
		charmander.attack(pikachu);
		actual = output.toString().contains(ash.toString());
		Assert.assertEquals(true, actual);
		
		actual = output.toString().contains(brock.toString());
		Assert.assertEquals(true, actual);
	}

	/*
	 * Resets the System.out and System.err fields back to their default values
	 */
	@After
	public void resetStreams() {
		System.setOut(System.out);
	} 

}
