public class Poriority {

	public static int getMissingPoriority(Problem porblem) {
		int[][] state = porblem.getState();
		int[][] goal = porblem.getGoal();
		int result = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
					if (state[i][j] != goal[i][j]) {
						result++;
					}
				
			}
		}
		return result;
	}

	public static int getDistansePoriority(Problem porblem) {
		int[][] state = porblem.getState();
		int[][] goal = porblem.getGoal();
		int result = 0;
		// looping state
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// looping goal
				if (state[i][j] == 0) 
					continue;
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							// check
							if (state[i][j] == goal[k][l]) {
								//if the numbers are in their right position, then "result = result + 0"
								result += Math.abs((i - k)) + Math.abs((j - l));
							}
						}
					}
				
			}
		}
		return result;
	}

}
