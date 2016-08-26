package minesweeper;

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
	
	public int numberOfRows() {
		return 0;
	}
	
	public int numberofColumns() {
		return 0;
	}
	
	public int numberOfMines() {
		return 0;
	}
	
	public boolean gameEnded() {
		return false;
	}
	
	public boolean isMarked(int row, int col) {
		return false;
	}
	
	public void mark(int row, int col) {
		
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return true if the cell located at the given position is Opened.
	 */
	public boolean isOpened(int row, int col) {
		return board.isOpened(row, col);
	}
	
	public void open(int row, int col) {
		
	}
		
}
