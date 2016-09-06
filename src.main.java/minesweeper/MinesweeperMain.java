package minesweeper;
/** 
 * Main class of the minesweeper game, CLI version.
 * TODO improve this description
 * 
 * @author DOSE 2016 team
 *
 */
public class MinesweeperMain {
	
	public static String getUserInput(){
		String command;
		String coord1;
		String coord2;
		command = System.in.toString();
		coord1 = System.in.toString();
		coord2 = System.in.toString();
		return command + coord1 + "," + coord2;
	}
	
	/**
	 * Runs minesweeper game with simple settings:
	 * 10 rows, 10 cols, 8 mines in random places.
	 * TODO improve this description.
	 * @param args
	 */
	public static void main(String[] args) {
		//TODO implement this method.
	}

}
