package minesweeper;

public class MinesweeperBoard {

	private MinesweeperCell[][] board;
	private int boardRows;
	private int boardCols;
	private int boardMines;
	
	/**
   * constructor
   * create the game's board
   * 
   * @param rows - number of rows of the board
   * @param cols - number of colums of the board
   * @param mines - number of mines of the board
   */
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
	 
	/**
	 * 
	 * 
	 * @return number of rows of the board
	 **/
  public int getBoardCols(){
    return boardCols;
  }

  public int getBoardMines(){
    return boardMines;
  }

	public int getRows() {
		return 0;
	}

}
