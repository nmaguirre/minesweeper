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
		
	public boolean isBlocked(){
		return this.blockedCell;
	}
	
	public boolean isClose(){
		return this.closeCell;
	}

	public void putMine(){
		if (!this.emptyCell && this.blockedCell ) throw new IllegalStateException("Can't put mine while the cell is bloked or is not empty");
		this.emptyCell = false;
	}

	public boolean isOpen(){
		return this.openCell;
	}

	public boolean hasMine(){
		return this.emptyCell == false;	
	}
	
}
