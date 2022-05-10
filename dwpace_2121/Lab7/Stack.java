/**
* A class that models a Stack using an ArrayList.
*
* @name		YOUR NAME HERE
* @version	THE DATE HERE
*/
import java.util.ArrayList;

public class Stack<T> {

	private ArrayList<T> elements;
	
	public Stack() {
		this.elements = new ArrayList<T>();
	}
	
	public int getSize() {
		return this.elements.size();
	}
	
	/**
	* Pushes an item to the top of the stack.
	*
	* @param	T 	item
	*/
	public void push(T item) {
		this.elements.add(item);	
		//Provide implementation.
	
	}
	
	/**
	* Peeks at, but does not remove, the item on the top of the stack.
	*
	* @return	T 	
	*/
	public T peek() {
		if(!elements.isEmpty()) 
		return this.elements.get(getSize() -1);
	return null;
		//Provide implementation.
		
	}
	
	/**
	* Pops off the item on the top of the stack.
	*
	* @return	T 	
	*/
	public T pop() {
		if(!elements.isEmpty()) 
		return this.elements.remove(getSize() - 1);
	return null;
		//Provide implementation.
		
	}
	
	/**
	* Provides a String representation of the stack.
	*
	* @return	String 	
	*/
	@Override
	public String toString() {
		String stackString = "";
		
		for (int i = 0; i < this.elements.size() -1; i++) {
			stackString = stackString + this.elements.get(i) + "\n";
		}
		return stackString;
	}
}