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
	/**
	 * 
	 * @return This method should indicate the quantity of mines nearby of a cell. 
	 * @param rows - number of rows of the board
     * @param cols - number of colums of the board
	 **/
	public int numberOfMinedNeighbours(int row, int col) {
		return 0;
	}
	
	private boolean checkValidPositionWithMine(int row, int col){
		boolean cellWithMine = false;
		if (row>=0 && row <=boardRows && col >=0 && col <=boardCols && board[row][col].hasMine() ){
			cellWithMine=true;
		}
		return cellWithMine;
	}
	
	/**
	 * 
	 * @return number of rows of the board
	 *
	 **/
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
  	
  	public boolean isMarked(int row, int col) {
		return board[row][col].isBlocked();
	}
  	
	public int getRows() {
		return 0;
	}

	public void mark(int row, int col){
		board[row][col].block();
	}

}
