/**
 * 
 */
package explorer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 
 *
 */
public class MazeExplorerTest {
	
	String[] maze = new String[]{
			"XXXXXXXXXXXXXXX",
			"X             X",
			"X XXXXXXXXXXX X",
			"X XS        X X",
			"X XXXXXXXXX X X",
			"X XXXXXXXXX X X",
			"X XXXX      X X",
			"X XXXX XXXX X X",
			"X XXXX XXXX X X",
			"X X    XXXXXX X",
			"X X XXXXXXXXX X",
			"X X XXXXXXXXX X",
			"X X         X X",
			"X XXXXXXXXX   X",
			"XFXXXXXXXXXXXXX"};
	
	
	String[] mazeBlocked = new String[]{
			"XXXXXXXXXXXXXXX",
			"X             X",
			"X XXXXXXXXXXX X",
			"X XS        X X",
			"X XXXXXXXXX X X",
			"X XXXXXXXXX X X",
			"X XXXX      X X",
			"X XXXX XXXX X X",
			"X XXXX XXXX X X",
			"X X    XXXXXX X",
			"X X XXXXXXXXX X",
			"X X XXXXXXXXX X",
			"X X         X X",
			"XXXXXXXXXXX   X",
			"XFXXXXXXXXXXXXX"};
	
	String[] mazeBlocked1 = new String[]{
			"XXXXXXXXXXXXXXX",
			"X             X",
			"X XXXXXXXXXXX X",
			"X XSX       X X",
			"X XXXXXXXXX X X",
			"X XXXXXXXXX X X",
			"X XXXX      X X",
			"X XXXX XXXX X X",
			"X XXXX XXXX X X",
			"X X    XXXXXX X",
			"X X XXXXXXXXX X",
			"X X XXXXXXXXX X",
			"X X         X X",
			"XXXXXXXXXXX   X",
			"XFXXXXXXXXXXXXX"};
	
	

	/**
	 * Test method for {@link explorer.MazeExplorer#explore(java.lang.String[])}.
	 */
	@Test
	public final void testExplore() {
		MazeExplorer.explore(maze);
	}
	
	@Test
	public final void testExploreBlock() {
		MazeExplorer.explore(mazeBlocked);
	}
	
	@Test
	public final void testExploreBlock1() {
		MazeExplorer.explore(mazeBlocked1);
	}

}
