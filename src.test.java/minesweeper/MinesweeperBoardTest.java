package minesweeper;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MinesweeperBoardTest {
	private MinesweeperBoard boardAux;
		
	
	
	@Before
	public void setUp(){
		boardAux = new MinesweeperBoard(10,10);
		boardAux.putMine(0,0);
		boardAux.putMine(0,1);
		boardAux.putMine(0,2);
		boardAux.putMine(1,0);
		boardAux.putMine(1,1);
		boardAux.putMine(1,2);
		boardAux.putMine(2,0);
		boardAux.putMine(2,1);
		boardAux.putMine(2,2);
		boardAux.putMine(9,9);
	}

    @Test
    public void ConstructorTestWithMinesPositive() {
      MinesweeperBoard board = new MinesweeperBoard(5,5,10);
      boolean checkRows = board.getRowCount() == 5;
      boolean checkCols = board.getColCount() == 5;
      boolean checkMines = board.getMineCount() == 10;
      assertTrue(checkRows && checkCols && checkMines);
    }
    
    public void ConstructorTestWithoutMinesPositive() {
      MinesweeperBoard board = new MinesweeperBoard(5,5);
      boolean checkRows = board.getRowCount() == 5;
      boolean checkCols = board.getColCount() == 5;
      assertTrue(checkRows && checkCols );
    }

    public void ConstructorTestWithMinesNegative() {
      MinesweeperBoard board = new MinesweeperBoard(-5,-5,10);
      assertTrue(board == null);
    }
    
    public void ConstructorTestWithoutMinesNegative() {
      MinesweeperBoard board = new MinesweeperBoard(-5,-5);
      assertTrue(board == null);
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
    
    @Test(expected=IllegalArgumentException.class)
    public void putMineExeptionTest3(){
      MinesweeperBoard board = new MinesweeperBoard(5,5,0);
      board.putMine(-5,8);
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
    public void isValidCoordenateTest() {
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
    public void notValidCoordenateTest() {
      int rows = 7;
      int cols = 8;
      int mines = 10;
      MinesweeperBoard board = new MinesweeperBoard(rows,cols,mines);
      assertFalse(board.isValidCoordinate(0,-1));
      assertFalse(board.isValidCoordinate(8,0));
      assertFalse(board.isValidCoordinate(-1,6));
      assertFalse(board.isValidCoordinate(0,8));
      assertFalse(board.isValidCoordinate(-2,-2));
      assertFalse(board.isValidCoordinate(9,9));
      assertFalse(board.isValidCoordinate(5,9));
      assertFalse(board.isValidCoordinate(9,5));
    }
    
    @Test
    public void isMarkedTest(){
    	MinesweeperBoard board = new MinesweeperBoard(8,8,10);
    	board.mark(0,0);
    	assertTrue(board.isMarked(0, 0));
    }

    @Test
    public void isNotMarkedTest(){
    	MinesweeperBoard board = new MinesweeperBoard(8,8,10);
    	assertFalse(board.isMarked(0,0));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void markExeptionTest(){
      MinesweeperBoard board = new MinesweeperBoard(5,5,0);
      board.mark(-5,8);
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
    /*
     * [+][*][ ]
     * [*][*][ ]
     * [ ][ ][ ]
     */
    public void numberOfMinedNeighboursTest1(){
    	assertEquals(3,boardAux.numberOfMinedNeighbours(0,0));
    }
    
    @Test
    /*
     * [*][+][*]
     * [*][*][*]
     * [ ][ ][ ]
     */
    public void numberOfMinedNeighboursTest2(){
    	assertEquals(5,boardAux.numberOfMinedNeighbours(0,1));
    }
    
    @Test
    /*
     * [ ][*][+]
     * [ ][*][*]
     * [ ][ ][ ]
     */
    public void numberOfMinedNeighboursTest3(){
    	assertEquals(3,boardAux.numberOfMinedNeighbours(0,2));
    }
    
    @Test
    /*
     * [*][*][ ]
     * [+][*][ ]
     * [*][*][ ]
     */
    public void numberOfMinedNeighboursTest4(){
    	assertEquals(5,boardAux.numberOfMinedNeighbours(1,0));
    }
    
    @Test
    /*
     * [*][*][*]
     * [*][+][*]
     * [*][*][*]
     */
    public void numberOfMinedNeighboursTest5(){
    	assertEquals(8,boardAux.numberOfMinedNeighbours(1,1));
    }
    
    @Test
    /*
     * [ ][*][*]
     * [ ][*][+]
     * [ ][*][*]
     */
    public void numberOfMinedNeighboursTest6(){
    	assertEquals(5,boardAux.numberOfMinedNeighbours(1,2));
    }
    
    @Test
    /*
     * [ ][ ][ ]
     * [*][*][ ]
     * [+][*][ ]
     */
    public void numberOfMinedNeighboursTest7(){
    	assertEquals(3,boardAux.numberOfMinedNeighbours(2,0));
    }
    
    @Test
    /*
     * [ ][ ][ ]
     * [*][*][*]
     * [*][+][*]
     */
    public void numberOfMinedNeighboursTest8(){
    	assertEquals(5,boardAux.numberOfMinedNeighbours(2,1));
    }
    
    @Test
    /*
     * [ ][ ][ ]
     * [ ][*][*]
     * [ ][*][+]
     */
    public void numberOfMinedNeighboursTest9(){
    	assertEquals(3,boardAux.numberOfMinedNeighbours(2,2));
    }
    
    @Test
    /*
     * [ ][ ][ ]
     * [ ][ ][ ]
     * [ ][ ][+]
     */
    public void numberOfMinedNeighboursTest10(){
    	assertEquals(0,boardAux.numberOfMinedNeighbours(9,9));
    }
    
    @Test(expected=IllegalArgumentException.class)
    /*
     * [ ][ ][ ]
     * [ ][ ][ ]
     * [ ][ ][ ]
     */
    public void numberOfMinedNeighboursTest11(){
    	boardAux.numberOfMinedNeighbours(30,10);
    }

    
    @Test
    public void hasMineFalseTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5, 5, 0);
    	assertFalse(board.hasMine(1, 1));

	}
    
    @Test
    public void hasMineTrueTest() {
    	MinesweeperBoard board = new MinesweeperBoard(5, 5, 0);
    	board.putMine(1,1);
    	assertTrue(board.hasMine(1, 1));
    	
	}
    //Test for AddRandomMines
    @Test
    public void addRandomMinesTestNominal(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	int n=8;
    	boardAux1.addRandomMines(n);
    	assertEquals(n,boardAux1.getMineCount());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void addRandomMinesTestExceptionNegative(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	int n=-1;
    	boardAux1.addRandomMines(n);
    	
    }
    @Test(expected=IllegalArgumentException.class)
    public void addRandomMinesTestExceptionZero(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	int n=0;
    	boardAux1.addRandomMines(n);
    	
    }
    @Test(expected=IllegalArgumentException.class)
    public void addRandomMinesTestExceptionEdgeTop(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	int n=100;
    	boardAux1.addRandomMines(n);

    } 
    @Test(expected=IllegalArgumentException.class)
    public void addRandomMinesTestExceptionEdgeTop2(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	int n=101;
    	boardAux1.addRandomMines(n);

    }

    @Test 
    public void addRandomMinesTestMark(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	boardAux1.mark(0, 0);
    	int n=3;
    	boardAux1.addRandomMines(n);
    	assertEquals(n,boardAux1.getMineCount());
    }
    @Test
    public void addRandomMinesOpen(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	boardAux1.open(3, 3);
    	int n=4;
    	boardAux1.addRandomMines(n);
    	assertEquals(n,boardAux1.getMineCount());
    }
    @Test
    public void addRandomMinesTestPutMine(){
    	MinesweeperBoard boardAux1 = new MinesweeperBoard(10,10);
    	boardAux1.putMine(3, 3);
    	int n=4;
    	boardAux1.addRandomMines(n);
    	assertEquals(n,boardAux1.getMineCount());
    }
    
    @Test
    public void unMarkedTest() {
	  MinesweeperBoard board = new MinesweeperBoard(8,8,10);
	  board.mark(0,0);
	  assertTrue(board.isMarked(0, 0));
	  board.unMarked(0, 0);
	  assertFalse(board.isMarked(0, 0));
    }
    
	@Test
	public void getClosedCellsCountTestCase1() {
	  MinesweeperBoard board = new MinesweeperBoard(8,8);
	  board.putMine(2,2);
	  board.open(2,2);
	  assertEquals(63,board.getClosedCellsCount());
	}
	
	@Test
	public void getClosedCellsCountTestCase2() {
	  MinesweeperBoard board = new MinesweeperBoard(8,8);
	  assertEquals(64,board.getClosedCellsCount());
	}
}
