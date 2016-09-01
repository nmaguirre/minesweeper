package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinesweeperBoardTest {

    @Test
    public void ConstructorTest() {
        MinesweeperBoard board = new MinesweeperBoard(5,5,10);
        boolean checkRows = board.getRowCount() == 5;
        boolean checkCols = board.getColCount() == 5;
        boolean checkMines = board.getMineCount() == 10;
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
    public void putMineTrueTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.putMine(1, 2);
    	assertTrue(board.hasMine(1,2));
	}
    
    
    @Test(expected=IllegalStateException.class)
    public void putMineExeptionTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.putMine(2, 2);
    	board.putMine(2, 2);
	}
    
    @Test(expected=IllegalStateException.class)
    public void putMineExeptionTest2() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
    	board.open(2, 2);
    	board.putMine(2, 2);
    }	
    
    @Test
    public void numberOfRowsTest() {
        MinesweeperBoard board = new MinesweeperBoard(10, 10, 8);
        assertTrue(board.getRowCount() == 10);
    }
    
    @Test
    public void numberOfColumnsTest() {
        MinesweeperBoard board = new MinesweeperBoard(10, 10, 8);
        assertTrue(board.getColCount() == 10);
    }
    
    @Test
    public void getBoardMinesTest() {
      int rows = 7;
      int cols = 8;
      int mines = 10;
      MinesweeperBoard board = new MinesweeperBoard(rows,cols,mines);
      assertTrue(board.getMineCount() == mines);
    }
    
    @Test
    public void isValidIndexTest() {
      int rows = 7;
      int cols = 8;
      int mines = 10;
      MinesweeperBoard board = new MinesweeperBoard(rows,cols,mines);
      for (int i=0; i< cols; i++){
        for (int j=0; i< rows; i++){
          assertTrue(board.isValidCoordinate(i,j));
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
    public void getBoardColsTest1(){
    	MinesweeperBoard board  = new MinesweeperBoard(2, 2, 4);
    	assertEquals(2, board.getColCount()); 	
    	
    }
    
    @Test
    public void getBoardColsTest2(){
    	MinesweeperBoard board  = new MinesweeperBoard(10, 10, 4);
    	assertEquals(10, board.getColCount()); 	
    	
    }

    @Test
    public void getBoardRowsTest1(){
    	MinesweeperBoard board  = new MinesweeperBoard(5, 5, 4);
    	assertEquals(5, board.getRowCount()); 	
    }

    @Test
    public void getBoardRowsTest2(){
    	MinesweeperBoard board  = new MinesweeperBoard(25, 25, 6);
    	assertEquals(25, board.getRowCount()); 	
    }
    
    @Test
    public void putMineFalseTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5,5,0);
       	assertFalse(board.hasMine(2,2));
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
