package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinesweeperBoardTest {

    @Test
    public void ConstructorTest() {
        MinesweeperBoard board = new MinesweeperBoard(5,5,10);
        boolean checkRows = board.getBoardRows() == 5;
        boolean checkCols = board.getBoardCols() == 5;
        boolean checkMines = board.getBoardMines() == 10;
        assertTrue(checkRows && checkCols && checkMines);
    }
    
    @Test
	public void isOpenedTrueTest(){
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.open(1,2);
        assertTrue(board.isOpened(1, 2));
	}
    
    @Test
	public void isOpenedFalseTest(){
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
        assertFalse(board.isOpened(1,2));
	}
    
    @Test
    private void putMineTrueTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.putMine(1, 2);
    	assertTrue(board.hasMine(1,2));
	}
    
    @Test
    private void putMineFalseTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	assertFalse(board.hasMine(2,2));
	}
    
    @Test(expected=IllegalStateException.class)
    private void putMineExeptionTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.putMine(2, 2);
    	board.putMine(2, 2);
	}
    
    @Test(expected=IllegalStateException.class)
    private void putMineExeptionTest2() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.open(2, 2);
    	board.putMine(2, 2);
    }	
}
