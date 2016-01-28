

public class Stack<T> {
	private StackNode<T> top;

	public Stack() {
		top = null;
	}

	public boolean empty() {
		return top == null;
	}
	
	public boolean full() {
		return false;
	}

	public T pop() {
		T e = top.data;
		top = top.next;
		return e;
	}

	public void push(T e) {
		StackNode<T> tmp = new StackNode<T>(e);
		tmp.next = top;
		top = tmp;
	}

}
