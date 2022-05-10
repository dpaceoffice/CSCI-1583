/**
* A class that models a Queue using an ArrayList.
*
* @name		YOUR NAME HERE
* @version	THE DATE HERE
*/
import java.util.ArrayList;

public class Queue<T> {

	private ArrayList<T> elements;
	
	public Queue() {
		this.elements = new ArrayList<T>();
	}

	/**
	* Offers an element to the end of the queue.
	*
	* @param	T 	item
	*/
	public void offer(T element) {
		elements.add(element);
	}
	
	/**
	* Peeks at, but does not remove, the element at the head of the queue.
	*
	* @return	T 	
	*/
	public T peek() {
		if(!elements.isEmpty()) 
		return elements.get(0);
	    return null;
		//Provide implementation.
		
	}
	
	/**
	* Polls an element from the head of the queue.
	*
	* @return	T 	
	*/
	public T poll() {
		if(!elements.isEmpty()) 
		return elements.remove(0);
	return null;
		//Provide implementation.
		
	}
	
	/**
	* Provides a String representation of the queue.
	*
	* @return 	String
	*/
	@Override
	public String toString() {
		String queueString = "";
		
		for (int i = 0; i < this.elements.size() -1; i++) {
			queueString = queueString + this.elements.get(i) + "\n";
		}
		return queueString;
	}
}