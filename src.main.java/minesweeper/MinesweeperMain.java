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

	private static MinesweeperGameState game;
	
	private static Scanner comScanner;
	private static Scanner coord1Scanner;
	private static Scanner coord2Scanner;
	
	
	/**
	 * Take the actions provided by the user and return a String with the action and cell.
	 * @return a String with the action and cell.
	 */


	public static String getUserInput(){
		String command;
		String coord1= new String("");
		String coord2= new String("");
		comScanner = new Scanner(System.in);
		coord1Scanner = new Scanner(System.in);
		coord2Scanner = new Scanner(System.in);

		command = comScanner.nextLine();
		try {
			if(command!="o" || command!="b" || command!="u" || command!="O" || command!="B" || command!="U"){
				System.out.println("Comando incorrecto");
				getUserInput();
			}
		}catch(Exception e){
			coord1 = coord1Scanner.nextLine();
			coord2 = coord2Scanner.nextLine();
		}
		return command + coord1 + "," + coord2;
	}
	
	/**
	 * Runs minesweeper game with simple settings:
	 * 10 rows, 10 cols, 8 mines in random places.
	 * TODO improve this description.
	 * @param args
	 */
	public static void main(String[] args) {
		game = new MinesweeperGameState();
		
		String cmd = "";
		
		while(!game.gameEnded()){
			game.toString();
			cmd = getUserInput();
			//executeUserInptu(cmd);
		}
	}

}
