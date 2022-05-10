/**
* @author David Pace
* @version 1.0
* @since 9/9/2019
*/

public interface MyObserver {
	
	/**
	* This is the only method that needs to be implemented 
	* by any class that implements MyObserver.
	*
	* @param o MyObservable object
	* @param arg An Object that sends in an argument if one wants to. Otherwise, it is null.
	*/
	public void update(MyObservable o, Object arg);

}
