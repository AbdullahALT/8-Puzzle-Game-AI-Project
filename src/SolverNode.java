public class SolverNode {
	private Problem problem;
	private SolverNode parent;
	private Action action;
	private int cost;

	public SolverNode(Problem problem) {
		this.problem = problem;
		parent = null;
		action = null;
		cost = 0;
	}

	public SolverNode(Problem problem, SolverNode parent, Action action, int cost) {
		this.problem = problem;
		this.parent = parent;
		this.action = action;
		this.cost = cost;
	}

	public SolverNode getParent() {
		return parent;
	}

	public int[][] state() {
		return problem.getState();
	}

	public static SolverNode childNode(Problem problem, SolverNode parent, Action action, int cost) {
		return new SolverNode(problem, parent, action, cost + parent.getCost());
	}

	public int getNumberOfActions() {
		return problem.getNumberOfActions();
	}

	public Action getAction() {
		return action;
	}

	public Problem result(Action action) {
		return Problem.result(problem, action);
	}

	public boolean testGoal() {
		return problem.testGoal();
	}

	public int getHuristicValue(Huristic huristic) {
		switch (huristic) {
		case distance:
			return Poriority.getDistansePoriority(problem);
		case missing:
			return Poriority.getMissingPoriority(problem);
		default:
			return -1;
		}
	}

	public boolean isEqual(SolverNode other) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.problem.getState()[i][j] != other.problem.getState()[i][j])
					return false;
			}
		}
		return true;
	}

	public Problem getProblem() {
		return problem;
	}

	public int getPriority(Huristic huristicType) {
		return (getHuristicValue(huristicType) + cost);
	}

	public int getCost() {
		return cost;
	}
	
	

}
