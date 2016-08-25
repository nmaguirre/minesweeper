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
	
	public boolean isOpened(int row, int col) {
		return false;
	}
	
	public void open(int row, int col) {
		
	}
		
}
