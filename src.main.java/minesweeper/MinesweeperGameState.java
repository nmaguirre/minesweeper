package minesweeper;

import java.awt.Color;

public class MinesweeperGameState {

    private MinesweeperBoard board;
    private boolean gameEnded;

    public MinesweeperGameState() {
        // default game
        // game started
        // board: 10x10
        // mines: 8 (randomly distributed)
        // all cells closed, none marked
    }
    
    
    /**
     * 
     * @return return the number of the rows of the board
     */

    public int numberOfRows() {
        return board.getRowCount();
    }
    
    /**
     * 
     * @return return the number of columns of the board
     */
    public int numberofColumns() {
        return board.getColCount();
    }

    /**
     * 
     * @return returns the number of mines on the board
     */
    public int numberOfMines() {
        return board.getMineCount();
    }
    
    /**
     * Return true if the game is ended.This method is used to see the 
     * outside of class if the game is ended or not
     * @return true if this.gameEnded is true
     */
    public boolean gameEnded() {
        return this.gameEnded;
    }

    /**
     * Returns true if the cell located at the given position is Marked. This method
     * allows you to see outside of class if a cell of the board is mark or not.
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
     * @return if the cell located at the given position is Marked.
     */
    public boolean isMarked(int row, int col) {
        return board.isMarked(row, col);
    }
    
    /**
     * Change state of a cell to blocked if the game is not ended
     * @param row
     * @param col
     */
    public void mark(int row, int col) { 
    	if(!gameEnded){
    		board.mark(row, col);
    	}
    }

    /**
     * @param row
     * @param col
     * @return true if the cell located at the given position is Opened.
     */
    public boolean isOpened(int row, int col) {
        return board.isOpened(row, col);
    }

    /**
     * @param row file number of the board where the cell is located.
     * @param col column number of the board where the cell is located.
     * This method open a cell in a position.
     */
    public void open(int row, int col) {
    	if( !board.isOpened(row, col) && !board.isMarked(row, col)){ //if the cell is not open or marked
    		board.open(row, col);//open the cell
    		if(!board.hasMine(row, col)){//if the cell has not a mine
    			board.openNeighboringMines(row, col);//open all neighbor cells that do not have mines
    			
    		}
    	}
    }
    

}
