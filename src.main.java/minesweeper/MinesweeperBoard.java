package minesweeper;

public class MinesweeperBoard {

	private MinesweeperCell[][] board;
	private int boardRows;
	private int boardCols;
	private int boardMines;
	
	public MinesweeperBoard(int rows, int cols, int mines) {
		// TODO Auto-generated constructor stub
	  boardRows = rows;
	  boardCols = cols;
	  boardMines = mines;
	}

	public int numberOfMinedNeighbours(int row, int col) {
		return 0;
	}
	
	public int getBoardRows(){
    return boardRows;
  }
	  
  public int getBoardCols(){
    return boardCols;
  }

  public int getBoardMines(){
    return boardMines;
  }

}
