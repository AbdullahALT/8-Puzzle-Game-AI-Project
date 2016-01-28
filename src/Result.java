
public class Result {
	private State state; 
	private SolverNode solution;
	
	public Result(State state) {
		this.state = state;
	}
	
	public Result(State state, SolverNode solution) {
		this.state = state;
		this.solution = solution;
	}
	
	public Stack<Action> result(){
		Stack<Action> stack = new Stack<Action>();
		SolverNode current = solution;
		while(current.getAction() != null ){
			stack.push(current.getAction());
			current = current.getParent();
		}
		return stack;
	}

	public SolverNode getSulotion() {
		return solution;
	}


	public State getState() {
		return state;
	}
	
	
	
	
}
