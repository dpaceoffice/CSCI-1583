import java.util.ArrayList;

public class MyObservable extends Object {

	ArrayList<MyObserver> observers;
	private boolean hasChanged;
	
	public MyObservable () {
		this.observers = new ArrayList<MyObserver>();
		this.hasChanged = false;
	}
	
	/**
	* Adds a MyObserver object to the ArrayList. 
	*
	* @param 	o		A MyObserver object that will be added to numOfObservers.
	*/
	public void addObserver(MyObserver o) {
		observers.add(o);
	}
	
	/**
	* Changes the value of hasChanged back to false.
	*/
	protected void clearChanged() {
		hasChanged = false;
	}

	/**
	* Returns the number of Observers, which is the length of the array.
	*/
	public int countObservers() {
		return observers.size();
	}

	/**
	* Essentially, accesses value of hasChanged.
	*/
	public boolean hasChanged() {
		return hasChanged;
	}

	/**
	* Notifies Observers of a change by calling update when 
	* hasChanged is true and sends in an argument as well.
	*/
    public void notifyObservers(Object arg) {
		if(hasChanged) {
			for(MyObserver o : observers) {
                  o.update(arg);
			}
			clearChanged();
		}
	}

	/**
	* Changes the value of hasChanged to true.
	*/
	public void setChanged() {
		hasChanged = true;
	}
}