package minesweeper;

/**
 * This class represents a cell in the game and their members and methods to
 * ensure this.
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

    /**
     * The constructor of MinesweeperCell class sets the new cell
     * properties as false.
     * The created cell is not blocked, it does not have a mine inside and it is not open.
     */
    public MinesweeperCell() {
        this.isBlockedCell = false;
        this.isMine = false;
        this.isOpenCell = false;
    }

    /**
     * @return true iff cell is blocked
     */
    public boolean isBlocked() {
        return this.isBlockedCell;
    }

    /**
     * @return true iff cell is close
     */
    public boolean isClose() {
        return !this.isOpenCell;
    }

    /**
     * @return true iff cell is open
     */
    public boolean isOpen() {
        return this.isOpenCell;
    }

    /**
     * @return true iff cell has a mine
     */
    public boolean hasMine() {
        return this.isMine;
    }

    /** This method fill the cell with a mine.
     * @throws IllegalStateException when called on a open or blocked cell or with a mine. */
    public void putMine() {
        if (this.hasMine() || this.isOpen())
            throw new IllegalStateException("Can't put mine while the cell is open or already have a mine ");
        this.isMine = true;
    }

    /**
     * This method open a cell. A cell can be open if the cell is close.
     * @throws IllegalStateException when called on a open or blocked cell.
     */
    public void open() {
        if (this.isOpen() || this.isBlocked())
            throw new IllegalStateException("Can't open a cell when it's open or it's blocked ");
        this.isOpenCell = true;
    }

    /**
     * This method blocks the cell when closed.
     * @throws IllegalStateException when called on a open or blocked cell.
     */
    public void block() {
        if (this.isBlocked() || this.isOpen())
            throw new IllegalStateException("Can't block a cell when it's open or it's blocked ");
        this.isBlockedCell = true;
    }

    /** This method unblock the cell blocked.
     * @throws IllegalStateException when called on unblocked cell */
    public void unblock() {
        if (!this.isBlocked())
            throw new IllegalStateException("Can't unblock an unblocked or opened cell");
        this.isBlockedCell = false;
    }
}
