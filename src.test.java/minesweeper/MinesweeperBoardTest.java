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

    public void numberOfRowsTest() {
        MinesweeperBoard board = new MinesweeperBoard(10, 10, 8);
        assertTrue(board.getBoardRows() == 10);
    }
    
    @Test
    public void numberOfColumnsTest() {
        MinesweeperBoard board = new MinesweeperBoard(10, 10, 8);
        assertTrue(board.getBoardCols() == 10);
    }
    
    @Test
    public void getBoardMinesTest() {
      int rows = 7;
      int cols = 8;
      int mines = 10;
      MinesweeperBoard board = new MinesweeperBoard(rows,cols,mines);
      assertTrue(board.getBoardMines() == mines);
    }
    
    @Test
    public void isValidIndexTest() {
      int rows = 7;
      int cols = 8;
      int mines = 10;
      MinesweeperBoard board = new MinesweeperBoard(rows,cols,mines);
      for (int i=0; i<cols; i++){
        for (int j=0; i<rows; i++){
          assertTrue(board.isValidIndex(i,j));
        }
      }
    }
    
    @Test
    public void isMarkedTest() {
    	MinesweeperBoard mwb = new MinesweeperBoard(8,8,10);
    	assertFalse(mwb.isMarked(0, 0));
    	mwb.mark(0, 0);
    	assertTrue(mwb.isMarked(0, 0));
    }
    
    @Test
    public void numberOfMinedNeighboursTest(){
    	MinesweeperBoard board = new MinesweeperBoard(10, 10, 2);
    	board.putMine(1,1);
    	board.putMine(2,2);
    	board.putMine(8, 8);
    	assertEquals(1,board.numberOfMinedNeighbours(2,2));
    	assertEquals(1,board.numberOfMinedNeighbours(1,1));
    	assertNotEquals(2,board.numberOfMinedNeighbours(1,1));
    	assertEquals(0,board.numberOfMinedNeighbours(8,8));
    }
    
}
