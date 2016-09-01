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
	public void isOpenTets(){
		MinesweeperGameState gameState = new MinesweeperGameState();
		//In this step the board should be created whith all cell blocked
		gameState.open(0, 0);
		assertTrue(!gameState.isOpened(0, 0));
		
		
	}
	
}
