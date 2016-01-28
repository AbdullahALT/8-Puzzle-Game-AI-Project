import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i[][] = { { 2, 1, 3 }, { 5, 4, 6 }, { 7, 8, 0 } };
		Problem b = new Problem(i);
		Scanner scan = new Scanner(System.in);
		String action = "";
		System.out.println(b);
		while (!b.testGoal()) {
			System.out.print("w: UP, a: LEFT, s: DOWN, d: RIGHT\n"
					+ "Your Action: ");
			
			try {
				switch (scan.next()) {
				case "w":
					b = Problem.result(b , Action.UP);
					action = action + " - UP";
					break;
				case "a":
					b = Problem.result(b, Action.LEFT);
					action = action + " - LEFT";
					break;

				case "d":
					b = Problem.result(b, Action.RIGHT);
					action = action + " - RIGHT";
					break;

				case "s":
					b = Problem.result(b, Action.DOWN);
					action = action + " - DOWN";
					break;

				default:
					break;
				}
				System.out.println(b + "\nYour Actions are: " + action);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("You Can not move there");
			}
			
		}
		System.out.println("Congrats!!! You Solved The 8-Puzzel");
		scan.close();

	}

}
