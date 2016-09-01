package minesweeper;

/** This class represents a cell in the game 
 * and their members and methods to ensure this.
 */
public class MinesweeperCell {
    
	/**
     * isBlockedCell represents if the cell is blocked or not
     * isMine represents if the cell has a mine inside or not
     * isOpenCell represents if the cell is open or not
     */
	private boolean isBlockedCell;
    private boolean isMine;
    private boolean isOpenCell;

    public MinesweeperCell() {
        this.isBlockedCell = false;
        this.isMine = false;
        this.isOpenCell = false;
    }

    /**
     * @return true if cell is blocked
     */
    public boolean isBlocked() {
        return this.isBlockedCell;
    }

    /**
     * @return true if the cell is close
     */
    public boolean isClose() {
        return !(this.isOpenCell);
    }

    /**
     * This method fill the cell with a mine.
     */
    public void putMine() {
        if (this.isMine || this.isOpenCell)
            throw new IllegalStateException("Can't put mine while the cell is open or already have a mine ");
        this.isMine = true;
    }

    public boolean isOpen() {
        return this.isOpenCell;
    }

    /**
     * This method open a cell.
     * A cell can be open if the cell is close.
     */
    public void open() {
        if (this.isClose()) {
            this.isOpenCell = true;
        }
    }

    /**
     * @return true iff cell has a mine
     */
    public boolean hasMine() {
        return this.isMine;
    }

    /**
     * This method blocks the cell when closed .
     * When the cell is open or blocked throw a IllegalStateException 
     */
    public void block() {
        if (this.isOpen() || this.isBlocked())
            throw new IllegalStateException("Can't block a cell when it's open or it's blocked ");
        this.isBlockedCell = true;
    }

    /**
     * This method unblock the cell blocked
     * @throws IllegalStateException when called on unblocked or opened cell.
     */
    public void unblock() {
    	if (!this.isBlocked()) throw new IllegalStateException("Can't unblock an unblocked or opened cell");
        this.isBlockedCell = false;
    }
}
