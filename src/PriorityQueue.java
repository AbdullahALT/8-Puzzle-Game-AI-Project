
public class PriorityQueue {
	private ListNode head, tail;
	private int size;
	private Huristic huristicType;
	
	public PriorityQueue(Huristic huristicType) {
		this.huristicType = huristicType;
	}
	
	public boolean full() {
		return false;
	}

	public int length() {
		return size;
	}
	
	public void enqueue(SolverNode node) {
		if(head == null)
			head = tail = new ListNode(node);
		else{
			int newNodeHuristic = node.getPriority(huristicType);
			ListNode newNode = new ListNode(node);
			ListNode cur = head;
			while(cur != null){
				if(cur.getPriority(huristicType) >= newNodeHuristic){
					if(cur != head){
						cur.prev.next = newNode;
						newNode.prev = cur.prev;
					}
					newNode.next = cur;
					cur.prev = newNode;
					if(cur == head)
						head = newNode;
					break;
				}
				cur = cur.next;
			}
			if(cur == null){
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			
		}
		size++;
	}

	public SolverNode serve() {
		SolverNode x = head.data;
		head = head.next;
		size--;
		if (size == 0)
			tail = null;
		return x;
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
}
