package minesweeper;

public class MinesweeperCell {
	private boolean blockedCell;
	private boolean openCell;

	public MinesweeperCell (){
		this.blockedCell = false;
		this.openCell = false;
	}
	
	public boolean isBlocked(){
		return this.blockedCell;
	}
	
	public boolean isOpen(){
		return this.openCell;
	}
	
}
