public class Solver {

	public static Result iterativeDeepingSearch(Problem problem) {
		int limit = 0;
		while (true) {
			Result result = DLS(problem, limit++);
			if (result.getState() != State.CUTOFF)

				return result;
			
		}
		
	}

	public static Result DLS(Problem problem, int limit) {
		return _DLS(new SolverNode(problem), limit);
	}

	private static Result _DLS(SolverNode node, int limit) {
		
		if (node.testGoal()){
			return new Result(State.SOLUTION, node);
			 
		}
		
		if (limit == 0){
			return new Result(State.CUTOFF);
		}
		
		Action[] action = Problem.actions(node.state());
		boolean isCutoff = false;
		for (int i = 0; i < node.getNumberOfActions(); i++) {
			SolverNode child = SolverNode.childNode(node.result(action[i]),
					node, action[i], 1);
			Result result = _DLS(child, limit - 1);
			if (result.getState() == State.CUTOFF)
				isCutoff = true;
			else if (result.getState() != State.NOSULOTION){
				return result;
			}

		}
		if (isCutoff)
			return new Result(State.CUTOFF);
		else
			return new Result(State.NOSULOTION);

	}
	
	
	public static Result AstarMissingHuristic(Problem problem){
		SolverNode inisial = new SolverNode(problem);
		PriorityQueue frontier = new PriorityQueue(Huristic.missing);
		frontier.enqueue(inisial);
		List explored = new List();
		while(true){
			if(frontier.length() == 0) 
				return new Result(State.NOSULOTION);
			SolverNode node = frontier.serve();
			if(node.testGoal())
				return new Result(State.SOLUTION, node);
			explored.insert(node);
			Action[] action = Problem.actions(node.state());
			for(int i = 0; i < node.getNumberOfActions(); i++){
				SolverNode child = SolverNode.childNode(node.result(action[i]),
						node, action[i], 1);
				if(!explored.isExist(child) && !frontier.isExist(child)){
					frontier.enqueue(child);
				}
					
			}
				
		}
		
	}
	
	public static Result AstarDistanceHuristic(Problem problem){
		SolverNode initial = new SolverNode(problem);  
		PriorityQueue frontier = new PriorityQueue(Huristic.distance);
		frontier.enqueue(initial);
		List explored = new List();
		while(true){
			if(frontier.length() == 0) 
				return new Result(State.NOSULOTION);
			SolverNode node = frontier.serve();
			if(node.testGoal())
				return new Result(State.SOLUTION, node);
			explored.insert(node);
			Action[] action = Problem.actions(node.state());
			for(int i = 0; i < node.getNumberOfActions(); i++){
				SolverNode child = SolverNode.childNode(node.result(action[i]),
						node, action[i], 1);
				if(!explored.isExist(child) && !frontier.isExist(child)){
					frontier.enqueue(child);
				}
					
			}
			
		}
		
		
	}
}
