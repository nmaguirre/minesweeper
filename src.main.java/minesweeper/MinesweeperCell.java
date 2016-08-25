package minesweeper;

public class MinesweeperCell {
	private boolean blockedCell;
	private boolean emptyCell;
	private boolean openCell;
	private boolean closeCell;
	
	public MinesweeperCell (){
		this.blockedCell = false;
		this.emptyCell = true;
		this.openCell = false;
		this.closeCell = true;
	}
	
	/**
	 * 
	 * @return true if cell is blocked
	 */
	public boolean isBlocked(){
		return this.blockedCell;
	}
	
	/**
	*
	* @return true if the cell is close
	* 
	*/
	public boolean isClose(){
		return this.closeCell;
	}

	/**
	 * Change the state of the cell when put a new mine
	 * 
	 */
	public void putMine(){
		if (!this.emptyCell && this.blockedCell ) throw new IllegalStateException("Can't put mine while the cell is bloked or is not empty");
		this.emptyCell = false;
	}

	public boolean isOpen(){
		return this.openCell;
	}
	
	/**
	 * change the state of the cell if this is close
	 * 
	 * @see isClose()
	 */
	public void open(){
	  if (this.isClose()){
	    this.openCell = true;
	    this.closeCell = false;
	  }
  }
	/**
	 * 
	 * @return true iff cell has a mine
	 */
	public boolean hasMine(){
		return this.emptyCell == false;	
	}
	
}
