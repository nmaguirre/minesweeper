package minesweeper;
import static org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperCellTest {

	@Test
	public void hasMineFalse(){
		MinesweeperCell cell = new MInesweeperCell();
		assertFalse(cell.hasMine());
	}
	
	@Test
	private void hasMineTrue() {
		MinesweeperCell cell = new MInesweeperCell();
		cell.putMine();
		assertTrue(cell.hasMine());
	}
	

}
