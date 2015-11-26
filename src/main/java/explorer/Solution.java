/**
 * 
 */
package explorer;

import java.util.Arrays;

/**
 * @author 
 *
 */
public class Solution {
	/**
	 * Complete maze board.
	 * Possible characters are
	 * 'X' - wall.
	 * 'S' - start.
	 * ' ' - empty space.
	 * 'F' - finish.
	 */
	private char[][] board;
	/**
	 * Current position x coordinate.
	 */
	private int x;
	/**
	 * Current position y coordinate.
	 */
	private int y;
	
	/**
	 * Keeps movement history.
	 */
	private StringBuilder movementHistory = new StringBuilder();
	
	/**
	 * Movement count;
	 */
	private int movementCount;
	/**
	 * Whether able to reach finishing point or not.
	 */
	private boolean solved;
	/**
	 * @return the board
	 */
	public char[][] getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}
	/**
	 * @return the movementCount
	 */
	public int getMovementCount() {
		return movementCount;
	}
	/**
	 * @param movementCount the movementCount to set
	 */
	public void setMovementCount(int movementCount) {
		this.movementCount = movementCount;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the solved
	 */
	public boolean isSolved() {
		return solved;
	}
	/**
	 * @param solved the solved to set
	 */
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder aboutMe = new StringBuilder("====================================================================");
		aboutMe.append(System.getProperty("line.separator"));
		for (int i = 0; i < board.length; i++) {
			aboutMe.append(Arrays.toString(board[i]));
			aboutMe.append(System.getProperty("line.separator"));
		}
		
		aboutMe.append(System.getProperty("line.separator"));
		aboutMe.append(movementHistory.toString());
		return aboutMe.toString();
	}
	
	/**
	 * To append movement history.
	 * @param c - movement details.
	 */
	public void appendMovementHistory(String currentMovement) {
		movementHistory.append(currentMovement);
	}
	
	
}
