import java.util.ArrayList;

public class Comedian extends MyObservable {

	private String myName; /** @invariant myName != "" */
	private String currentJoke;
	
	/**
	* @param	name	Comedian's name.
	* @custom.require name != ""
	* @custom.ensure  getName() != "" && getName() == name
	*/
	public Comedian(String name) {
		this.myName = name;
		this.currentJoke = "";
	}

	/**
	* @return	String 		A string corresponding to the Comedian's name.
	* @custom.ensure  getName() != ""
	*/
	public String getName() {
		return myName;
	}

	/**
	* @return	String 		A string corresponding to the Comedian's joke.
	*/
	public String getCurrentJoke() {
		return currentJoke;
	}
	
	/**
	* @return	ArrayList 		The list of JokeJudges judging this Comedian.
	*/
	public ArrayList<MyObserver> getJokeJudges() {
		return this.observers;
	}
	
	/**
	* @param	String 		A String containing the new joke.
	*/
	public void tellsAJoke(String newJoke) {
		this.currentJoke = newJoke;
		setChanged();
		notifyObservers(this.currentJoke);
	}

	/**
	* @return	String 		Returns a string corresponding the the state of the Comedian.
	*/
	public String toString() {
		String returnVal = "";
		returnVal += "Comedian " + myName + " told a joke: " + currentJoke;
		return returnVal;
	}
}//End class Comedian.