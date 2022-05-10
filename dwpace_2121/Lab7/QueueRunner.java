/**
* A class that initializes a Queue and 
* performs offering, polling, and peeking.
*
* @name		Christian Roos
* @version	September 29, 2019
*/
public class QueueRunner {

	public static void main(String[] args) {
		
		Queue<String> queue = new Queue<String>();
		queue.offer("This");
		queue.offer("is");
		queue.offer("a");
		queue.offer("queue");
		System.out.println("Queue after offering four elements:\n");
		System.out.println(queue.toString());
		
		System.out.println("Peeking at the head of the queue:\n");
		System.out.println(queue.peek());
		System.out.println();
		
		queue.poll();
		queue.poll();
		System.out.println("Queue after polling two elements:\n");
		System.out.println(queue.toString());
		
		queue.offer("This");
		queue.offer("is");
		queue.offer("still");
		System.out.println("Queue after offering three new elements:\n");
		System.out.println(queue.toString());
		
		System.out.println("Peeking at the head of the queue:\n");
		System.out.println(queue.peek());
		System.out.println();
		
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		
		System.out.println("Peeking at the head of the queue after all elements removed:\n");
		System.out.println(queue.peek());
	}
}