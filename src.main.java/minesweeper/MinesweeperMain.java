package minesweeper;

import java.util.Scanner;

/** 
 * Main class of the minesweeper game, CLI version.
 * TODO improve this description
 * 
 * @author DOSE 2016 team
 *
 */
public class MinesweeperMain {

	/**
	 * User input handling
	 * 
	 * 
	 * 
	 *
	 */
	private static final String cmdOpen = "open";
	private static final String cmdBlock = "block";
	private static final String cmdUnblock = "unblock";
	
	private static Scanner comScanner = new Scanner(System.in);

	public static String[] getUserInput() {
		String[] command = null;
		while (true) {
			command = comScanner.nextLine().split(" ");
			//for(String s:command)
			//	System.out.print(s + "---");
			
			// Sanitize number of arguments
			if(command.length != 3) {
				System.out.println(usage("Wrong number of arguments. "));
//				System.out.print("Wrong number of arguments. ");
//				System.out.println("Usage: <cmd> <coordX> <coordY>");
				continue;
			}
			
			// Sanitize X coordinate
			try {
				int coordX = Integer.parseInt(command[1]);
				if(!(0 <= coordX && coordX < game.numberOfRows())) {
					System.out.println(usage("Invalid X coordinate: out of bounds. "));
//					System.out.print("Invalid X coordinate: out of bounds. "); 
//					System.out.println("Usage: <cmd> <coordX> <coordY>");
					continue;
				}	
			} catch (NumberFormatException e) {
				System.out.println(usage("Invalid X coordinate: not a number. "));
//				System.out.print("Invalid X coordinate: not a number. ");
//				System.out.println("Usage: <cmd> <coordX> <coordY>");
				continue;
			}
			
			// Sanitize Y coordinate
			try {
				int coordY = Integer.parseInt(command[2]);
				if(!(0 <= coordY && coordY < game.numberOfRows())) {
					System.out.println(usage("Invalid Y coordinate: out of bounds. "));
//					System.out.print("Invalid Y coordinate: out of bounds. "); 
//					System.out.println("Usage: <cmd> <coordX> <coordY>");
					continue;
				}	
			} catch (NumberFormatException e) {
				System.out.println(usage("Invalid Y coordinate: not a number. "));
//				System.out.print("Invalid Y coordinate: not a number. ");
//				System.out.println("Usage: <cmd> <coordX> <coordY>");
				continue;
			}
			
			// Sanitize command: If succeds we're done.
			if(command[0].equals(cmdOpen))
				break;
			if(command[0].equals(cmdBlock))
				break;
			if(command[0].equals(cmdUnblock)) 
				break;
			
			// If it got here input didn`t check
			System.out.println(usage("Wrong command"));
//			System.out.print("Wrong command, only ");
//			System.out.print("\"" + cmdOpen + "\", ");
//			System.out.print("\"" + cmdBlock + "\" or ");
//			System.out.print("\"" + cmdUnblock + "\" ");
//			System.out.print("are accepted. ");
//			System.out.println("Usage: <cmd> <coordX> <coordY>");
		}
		// Some assumptions. Should check out fine. 
		assert command != null;
		assert command.length == 3;
		
		return command;
	}
	
	private static String usage(String errorMsg) {
		String res = errorMsg + "\n";
		res += "\"" + cmdOpen + "\", ";
		res += "\"" + cmdBlock + "\" or ";
		res += "\"" + cmdUnblock + "\" ";
		res += "are accepted.\n";
		res += "Usage: <cmd> <coordX> <coordY>";
		return res;
	}
	
	
	/** THE GAME. 
	 * 
	 *  ENJOY :)
	 * 
	 *  DOSE 2016 TEAM
	 *   
	 */
	private static MinesweeperGameState game;

	/**
	 * Runs minesweeper game with simple settings:
	 * 10 rows, 10 cols, 8 mines in random places.
	 * TODO improve this description.
	 * @param args
	 */
	public static void main(String[] args) {
		game = new MinesweeperGameState();
		String[] cmd;
		while(!game.gameEnded()){
			System.out.println(game.toString());
			System.out.println(usage(""));
			cmd = getUserInput();
			int coordX = -1, coordY = -1; 
			try {
				coordX = Integer.parseInt(cmd[1]);
				coordY = Integer.parseInt(cmd[2]);
			} catch (NumberFormatException e) {
				// Should not happen
				// Get medieval!!
				assert false; 
			}
			
			
			if(cmd[0].equals(cmdOpen)) {
				game.open(coordX, coordY);
			} else if(cmd[0].equals(cmdBlock)) {
				game.mark(coordX, coordY);
			} else if(cmd[0].equals(cmdUnblock)) {
				game.unMarked(coordX, coordY);
			} else {
				// Should have been one of the above
				// Get medieval!!
				assert false; 
			}
		}

		if(game.gameEnded()){
			if (game.result()){
				System.out.println ("You Win!!");
			}
			else {
				System.out.println ("You Lose");	
			}
			game.openAllMines();
		}
		System.out.print(game.toString());
	}

}
