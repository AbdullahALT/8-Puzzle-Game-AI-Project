
public class List {
	private ListNode head;
	private ListNode current;
	private int size;

	public List() {
		head = current = null;
		size = 0;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean first() {
		return current.prev == null;
	}

	public boolean full() {
		return false;
	}

	public void findfirst() {
		current = head;
	}

	public void findnext() {
		current = current.next;
	}

	public void findPrevious() {
		current = current.prev;
	}

	public SolverNode retrieve() {
		return current.data;
	}

	public void update(SolverNode val) {
		current.data = val;
	}

	public void insert(SolverNode val) {
		ListNode tmp = new ListNode(val);
		if (empty()) {
			current = head = tmp;
		} else {
			tmp.next = current.next;
			tmp.prev = current;
			if (current.next != null)
				current.next.prev = tmp;
			current.next = tmp;
			current = tmp;
		}
		size++;
	}

	public void remove() {
		if (current == head) {
			head = head.next;
			if (head != null)
				head.prev = null;
		} else {
			current.prev.next = current.next;
			if (current.next != null)
				current.next.prev = current.prev;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
		size--;
	}
	
	public int length(){
		return size;
	}
	
	public boolean isExist(SolverNode val){
		ListNode cur = head;
		while(cur != null){
			if(cur.data.isEqual(val))
				return true;
			cur = cur.next;
		}
		return false;
	}

	@Override
	public String toString() {
		String state = new String("");
		ListNode cur = head;
		while(cur != null){
			state = state + cur.data.getProblem().toString() + " || ";
			cur = cur.next;
		}
		
		
		
		return "List [" + state +"]";
	}
	
	
}
