public class LinkedList<T> {

	Node<T> firstNode;
	Node<T> lastNode;
	private int size;

	public LinkedList() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}

	public int size() {
		return this.size;
	}

	public Iterator<T> getIterator() {
		return new Iterator<T>(this);
	}

	public void add(T element) {
		Node<T> newNode = new Node<T>(element);

		if (firstNode == null) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.setNextNode(newNode);
			newNode.setPriorNode(lastNode);
			lastNode = newNode;
		}
		size++;
	}

	public void addBeginning(T element) {
		Node<T> newNode = new Node<T>(element);
		Node<T> current = firstNode;
		newNode.setNextNode(current);
		current.setPriorNode(newNode);
		firstNode = newNode;
	}

	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void add(T element, int index) {
		int counter = 0;
		Node<T> newNode = new Node<T>(element);
		Node<T> current = firstNode;
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == size)
			add(element);
		else if (index == 0)
			addBeginning(element);
		else {
			while (current != null) {
				if (counter == index - 1)
					break;
				current = current.getNextNode();
				counter++;
			}
			newNode.setNextNode(current.getNextNode());
			newNode.setPriorNode(current);
			current.getNextNode().setPriorNode(newNode);
			current.setNextNode(newNode);
			size++;
		}
	}

	public T get(int index) {
		int counter = 0;
		Node<T> current = firstNode;
		while (current != null) {
			if (counter == index)
				break;
			current = current.getNextNode();
			counter++;
		}
		return current.getData();
	}

	/**
	 * We have to iterate regardless, we can use iteratorAt because we do not
	 * require an index and we inturn use less memory
	 * 
	 * @param element
	 * @return
	 */
	public boolean contains(T element) {
		return iteratorAt(element) != null;
	}

	public Iterator<T> iteratorAt(T element) {
		Iterator<T> it = getIterator();
		while (it.hasNext()) {
			T data = it.next();
			if (data == element)
				return it;
		}
		return null;
	}

	public int indexOf(T element) {
		Iterator<T> it = getIterator();
		int counter = 0;
		while (it.hasNext()) {
			T data = it.next();
			if (data == element)
				return counter;
			counter++;
		}
		return -1;
	}

	public String toString() {
		String returnVal = "";
		Node<T> current = firstNode;
		if (size != 0) {
			while (current != null) {
				returnVal += current.toString();
				returnVal += "\n";
				current = current.getNextNode();
			}
		}
		return returnVal;
	} // end toString

	class Node<T> {

		private T data;
		private Node<T> nextNode;
		private Node<T> priorNode;

		public Node(T data) {
			nextNode = null;
			priorNode = null;
			this.data = data;
		}

		public T getData() {
			return this.data;
		}

		public Node<T> getNextNode() {
			return nextNode;
		}

		public Node<T> getPriorNode() {
			return priorNode;
		}

		public void setNextNode(Node<T> next) {
			nextNode = next;
		}

		public void setPriorNode(Node<T> prior) {
			this.priorNode = prior;
		}

		public String toString() {
			return data.toString();
		}

	} // end of Node<T>
}
