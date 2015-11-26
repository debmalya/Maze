/**
 * 
 */
package explorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author
 *
 */
public class MazeExplorer {
	/**
	 * 
	 */
	private static final char MOVE_UP = 'U';

	/**
	 * Move forward direction
	 */
	private static final char MOVE_DOWN = 'D';

	/**
	 * Move at right
	 */
	private static final char GO_AT_RIGHT = 'R';

	/**
	 * Move at left.
	 */
	private static final char GO_AT_LEFT = 'L';

	/**
	 * Indicates empty space.
	 */
	private static final char EMPTY_SPACE_INDICATOR = ' ';

	/**
	 * Finish point indicator
	 */
	private static final char FINISHING_POINT_INDICATOR = 'F';

	/**
	 * Start point indicator
	 */
	private static final char STARTING_POINT_INIDICATOR = 'S';

	/**
	 * Possible solution container.
	 */
	private static Stack<Solution> solutionStack = new Stack<Solution>();

	/**
	 * Move upward.
	 */
	private static int[] MOVE_BACKWARD = new int[] { -1, 0 };

	/**
	 * Move downward.
	 */
	private static int[] MOVE_FORWARD = new int[] { 1, 0 };

	/**
	 * Move left.
	 */
	private static int[] MOVE_LEFT = new int[] { 0, -1 };

	/**
	 * Move right.
	 */
	private static int[] MOVE_RIGHT = new int[] { 0, 1 };

	/**
	 * Starting point x-coordinate.
	 */
	private static int startX;

	/**
	 * End point x-coordinate.
	 */
	private static int endX;

	/**
	 * Starting point y-coordinate.
	 */
	private static int startY;

	/**
	 * End point y-coordinate.
	 */
	private static int endY;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("Enter each line at time. To make an end only press <ENTER>.");
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> inputList = new ArrayList<String>();
			String line = "";

			while (true) {
				line = scanner.nextLine();

				if (line.trim().length() == 0) {
					break;
				} else {
					inputList.add(line);
				}

			}

			explore(inputList.toArray(new String[0]));

		}

	}

	/**
	 * @param array
	 */
	public static void explore(String[] array) {

		char[][] maze = new char[array[0].length()][array[0].length()];
		int y = -1;
		for (int i = 0; i < array.length; i++) {
			maze[i] = array[i].toCharArray();

			// get starting point
			y = array[i].indexOf(STARTING_POINT_INIDICATOR);
			if (y > -1) {
				startX = i;
				startY = y;
			}

			// get finishing point
			y = array[i].indexOf(FINISHING_POINT_INDICATOR);
			if (y > -1) {
				endX = i;
				endY = y;
			}
		}

		Solution solution = new Solution();
		solution.setBoard(maze);
		solution.setX(startX);
		solution.setY(startY);

		solutionStack.push(solution);

		while (!solutionStack.isEmpty()) {
			solve(solutionStack.pop());
		}

	}

	/**
	 * Just check what are the possible moves from the X, Y (current position).
	 * If movement possible move update solution board and push into the stack.
	 * 
	 * @param pop
	 *            - current solution.
	 */
	private static void solve(Solution pop) {
		boolean isChanged = false;
		if (move(pop, MOVE_LEFT[0], MOVE_LEFT[1], GO_AT_LEFT)) {
			solutionStack.push(pop);
			isChanged = true;
		}
		if (move(pop, MOVE_RIGHT[0], MOVE_RIGHT[1], GO_AT_RIGHT)) {
			solutionStack.push(pop);
			isChanged = true;
		}
		if (move(pop, MOVE_FORWARD[0], MOVE_FORWARD[1], MOVE_DOWN)) {
			solutionStack.push(pop);
			isChanged = true;
		}

		if (move(pop, MOVE_BACKWARD[0], MOVE_BACKWARD[1], MOVE_UP)) {
			solutionStack.push(pop);
			isChanged = true;
		}

		if (pop.isSolved() && !pop.isPrinted()) {
			// Not able to move in any direction 'L' (Left),'R' (Right), 'F'
			// (Forward), 'B' (Backward).
			// Print solution.
			System.out.println(pop);
			pop.setPrinted(true);
		}else if (!isChanged && !pop.isPrinted()) {
			System.out.println(pop);
			pop.setPrinted(true);
		}

	}

	/**
	 * To check whether movement to the desired location feasible or not. If
	 * feasible make the movement and return true. Otherwise return false (board
	 * remains unchanged);
	 * 
	 * @param pop
	 *            - current solution.
	 * @param x
	 *            - desired position x coordinate.
	 * @param y
	 *            - desired position y coordinate.
	 * @param direction
	 *            - movement direction.
	 * @return true if movement possible , false otherwise.
	 */
	private static boolean move(Solution pop, int x, int y, char direction) {
		int modifiedX = pop.getX() + x;
		int modifiedY = pop.getY() + y;

		int width = pop.getBoard()[0].length;
		int height = pop.getBoard().length;
		
		if (modifiedX == endX && modifiedY == endY) {
			pop.setX(modifiedX);
			pop.setY(modifiedY);
			pop.setSolved(true);
			return true;
		}

		// Check whether desired position is within board.
		// Check desired position is empty.
		if (modifiedX > -1 && modifiedX < width && modifiedY > -1
				&& modifiedY < height) {
			if (pop.getBoard()[modifiedX][modifiedY] == EMPTY_SPACE_INDICATOR) {
				pop.getBoard()[modifiedX][modifiedY] = direction;
				pop.setMovementCount(pop.getMovementCount()+1);
				pop.appendMovementHistory(pop.getMovementCount()+" " + direction+",");
				pop.setX(modifiedX);
				pop.setY(modifiedY);
				return true;
			} 
		}
		return false;

	}
}
