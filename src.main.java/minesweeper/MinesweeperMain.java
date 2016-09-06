package minesweeper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		String coords;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		command = br.readLine();
		coords = br.readLine();
		return command + coords;
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
