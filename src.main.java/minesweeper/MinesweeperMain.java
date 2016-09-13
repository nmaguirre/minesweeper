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
	 */
	private static final String CMD_OPEN = "open";
	private static final String CMD_BLOCK = "block";
	private static final String CMD_UNBLOCK = "unblock";
	private static final int COMMAND = 0;
	private static final int X_CORD = 1;
	private static final int Y_CORD = 2;
	private static final int COLS = 0;
	private static final int ROWS= 1;
	private static final int MINES = 2;
	
	private static Scanner comScanner = new Scanner(System.in);

	public static String[] getUserInput() {
		String[] input = null;
		while (true) {
			input = comScanner.nextLine().split(" ");
			
			// Sanitize number of arguments
			if(input.length != 3) {
				System.out.println(usage("Wrong number of arguments. "));
				continue;
			}
			
			// Sanitize X coordinate
			try {
				int coordX = Integer.parseInt(input[1]);
				if(!(0 <= coordX && coordX < game.numberOfRows())) {
					System.out.println(usage("Invalid X coordinate: out of bounds. "));
					continue;
				}	
			} catch (NumberFormatException e) {
				System.out.println(usage("Invalid X coordinate: not a number. "));
				continue;
			}
			
			// Sanitize Y coordinate
			try {
				int coordY = Integer.parseInt(input[2]);
				if(!(0 <= coordY && coordY < game.numberOfRows())) {
					System.out.println(usage("Invalid Y coordinate: out of bounds. "));
					continue;
				}	
			} catch (NumberFormatException e) {
				System.out.println(usage("Invalid Y coordinate: not a number. "));
				continue;
			}
			
			// Sanitize command: If succeds we're done.
			if(input[COMMAND].equals(CMD_OPEN))
				break;
			if(input[COMMAND].equals(CMD_BLOCK))
				break;
			if(input[COMMAND].equals(CMD_UNBLOCK)) 
				break;
			
			// If it got here input didn`t check
			System.out.println(usage("Wrong command"));
		}
		// Some assumptions. Should check out fine. 
		assert input != null;
		assert input.length == 3;
		
		return input;
	}
	
	private static String usage(String errorMsg) {
		String res = errorMsg + "\n";
		res += "\"" + CMD_OPEN + "\", ";
		res += "\"" + CMD_BLOCK + "\" or ";
		res += "\"" + CMD_UNBLOCK + "\" ";
		res += "are accepted.\n";
		res += "Usage: <cmd> <coordX> <coordY>";
		return res;
	}
	
	private static void executeUserInput(String[] user_input) {
		int coordX = -1, coordY = -1; 
		try {
			coordX = Integer.parseInt(user_input[X_CORD]);
			coordY = Integer.parseInt(user_input[Y_CORD]);
		} catch (NumberFormatException e) {
			// Should not happen
			// Get medieval!!
			assert false; 
		}
		
		if (user_input[COMMAND].equals(CMD_OPEN))
			game.open(coordX, coordY);
		else if (user_input[COMMAND].equals(CMD_BLOCK))
			game.mark(coordX, coordY);
		else if (user_input[COMMAND].equals(CMD_UNBLOCK))
			game.unMarked(coordX, coordY);
		else 
			// Should have been one of the above
			// Get medieval!!
			assert false; 
	}
	
	
	/** THE GAME. 
	 *  ENJOY :)
	 *  DOSE 2016 TEAM
	 */
	private static MinesweeperGameState game;

	/**
	 * Runs minesweeper game with simple settings:
	 * 10 rows, 10 cols, 8 mines in random places.
	 * TODO improve this description.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input;
		
		if (args.length != 3)
			game = new MinesweeperGameState();
		else
			game = new MinesweeperGameState(Integer.parseInt(args[ROWS]), 
					                        Integer.parseInt(args[COLS]), 
							                Integer.parseInt(args[MINES]));
		
		while(!game.gameEnded()){
			System.out.println(game.toString());
			System.out.println(usage(""));
			input = getUserInput();
			executeUserInput(input);
		}

		if(game.gameEnded()){
			game.openAllMines();
			if (game.result())
				System.out.println("You Win!!");
			else
				System.out.println("You Lose :(");	
		}
		
		System.out.print(game.toString());
	}

}
