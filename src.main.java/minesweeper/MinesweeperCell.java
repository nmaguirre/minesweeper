package minesweeper;

public class MinesweeperCell {
	private boolean blockedCell;

	public MinesweeperCell (){
		this.blockedCell = false;
	}
	
	public boolean isBlocked(){
		return this.blockedCell;
	}
}
