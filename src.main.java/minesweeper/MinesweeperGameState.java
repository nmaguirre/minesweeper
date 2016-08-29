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
        return board.getBoardRows();
    }

    public int numberofColumns() {
        return board.getBoardCols();
    }

    public int numberOfMines() {
        return board.getBoardMines();
    }

    public boolean gameEnded() {
        return this.gameEnded;
    }

    public boolean isMarked(int row, int col) {
        return false;
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

    public void open(int row, int col) { }

}
