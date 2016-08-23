package minesweeper;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperCellTest {

	@Test
	public void hasMineFalse(){
		MinesweeperCell cell = new MinesweeperCell();
		assertFalse(cell.hasMine());
	}
	
	@Test
	private void hasMineTrue() {
		MinesweeperCell cell = new MinesweeperCell();
		cell.putMine();
		assertTrue(cell.hasMine());
	}
		
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
