
public class StackNode<Type> {
	public Type data;
	public StackNode<Type> next;
	public StackNode<Type> prev;

	public StackNode() {
		data = null;
		prev = next = null;
	}

	public StackNode(Type val) {
		data = val;
		next = prev = null;
	}

}
