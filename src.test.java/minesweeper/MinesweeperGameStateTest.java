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
	public void markTest() {
		MinesweeperGameState state = new MinesweeperGameState();
		state.mark(0, 0);	
		assertTrue(state.isMarked(0, 0));
	}
	
}
