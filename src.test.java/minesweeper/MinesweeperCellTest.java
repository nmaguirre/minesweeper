package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperCellTest {

	@Test
	public void isOpenCell() {
		MinesweeperCell cell = new MinesweeperCell();
		assertTrue(cell.isOpen());
	}
	@Test
	public void isClose(){
		MinesweeperCell cell = new MinesweeperCell();
		assertTrue(cell.isClose());
	}

}
