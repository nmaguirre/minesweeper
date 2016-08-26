package minesweeper;

public class MinesweeperBoard {

	private MinesweeperCell[][] board;
	
	public MinesweeperBoard(int rows, int cols, int mines) {
		// TODO Auto-generated constructor stub
	}

	public int numberOfMinedNeighbours(int row, int col) {
		return 0;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return true if the cell located at the given position is Opened.
	 */
	public boolean isOpened(int row, int col) {
		MinesweeperCell cell = board[row][col];
		return !cell.isClose();
	}
}
