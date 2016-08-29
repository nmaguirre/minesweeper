package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinesweeperGameStateTest {

    @Test
    public void numberOfRowsTest() {
        MinesweeperBoard board = new MinesweeperBoard(10, 10, 8);
        assertTrue(board.getBoardRows() == 10);
    }

    @Test
    public void gameEndedTest () {
        MinesweeperGameState gameState = new MinesweeperGameState();
        assertFalse(gameState.gameEnded());
    }
    
	@Test
	public void isMarkedTest(){
		 MinesweeperGameState mwgs = new MinesweeperGameState();
		 mwgs.mark(0, 0);		
		 assertTrue(mwgs.isMarked(0, 0));
	}
	
	@Test
	public void mark(){
		MinesweeperGameState state = new MinesweeperGameState();
		state.mark(1, 1);	
		assertTrue(state.isMarked(1, 1));
	}

}
