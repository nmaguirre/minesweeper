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
        assertTrue(gameState.gameEnded());
    }

}
