
public class Problem {
	private int[][] board;
	private Blank blank;
	private int[][] goal;
	
	
	public Problem(int state[][]) {
		board = new int[3][3];
		this.goal = new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 0 } };
		setState(state);
	}
	

	
	public void move(Action action) {
		
		switch (action) {
		case RIGHT:
			board[blank.getRow()][blank.getColumn()] = board[blank.getRow()][blank
					.getColumn() + 1];
			board[blank.getRow()][blank.getColumn() + 1] = 0;
			blank.movedTo(blank.getRow(), blank.getColumn() + 1);
			break;
		case LEFT:
			board[blank.getRow()][blank.getColumn()] = board[blank.getRow()][blank
					.getColumn() - 1];
			board[blank.getRow()][blank.getColumn() - 1] = 0;
			blank.movedTo(blank.getRow(), blank.getColumn() - 1);
			break;
		case UP:
			board[blank.getRow()][blank.getColumn()] = board[blank.getRow() - 1][blank
					.getColumn()];
			board[blank.getRow() - 1][blank.getColumn()] = 0;
			blank.movedTo(blank.getRow() - 1, blank.getColumn());
			break;
		case DOWN:
			board[blank.getRow()][blank.getColumn()] = board[blank.getRow() + 1][blank
					.getColumn()];
			board[blank.getRow() + 1][blank.getColumn()] = 0;
			blank.movedTo(blank.getRow() + 1, blank.getColumn());
			break;

		default:
			break;
		}
	}

	@Override
	public String toString() {
		String s = new String("");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				s = s + board[i][j] + "\t";
			}
			s = s + "\n";
			
		}
		return s;
	}

	public Blank getBlank() {
		return blank;
	}
	
	public static Problem result(Problem problem, Action action){
		Problem result = new Problem(problem.board);
		result.move(action);
		return result;
	}
	
	private void setState(int state[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (state[i][j] == 0)
					blank = new Blank(i, j);
				board[i][j] = state[i][j];

			}
		}
	}

	public int[][] getState() {
		int[][] state = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				state[i][j] = board[i][j];

			}
		}
		return state;
	}

	public static Action[] actions(int state[][]) {
		Problem b = new Problem(state);
		return b.blank.getActions();
	}

	public boolean testGoal() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (goal[i][j] != board[i][j])
					return false;
		return true;

	}
	
	public int getNumberOfActions(){
		return blank.getActnb();
	}

	public int[][] getGoal() {
		return goal;
	}
	
	
	
	
	
	
	
	
	
}
