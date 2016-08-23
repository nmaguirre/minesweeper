package minesweeper;

public class MinesweeperCell {
	private boolean blockedCell;
	private boolean emptyCell;

	public MinesweeperCell (){
		this.blockedCell = false;
		this.emptyCell = true;
	}
	
	public boolean isBlocked(){
		return this.blockedCell;
	}
	
	public void putMine(){
		if (!this.emptyCell && this.blockedCell ) throw IllegalStateException("Can't put mine while the cell is bloked or is not empty");
		this.emptyCell = false;
	}
}
