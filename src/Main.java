import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			
		//Enter state 		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the tiles in each position: ");
		int[][] state = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int num;
				do {
					System.out.printf("[%d, %d]: ", i, j);
					num = scan.nextInt();
				} while (num < 0 || num > 9);
				state[i][j] = num;
			}
		}
		scan.close();
		
		
		//Print state
		System.out.println("Here is your state: ");

		Problem problem = new Problem(state);
		System.out.println(problem);
		if (isSolvable(state)) {
			System.out.println("Here is its solution");
			System.out
					.println("-----------------------The Solution----------------------");
			
			
			//A* with Manhattan Distance Heuristic Search
			long start = System.currentTimeMillis();
			Result res = Solver.AstarDistanceHuristic(problem);
			long end = System.currentTimeMillis();

			System.out.println("\nA* with Manhattan Distance Heuristic Search");
			printResult(res);
			System.out.println("A* with Manhattan Distance Total Time:\t" + (end - start));

			
			//A* with Missing Tiles Heuristic Search
			long start2 = System.currentTimeMillis();
			Result res2 = Solver.AstarMissingHuristic(problem);
			long end2 = System.currentTimeMillis();
			
			System.out.println("\nA* with Missing Tiles Heuristic Search");
			printResult(res2);
			System.out.println("A* with Missing Tiles Total Time:\t" + (end2 - start2));
			
			//Iterative Deeping Search
			long start3 = System.currentTimeMillis();
			Result res3 = Solver.iterativeDeepingSearch(problem);
			long end3 = System.currentTimeMillis();
			
			System.out.println("\nIterative Deeping Search");
			printResult(res3);
			System.out.println("Iterative Deeping Search Total Time:\t" + (end3 - start3));
			
			
			
			
		} else
			System.out.println("The problem is not solvable");

	}

	public static boolean isSolvable(int[][] state) {
		int nbInversion = 0;
		for (int rowFirst = 0; true; rowFirst++) {
			for (int columnFirst = 0; columnFirst < 3; columnFirst++) {
				int rowSecond = rowFirst, columnSecond = columnFirst + 1;
				if (rowFirst == 2 && columnFirst == 2) {
					return nbInversion % 2 == 0 ? true : false;
				} else if (columnFirst == 2) {
					columnSecond = 0;
					rowSecond = rowFirst + 1;
				}
				for (   ; rowSecond < 3; rowSecond++) {
					for (   ; columnSecond < 3; columnSecond++) {

						if (state[rowFirst][columnFirst] != 0 && state[rowSecond][columnSecond] != 0
								&& state[rowFirst][columnFirst] > state[rowSecond][columnSecond]) {
							nbInversion++;
						}
					}
					if (columnSecond == 3)
						columnSecond = 0;
				}
			}
		}

	}
	
	public static void printResult(Result res){
		if (res.getState() == State.SOLUTION){
			Stack<Action> stack = res.result();
			while(!stack.empty()){
				System.out.print(stack.pop() + " ");
				if(!stack.empty())
					System.out.print("- ");
			}
			System.out.println();
		}
	}

}
