/**
* A class that initializes a Stack and 
* performs pushing, popping, and peeking.
*
* @name		Christian Roos
* @version	September 29, 2019
*/
public class StackRunner {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("This");
		stack.push("is");
		stack.push("a");
		stack.push("stack");
		System.out.println("Stack after pushing four elements:\n");
		System.out.println(stack.toString());
		
		stack.pop();
		stack.pop();
		System.out.println("Stack after popping off two elements:\n");
		System.out.println(stack.toString());
		
		System.out.println("Peeking at the top of the stack:\n");
		System.out.println(stack.peek());
		System.out.println();
		
		stack.push("still");
		stack.push("a");
		stack.push("stack");
		System.out.println("Stack after pushing on three new elements:\n");
		System.out.println(stack.toString());
		
		System.out.println("Peeking at the top of the new stack:\n");
		System.out.println(stack.peek());
		System.out.println();
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		System.out.println("Peeking at the top of the stack after removing all elements:\n");
		System.out.println(stack.peek());
	}
}