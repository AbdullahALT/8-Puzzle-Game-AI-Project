

public class ListNode {
	public SolverNode data;
	public ListNode next;
	public ListNode prev;

	public ListNode() {
		data = null;
		prev = next = null;
	}

	public ListNode(SolverNode val) {
		data = val;
		next = prev = null;
	}
	
	public int getPriority(Huristic Type){
		return data.getPriority(Type);
	}
}
