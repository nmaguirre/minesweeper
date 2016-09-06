package minesweeper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This Class MinesweeperBoard represents a 
 * particular board in the game with the necessary 
 * methods for handling. In addition, the board is composed
 * of cells.
 **/

public class MinesweeperBoard {
	
	/**
	 * board is a matrix of cells representing the game board.
	 * boardRows represents the size of the rows of the board.
	 * boardCols represents the size of the columns of the board.
	 * boardMines represents the number of mines containing the board. 
	 **/
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
     * constructor create the game's board without mines
     * @param height - number of rows of the board
     * @param width - number of colums of the board
     */

    public MinesweeperBoard (int height, int width){

        boardRows = height;
        boardCols = width;
        boardMines = 0;
        
        board = new MinesweeperCell[boardRows][boardCols];
        
        for (int r=0; r < boardRows;r++)
        	for (int c=0; c < boardCols; c++) 
        		board[r][c]=new MinesweeperCell(); 
    }

    /**
	 * @param row - number of row of the board
     * @param col - number of column of the board
	 * @return true when coordinate is valid rangethat takes
	 */
	public boolean isValidCoordinate(int row, int col) {

		boolean validCoordinate = row>=0 && row<boardRows && col>=0 && col<boardCols;
		return validCoordinate;

	}
        
	/**
	 * This method open recursively all neighboring cells to a specific cell
	 * @param row
	 * @param col
	 *
	 */
        
	public void openNeighboringMines(int row, int col){
		if (!isValidCoordinate(row,col)){
    		throw new IllegalArgumentException("Invalid coordenate.");
    	} else {
            if (isValidCoordinate(row,col+1) && !isOpened(row, col+1) && !isMarked(row, col+1) && !hasMine(row, col+1)){
            	if ( numberOfMinedNeighbours(row, col+1) == 0){
            		open(row, col+1);
            		openNeighboringMines(row, col+1);
            		
            	} else{
            		open(row, col+1);
            	}
            }   
            if (isValidCoordinate(row + 1, col + 1) && !isOpened(row + 1, col + 1) && !isMarked(row + 1, col + 1) && !hasMine(row + 1, col + 1)){
            	if ( numberOfMinedNeighbours(row + 1, col + 1) == 0){
            		open(row+1, col+1);
            		openNeighboringMines(row+1, col+1);
            	} else{
            		open(row + 1, col + 1);
            	}
            }
            if (isValidCoordinate(row + 1, col) && !isOpened(row + 1, col) && !isMarked(row + 1, col) && !hasMine(row + 1, col)){
            	if ( numberOfMinedNeighbours(row + 1, col) == 0){
            		open(row + 1, col);
            		openNeighboringMines(row+1, col);
            	} else{
            		open(row + 1, col);
            	}
            }
            if (isValidCoordinate(row + 1, col - 1) && !isOpened(row + 1, col - 1) && !isMarked(row + 1, col - 1) && !hasMine(row + 1, col - 1)){
            	if ( numberOfMinedNeighbours(row + 1, col - 1) == 0){
            		open(row + 1, col - 1);
            		openNeighboringMines(row+1, col-1);
            		
            	} else{
            		open(row + 1, col - 1);
            	}
            }
            if (isValidCoordinate(row, col - 1) && !isOpened(row, col - 1) && !isMarked(row, col - 1) && !hasMine(row, col - 1)){
            	if ( numberOfMinedNeighbours(row, col - 1) == 0){
            		open(row, col - 1);
            		openNeighboringMines(row, col-1);
            		
            	} else{
            		open(row, col - 1);
            	}
            }
            if (isValidCoordinate(row - 1, col - 1) && !isOpened(row - 1, col - 1) && !isMarked(row - 1, col - 1) && !hasMine(row - 1, col - 1)){
            	if ( numberOfMinedNeighbours(row - 1, col - 1) == 0){
            		open(row - 1, col - 1);
            		openNeighboringMines(row-1, col-1);
            		
            	} else{
            		open(row - 1, col - 1);
            	}
            }
            if (isValidCoordinate(row - 1, col) && !isOpened(row - 1, col) && !isMarked(row - 1, col) && !hasMine(row - 1, col)){
            	if ( numberOfMinedNeighbours(row - 1, col) == 0){
            		open(row - 1, col);
            		openNeighboringMines(row-1, col);
            		
            	} else{
            		open(row - 1, col);
            	}
            }
            if (isValidCoordinate(row - 1, col + 1) && !isOpened(row - 1, col + 1) && !isMarked(row - 1, col + 1) && !hasMine(row - 1, col + 1)){
            	if ( numberOfMinedNeighbours(row - 1, col + 1) == 0){
            		open(row - 1, col + 1);
            		openNeighboringMines(row-1, col+1);
            		
            	} else{
            		open(row - 1, col + 1);
            	}
            }
		}
	}

    /**
     * @param row - number of row of the board
     * @param col - number of column of the board
     * @return This method should indicate the quantity of mines nearby of a cell.
     **/
    public int numberOfMinedNeighbours(int row, int col) {
    	if (!isValidCoordinate(row,col)){
    		throw new IllegalArgumentException("Invalid coordenate.");
    	}
        int mine = 0;
        //neighbors look limiting
        if (isValidCoordinate(row,col+1) ){
        	if ( board[row][col+1].hasMine() )
        		mine++;
        }        	
        if (isValidCoordinate(row + 1, col + 1)){
        	if ( board[row+1][col+1].hasMine() )
        		mine++;
        }        
        if (isValidCoordinate(row + 1, col)){
        	if( board[row+1][col].hasMine())
        		mine++;
        }            
        if (isValidCoordinate(row + 1, col - 1)){
        	if ( board[row+1][col-1].hasMine())
        		mine++;
        }
        if (isValidCoordinate(row, col - 1)){
        	if (board[row][col-1].hasMine())
        		mine++;
        }
        if (isValidCoordinate(row - 1, col - 1)){
        	if(board[row-1][col-1].hasMine())
        		mine++;        		
        }
        if (isValidCoordinate(row - 1, col)){
        	if(board[row-1][col].hasMine())
        		mine++;
        }
        if (isValidCoordinate(row - 1, col + 1)){
        	if (board[row-1][col+1].hasMine())
        		mine++;
        }
        return mine;
    }

    /**
     * @return number of rows of the board
     **/
    public int getRowCount() {
        return boardRows;
    }

    /**
     * @return number of cols of the board
     **/
    public int getColCount() {
        return boardCols;
    }
    
    /**
     * Return number of mines of the board. This method allows you to see outside 
     * of class the number of mines on the board
     * @return number of mines of the board
     */
    public int getMineCount() {
        return boardMines;
    }
    
    /**
     * put mine in board in the cell located at the given position
     * @param row - file number of the board where the cell is located.
     * @param col - column number of the board where the cell is located.
     * @throws IllegalStateException if the cell is open or already content a mine
     * @throws IllegalArgumentException if coordenate is invalid
     * 
     */
    public void putMine(int row, int col) {
		if (!isValidCoordinate(row,col)) throw new IllegalArgumentException("Coordenate is invalid");
		if (board[row][col].isOpen() || board[row][col].hasMine() || board[row][col].isBlocked()) throw
			  new IllegalStateException("cell open,blocked or already exists mine");
		board[row][col].putMine(); 
		++this.boardMines;
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
     * This method open a cell. A cell can be open if the cell is close.
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
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
    	if (isValidCoordinate(row,col)){
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
    
    /**
     * This method Unmark the current position if a mine is Marked.
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
     */
    
    public void unMarked (int row, int col){
    	if(isValidCoordinate(row,col)){
    		if(isMarked(row,col)){
    			board[row][col].unblock();
    		}
    	}
    }
    
    
    /**
     * This method takes a integer value that represents how many mines to add to the board,
     * and adds them in random coordinates.
     * @param n - quantity of mines to add to the board.
     */
    public void addRandomMines(int n){
    	ArrayList<MinesweeperCell> freeCells = new ArrayList<MinesweeperCell>();
    	for (int row = 0; row < this.getRowCount(); row ++){
    		for (int col = 0; col < this.getColCount(); col++){
    			if (!((board[row][col].isBlocked())
    				||(board[row][col].isOpen())
    				||(board[row][col].hasMine()))){
    				
    				freeCells.add(board[row][col]);
    			}
    		}
    	}
    	if (!((0<n)&&(n<freeCells.size()))) {
    		throw new IllegalArgumentException("The argument is not valid.");
    	}
    	// freeCells is reordered by the Fisher-Yates algorithm implemented in shuffle(List<?> list) method. This method runs in linear time.
    	Collections.shuffle(freeCells);
    	//In each of the first N cells in the freeCells list, a mine is inserted.
    	for (MinesweeperCell cell : freeCells.subList(0, n)){
    		cell.putMine();
    	}
    }
    
    /**
     * String that represent visually the board
     */
    public String toString() {
    	String result = "";
    	MinesweeperCell actualCell;
    	for (int row = 0; row<this.getRowCount(); row++){
    		for (int col = 0; col<this.getColCount(); col++){
    			actualCell = board[row][col];
    			if(actualCell.isOpen()){
    				if(actualCell.hasMine()){
    					//ABIERTA CON MINAS (X)
    					result = result + " X ";
    				}
    				else{
    					//ABIERTA SIN MINAS (0-9)
    					result = result + " " + Integer.toString(this.numberOfMinedNeighbours(row, col)) + " ";
    				}
    			}
    			else{
    				if(actualCell.isBlocked()){
    					//CERRADA Y BLOQUEADA (B)
    					result = result + " B ";
    				}
    				else{
    					//CERRADA Y DESBLOQUEADA (-)
    					result = result + " - ";
    				}
    			}
    		}
    		result = result + "\n";
    	}
    	return result;
    }

	
    /**
     * Return number of closed mines from board.
     * @return number of closed mines
     */
    public int getClosedCellsCount() {
		int count = 0;
		for(int col=0;col<getColCount();col++){
			for(int row=0;row<getRowCount();row++ ){
				if(!isOpened(row, col)){ //if cell is not open
					count++;
				}
			}
		}
		return count;
	}
}
