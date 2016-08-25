package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperGameStateTest {

	@Test
	public void numberOfRowsTest() {
		MinesweeperBoard board = new MinesweeperBoard(10, 10, 8);
		assertTrue(board.getRows() == 10);
	}

}
