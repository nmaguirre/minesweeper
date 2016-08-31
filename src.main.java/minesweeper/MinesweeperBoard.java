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
     * 		creates all the cells in the matrix
     */
    public MinesweeperBoard(int rows, int cols, int mines) {
        boardRows = rows;
        boardCols = cols;
        boardMines = mines;
        
        board = new MinesweeperCell[boardRows][boardCols];
        for (int r=0; r < boardRows;r++)
        	for (int c=0; c < boardCols; c++) 
        		board[r][c]=new MinesweeperCell();       
    }

    /**
	 * 
	 * @param row
	 * @param col
	 * @return true when coordinate is valid range
	 */
	public boolean isValidCoordenate(int row, int col) {
		
		if (row<0 || col<0 || row>= boardRows || col>=boardCols) {
			return false;
		} else return true;
		
	}

    /**
     * @param row - number of row of the board
     * @param col - number of column of the board
     * @return This method should indicate the quantity of mines nearby of a cell.
     **/
    public int numberOfMinedNeighbours(int row, int col) {
    	if (!isValidCoordenate(row,col)){
    		throw new IllegalArgumentException("Invalid coordenate.");
    	}
        int mine = 0;
        //neighbors look limiting
        if (isValidCoordenate(row,col+1) ){
        	if ( board[row][col+1].hasMine() )
        		mine++;
        }        	
        if (isValidCoordenate(row + 1, col + 1)){
        	if ( board[row+1][col+1].hasMine() )
        		mine++;
        }        
        if (isValidCoordenate(row + 1, col)){
        	if( board[row+1][col].hasMine())
        		mine++;
        }            
        if (isValidCoordenate(row + 1, col - 1)){
        	if ( board[row+1][col-1].hasMine())
        		mine++;
        }
        if (isValidCoordenate(row, col - 1)){
        	if (board[row][col-1].hasMine())
        		mine++;
        }
        if (isValidCoordenate(row - 1, col - 1)){
        	if(board[row-1][col-1].hasMine())
        		mine++;        		
        }
        if (isValidCoordenate(row - 1, col)){
        	if(board[row-1][col].hasMine())
        		mine++;
        }
        if (isValidCoordenate(row - 1, col + 1)){
        	if (board[row-1][col+1].hasMine())
        		mine++;
        }
        return mine;
    }

    /**
     * @return number of rows of the board
     **/
    public int getBoardRows() {
        return boardRows;
    }

    /**
     * @return number of cols of the board
     **/
    public int getBoardCols() {
        return boardCols;
    }
    
    /**
     * Return number of mines of the board. This method allows you to see outside 
     * of class the number of mines on the board
     * @return number of mines of the board
     */
    public int getBoardMines() {
        return boardMines;
    }
    
    /**
     * put mine in board in the cell located at the given position
     * @param row - file number of the board where the cell is located.
     * @param col - column number of the board where the cell is located.
     * @throws IllegalStateException if the cell is open or already content a mine
     */
    public void putMine(int row, int col) {
		if (isValidCoordenate(row,col)) {
			if (board[row][col].isOpen() || board[row][col].hasMine()) throw
			  new IllegalStateException("cell open or already exists mine");
		         board[row][col].putMine(); 
		}
		
	}
    
    /**
     * Returns true if the cell located at the given position is Marked. This method
     * allows you to see outside of class if a cell of the board is mark or not.
     * @param row  - file number of the board where the cell is located.
     * @param col - column number of the board where the cell is located.
     * @return if the cell located at the given position is Marked.
     */
    public boolean isMarked(int row, int col) {
        return board[row][col].isBlocked();
    }

    /**
     * Returns true if the cell located at the given position is Opened. This method
     * allows you to see outside of class if a cell of the board is open or not.
     * @param row - file number of the board where the cell is located.
     * @param col - column number of the board where the cell is located.
     * @return true if the cell located at the given position is Opened.
     */
    public boolean isOpened(int row, int col) {
        MinesweeperCell cell = board[row][col];
        return !cell.isClose();
    }
    
    /**
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
     * This method open a cell in a position.
     */
    public void open(int row, int col) {
    	MinesweeperCell cell = board[row][col];
        cell.open();
    }


    /**
     * This method receive the position of a cell board and should block it.
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
     */
    public void mark(int row, int col) {
    	if (isValidCoordenate(row,col)){
    		board[row][col].block();
    	}
    }

    
    /**
     * This method return true if the cell on the position given of the board has mine, otherwise return false.
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
     * @return true if the cell on the position given of the board has mine.
     */
    public boolean hasMine(int row, int col){
    	return board[row][col].hasMine();
    }	
    
    public void unMarked (int row, int col){
    	if(isValidCoordenate(row,col)){
    		if(isMarked(row,col)){
    			board[row][col].unblock();
    		}
    	}
}
}
