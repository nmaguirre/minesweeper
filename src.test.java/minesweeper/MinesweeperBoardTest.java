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
}
