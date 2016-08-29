package minesweeper;

public class MinesweeperBoard {

    private MinesweeperCell[][] board;
    private int boardRows;
    private int boardCols;
    private int boardMines;

    /**
     * constructor create the game's board
     * @param rows - number of rows of the board
     * @param cols - number of colums of the board
     * @param mines - number of mines of the board
     */
    public MinesweeperBoard(int rows, int cols, int mines) {
        boardRows = rows;
        boardCols = cols;
        boardMines = mines;
    }

    /**
	 * 
	 * @param row
	 * @param col
	 * @return true when index is valid
	 */
	public boolean isValidIndex(int row, int col) {
		
		if (row<0 || col<0 || row>= boardRows || col>=boardCols) {
			throw new IllegalArgumentException("error index of matrix");
		} else return true;
		
	}

    /**
     * @return This method should indicate the quantity of mines nearby of a cell.
     * @param rows - number of rows of the board
     * @param cols - number of colums of the board
     **/
    public int numberOfMinedNeighbours(int row, int col) {
        int mine = 0;
        if (checkValidPositionWithMine(row, col + 1))
            mine++;
        if (checkValidPositionWithMine(row + 1, col + 1))
            mine++;
        if (checkValidPositionWithMine(row + 1, col))
            mine++;
        if (checkValidPositionWithMine(row + 1, col - 1))
            mine++;
        if (checkValidPositionWithMine(row, col - 1))
            mine++;
        if (checkValidPositionWithMine(row - 1, col - 1))
            mine++;
        if (checkValidPositionWithMine(row - 1, col))
            mine++;
        if (checkValidPositionWithMine(row - 1, col + 1))
            mine++;
        return mine;
    }

    private boolean checkValidPositionWithMine(int row, int col) {
        return row >= 0 && row <= boardRows && col >= 0 && col <= boardCols && board[row][col].hasMine();
    }

    /**
     * @return number of rows of the board
     **/
    public int getBoardRows() {
        return boardRows;
    }

    /**
     * @return number of rows of the board
     **/
    public int getBoardCols() {
        return boardCols;
    }

    public int getBoardMines() {
        return boardMines;
    }
    /**
     * put mine in board
     * @param row
     * @param col
     */
    
    public void putMine(int row, int col) {
		if (isValidIndex(row,col)) {
			if (board[row][col].isOpen() || board[row][col].hasMine()) throw
			  new IllegalStateException("cell open or already exists mine");
		         board[row][col].putMine(); 
		}
		
	}

    public boolean isMarked(int row, int col) {
        return board[row][col].isBlocked();
    }

    /**
     * @param row
     * @param col
     * @return true if the cell located at the given position is Opened.
     */
    public boolean isOpened(int row, int col) {
        MinesweeperCell cell = board[row][col];
        return !cell.isClose();
    }

    public void mark(int row, int col) {
    	if (isValidIndex(row,col)){
    		board[row][col].block();
    	}
    }

}
