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

	/**
	 * Test method for {@link explorer.MazeExplorer#explore(java.lang.String[])}.
	 */
	@Test
	public final void testExplore() {
		MazeExplorer.explore(maze);
	}

}
