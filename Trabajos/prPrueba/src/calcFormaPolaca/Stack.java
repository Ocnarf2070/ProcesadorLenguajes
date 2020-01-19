package calcFormaPolaca;

public class Stack <T> {
	private static class Node <E>{
		E elem;
		Node <E> next;
		public Node(E x, Node<E> node) {
			elem = x;
			next = node;
		}
	}
	private Node<T> top;

	public Stack() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(T x) {
		Node <T> node = new Node<T>(x, top);
		top = node;

	}

	public T top() {
		if(isEmpty()) throw new EmptyStackException("top on empty stack");
		return top.elem;
	}

	
	public void pop() {
		if(isEmpty()) throw new EmptyStackException("top on empty stack");
		top = top.next;
	}
}
