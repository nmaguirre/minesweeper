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
		
	public boolean isBlocked(){
		return this.blockedCell;
	}

	public void putMine(){
		if (!this.emptyCell && this.blockedCell ) throw IllegalStateException("Can't put mine while the cell is bloked or is not empty");
		this.emptyCell = false;
	}

	public boolean isOpen(){
		return this.openCell;
	}
	
}
