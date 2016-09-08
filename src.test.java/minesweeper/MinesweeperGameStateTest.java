package minesweeper;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;

public class MinesweeperGameStateTest {
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
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
		assertTrue(state.isBlocked(0, 0));
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
	public void MinesweeperGameStateWhithParamBoard(){
		MinesweeperBoard boardAux = new MinesweeperBoard(2,2);
		boardAux.putMine(0, 0);
		MinesweeperGameState gamestate = new MinesweeperGameState(boardAux);
		assertEquals(1, gamestate.numberOfMines());
				
	}
	
	@Test
	public void MinesweeperGameStateWhithParamBoardErrorNull(){
		MinesweeperBoard boardAux = null;
		expected.expect(NullPointerException.class);
		MinesweeperGameState gamestate = new MinesweeperGameState(boardAux);	
	}

	@Test
	public void MinesweeperGameStateWhithParamBoardErrorBoardEnded(){
		MinesweeperBoard boardAux = new MinesweeperBoard(2,2);
		boardAux.putMine(0,0);
		boardAux.putMine(1, 1);
		boardAux.open(0, 1);
		boardAux.open(1, 0);
		expected.expect(IllegalArgumentException.class);
		MinesweeperGameState gamestate = new MinesweeperGameState(boardAux);	
	}
	
	@Test
	public void endGame(){
		MinesweeperGameState gameState = new MinesweeperGameState();
		gameState.endGame();
		assertTrue(gameState.gameEnded());
		
	}
        
        @Test
        public void openTest (){
            MinesweeperGameState gameState = new MinesweeperGameState();
		gameState.open(0, 0);	
                assertFalse(gameState.isBlocked(0, 0));
		assertTrue(gameState.isOpened(0, 0));               
        
        }
        
        @Test
        public void openTestBugControl () {
    		MinesweeperBoard boardAux = new MinesweeperBoard(10,10);
    		boardAux.putMine(0,0);
    		MinesweeperGameState StateAux=new MinesweeperGameState(boardAux);
        	StateAux.open(0,1);
        	assertFalse(StateAux.isOpened(1,1));
        }
	
}
