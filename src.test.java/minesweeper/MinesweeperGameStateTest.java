package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinesweeperGameStateTest {

	
    @Test
    public void gameEndedTest () {
        MinesweeperGameState gameState = new MinesweeperGameState();
        assertFalse(gameState.gameEnded());
    }
    @Test
    public void numberOfRowsGameTest(){
    	MinesweeperGameState mwgState = new MinesweeperGameState();
    	int rows = 10;
    	assertEquals(rows,mwgState.numberOfRows());
    }
    
    @Test
    public void numberOfColsGameTest(){
    	MinesweeperGameState mwgState = new MinesweeperGameState();
    	int cols = 10;
    	assertEquals(cols,mwgState.numberofColumns());
    }
    
    @Test
    public void numberOfMinesTest(){
    	MinesweeperGameState mwgState = new MinesweeperGameState();
    	int numberOfMines = 8;
    	assertEquals(numberOfMines,mwgState.numberOfMines());
    }
    
	@Test
	public void markTest() {
		MinesweeperGameState state = new MinesweeperGameState();
		state.mark(0, 0);	
		assertTrue(state.isMarked(0, 0));
	}
	
	@Test
	public void isOpenedTets(){
		MinesweeperGameState gameState = new MinesweeperGameState();
		//In this step the board should be created with all cell blocked
		gameState.open(0, 0);
		assertTrue(gameState.isOpened(0, 0));
	}

	@Test
	public void MinesweeperGameStateWhithParams(){
		MinesweeperGameState gamestate = new MinesweeperGameState(0,0,0);
		assertEquals(0, gamestate.numberOfMines());
				
	}

	@Test(expected=IllegalArgumentException.class)
	public void MinesweeperGameStateWhithParamsError(){
		MinesweeperGameState gamestate1 = new MinesweeperGameState(0,0,-2);	
	}

	
	@Test
	public void endGame(){
		MinesweeperGameState gameState = new MinesweeperGameState();
		gameState.endGame();
		assertTrue(gameState.gameEnded());
		
	}
	
}
