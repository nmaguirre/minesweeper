package minesweeper;

public class MinesweeperCell {
	private boolean blockedCell;
	private boolean emptyCell;
	private boolean openCell;
	
	public MinesweeperCell (){
		this.blockedCell = false;
		this.emptyCell = true;
		this.openCell = false;
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
		return !(this.openCell);
	}

	
	/**
	 * This method fill the cell with a mine. 
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
	  }
  }
	/**
	 * 
	 * @return true iff cell has a mine
	 */
	public boolean hasMine(){
		return this.emptyCell == false;	
	}
	
	/**
	 * This method block the cell when 
	 */
	public void block(){
		if(this.isOpen()) throw new IllegalStateException("Can't block a cell when it's open "); 
		this.blockedCell = true;
	}
	
}
