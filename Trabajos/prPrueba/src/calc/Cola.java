/**
 * @author Pepe Gallardo, Data Structures, Grado en Informática. UMA.
 *
 * Queue implementation using a linked list
 */
 
package calc;

/**
 * Queue implemented using a double ended linked list
 * (with references to first and last elements).
 * @param <T> Type of elements in stack.
 */
public class Cola<T> implements Queue<T> {
	private static class Node<E> {
		private E elem;
		private Node<E> next;

		public Node(E x, Node<E> node) {
			elem = x;
			next = node;
		}
	}

	Node<T> first, last;

	/**
	 * Creates an empty queue.
	 * <p>Time complexity: O(1)
	 */
	public Cola() {
		first = null;
		last = null;
	}

	/** 
	 * {@inheritDoc}
	 * <p>Time complexity: O(1)
	 */
	public boolean vacia() {
		return first == null;
	}

	/** 
	 * {@inheritDoc}
	 * <p>Time complexity: O(1)
	 * @throws EmptyQueueException {@inheritDoc} 
	 */
	public T frente() {
		if (vacia())
			throw new EmptyQueueException("first on empty queue");
		else
			return first.elem;
	}

	/** 
	 * {@inheritDoc}
	 * <p>Time complexity: O(1)
	 * @throws EmptyQueueException {@inheritDoc} 
	 */
	public void desacolar() {
		if (vacia())
			throw new EmptyQueueException("dequeue on empty queue");
		else {
			first = first.next;
			if (first == null) // queue became empty
				last = null;
		}
	}

	/** 
	 * {@inheritDoc}
	 * <p>Time complexity: O(1)
	 */
	public void acolar(T x) {
		Node<T> node = new Node<T>(x, null);
		if (first == null) { // queue was empty
			first = node;
			last = node;
		} else {
			last.next = node;
			last = last.next;
		}
	}

	/** 
	 * Returns representation of queue as a String.
	 */
	@Override
	public String toString() {
    String className = getClass().getName().substring(getClass().getPackage().getName().length()+1);  
		String s = className+"(";
		for (Node<T> node = first; node != null; node = node.next)
			s += node.elem + (node.next != null ? "," : "");
		s += ")";
		return s;
	}

}
